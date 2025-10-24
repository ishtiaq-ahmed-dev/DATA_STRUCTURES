#include<iostream>
#include<iostream>
#include<iomanip>
using namespace std;

class Node {

public:

	int data;
	Node* next;
	Node* prev;


	Node(int value)
	{
		this->data = value;
		this->next = nullptr;
		this->prev = nullptr;

	}
};

class DLL
{

public:

	Node* head;
	Node* tail;


	DLL()
	{
		head = nullptr;
		tail = nullptr;
	}



~DLL(){
		Node* curr = head;
		while (curr != nullptr){
			head = head->next;
			delete curr;
			curr = head;
		}
		delete head;
		delete tail;
	}

	void deleteall(){
	Node* curr = head;
	while (curr != nullptr){
		head = head->next;
		curr->prev = nullptr;
		DisplayNode	(curr);			
		delete curr;
		curr = head;
	}
	 head=nullptr;
	 tail=nullptr;
}

	void display()
	{
		Node* current = head;

		if (current == nullptr)
		{
			cout << "List is Empty" << endl;
			return;
		}

		while (current != nullptr)
		{
			cout << current->data << endl;
			current = current->next;
		}
	}

	void Display() {
		if (head == nullptr)
		{
			cout << "List is Empty" << endl;
			return;
		}
		Node* temp = head;
		cout << "\n------------------------------------------------------\n";
		cout << "     Prev Address        |   Data   |     Next Address |   Node Address\n";
		cout << "------------------------------------------------------\n";

		while (temp != nullptr) {
			cout << setw(20) << temp->prev   // shows prev pointer address
				<< " | " << setw(7) << temp->data   // data field
				<< " | " << setw(18) << temp->next  // shows next pointer address
				<< " | " << setw(20) << temp
				<< endl;
			temp = temp->next;
		}
		cout << endl << "Tail: " << tail << endl;
		cout << "------------------------------------------------------\n";
	}



	void insertAtBegin(int value)
	{
		Node* newNode = new Node(value);

		newNode->next = head;

		if (head != nullptr)
		{
			head->prev = newNode;
		}
		head = newNode;

		if (head->next == nullptr)
		{
			tail = newNode;
		}
	}

	void insertAtPos(int position, int value)
	{
		if (head == nullptr){
			if (position == 1){
				insertAtBegin(value);
				return;
			}
			else{
				cout<<"Invalid Position"<<endl;
				return;
			}
		}

		Node* current = head;
		Node* newNode = new Node(value);

		for (int i = 1; i < position - 1; i++)
		{
			current = current->next;
		}

		newNode->next = current->next;
		newNode->prev = current;
		if (current->next == nullptr){
			tail = newNode;
		}
		else{
			current->next->prev = newNode;
		}
		current->next = newNode;
	}


	void deleteFB() {


		if (head == nullptr)
		{
			cout << "List is Empty" << endl;
			return;
		}
		else if (head->next == nullptr)
		{
			delete head;
			head = nullptr;
			return;
		}
		else
		{
			Node* temp = head;
			head = head->next;
			head->prev = nullptr;
			cout<<"Deleted data is: " << temp->data << "\n";
			delete temp;

		}
	}

	void DisplayNode(Node* node) {
		Node* temp = node;
		cout << "\n------------------------------------------------------\n";
		cout << "     Prev Address        |   Data   |     Next Address |   Node Address\n";
		cout << "------------------------------------------------------\n";

			cout << setw(20) << temp->prev   // shows prev pointer address
				<< " | " << setw(7) << temp->data   // data field
				<< " | " << setw(18) << temp->next  // shows next pointer address
				<< " | " << setw(20) << temp
				<< endl;
			temp = temp->next;
		cout << "------------------------------------------------------\n";

	}
	void search(int value)
	{
		Node* current = head;

		while (current != nullptr)
		{
			if (current->data == value)
			{
				cout << "Node found...";
				DisplayNode(current);
			}
			current = current->next;
		}
	}

	void insertAtEnd(int value)
	{
		if (tail == nullptr)
		{
			insertAtBegin(value);
		}
		else
		{
			Node* current = tail;
			Node* newNode = new Node(value);


			current->next = newNode;
			newNode->prev = current;
			newNode->next = nullptr;
			tail = newNode;

		}
	}


};

int main()
{

	DLL obj1;
	obj1.insertAtPos(1,10);
	obj1.insertAtPos(2,20);
	obj1.insertAtPos(3,30);
	obj1.insertAtPos(4,40);


	obj1.Display();
	obj1.deleteFB();
	obj1.Display();
	obj1.deleteall();
	obj1.Display();
  return 0;
}
