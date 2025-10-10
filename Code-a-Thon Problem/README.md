# 🎓 Student Queue Management System (Linked List Implementation)

This program implements a **dynamic student queue** using a **singly linked list** in C++.  
It simulates a real-world system such as a **T-shirt distribution or registration counter**, where students join the line, get served, or leave before their turn.

---

## 📘 Overview

Each student is stored as a **node** with:
- 🧍 **Name**
- 🆔 **ID number**
- 🔗 Pointer to the next student

The system supports adding, serving, removing, and displaying students efficiently using pointer-based linked list operations.

---

## 🛠 Features

| Operation | Description |
|------------|-------------|
| ➕ **Add Student** | Inserts a new student at the end of the queue. |
| 🎯 **Serve Student** | Removes the first student (front of the queue). |
| 🚪 **Student Leaves** | Removes a student with a specific ID from anywhere in the queue. |
| 👀 **Display Students** | Displays the entire queue of waiting students. |
| 🔢 **Count Students** | Shows the total number of students currently in the list. |
| ❌ **Exit** | Ends the program safely, releasing all allocated memory. |

---

## 💻 Code Structure

### 🔹 `struct Node`
Represents each student:
\`\`\`cpp
struct Node {
    string name;
    int ID;
    Node* next;
};
\`\`\`

### 🔹 `class linked_list`
Handles queue logic with:
- \`add_student()\`
- \`serve_student()\`
- \`student_leaves(int ID)\`
- \`display()\`
- \`cout_students()\`
- Destructor to free memory

---

## ▶️ Example Menu Execution

\`\`\`
1. Add student
2. Serve student
3. Student leaves
4. Display students
5. Count students
6. Exit
Enter your choice: 1
Enter student name: Ali
Enter student ID: 101
Enter your choice: 1
Enter student name: Sana
Enter student ID: 102
Enter your choice: 4
Student name: Ali ID: 101
Student name: Sana ID: 102
Enter your choice: 2
Student Surved: Ali ID: 101
Enter your choice: 5
Total students: 1
\`\`\`

---

## 🚀 How to Run

1. Save file as \`student_queue.cpp\`  
2. Compile and run:
   \`\`\`bash
   g++ student_queue.cpp -o student_queue
   ./student_queue
   \`\`\`

---

## ⚙️ Learning Outcomes

- Hands-on understanding of **Linked Lists**
- Practice with **dynamic memory management** using \`new\` and \`delete\`
- Implementation of **menu-based user interaction**
- Managing real-world logic like **queue behavior and removal by ID**

---

## 👨‍💻 Author

**Ishtiaq Ahmed**  
Artificial Intelligence Student | C++ & Python Developer | Data Structures Enthusiast
