#include<iostream>
#include<string>
using namespace std;

class node {
public:
    string name;
    node* next;
    node* prev;

    node(string name) {
        this->name = name;
        next = nullptr;
        prev = nullptr;
    }
};

class doublyringlinkedlist {
public:
    node* curr;
    node* head;
    node* tail;

    doublyringlinkedlist() {
        head = nullptr;
        tail = nullptr;
        curr = nullptr;
    }

    void add_at_end(string n) {
        node* newnode = new node(n);
        if (head == nullptr) {
            head = newnode;
            tail = newnode;
            newnode->next = newnode;
            newnode->prev = newnode;
        }
        else {
            newnode->prev = tail;
            newnode->next = head;
            tail->next = newnode;
            head->prev = newnode;
            tail = newnode;
        }
    }

    void josephus_problem(int total, int jump) {
        string person;
        for (int x = 1; x <= total; x++) {
            cout << "Enter person " << x << " name: ";
            cin >> person;
            add_at_end(person);
        }

        curr = head;

        cout << "\nEliminating:\n";
		for (int x = 1; x < total; x++) {
            for (int y = 1; y < jump; y++) {
                curr = curr->next;
            }
			node* temp = curr;
			curr = curr->next;
            cout << temp->name << "       eliminated.\n";
            temp->prev->next = temp->next;
            temp->next->prev = temp->prev;
            if (temp == head) {
                head = temp->next;
            }
            if (temp == tail) {
                tail = temp->prev;
			}
			delete temp;
        }

        cout << "\nRemaining is: " << curr->name << endl;
    }
};

int main() {
    doublyringlinkedlist game;
    int totalPeople, step;

    cout << "Enter total number of people: ";
    cin >> totalPeople;
    cout << "Enter step count (jump): ";
    cin >> step;

    game.josephus_problem(totalPeople, step);

    return 0;
}
