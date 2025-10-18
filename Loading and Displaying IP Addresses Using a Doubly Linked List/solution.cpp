#include<iostream>
#include<sstream>
#include<string>
#include<fstream>
using namespace std;

struct Node {
    public:
    string ipaddress;
    Node* next;
    Node* prev;

    Node(string ip){
        ipaddress = ip;
        next = nullptr;
        prev = nullptr;
    }
};

class DoublyLinkedList{
    public:
    Node* head;
    Node* tail;

    DoublyLinkedList(){
        head = nullptr;
        tail = nullptr;
    }

    void insertatbeginning(string ip){
        Node* newNode = new Node(ip);
        if(head == nullptr){
            head = newNode;
            tail = newNode;
        } else {
            newNode->next = head;
            head->prev = newNode;
            head = newNode;
        }
    }

    bool validate_ip(string ip){
    int ip_len = ip.length();
    int dot_count = 0;
    int digit_count = 0;

    for(int i = 0; i < ip_len; i++){
        if(ip[i] == '.') {
            dot_count++;
            if(digit_count == 0 || digit_count > 3) {
                return false;
            }
        digit_count = 0;
        }
        else if(isdigit(ip[i])) {
            digit_count++;
        }
        else {
            cout<<"Invalid character in IP address \n";
            return false; 
        }
    }
    if(digit_count == 0 || digit_count > 3) {
        return false;
    }
    if(dot_count != 3) return false;
    return true;
}

    void add_addresses(string input) {
    stringstream ss(input);
    string ip;
    int count = 0;

    while (getline(ss, ip, ',')) {
        count++;
        cout << "IP Address " << count << ": " << ip << endl;
        

        if (validate_ip(ip)) {
            cout << ip << " is a valid IP address and added to the list\n";
            insertatbeginning(ip);
        } else {
            cout << ip << " is not a valid IP address\n";
        }
    }

}

void add_addresses_from_file(const string& filename) {
        ifstream infile(filename);
        if (!infile) {
            cerr << "Error opening file: " << filename << endl;
            return;
        }

        string line;
        if (getline(infile, line)) {
            stringstream ss(line);
            string ip;
            int count = 0;

            while (getline(ss, ip, ',')) {
                count++;
                cout << "IP Address " << count << ": " << ip << endl;

                if (validate_ip(ip)) {
                    insertatbeginning(ip);  
                    cout << ip << " is a valid IP address and added to the list\n";
                } else {
                    cout << ip << " is not a valid IP address\n";
                }
            }
        } else {
            cout << "File is empty or not in expected format.\n";
        }
    }
    void display_from_start(){
        Node* curr = head;
        if(curr == nullptr){
            cout << "List is empty\n";
            return;
        }
        while(curr != nullptr){
            cout << "IP Address: " << curr->ipaddress<<"\n";
            curr = curr->next;
        }    }

    void display_from_end(){
        Node* curr = tail;
        if(curr == nullptr){
            cout << "List is empty\n";
            return;
        }
        while(curr != nullptr){
            cout << "IP Address: " << curr->ipaddress<<"\n";
            curr = curr->prev;
        }    }

     ~DoublyLinkedList() {
    Node* curr = head;
    while (curr != nullptr) {
        Node* nextNode = curr->next;
        delete curr;
        curr = nextNode;
    }
    head = nullptr;
    tail = nullptr;
}

};

int main() {
    DoublyLinkedList dll;
    int choice;
    string addresses,filename;

    while (true) {
        cout << "Menu:\n";
        cout << "1. Add IP addresses from console\n";
       cout<<"Add IP addresses from file\n";
        cout << "3. Display IP addresses from start to end\n";
        cout << "4. Display IP addresses from end to start\n";
        cout << "5. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;
        cin.ignore(); 

        switch (choice) {
            case 1:
                cout << "Enter IP addresses separated by commas: ";
                getline(cin, addresses);
                dll.add_addresses(addresses);
                break;
            case 2:
                cout<<"Enter filename: ";
                cin>>filename;
                dll.add_addresses_from_file(filename);
                break;
            case 3:
                dll.display_from_start();
                break;
            case 4:
                dll.display_from_end();
                break;
            case 5:
                cout << "Exiting...\n";
                return 0;
            default:
                cout << "Invalid choice. Please try again.\n";
        }
    return 0;
}
