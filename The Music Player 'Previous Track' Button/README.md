# 🎵 Music Player Using Stack (C++)

This project simulates a **Music Player** using a **Linked List–based Stack** in C++.  
Each new track is pushed onto the stack, and “Previous Track” plays the last played track by popping it.

A simple but powerful example of:
✔️ Stack (LIFO)  
✔️ Linked List nodes  
✔️ Memory handling  
✔️ Real-world simulation of music app behavior  

---

## 🚀 Features

### ✔️ Play Track  
Adds a track to the stack and marks it as *currently playing*.

### ✔️ Play Previous Track  
Pops the top track (last played) and plays the one before it.

### ✔️ Stack-Based History  
The player keeps track of the playback history using a **Last-In-First-Out** mechanism.

---

## 📌 Example Menu

Play Track

Previous Track

Exit


---

## 📂 Code Structure

### **Node Class**
Holds:
- Track name  
- Pointer to next node  

### **LLStack Class**
Implements:
- `isEmpty()`  
- `playtrack(string track)` → push  
- `playprevioustrack()` → pop  

### **main() Loop**
Takes repeated user input until Exit.

---

## 🧠 How It Works (Logic)

1. When you play a track:
   - It gets **pushed** onto the stack  
2. When you press “Previous Track”:
   - Top of stack is **popped**  
   - Reveals the track before it  
3. If stack is empty, no history is available  

This is exactly how real music players maintain playback history.

---

📘 Learning Outcomes

By completing this project, you will understand:

✔️ Linked list fundamentals

✔️ Stack operations using nodes

✔️ Real implementation of LIFO behavior

✔️ Menu-driven program structure

✔️ Dynamic memory allocation with new and delete

---

👨‍💻 Author

Ishtiaq Ahmed
AI Student • C++ Developer • Data Structures Enthusiast
