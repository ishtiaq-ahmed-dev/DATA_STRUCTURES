# 🔗 **Doubly Linked List (DLL) — Tasks & Implementation in C++**

This program demonstrates a **fully functional Doubly Linked List (DLL)** implementation in **C++**, featuring node insertion, deletion, searching, and structured display of node memory addresses.  
It also contains **4 essential coding tasks** focused on fixing logic errors and understanding pointer management.

---

## 🧱 **Project Overview**

This program includes:
- Node insertion (beginning, position-based, and end)
- Deletion from the beginning and full list deletion
- Node display with **Prev / Data / Next / Address** table
- Destructor to safely free memory
- Search functionality with detailed node output

---

## 🧩 **Core Functionalities**

| **Feature** | **Description** |
|--------------|-----------------|
| 🧠 **Destructor** | Automatically deletes all nodes to prevent memory leaks. |
| ⚙️ **Insert at Position** | Inserts a new node at a specific position. |
| 🧱 **Insert at Beginning / End** | Adds new elements to the start or end of the list. |
| 🗑️ **Delete from Beginning** | Removes the first node safely and updates pointers. |
| ❌ **Delete All Nodes** | Frees the entire list and resets both `head` and `tail`. |
| 🔍 **Search Function** | Searches and displays a node’s data and address details. |
| 👁️ **Display with Addresses** | Displays all nodes with their memory references. |

---

## 🧠 **Class Structure**

### 🔹 **Node Class**

```cpp
class Node {
public:
    int data;
    Node* next;
    Node* prev;

    Node(int value) {
        data = value;
        next = nullptr;
        prev = nullptr;
    }
};

🧩 Task Breakdown
Task No.	Description	Objective
Task 1	Implement a destructor to free allocated memory.	Manage dynamic memory safely.
Task 2	Add four items and test positional insertion for the 5th node.	Fix logical flow for inserting beyond current size.
Task 3	Debug and fix the deleteFB() function.	Correct pointer movement and memory release.
Task 4	Fix DisplayNode() to show only the selected node.	Ensure correct node pointer references.

🧪 Example Output

------------------------------------------------------
     Prev Address        |   Data   |     Next Address |   Node Address
------------------------------------------------------

       0x0000000000000000 |      10  |   0x00000000004D42C0 |   0x00000000004D42A0
       0x00000000004D42A0 |      20  |   0x00000000004D42E0 |   0x00000000004D42C0
       0x00000000004D42C0 |      30  |   0x00000000004D4300 |   0x00000000004D42E0

------------------------------------------------------
Tail: 0x00000000004D4300
------------------------------------------------------

Deleted data is: 10
List is Empty


🧠 Learning Outcomes

By working on this project, you’ll learn to:

✅ Implement custom destructors and handle pointers safely

✅ Understand bidirectional linking using prev and next pointers

✅ Debug pointer mismanagement errors

✅ Practice object-oriented design in C++

✅ Build table-formatted output for debugging memory structures

👨‍💻 Author

Ishtiaq Ahmed
🎓 AI Student • 💻 C++ & Python Developer • 🧠 AI Developer
