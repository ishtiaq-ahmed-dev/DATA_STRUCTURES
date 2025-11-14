# 🔢 Bracket Balance Checker (C++)

This project implements a **Bracket Balance Checker** using a **custom Array-Based Stack** in C++.  
It validates whether an expression contains properly balanced brackets:

- **() Round brackets**
- **{} Curly brackets**
- **[] Square brackets**

This program is useful for:
✔️ Expression validation  
✔️ Compiler design basics  
✔️ Understanding stack data structure  

---

## 🚀 Features

### ✔️ Custom Stack (ArrayStack)
Implements stack operations:
- `push()`
- `pop()`
- `peek()`
- `isEmpty()`
- `isFull()`

### ✔️ Balanced Expression Checker
Checks for valid bracket pairing:
- `(` matches `)`
- `{` matches `}`
- `[` matches `]`

### ✔️ Loop Input Mode
Enter expressions continuously until you type:


---

## 📂 Code Structure

### **ArrayStack class**
- Uses array of size 20
- Manages bracket operations

### **areBracketsBalanced()**
Core function to check matching brackets.

### **main() loop**
Keeps taking input until termination.

---

## 🧠 Logic Behind the Program

1. Traverse expression character by character  
2. Push every opening bracket  
3. When a closing bracket appears:
   - Check top of stack  
   - If match → pop  
   - If mismatch → expression invalid  
4. End:
   - If stack empty → Balanced  
   - Else → Not Balanced  

---

📘 Learning Outcomes

✔️ Learn stack fundamentals

✔️ Understand bracket-matching algorithms

✔️ Build real-world expression validators

✔️ Strengthen C++ object-oriented logic

---

👨‍💻 Author

Ishtiaq Ahmed
C++ Developer • AI Student • Data Structures Enthusiast
