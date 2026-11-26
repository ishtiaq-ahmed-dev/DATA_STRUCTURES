<div align="center">

# DATA_STRUCTURES

**Data structures built by hand in C++, each one wrapped around a small real-world problem.**

[![Language](https://img.shields.io/badge/language-C%2B%2B-00599C?style=flat-square&logo=cplusplus&logoColor=white)](https://isocpp.org/)
[![Standard](https://img.shields.io/badge/standard-C%2B%2B11-informational?style=flat-square)](#build)
[![No STL containers](https://img.shields.io/badge/STL%20containers-none-orange?style=flat-square)](#contents)
[![Programs](https://img.shields.io/badge/programs-16-brightgreen?style=flat-square)](#contents)

[Contents](#contents) · [How it is organised](#how-it-is-organised) · [Build](#build) · [Usage](#usage) · [Project layout](#project-layout) · [Author](#author)

</div>

---

My Data Structures lab work from university. Every linked list, stack, queue and tree here is written from scratch with raw pointers and `new`/`delete`. None of the programs use `std::list`, `std::stack`, `std::queue`, `std::map` or `std::set`. Instead of abstract exercises, most tasks are dressed up as something concrete: a bus queue, a hospital emergency room, a music player's back button, a game matchmaking server.

## Contents

### Linked lists

| Program | Structure | What it does | Source |
|---|---|---|---|
| Passenger queue | Singly linked list | Bus passenger queue: insert at the front, back or a given position, remove from the front, print the line | [`BRT_Linked_List/brt_linkedlist.cpp`](BRT_Linked_List/brt_linkedlist.cpp) |
| Student queue (Code-a-Thon) | Singly linked list | Menu-driven queue for a T-shirt counter: add, serve, remove a student by ID, display, count | [`Code-a-Thon Problem/Code-a-Thon.cpp`](Code-a-Thon%20Problem/Code-a-Thon.cpp) |
| Doubly linked list | Doubly linked list | Insert at start, end or position, delete from the front, delete all, search; prints each node's prev, next and own address as a table | [`Doubly Linked List/DLL.cpp`](Doubly%20Linked%20List/DLL.cpp) |
| Hospital emergency queue | Doubly linked list | Critical patients go to the front, walk-ins to the back, others at a priority position; treated patients leave from the front | [`Hospital Emergency Queue System/Complete C++ ( Logical Code ).cpp`](Hospital%20Emergency%20Queue%20System/Complete%20C%2B%2B%20(%20Logical%20Code%20).cpp) |
| IP address manager | Doubly linked list | Reads comma-separated IPv4 addresses from the console or a file, checks the format of each, and prints the list forwards and backwards | [`Loading and Displaying IP Addresses Using a Doubly Linked List/IP_Adresses_Manager_(Solution).cpp`](Loading%20and%20Displaying%20IP%20Addresses%20Using%20a%20Doubly%20Linked%20List/IP_Adresses_Manager_(Solution).cpp) |
| Josephus problem | Circular doubly linked list | Takes names and a step count, eliminates every k-th person around the circle, and prints the survivor | [`Josephus Problem/Josephus Problem Solution.cpp`](Josephus%20Problem/Josephus%20Problem%20Solution.cpp) |
| Student performance analytics | Singly linked list | Loads student records from a text file, sorts copies of the list with an iterative bottom-up merge sort, and writes three reports | [`Student Performance Analytics System/solution.cpp`](Student%20Performance%20Analytics%20System/solution.cpp) |

### Stacks and queues

| Program | Structure | What it does | Source |
|---|---|---|---|
| Balanced brackets checker | Array-based stack | Checks that `()`, `[]` and `{}` open and close in the right order | [`The Balanced Brackets Checker/Solution.cpp`](The%20Balanced%20Brackets%20Checker/Solution.cpp) |
| Music player "Previous Track" | Linked-list stack | Playing a track pushes it; "previous" pops the last one played | [`The Music Player 'Previous Track' Button/Solution.cpp`](The%20Music%20Player%20'Previous%20Track'%20Button/Solution.cpp) |
| Dynamic circular queue | Circular array | Ring-buffer queue that starts at capacity 4 and doubles when full, re-packing elements in order | [`Dynamic Circular Queue/main.cpp`](Dynamic%20Circular%20Queue/main.cpp) |

### Trees

| Program | Structure | What it does | Source |
|---|---|---|---|
| Chronos time stabilizer | Binary search tree | Events keyed by year. Commands: `INJECT` (insert), `PARADOX` (delete, all three cases), `SEARCH`, `REPORT` (in-order), `EXIT` | [`Binary Search Tree(BST)/main.cpp`](Binary%20Search%20Tree(BST)/main.cpp) |
| Arena of Ratings | Binary search tree | Matchmaking engine keyed by player rating: join and leave, damage and heal, nearest-opponent match, range listing, rank, k-th player, duel path distance, tree stats | [`Arena of Ratings: BST-Based Real-Time Matchmaking Engine/arena.cpp`](Arena%20of%20Ratings%3A%20BST-Based%20Real-Time%20Matchmaking%20Engine/arena.cpp) |

### Pointers and dynamic memory

| Program | Concept | What it does | Source |
|---|---|---|---|
| Cafe bill | Pointers to variables | Reads coffee quantities through `int*` and prints the total | [`Pointers/Cafe_code`](Pointers/Cafe_code) |
| Secret code machine | Function pointer | Calls a factorial function through a function pointer to make a "secret key" | [`Pointers/Secret_Code_Machine`](Pointers/Secret_Code_Machine) |
| Sports score tracker | `malloc` / `free` | Stores each player's runs in a heap array sized at runtime | [`Pointers/sports score tracker.cpp`](Pointers/sports%20score%20tracker.cpp) |
| Attendance register | `calloc` / `free` | Marks present workers by roll number in a zeroed `bool` array and counts present and absent | [`Pointers/attendance register.cpp`](Pointers/attendance%20register.cpp) |

## How it is organised

One folder per task. Most folders hold the solution plus a README that explains it, and some also keep the original assignment and the work handed in with it:

- **Problem statements:** `QUESTION SCENARIO.txt` (Arena of Ratings), `Problem Statement.txt` (IP addresses), `Problem Statement 1.docx` (Code-a-Thon), `Questions.md` and `Question.md` (the two stack problems).
- **Posters:** Arena of Ratings, Code-a-Thon, Hospital Emergency Queue System and the IP address manager each have a poster PDF, and some a JPG too.
- **Write-ups:** the hospital queue folder has the full paper (`COMPLETE PAPER.docx`) and hand-traced dry runs (`Dry Run Pictures.pdf`).
- **Test runs:** Arena of Ratings ships two input files (`Test 1.txt`, `Test 2.txt`) with screenshots of the output.

## Build

Any C++11 compiler works (the code uses `nullptr`). Each program is a single file with no dependencies beyond the standard library. Folder names contain spaces, so quote the paths.

```bash
g++ -std=c++11 -Wall -o dcq "Dynamic Circular Queue/main.cpp"
g++ -std=c++11 -Wall -o josephus "Josephus Problem/Josephus Problem Solution.cpp"
```

The two files in `Pointers/` without an extension need `-x c++` so the compiler knows the language:

```bash
g++ -std=c++11 -x c++ -o cafe Pointers/Cafe_code
g++ -std=c++11 -x c++ -o secret Pointers/Secret_Code_Machine
```

On Windows with MSVC, use `cl /EHsc "<file>.cpp"`. For the extensionless files, add `/TP` to compile them as C++.

**Build notes**

- **Hospital Emergency Queue System** contains only the `Emergency_Room` class, because the assignment asked for the functions alone. To run it, add a `main()`, change `#incluse` on the first line to `#include`, and remove the two `#` comment lines at the bottom.
- **IP address manager** is missing the closing brace of the `while` loop in `main()`. Add a `}` before the final `return 0;` and it compiles.
- **Student performance analytics** reads from a hard-coded path set in `main()`. Point `path` at your own data file first (format below).

## Usage

Most programs are interactive: run them and follow the prompts or the numbered menu. A few read commands from standard input, so you can type them or pipe a file in.

**Arena of Ratings.** The first line is the number of commands, then one command per line.

```bash
g++ -std=c++11 -o arena "Arena of Ratings: BST-Based Real-Time Matchmaking Engine/arena.cpp"
./arena < input.txt
```

where `input.txt` looks like:

```text
5
JOIN 50 Ares 120
JOIN 20 Luna 100
MATCH 25
STATUS 50
STATS
```

**Chronos time stabilizer (BST).** Reads commands until `EXIT`.

```text
INJECT 1969 Moon Landing
INJECT 1989 Fall of the Berlin Wall
SEARCH 1969
PARADOX 1989
REPORT
EXIT
```

**Student performance analytics.** The input file has one header line, then one record per line:

```text
<id> <first_name> <last_name> <dept> <semester> <cgpa> <credits> <enrollment_year>
```

It writes `sorted_by_enrollment.txt` (grouped by year, with the average CGPA per cohort), `department_analysis.txt` (by department and semester, with min, max and average CGPA) and `performance_tiers.txt` (five CGPA bands with counts and percentages).

**IP address manager.** Option 1 takes a comma-separated line typed in, option 2 asks for a filename and reads the first line of that file, for example:

```text
192.168.1.10,10.0.0.5,172.16.0.1,8.8.8.8
```

## Project layout

```text
DATA_STRUCTURES/
├── Arena of Ratings: BST-Based Real-Time Matchmaking Engine/
│   ├── arena.cpp
│   ├── QUESTION SCENARIO.txt
│   ├── Test 1.txt, Test 2.txt, Test 1 output.png, Test 2 output.png
│   ├── POSTER For Arena of Ratings .jpg / .pdf
│   └── README.md
├── Binary Search Tree(BST)/                main.cpp, README.md
├── BRT_Linked_List/                        brt_linkedlist.cpp, Readme.md
├── Code-a-Thon Problem/                    Code-a-Thon.cpp, Problem Statement 1.docx, poster PDF, README.md
├── Doubly Linked List/                     DLL.cpp, README.md
├── Dynamic Circular Queue/                 main.cpp, Readme.md
├── Hospital Emergency Queue System/        Complete C++ ( Logical Code ).cpp, paper, dry runs, posters, README.md
├── Josephus Problem/                       Josephus Problem Solution.cpp, README.md
├── Loading and Displaying IP Addresses Using a Doubly Linked List/
│                                           IP_Adresses_Manager_(Solution).cpp, Problem Statement.txt, poster PDF, README.md
├── Pointers/                               Cafe_code, Secret_Code_Machine, sports score tracker.cpp,
│                                           attendance register.cpp, Readme.md
├── Student Performance Analytics System/   solution.cpp
├── The Balanced Brackets Checker/          Solution.cpp, Questions.md, README.md
├── The Music Player 'Previous Track' Button/  Solution.cpp, Question.md, README.md
└── README.md
```

> The Arena of Ratings folder name contains a colon, which Windows does not allow in file names. Git on Windows cannot check that folder out. Clone on Linux, macOS or WSL to get it, or read it on GitHub.

## License

No license file is included. The code is shared for learning and reference as part of university coursework; ask before reusing it.

## Author

**Ishtiaq Ahmed**<br>
University student, Artificial Intelligence enthusiast.<br>
GitHub: [@ishtiaq-ahmed-dev](https://github.com/ishtiaq-ahmed-dev)
