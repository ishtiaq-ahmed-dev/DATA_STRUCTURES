#include <iostream>
#include <string>
#include <limits>
using namespace std;

//========================================================
// NODE STRUCTURE
//========================================================
struct TimeCapsule {
    int year;
    string eventName;
    TimeCapsule* left;
    TimeCapsule* right;

    TimeCapsule(int y, string e) : year(y), eventName(e), left(nullptr), right(nullptr) {}
};

//========================================================
// BST CLASS WITH YOUR STYLE OF FUNCTIONS
//========================================================
class TimeTree {
private:
    TimeCapsule* root;

    // -----------------------------------------
    // INSERT (same style as your BST insert)
    // -----------------------------------------
    TimeCapsule* insert(TimeCapsule* node, int year, string name) {
        if (!node) return new TimeCapsule(year, name);

        if (year < node->year)
            node->left = insert(node->left, year, name);
        else
            node->right = insert(node->right, year, name);

        return node;
    }

    // -----------------------------------------
    // SEARCH (same style as your BST search)
    // -----------------------------------------
    TimeCapsule* searchNode(TimeCapsule* node, int year) {
        if (!node) return nullptr;
        if (node->year == year) return node;

        if (year < node->year)
            return searchNode(node->left, year);
        else
            return searchNode(node->right, year);
    }

    // -----------------------------------------
    // FIND MIN
    // -----------------------------------------
    TimeCapsule* minNode(TimeCapsule* node) {
        while (node && node->left) node = node->left;
        return node;
    }

    // -----------------------------------------
    // DELETE NODE (same style as classic BST)
    // -----------------------------------------
    TimeCapsule* deleteNode(TimeCapsule* node, int year) {
        if (!node) return nullptr;

        if (year < node->year)
            node->left = deleteNode(node->left, year);

        else if (year > node->year)
            node->right = deleteNode(node->right, year);

        else {
            // Case 1: No children
            if (!node->left && !node->right) {
                delete node;
                return nullptr;
            }
            // Case 2: 1 child
            else if (!node->left) {
                TimeCapsule* temp = node->right;
                delete node;
                return temp;
            }
            else if (!node->right) {
                TimeCapsule* temp = node->left;
                delete node;
                return temp;
            }
            // Case 3: 2 children
            else {
                TimeCapsule* successor = minNode(node->right);
                node->year = successor->year;
                node->eventName = successor->eventName;
                node->right = deleteNode(node->right, successor->year);
            }
        }
        return node;
    }

    // -----------------------------------------
    // INORDER TRAVERSAL
    // -----------------------------------------
    void inorder(TimeCapsule* node) {
        if (!node) return;
        inorder(node->left);
        cout << node->year << ": " << node->eventName << endl;
        inorder(node->right);
    }

    // Helper to delete entire tree
    void destroyTree(TimeCapsule* node) {
        if (!node) return;
        destroyTree(node->left);
        destroyTree(node->right);
        delete node;
    }

public:

    TimeTree() { root = nullptr; }
    ~TimeTree() { destroyTree(root); }

    //========================================================
    // PUBLIC METHODS USING THE STYLE YOU WANT
    //========================================================

    void inject(int year, string name) {
        cout << "> System: Injecting " << year << "... ";
        root = insert(root, year, name);
        cout << "Timeline stable." << endl;
    }

    void resolveParadox(int year) {
        cout << "> Alert: Paradox detected at " << year << "!" << endl;
        root = deleteNode(root, year);
        cout << "> System: Paradox resolved." << endl;
    }

    void search(int year) {
        cout << "> Query: Searching for " << year << "..." << endl;

        TimeCapsule* result = searchNode(root, year);

        if (!result)
            cout << "> Result: Year not found." << endl;
        else
            cout << "> Result: Event Found! [" << result->year << ": " << result->eventName << "]" << endl;
    }

    void report() {
        cout << "> COMMAND: CHRONOLOGICAL REPORT" << endl;
        cout << "-------------------------------" << endl;
        inorder(root);
        cout << "-------------------------------" << endl;
    }
};

//========================================================
// MAIN (DO NOT MODIFY)
//========================================================
int main() {
    TimeTree chronos;
    string command;
    int year;
    string eventName;

    cout << "--- CHRONOS TIME STABILIZER V1.0 ---" << endl;
    cout << "Waiting for Time Stream Inputs..." << endl << endl;

    while (cin >> command) {
        if (command == "INJECT") {
            cin >> year;
            getline(cin >> ws, eventName);
            chronos.inject(year, eventName);
        }
        else if (command == "PARADOX") {
            cin >> year;
            chronos.resolveParadox(year);
        }
        else if (command == "SEARCH") {
            cin >> year;
            chronos.search(year);
        }
        else if (command == "REPORT") {
            chronos.report();
        }
        else if (command == "EXIT") {
            break;
        }
        else {
            cout << "> Unknown Command." << endl;
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
        }
        cout << endl;
    }
}
