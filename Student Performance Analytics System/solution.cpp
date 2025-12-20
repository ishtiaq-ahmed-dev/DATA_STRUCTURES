#include <iostream>
#include <fstream>
#include <iomanip>
#include <string>
#include <sstream>

using namespace std;

/* ===================== DATA STRUCTURE ===================== */
struct Student {
    int id;
    string name;
    string dept;
    int semester;
    double cgpa;
    int credits;
    int year;
    Student* next;

    Student(int i, string n, string d, int s, double g, int c, int y)
        : id(i), name(n), dept(d), semester(s), cgpa(g), credits(c), year(y), next(nullptr) {}
};

/* ===================== MEMORY MANAGEMENT ===================== */

void deleteList(Student* head) {
    while (head) {
        Student* temp = head;
        head = head->next;
        delete temp;
    }
}

Student* cloneList(Student* source) {
    if (!source) return nullptr;
    Student* newHead = new Student(source->id, source->name, source->dept, source->semester, source->cgpa, source->credits, source->year);
    Student* curr = newHead;
    source = source->next;
    while (source) {
        curr->next = new Student(source->id, source->name, source->dept, source->semester, source->cgpa, source->credits, source->year);
        curr = curr->next;
        source = source->next;
    }
    return newHead;
}

/* ===================== ITERATIVE MERGE SORT (Stack-Safe) ===================== */

Student* merge(Student* a, Student* b, bool (*comp)(Student*, Student*)) {
    Student dummy(0, "", "", 0, 0, 0, 0);
    Student* tail = &dummy;
    while (a && b) {
        if (comp(a, b)) { tail->next = a; a = a->next; }
        else { tail->next = b; b = b->next; }
        tail = tail->next;
    }
    tail->next = (a) ? a : b;
    return dummy.next;
}

void iterativeMergeSort(Student** headRef, bool (*comp)(Student*, Student*)) {
    if (!*headRef || !(*headRef)->next) return;
    Student* list[32]; 
    for (int i = 0; i < 32; i++) list[i] = nullptr;
    Student* curr = *headRef;
    while (curr) {
        Student* nextNode = curr->next;
        curr->next = nullptr;
        int i;
        for (i = 0; i < 31 && list[i] != nullptr; i++) {
            curr = merge(list[i], curr, comp);
            list[i] = nullptr;
        }
        list[i] = curr;
        curr = nextNode;
    }
    Student* result = nullptr;
    for (int i = 0; i < 32; i++) result = merge(list[i], result, comp);
    *headRef = result;
}

/* ===================== COMPARATORS ===================== */

bool compEnrollment(Student* a, Student* b) {
    if (a->year != b->year) return a->year < b->year;
    return a->id < b->id;
}

bool compDeptAnalysis(Student* a, Student* b) {
    if (a->dept != b->dept) return a->dept < b->dept;
    if (a->semester != b->semester) return a->semester < b->semester;
    return a->cgpa > b->cgpa;
}

bool compAlpha(Student* a, Student* b) {
    return a->name < b->name;
}

/* ===================== REPORT GENERATORS ===================== */

// Report 2: Enrollment
void generateEnrollmentReport(Student* master) {
    cout << "  > Generating Enrollment Report..." << endl;
    Student* copy = cloneList(master);
    iterativeMergeSort(&copy, compEnrollment);
    ofstream fout("sorted_by_enrollment.txt");
    
    Student* curr = copy;
    while (curr) {
        int targetYear = curr->year;
        double sumGPA = 0;
        int count = 0;
        fout << "\n================ ENROLLMENT YEAR: " << targetYear << " ================\n";
        while (curr && curr->year == targetYear) {
            fout << "ID: " << curr->id << " | Name: " << setw(20) << left << curr->name << " | GPA: " << curr->cgpa << "\n";
            sumGPA += curr->cgpa;
            count++;
            curr = curr->next;
        }
        fout << "------------------------------------------------------------\n";
        fout << "Average CGPA for " << targetYear << " Cohort: " << fixed << setprecision(2) << (sumGPA / count) << "\n";
    }
    fout.close();
    deleteList(copy);
}

// Report 3: Department Analysis
void generateDeptReport(Student* master) {
    cout << "  > Generating Department Report..." << endl;
    Student* copy = cloneList(master);
    iterativeMergeSort(&copy, compDeptAnalysis);
    ofstream fout("department_analysis.txt");

    Student* curr = copy;
    while (curr) {
        string d = curr->dept;
        int count = 0;
        double sumGPA = 0, sumCred = 0, high = -1, low = 5;

        fout << "\nDEPARTMENT: " << d << "\n";
        fout << "------------------------------------------------------------\n";
        while (curr && curr->dept == d) {
            fout << "Sem " << curr->semester << " | GPA: " << curr->cgpa << " | " << curr->name << "\n";
            sumGPA += curr->cgpa;
            sumCred += curr->credits;
            if (curr->cgpa > high) high = curr->cgpa;
            if (curr->cgpa < low) low = curr->cgpa;
            count++;
            curr = curr->next;
        }
        fout << "\n>>> STATISTICS FOR " << d << " <<<\n";
        fout << "Total Students: " << count << "\nAverage CGPA: " << (sumGPA / count) 
             << "\nHighest: " << high << " | Lowest: " << low 
             << "\nAverage Credits: " << (sumCred / count) << "\n\n";
    }
    fout.close();
    deleteList(copy);
}

// Report 4: Performance Tiers
void generatePerformanceTiers(Student* master, int totalLoaded) {
    cout << "  > Generating Performance Tiers..." << endl;
    Student* copy = cloneList(master);
    iterativeMergeSort(&copy, compAlpha);
    ofstream fout("performance_tiers.txt");

    const char* labels[] = {"ELITE TIER (>= 3.70)", "HIGH ACHIEVERS (3.30-3.69)", "GOOD STANDING (3.00-3.29)", "SATISFACTORY (2.50-2.99)", "NEEDS IMPROVEMENT (< 2.50)"};
    
    for (int i = 0; i < 5; i++) {
        int count = 0;
        fout << "\n--- " << labels[i] << " ---\n";
        for (Student* c = copy; c; c = c->next) {
            bool inTier = false;
            if (i == 0 && c->cgpa >= 3.70) inTier = true;
            else if (i == 1 && c->cgpa >= 3.30 && c->cgpa < 3.70) inTier = true;
            else if (i == 2 && c->cgpa >= 3.00 && c->cgpa < 3.30) inTier = true;
            else if (i == 3 && c->cgpa >= 2.50 && c->cgpa < 3.00) inTier = true;
            else if (i == 4 && c->cgpa < 2.50) inTier = true;

            if (inTier) {
                fout << left << setw(25) << c->name << " | GPA: " << c->cgpa << "\n";
                count++;
            }
        }
        fout << "Count: " << count << " (" << fixed << setprecision(2) << ((double)count / totalLoaded * 100) << "%)\n";
    }
    fout.close();
    deleteList(copy);
}

/* ===================== MAIN ===================== */

int main() {
    ios::sync_with_stdio(false); cin.tie(NULL);
    string path = "/Users/ishtiaqahmed/Desktop/DSA LAB TASK/output/students_data.txt";
    ifstream inFile(path);
    if (!inFile) return 1;

    Student *head = nullptr, *tail = nullptr;
    string line; getline(inFile, line); 
    int loaded = 0;
    while (getline(inFile, line)) {
        stringstream ss(line);
        int id, sem, cr, yr; double g; string fn, ln, dp;
        if (ss >> id >> fn >> ln >> dp >> sem >> g >> cr >> yr) {
            Student* n = new Student(id, fn + " " + ln, dp, sem, g, cr, yr);
            if (!head) head = tail = n; else { tail->next = n; tail = n; }
            loaded++;
        }
    }
    inFile.close();
    cout << "Loaded " << loaded << " records." << endl;

    if (head) {
        generateEnrollmentReport(head);
        generateDeptReport(head);
        generatePerformanceTiers(head, loaded);
    }

    deleteList(head);
    cout << "All reports complete." << endl;
    return 0;
}
