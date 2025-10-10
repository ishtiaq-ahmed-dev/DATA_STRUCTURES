#include<iostream>
#include<string>
using namespace std;

struct Node{
    string name;
    int ID;
    Node* next;

    Node(string a, int b){
        name = a;
        ID = b;
        next = NULL;
    }
};

class linked_list{
    private:
    Node* head;

    public:
    Node* current=nullptr;
    int count=0;
    int length=0;

    linked_list(){
        head = nullptr;
    }

    void add_student(){
        current=head;
        string n;
        int id;
        cout<<"Enter student name: ";
        cin>>n;
        cout<<"Enter student ID: ";
        cin>>id;
        Node* new_node = new Node(n, id);
        if(head == nullptr){
            head = new_node;
            length++;
            return;}
        else{
            while(current->next != nullptr){
            current = current->next;
        }
            current->next = new_node;
            length++;
            return;
        }
    }
    void serve_student(){
        if (head==nullptr){
            cout<<"List is empty.";
            return;
        }
        else{
            if(count <=100){
            current = head;
            Node* temp = head;
            cout<<"Student Surved: "<<current->name <<"ID: " <<current->ID<<endl;
            head = current->next;
            delete temp;
            length--;
            return ;
            } else{
                cout<<"T-shirt finished cant serve more.\n";
                return;
            }
            
        }
    }
    void student_leaves(int p_id){
    if(head == nullptr){
        cout << "List is empty.\n";
        return;
    }

    Node* cur = head;
    Node* back = nullptr;

    while(cur != nullptr){
        if(cur->ID == p_id){
            cout << "Student leaves: " << cur->name << " ID: " << cur->ID <<"\n";
            delete cur;
            length--;
            return;
        }
        back = cur;
        cur = cur->next;
    }
    cout << "Student not found." << endl;
}

    void display(){
        if(head==nullptr){
            cout<<"List is empty.";
            return;
        }
        current = head;
        for(int x=1;x<=length;x++){
            cout<<"Student name: "<<current->name<<" ID: "<<current->ID<<endl;
            current = current->next;
        }
        return;}

    void cout_students(){
        cout<<"Total students: "<<length<<endl;
        return;
    }
    ~linked_list(){
        Node* temp;
        while(head != nullptr){
            temp = head;
            head = head->next;
            delete temp;
        }
    }
};

int main(){
    linked_list list1;
    int choice;
    while(true){
    cout<<"1. Add student\n2. Serve student\n3. Student leaves\n4. Display students\n5. Count students\n6. Exit\n Enter your choice: ";
        cin>>choice;
        switch(choice){
            case 1:
                list1.add_student();
                break;
            case 2:
                list1.serve_student();
                break;
            case 3:
                int id;
                cout<<"Enter student ID who wants to leave: ";
                cin>>id;
                list1.student_leaves(id);
                break;
            case 4:
                list1.display();
                break;
            case 5:
                list1.cout_students();
                break;
            case 6:
                cout<<"Exiting...\n";
                return 0;
            default:
                cout<<"Invalid choice. Try again.\n";
        }
    }
}
