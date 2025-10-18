# 🌐 IP Address Management System using Doubly Linked List

This C++ program implements a **Doubly Linked List–based IP Address Management System**, allowing users to **validate**, **store**, and **display** IP addresses from both **console input** and **files**.

It demonstrates practical use of **file handling**, **string parsing**, and **pointer-based data structures**, forming a solid foundation for network-related data processing applications.

---

## 🛠 Features

| Operation | Description |
|------------|-------------|
| 🧾 **Add from Console** | Enter multiple IP addresses separated by commas (e.g. `192.168.0.1,10.0.0.5`). |
| 📂 **Add from File** | Load and validate IP addresses directly from a text file. |
| 🔍 **Validate IP** | Ensures correct format, digit count, and proper placement of dots. |
| 👁️ **Display from Start** | Prints IP addresses from head to tail. |
| 👁️ **Display from End** | Prints IP addresses from tail to head. |
| ❌ **Exit** | Safely terminates the program and releases memory. |

---

## 🧩 Code Structure  

### 🔹 **Node Structure**
Each node represents a single IP address and its connections within the doubly linked list.

\`\`\`cpp
struct Node {
    string ipaddress;   // Stores IP address
    Node* next;         // Pointer to the next node
    Node* prev;         // Pointer to the previous node
};
\`\`\`

---

### 🔹 **DoublyLinkedList Class**
Encapsulates all core operations of the IP address management system.

**Main Methods:**

| Method | Description |
|---------|-------------|
| \`insertatbeginning(string ip)\` | Inserts a new IP node at the beginning of the list |
| \`validate_ip(string ip)\` | Validates the syntax and structure of an IP address |
| \`add_addresses(string input)\` | Adds multiple IPs entered via console (comma-separated) |
| \`add_addresses_from_file(string filename)\` | Reads and validates IPs from a file |
| \`display_from_start()\` | Displays all stored IP addresses (head → tail) |
| \`display_from_end()\` | Displays all stored IP addresses (tail → head) |
| \`~DoublyLinkedList()\` | Destructor to free all dynamically allocated memory |

---

### 🔹 **Main Menu Flow**
The user interacts through a simple console-based menu.

\`\`\`text
Menu:
1. Add IP addresses from console
2. Add IP addresses from file
3. Display IP addresses from start to end
4. Display IP addresses from end to start
5. Exit
\`\`\`

---

## 🧮 Example Execution  

\`\`\`
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
\`\`\`

---

## ⚙️ How to Run  

1. **Save the file** as \`ip_address_manager.cpp\`  
2. **Open terminal** in the same folder  
3. **Compile and run** the program:
   \`\`\`bash
   g++ ip_address_manager.cpp -o ip_manager
   ./ip_manager
   \`\`\`
4. **To test file input**:  
   - Create a file named \`ips.txt\`  
   - Add comma-separated IPs inside:
     \`\`\`
     192.168.1.1,10.10.10.10,300.1.1.1
     \`\`\`
   - Run the program and choose option \`2\`, then enter \`ips.txt\`

---

## 🎯 Learning Outcomes  

By working on this project, you’ll:  
✅ Understand the implementation of a **Doubly Linked List** in C++  
✅ Learn **IP validation logic** using string operations and conditions  
✅ Practice **file handling** (\`ifstream\`, \`getline\`)  
✅ Master **dynamic memory management** (\`new\`, \`delete\`, destructor)  
✅ Design a **menu-driven program** simulating a real-world system  

---

## 👨‍💻 Author  

**Ishtiaq Ahmed**  
Artificial Intelligence Student | C++ & Python Developer | Data Structures Enthusiast
