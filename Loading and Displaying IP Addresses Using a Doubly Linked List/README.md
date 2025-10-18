# 🌐 IP Address Management System using Doubly Linked List

This C++ program implements a **Doubly Linked List–based IP Address Management System**, allowing users to **validate**, **store**, and **display** IP addresses from both **console input** and **files**.

It demonstrates practical use of:
✔️ File handling  
✔️ String parsing  
✔️ Pointer-based data structures  

This forms a solid foundation for network-related data processing applications.

────────────────────────────────────────────

## 🛠️ Features

| Operation                | Description                                                                 |
|--------------------------|-----------------------------------------------------------------------------|
| 🧾 Add from Console       | Enter multiple IP addresses separated by commas (e.g. `192.168.0.1,10.0.0.5`) |
| 📂 Add from File          | Load and validate IP addresses directly from a text file (`ips.txt`)        |
| 🔍 Validate IP            | Ensures correct format and value range (0–255 per octet)                    |
| 👁️ Display from Start     | Prints IP addresses from head → tail                                        |
| 👁️ Display from End       | Prints IP addresses from tail → head                                        |
| ❌ Exit                   | Safely terminates the program and releases memory                           |

────────────────────────────────────────────

## 🧩 Code Structure  

### 🔹 Node Structure

Each node represents a single IP address and its links:

```cpp
struct Node {
    string ipaddress;   // Stores the IP address
    Node* next;         // Points to next node
    Node* prev;         // Points to previous node
};


🔹 DoublyLinkedList Class

Encapsulates all linked list operations.

Method	Purpose
insert_at_end(string ip)	Inserts an IP address node at the end of the list
validate_ip(string ip)	Validates IP address format and numerical range
add_addresses(string input)	Parses and adds multiple comma-separated IPs from console
add_addresses_from_file(string filename)	Loads IPs from a file like ips.txt
display_from_start()	Displays IPs from head → tail
display_from_end()	Displays IPs from tail → head
~DoublyLinkedList()	Destructor to release memory

🔹 Menu-Driven User Interface

Menu:
1. Add IP addresses from console
2. Add IP addresses from file
3. Display IP addresses from start to end
4. Display IP addresses from end to start
5. Exit

🧪 Example Execution

📋 Menu:
1. Add IP addresses from console
2. Add IP addresses from file
3. Display IP addresses from start to end
4. Display IP addresses from end to start
5. Exit

Enter your choice: 1
Enter IP addresses separated by commas: 192.168.0.1,256.1.1.1,10.0.0.5

IP Address 1: 192.168.0.1
✅ 192.168.0.1 is valid and added to the list

IP Address 2: 256.1.1.1
❌ 256.1.1.1 is not a valid IP address

IP Address 3: 10.0.0.5
✅ 10.0.0.5 is valid and added to the list


⚙️ How to Run

Save the file as ip_address_manager.cpp

Open terminal in the project directory

Compile and run the program:
g++ ip_address_manager.cpp -o ip_manager
./ip_manager


📘 Learning Outcomes

By building this project, you'll:

✅ Understand how doubly linked lists work in C++
✅ Learn practical IP validation techniques
✅ Apply file I/O for real-world data processing
✅ Master memory management using new and delete
✅ Design a user-friendly menu-driven program

👨‍💻 Author

Ishtiaq Ahmed
🎓 AI Student • 💻 C++ & Python Developer • 🧠 Data Structures Enthusiast
