# ⚔️ **Josephus Problem Simulation using Doubly Circular Linked List (C++)**

This C++ program simulates the **Josephus Problem**, a famous theoretical problem in computer science and mathematics, using a **Doubly Circular Linked List**.  

Each person is represented as a node in a circular list.  
The program repeatedly counts through the circle and eliminates every *k-th* person until only one remains — the survivor.

---

## 🧠 **What is the Josephus Problem?**

In the Josephus problem:  
> People stand in a circle waiting to be executed. Starting from a given point, every k-th person is eliminated until only one remains.

This program models that process dynamically with a **doubly circular linked list**, updating connections after each elimination.

---

## 🧩 **Program Features**

| **Feature** | **Description** |
|--------------|-----------------|
| 🔁 **Circular Linked List** | Each node points to both its previous and next node, forming a continuous ring. |
| 👥 **Dynamic Input** | Users can enter any number of people with custom names. |
| ⚙️ **Custom Step Count** | Allows flexible "jump" or step size for elimination order. |
| 💥 **Elimination Simulation** | Displays each eliminated person in real-time. |
| 🏆 **Final Survivor** | Outputs the last remaining person's name. |

---

## 🧱 **Core Class Structure**

### 🔹 **Node Class**

```cpp
class node {
public:
    string name;
    node* next;
    node* prev;

    node(string name) {
        this->name = name;
        next = nullptr;
        prev = nullptr;
    }
};


```

⚙️ Algorithm Explanation

Input total people and step count.

Create a circular linked list of all participants.

Move forward (jump - 1) times to find the next person to eliminate.

Remove that person from the circle and continue.

Repeat until one person (the survivor) remains.



🎯 Learning Outcomes

By completing this project, you’ll:

✅ Understand circular doubly linked list structure

✅ Practice pointer manipulation and dynamic memory management

✅ Implement real-world problem logic using data structures

✅ Strengthen algorithmic thinking

✅ Master node insertion and deletion in a circular structure


👨‍💻 Author

Ishtiaq Ahmed
🎓 AI Student • 💻 C++ & Python Developer • 🧠 Data Structures Enthusiast
