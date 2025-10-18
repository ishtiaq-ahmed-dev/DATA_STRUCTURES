# 🌐 IP Address Management System using Doubly Linked List

This C++ program implements a **Doubly Linked List–based IP Address Management System**, allowing users to **validate**, **store**, and **display** IP addresses from both **console input** and **files**.

It demonstrates practical use of **file handling**, **string parsing**, and **pointer-based data structures**, forming a solid foundation for network-related data processing applications.

---

## 📘 Overview

Each IP address is represented as a **node** in a **doubly linked list**, enabling traversal in both forward and backward directions.  
The program validates each entered IP and only stores those that are correctly formatted.

---

## 🛠 Features

| Operation | Description |
|------------|-------------|
| 🧾 **Add from Console** | Enter multiple IP addresses separated by commas (e.g. `192.168.0.1,10.0.0.5`). |
| 📂 **Add from File** | Load and validate IP addresses directly from a text file. |
| 🔍 **Validate IP** | Checks correct format, digit count, and valid placement of dots. |
| 👁️ **Display from Start** | Prints IPs from head to tail. |
| 👁️ **Display from End** | Prints IPs from tail to head. |
| ❌ **Exit** | Safely terminates the program and releases memory. |

---

## 💻 Code Structure

### 🔹 `struct Node`
Each node represents one IP address and its connections:
\`\`\`cpp
struct Node {
    string ipaddress;
    Node* next;
    Node* prev;
};
\`\`\`

### 🔹 `class DoublyLinkedList`
Handles all major operations:
- \`insertatbeginning(string ip)\`
- \`validate_ip(string ip)\`
- \`add_addresses(string input)\`
- \`add_addresses_from_file(string filename)\`
- \`display_from_start()\`
- \`display_from_end()\`
- Destructor to free memory.

---

## ▶️ Example Menu Execution

\`\`\`
Menu:
1. Add IP addresses from console
2. Add IP addresses from file
3. Display IP addresses from start to end
4. Display IP addresses from end to start
5. Exit
Enter your choice: 1
Enter IP addresses separated by commas: 192.168.0.1,256.1.1.1,10.0.0.5

IP Address 1: 192.168.0.1
192.168.0.1 is a valid IP address and added to the list
IP Address 2: 256.1.1.1
256.1.1.1 is not a valid IP address
IP Address 3: 10.0.0.5
10.0.0.5 is a valid IP address and added to the list
\`\`\`

---

## 🚀 How to Run

1. Save your code as \`ip_address_manager.cpp\`  
2. Compile and run:
   \`\`\`bash
   g++ ip_address_manager.cpp -o ip_manager
   ./ip_manager
   \`\`\`

3. To load from a file:  
   - Create a file named \`ips.txt\`  
   - Add IPs separated by commas:  
     ```
     192.168.1.1,10.10.10.10,300.1.1.1
     ```
   - Choose option **2** in the menu and enter `ips.txt`

---

## ⚙️ Learning Outcomes

- Understand **Doubly Linked List operations**  
- Implement **string parsing using stringstream**  
- Learn **input validation** for structured data (IP format)  
- Use **file handling (ifstream)** in real-world logic  
- Practice **memory management** with destructors  

---

## 👨‍💻 Author

**Ishtiaq Ahmed**  
Artificial Intelligence Student | C++ & Python Developer | Data Structures Enthusiast
