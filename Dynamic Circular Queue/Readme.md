# 🔄 Dynamic Circular Queue in C++ (with Auto-Resizing)

This project implements a **circular queue** using **dynamic arrays** in C++, with automatic resizing when the queue becomes full.  
It demonstrates:

- Queue fundamentals  
- Dynamic memory handling  
- Circular indexing  
- Automatic resizing (capacity × 2)  
- Front and rear pointer logic  

A perfect demonstration of **DSA + real-world queue behavior**.

---

## 🚀 Features

### ✔️ Circular Queue Implementation  
Uses modular arithmetic:  
(index + 1) % capacity

This ensures efficient space usage.

### ✔️ Automatic Resizing  
When the queue is full → capacity doubles internally.

### ✔️ Core Operations
| Operation | Description |
|----------|-------------|
| `enqueue()` | Adds element at rear |
| `dequeue()` | Removes element from front |
| `front()` | Shows front element |
| `print()` | Displays queue contents |
| `resize()` | Doubles array capacity when full |

---

## 📂 Code Structure

### **Private Members**
- `int* arr` – dynamic array  
- `int capacity` – max current capacity  
- `int frontIdx` – first element  
- `int raerIdx` – next insertion point  
- `int currentSize` – number of stored elements  

### **resize() Function**
Copies elements in correct queue order using:
```cpp
(arr[(frontIdx + i) % capacity])

---

🧠 Learning Outcomes

After studying this code, you will understand:

✔️ How circular queues work

✔️ How dynamic memory is managed in C++

✔️ How to resize arrays manually

✔️ Preventing overflow/underflow

✔️ Queue behavior in operating systems, networks & simulations

✔️ Modular indexing

This is one of the most important queue implementations used in real-world systems.

👨‍💻 Author

Ishtiaq Ahmed
AI Student • C++ & Python Developer • Data Structures & Algorithms Enthusiast
