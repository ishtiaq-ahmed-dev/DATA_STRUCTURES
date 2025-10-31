#incluse<iostream>
using namespace std;

struct node {
    int P_ID;
    node* next;
    node* previous;

    node(int ID){
        P_ID=ID;
        next=nullptr;
        previous=nullptr;
    }
};

class Emergency_Room{
    private:
    node* head;
    node* tail;
    int total_patients;
    public:
    Emergency_Room(){
        head=nullptr;
        tail=nullptr;
        total_patients =0;
    }

    void insert_patient_at_beginning(int ID){

        node* new_patient = new node(ID);

        if(head==nullptr){
            head =new_patient;
            tail =new_patient;
        } else {
            new_patient->next =head;
            head->previous =new_patient;
            head =new_patient;
        }

        total_patients++;
    }

    void insert_at_end(int ID){

        node* new_patient = new node(ID);

        if(head == nullptr){
            head=new_patient;
            tail=new_patient;
        } else {
            tail->next =new_patient;
            new_patient->previous =tail;
            tail=new_patient;
        }

        total_patients++;
    }

    void insert_at_any_position(int ID, int position){

        if(position< 1 || position>total_patients+1){
            cout <<"Invalid Position\n";
            return;
        }

        if(position==1){
            insert_patient_at_beginning(ID);
            return;
        }

        if(position==total_patients + 1){
            insert_at_end(ID);
            return;
        }

        node* new_patient = new node(ID);
        node* current = head;

        for(int i = 1; i < position - 1; i++){
            current = current->next;
        }

        new_patient->next= current->next;
        new_patient->previous=current;
        current->next->previous =new_patient;
        current->next = new_patient;

        total_patients++;
    }

    
    void delete_patient_at_beginning(){

        if(head == nullptr){
            cout <<"list is empty\n";
            return;
        }

        node* temp = head;
        head = head->next;

        if(head != nullptr){
            head->previous = nullptr;
    } else {
        tail = nullptr;
 }

        total_patients--;
        delete temp;
    }

};

#i am not using main function because the question was only to create functions
#if want to test the code please use main function