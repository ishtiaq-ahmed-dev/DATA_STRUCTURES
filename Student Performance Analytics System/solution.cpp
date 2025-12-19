#include <iostream>
#include <fstream>
#include <iomanip>
#include <string>
#include <vector>
#include <algorithm>
#include <climits>
using namespace std;

/* ===================== DATA STRUCTURE ===================== */

struct StudentNode {
    int id;
    string fullName;
    string department;
    int semester;
    float gpa;
    int credits;
    int year;
    StudentNode* next;

    StudentNode(int i, const string& n, const string& d,
                int s, float g, int c, int y)
        : id(i), fullName(n), department(d),
          semester(s), gpa(g), credits(c), year(y), next(nullptr) {}
};

/* ===================== DATABASE CLASS ===================== */

class HumanDB {
public:
    StudentNode* head;

    HumanDB() : head(nullptr) {}

    /* ---------- ADD STUDENT ---------- */
    void addStudent(int i, const string& n, const string& d,
                    int s, float g, int c, int y) {
        StudentNode* node = new StudentNode(i, n, d, s, g, c, y);
        if (!head) {
            head = node;
            return;
        }
        StudentNode* t = head;
        while (t->next) t = t->next;
        t->next = node;
    }

    /* ---------- LOAD DATA (COUNT-BASED) ---------- */
    void loadData(const string& filename) {
        ios::sync_with_stdio(false);
        cin.tie(nullptr);

        ifstream fin(filename);
        if (!fin) {
            cerr << "ERROR: Cannot open input file\n";
            exit(1);
        }

        long long count;
        fin >> count;

        for (long long i = 0; i < count; i++) {
            int id, sem, credits, year;
            float gpa;
            string first, last, dept;

            if (!(fin >> id >> first >> last >> dept >> sem >> gpa >> credits >> year))
                break;

            if (gpa < 0 || gpa > 4 || sem < 1 || sem > 8)
                continue;

            addStudent(id, first + " " + last, dept, sem, gpa, credits, year);
        }
        fin.close();
    }

    /* ---------- LINKED LIST → VECTOR ---------- */
    vector<StudentNode*> toVector() {
        vector<StudentNode*> v;
        v.reserve(1000000); // helps with large files
        StudentNode* t = head;
        while (t) {
            v.push_back(t);
            t = t->next;
        }
        return v;
    }

    /* ---------- SORTING ---------- */
    vector<StudentNode*> sortByCGPA() {
        auto v = toVector();
        sort(v.begin(), v.end(), [](auto a, auto b) {
            if (a->gpa != b->gpa) return a->gpa > b->gpa;
            if (a->credits != b->credits) return a->credits > b->credits;
            return a->id < b->id;
        });
        return v;
    }

    vector<StudentNode*> sortByYear() {
        auto v = toVector();
        sort(v.begin(), v.end(), [](auto a, auto b) {
            if (a->year != b->year) return a->year < b->year;
            return a->id < b->id;
        });
        return v;
    }

    vector<StudentNode*> sortByDepartment() {
        auto v = toVector();
        sort(v.begin(), v.end(), [](auto a, auto b) {
            if (a->department != b->department) return a->department < b->department;
            if (a->semester != b->semester) return a->semester < b->semester;
            return a->gpa > b->gpa;
        });
        return v;
    }

    /* ===================== OUTPUT FILES ===================== */

    void saveRankedByCGPA(const vector<StudentNode*>& v) {
        ofstream fout("ranked_by_cgpa.txt");
        int rank = 1;

        fout << "Rank | ID | Name | Dept | Sem | CGPA | Credits | Year\n";
        for (auto s : v) {
            fout << rank++ << " "
                 << s->id << " "
                 << s->fullName << " "
                 << s->department << " "
                 << s->semester << " "
                 << fixed << setprecision(2) << s->gpa << " "
                 << s->credits << " "
                 << s->year << "\n";
        }
        fout.close();
    }

    void saveByEnrollment(const vector<StudentNode*>& v) {
        ofstream fout("sorted_by_enrollment.txt");

        int curYear = INT_MIN;
        double sum = 0;
        int cnt = 0;

        for (auto s : v) {
            if (s->year != curYear) {
                if (cnt > 0)
                    fout << "Average CGPA: " << sum / cnt << "\n\n";
                curYear = s->year;
                fout << "Enrollment Year: " << curYear << "\n";
                sum = 0;
                cnt = 0;
            }
            fout << s->id << " " << s->fullName << " " << s->gpa << "\n";
            sum += s->gpa;
            cnt++;
        }
        if (cnt > 0)
            fout << "Average CGPA: " << sum / cnt << "\n";

        fout.close();
    }

    void saveDepartmentAnalysis(const vector<StudentNode*>& v) {
        ofstream fout("department_analysis.txt");

        string curDept = "";
        int total = 0;
        double sum = 0, high = 0, low = 4.0, credits = 0;

        for (auto s : v) {
            if (s->department != curDept) {
                if (!curDept.empty()) {
                    fout << "Students=" << total
                         << " AvgCGPA=" << sum / total
                         << " High=" << high
                         << " Low=" << low
                         << " AvgCredits=" << credits / total << "\n\n";
                }
                curDept = s->department;
                fout << "Department: " << curDept << "\n";
                total = 0; sum = 0; high = 0; low = 4.0; credits = 0;
            }
            fout << s->fullName << " Sem:" << s->semester
                 << " CGPA:" << s->gpa << "\n";

            total++;
            sum += s->gpa;
            credits += s->credits;
            high = max(high, (double)s->gpa);
            low = min(low, (double)s->gpa);
        }

        if (total > 0)
            fout << "Students=" << total
                 << " AvgCGPA=" << sum / total
                 << " High=" << high
                 << " Low=" << low
                 << " AvgCredits=" << credits / total << "\n";

        fout.close();
    }

    void savePerformanceTiers() {
        auto v = toVector();
        sort(v.begin(), v.end(), [](auto a, auto b) {
            return a->fullName < b->fullName;
        });

        ofstream fout("performance_tiers.txt");

        for (auto s : v) {
            if (s->gpa >= 3.7) fout << "Elite: ";
            else if (s->gpa >= 3.3) fout << "High: ";
            else if (s->gpa >= 3.0) fout << "Good: ";
            else if (s->gpa >= 2.5) fout << "Satisfactory: ";
            else fout << "Needs Improvement: ";

            fout << s->fullName << " " << s->gpa << "\n";
        }
        fout.close();
    }

    void freeList() {
        while (head) {
            StudentNode* t = head;
            head = head->next;
            delete t;
        }
    }
};

/* ===================== MAIN ===================== */

int main() {
    HumanDB db;

    db.loadData("students_data.txt");

    db.saveRankedByCGPA(db.sortByCGPA());
    db.saveByEnrollment(db.sortByYear());
    db.saveDepartmentAnalysis(db.sortByDepartment());
    db.savePerformanceTiers();

    db.freeList();
    return 0;
}
