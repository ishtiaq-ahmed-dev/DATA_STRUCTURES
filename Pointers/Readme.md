# C++ Pointer Examples: Coffee Billing & Secret Key Calculator

This repository contains two simple C++ programs demonstrating basic pointer concepts and function pointers.

---

## 1. Coffee Billing Program

A simple program to calculate the total bill for coffee orders. It uses pointers to handle user input quantities and calculates the cost based on fixed prices for Espresso, Latte, and Cappuccino.

### How It Works

- Prices for each coffee type are predefined:
  - Espresso: 10 units
  - Latte: 20 units
  - Cappuccino: 30 units
- The program declares integer variables to store quantities.
- It uses pointers to these quantity variables to take input from the user.
- Then, it calculates the cost for each coffee type by multiplying the quantity by its price.
- Finally, it sums up all costs and displays the total bill.

### Sample Input/Output

Enter the quantity of Espresso: 2
Enter the quantity of Latte: 1
Enter the quantity of Cappuccino: 3
Total Bill: 130


---

## 2. Secret Key Calculator Program

This program calculates the factorial of a number entered by the user, referred to as the "secret key." It demonstrates the use of **function pointers** in C++.

### How It Works

- The function `secret_code(int a)` computes the factorial of the input number `a` using a loop.
- It multiplies numbers from `a` down to 1 to get the factorial.
- The program uses a function pointer `ptr_secret_code` to point to the `secret_code` function.
- The function pointer is then used to call the factorial function.

### Why Use Function Pointers?

- Function pointers allow dynamic function calls.
- They can be useful in scenarios like callbacks, event handling, or selecting functions at runtime.

### Sample Input/Output

Enter a number: 5
The secret key is: 120


---

## How to Compile and Run

### Coffee Billing

```bash
g++ coffee_billing.cpp -o coffee_billing
./coffee_billing


###Secret Key Calculator

g++ secret_code.cpp -o secret_code
./secret_code

Summary

Both programs highlight core C++ concepts involving pointers.

The first program uses pointers to input and process data stored in variables.

The second program introduces function pointers to call functions dynamically.

License

This project is open source and free to use.
