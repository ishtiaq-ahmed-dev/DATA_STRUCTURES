#include <iostream>
using namespace std;

class Node {
public:
    string currtrack;
    Node* next;

    Node(string t) {
        currtrack = t;
        next = nullptr;
    }
};

class LLStack {
private:
    Node* top;

public:
    LLStack() {
        top = nullptr;
    }

    bool isEmpty() {
        return top == nullptr;
    }

    void playtrack(string track) {
        Node* newNode = new Node(track);
        newNode->next = top;
        top = newNode;
    }

    void playprevioustrack() {
        if (isEmpty()) {
            cout << "Stack is empty! Nothing to play.\n";
            return;
        }
        Node* temp = top;
        string poppedtrack = top->currtrack;
        top = top->next;
        delete temp;
        cout << "Playing previous track: " << poppedtrack << endl;
    }
};

int main() {
    LLStack music_player;
    int choice;
    string track;
    while (true)
    {
        cout << "1. Play Track\n2. Previous Track\n3. Exit\nEnter your choice: ";
        cin >> choice;
        switch (choice) {
            case 1:
                cout << "Enter track name: ";
                cin >> track;
                music_player.playtrack(track);
                cout << "Playing track: " << track <<"\n";
                break;
            case 2:
                music_player.playprevioustrack();
                break;
            case 3:
                cout << "Exiting music player.\n";
                return 0;
            default:
                cout << "Invalid choice! Please try again.\n";
        }
    }
    return 0;
}
