# 🕒 Chronos Time Stabilizer — BST-Based Time Capsule Manager

A futuristic **Binary Search Tree (BST) Time Engine** that stores historical or fictional events by year, allowing you to:

- 🚀 Inject new events into the timeline  
- ⚠️ Resolve paradoxes by deleting events  
- 🔍 Search the timestream for a specific year  
- 📜 Generate chronological reports  
- 🧹 Auto-clean memory using a destructor  

This project blends **C++ Data Structures (BST)** with a **science-fiction interface**, creating the feel of a real timeline-manipulation system.

---

## 🌌 Features

### ✔️ INJECT — Add an Event  
Adds a new time capsule (year + event description) into the BST structure.

INJECT 1998 Pokemon Launched

sql
Copy code

### ✔️ PARADOX — Delete an Event  
Removes a time capsule by year, with full BST deletion cases:

- No child  
- One child  
- Two children (successor replacement)

PARADOX 2020

shell
Copy code

### ✔️ SEARCH — Look Up an Event  
SEARCH 2005

yaml
Copy code

### ✔️ REPORT — Sorted Chronological List  
Automatically traverses the BST in **inorder traversal**, giving sorted timeline output.

### ✔️ EXIT  
Ends the simulation.

---

## 🛠️ Internal Architecture

### 🌳 **TimeCapsule Node Structure**
```cpp
struct TimeCapsule {
    int year;
    string eventName;
    TimeCapsule* left;
    TimeCapsule* right;
};
🧠 TimeTree (BST Controller)
Implements BST logic through custom sci-fi functions:

Method	Purpose
inject()	Inserts a new year/event pair
resolveParadox()	Deletes a BST node
search()	Finds a specific event
report()	Displays events in sorted order
destroyTree()	Recursively deletes entire BST

📡 Example Session
yaml
Copy code
--- CHRONOS TIME STABILIZER V1.0 ---
Waiting for Time Stream Inputs...

INJECT 1999 Y2K Event
> System: Injecting 1999... Timeline stable.

INJECT 2020 Global Pandemic
> System: Injecting 2020... Timeline stable.

SEARCH 1999
> Query: Searching for 1999...
> Result: Event Found! [1999: Y2K Event]

PARADOX 2020
> Alert: Paradox detected at 2020!
> System: Paradox resolved.

REPORT
-------------------------------
1999: Y2K Event
-------------------------------
⚙️ How It Works Internally
🌲 BST Insert Logic
Events are inserted by comparing years:

cpp
Copy code
if (year < node->year) node->left = insert(...);
else node->right = insert(...);
🌀 BST Delete Logic (Paradox Resolution)
Handles:

leaf node deletion

single child

two children (with inorder successor)

🔁 Inorder Traversal (Time Report)
Ensures events appear in chronological order.

🎮 Available Commands
Command	Usage	Description
INJECT y event	INJECT 1990 Cold War Ends	Add new event
PARADOX y	PARADOX 2012	Delete an event
SEARCH y	SEARCH 2001	Find an event
REPORT	—	List all events sorted
EXIT	—	Quit simulator


🧠 Learning Outcomes

By studying this project, you will understand:

✔️ BST insertion, deletion, searching

✔️ Handling all delete cases with successor

✔️ Memory management + destruction

✔️ User-driven command parsing

✔️ Recursive tree operations

✔️ Building interactive simulations with DSA

👨‍💻 Author
Ishtiaq Ahmed
AI Student • C++ Developer • DSA Enthusiast
