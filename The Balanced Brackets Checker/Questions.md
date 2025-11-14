# C++ Stack Practice Problems

Here are several scenario-based problems designed to help you practice and understand the various uses of the Stack data structure.

---

## 🏛️ Problem : The Balanced Brackets Checker

### Scenario
You are building a linter for a new code editor. The most fundamental feature is checking for valid syntax. The first step is to ensure that all brackets (or parentheses) are **balanced**. This means every opening bracket has a matching closing bracket in the correct order.

### Task
Write a C++ function `bool areBracketsBalanced(string expression)` that takes a string and returns `true` if all brackets are balanced, and `false` otherwise.

Your function must handle three types of brackets:
* Parentheses: `(` and `)`
* Square Brackets: `[` and `]`
* Curly Braces: `{` and `}`

### Logic Hint
1.  Create a stack that can hold characters (`char`).
2.  Iterate through the `expression` string, character by character.
3.  If you encounter an **opening bracket** (`(`, `[`, or `{`), **push** it onto the stack.
4.  If you encounter a **closing bracket** (`)`, `]`, or `}`):
    * Check if the stack is **empty**. If it is, you found a closing bracket with no opener. Return `false`.
    * If it's not empty, **pop** the top element.
    * Check if the popped element is the **matching opener** for the current closing bracket.
        * If `)` is found, the popped element must be `(`.
        * If `]` is found, the popped element must be `[`.
        * If `}` is found, the popped element must be `{`.
    * If they do **not** match, return `false`.
5.  After the loop finishes, check if the stack is **empty**. If it is, all brackets were matched. Return `true`. If it's *not* empty, it means there are leftover opening brackets. Return `false`.

### Test Cases
* `"{[()]}"` $\to$ **true**
* `"{[(])}"` $\to$ **false** (Mismatched: `]` found, `(` expected)
* `"{{[[(())]]}}"` $\to$ **true**
* `"{"` $\to$ **false** (Leftover opener)
* `")"` $\to$ **false** (Closing bracket with no opener)

---
