#include<iostream>
#include<string>
using namespace std;

const int MAX = 20;
class ArrayStack{
    private:    
    int arr[MAX];
    int top;
    public:
    ArrayStack(){
        top = -1;
    }

    bool isEmpty(){
        return top == -1;
    }

    bool isFull(){
        return top == MAX - 1;
    }

    void push(char x){
        if(isFull()){
            cout << "Stack Overflow" << endl;
            return;
        }
        arr[++top] = x;
    }
    char pop(){
        if(isEmpty()){
            cout << "Stack Underflow" << endl;
            return -1;
        }
        return arr[top--];
    }

    char peek(){
        if(isEmpty()){
            cout << "Stack is empty" << endl;
            return -1;
        }
        return arr[top];
    }

    void display(){
        if(isEmpty()){
            cout << "Stack is empty" << endl;
            return;
        }
        for(int i = 0; i <= top; i++){
            cout << arr[i] <<endl;
        }    }

    
};

bool areBracketsBalanced(string exp) {
        ArrayStack obj;
       int length = exp.length();
       for (int x = 0 ; x< length ; x++){
        if (exp[x]== '[' || exp[x]== '{' || exp[x]== '('){
            obj.push(exp[x]);
        }
        else{
            if (obj.peek() == '(' && exp[x] == ')'){
                obj.pop();
            }
            else if (obj.peek() == '{' && exp[x] == '}'){
                obj.pop();
            }
            else if (obj.peek() == '[' && exp[x] == ']'){
                obj.pop();
            }
            else{
                return false;
            }
        }
       }
    return obj.isEmpty();
}


int main(){
    while(true){
    string exp;
    cout << "Enter the expression: ";
    cin >> exp;
    if(exp == "exit" || exp == "quit"){
        break;
    }
    bool result = areBracketsBalanced(exp);
    if(result)
        cout << "Balanced" << endl;
    else
        cout << "Not Balanced" << endl;
    }
        
    return 0;
}
