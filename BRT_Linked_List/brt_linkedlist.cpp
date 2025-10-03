#include <iostream>
using namespace std;

struct Node {
    int Passenger_ID;
    Node* next;
    Node(int data) {
        Passenger_ID = data;
        next = nullptr;
    }
};

class LinkedList {
private:
    Node* head;

public:
    LinkedList() {
        head = nullptr;
    }

    void insert_at_beginning(int ID) {
        Node* NewNode = new Node(ID);
        NewNode->next = head;
        head = NewNode;
    }

    void insert_at_end(int ID) {
        Node* NewNode = new Node(ID);

        if (head == nullptr) {
            head = NewNode;
            return;
        }

        Node* current = head;
        while (current->next != nullptr) {
            current = current->next;
        }
        current->next = NewNode;
    }

    void insert_at_position(int ID, int position) {
        if (position == 0) {
            insert_at_beginning(ID);
            return;
        }

        Node* current = head;
        int i = 0;
        while (current != nullptr && i < position - 1) {
            current = current->next;
            i++;
        }

        if (current == nullptr) {
            cout << "Position out of range, inserting at end.\n";
            insert_at_end(ID);
            return;
        }

        Node* NewNode = new Node(ID);
        NewNode->next = current->next;
        current->next = NewNode;
    }

    void delete_from_beginning() {
        if (head == nullptr) {
            cout << "List is empty.\n";
            return;
        }

        Node* temp = head;
        head = head->next;
        delete temp;
    }

    void print() {
        Node* current = head;
        cout << "\nQueue: ";
        while (current != nullptr) {
            cout << current->Passenger_ID << " -> ";
            current = current->next;
        }

    }
};

int main() {
    LinkedList queue;
    queue.insert_at_beginning(101);
    queue.insert_at_end(102);
    queue.insert_at_end(103);
    queue.print();
    queue.insert_at_beginning(999);
    queue.print();
    queue.insert_at_position(555, 2);
    queue.print();
    queue.delete_from_beginning();
    queue.print();
    return 0;
}
