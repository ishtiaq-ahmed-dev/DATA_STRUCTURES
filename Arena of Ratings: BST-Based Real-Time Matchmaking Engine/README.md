# Arena of Ratings: BST-Based Real-Time Matchmaking Engine

A high-performance matchmaking system for competitive gaming built from scratch using Binary Search Trees in C++.

## 📋 Overview

**Arena of Ratings** is a custom implementation of a real-time player matchmaking and leaderboard engine for competitive games. The system efficiently manages player data, finds optimal opponents, tracks rankings, and performs complex queries - all implemented using a pointer-based Binary Search Tree without relying on STL containers like `map` or `set`.

## 🎯 Problem Statement

Design and implement a matchmaking engine that:
- Manages players identified by unique rating values
- Supports dynamic join/leave operations
- Finds nearest opponents for matchmaking
- Performs range queries and ranking operations
- Calculates structural diagnostics and path distances
- Handles all operations efficiently in real-time

## 🛠️ Technical Implementation

### Data Structure
- **Binary Search Tree (BST)** with custom node implementation
- Each node stores: `rating` (key), `name`, `hp` (health points)
- Left/right child pointers for tree structure
- Ordered exclusively by rating for all operations

### Core Features

#### Player Management
- `JOIN` - Add new players with duplicate prevention
- `LEAVE` - Remove players (handles all 3 deletion cases)
- `STATUS` - Query player information by rating
- `DAMAGE/HEAL` - Update player health points

#### Matchmaking Operations
- `MATCH` - Find closest opponent with tie-breaking rules
- `NEXT` - Find next higher rated player
- `PREV` - Find next lower rated player

#### Query Operations
- `RANGE` - List players in rating range (sorted)
- `RANK` - Count players below a rating threshold
- `KTH` - Find k-th ranked player

#### Advanced Features
- `DUEL` - Calculate path distance between two players (LCA algorithm)
- `STATS` - Display system statistics (players, min, max, height, leaves)

## 💻 Implementation Details

### Key Algorithms
- **Insertion**: Recursive with duplicate checking - O(log n) average
- **Deletion**: Handles leaf, single-child, and two-child cases using in-order successor
- **Search**: Binary search traversal - O(log n) average
- **Traversal**: In-order for sorted output - O(n)
- **Rank Calculation**: Recursive counting - O(n)
- **Path Finding**: Lowest Common Ancestor (LCA) approach

### Complexity Analysis
| Operation | Average Case | Worst Case |
|-----------|-------------|------------|
| Insert    | O(log n)    | O(n)       |
| Delete    | O(log n)    | O(n)       |
| Search    | O(log n)    | O(n)       |
| Range     | O(k + log n)| O(n)       |
| Rank/KTH  | O(n)        | O(n)       |
| DUEL      | O(log n)    | O(n)       |

*Note: Worst case occurs with skewed trees*

## 🚀 Usage

### Compilation
```bash
g++ -o arena arena.cpp
```

### Running the Program

**Method 1: Direct Input (Console)**
```bash
./arena
```
Then type your commands directly:
```
5
JOIN 50 Ares 120
JOIN 20 Luna 100
MATCH 25
STATUS 50
STATS
```

**Method 2: Using Input File (Optional)**
```bash
./arena < input.txt
```

**Method 3: Pipe Input**
```bash
echo "3
JOIN 50 Ares 120
STATUS 50
STATS" | ./arena
```

### Input Format
```
<Q>                          # Number of commands
<COMMAND> <parameters>       # Each command on new line
```

### Example Session
**Input:**
```
5
JOIN 50 Ares 120
JOIN 20 Luna 100
MATCH 25
STATUS 50
STATS
```

**Output:**
```
JOINED
JOINED
20 Luna 100
50 Ares 120
PLAYERS 2
MIN 20
MAX 50
HEIGHT 1
LEAVES 1
```

## 📊 Sample Test Cases

### Test Case 1: Basic Operations
**Input:**
```
16
JOIN 50 Ares 120
JOIN 20 Luna 100
JOIN 70 Neo 90
JOIN 10 Ivy 80
JOIN 30 Omar 110
MATCH 25
NEXT 30
PREV 30
RANGE 15 55
KTH 3
RANK 50
DUEL 10 70
LEAVE 20
RANGE 0 100
STATS
```

**Output:**
```
JOINED
JOINED
JOINED
JOINED
JOINED
20 Luna 100
50 Ares 120
20 Luna 100
20 Luna 100
30 Omar 110
50 Ares 120
30 Omar 110
3
DIST 3
LEFT
10 Ivy 80
30 Omar 110
50 Ares 120
70 Neo 90
PLAYERS 4
MIN 10
MAX 70
HEIGHT 2
LEAVES 2
```

### Test Case 2: Edge Cases
**Input:**
```
10
JOIN 100 Hero 200
JOIN 100 Duplicate 150
LEAVE 999
STATUS 999
MATCH 100
NEXT 200
PREV 50
KTH 5
RANGE 50 150
STATS
```

**Output:**
```
JOINED
DUPLICATE
NOT FOUND
NOT FOUND
EMPTY
NONE
NONE
OUT OF RANGE
100 Hero 200
PLAYERS 1
MIN 100
MAX 100
HEIGHT 0
LEAVES 1
```

## 🎓 Educational Value

This project demonstrates:
- ✅ Custom BST implementation without STL
- ✅ Proper deletion handling (all 3 cases)
- ✅ Recursive tree algorithms
- ✅ In-order traversal applications
- ✅ Tree height and structure analysis
- ✅ LCA (Lowest Common Ancestor) algorithm
- ✅ Efficient matchmaking logic

## 🔧 Technical Constraints

- No use of `std::map`, `std::set`, or similar STL containers
- Pointer-based dynamic memory management
- All operations maintain BST ordering property
- Handles edge cases (empty tree, single node, duplicates)

## 📝 Command Reference

| Command | Syntax | Description | Output |
|---------|--------|-------------|--------|
| JOIN | `JOIN <rating> <name> <hp>` | Add player | `JOINED` or `DUPLICATE` |
| LEAVE | `LEAVE <rating>` | Remove player | `LEFT` or `NOT FOUND` |
| STATUS | `STATUS <rating>` | Query player info | `<rating> <name> <hp>` or `NOT FOUND` |
| DAMAGE | `DAMAGE <rating> <amount>` | Reduce HP | `DAMAGED <new_hp>` or `NOT FOUND` |
| HEAL | `HEAL <rating> <amount>` | Increase HP | `HEALED <new_hp>` or `NOT FOUND` |
| MATCH | `MATCH <X>` | Find closest opponent | `<rating> <name> <hp>` or `EMPTY` |
| NEXT | `NEXT <X>` | Find next higher rating | `<rating> <name> <hp>` or `NONE` |
| PREV | `PREV <X>` | Find next lower rating | `<rating> <name> <hp>` or `NONE` |
| RANGE | `RANGE <L> <R>` | List players in range | Player list or `EMPTY` |
| RANK | `RANK <X>` | Count players below X | `<count>` |
| KTH | `KTH <k>` | Find k-th player | `<rating> <name> <hp>` or `OUT OF RANGE` |
| DUEL | `DUEL <A> <B>` | Path distance | `DIST <d>` or `NOT FOUND` |
| STATS | `STATS` | System statistics | Multiple lines with stats |

## 🐛 Known Limitations

- Tree can become unbalanced with sequential insertions (no auto-balancing)
- Memory cleanup on program exit could be improved with destructor
- Maximum input size limited to 200,000 operations

## 🚀 Future Improvements

- Implement AVL or Red-Black tree for guaranteed O(log n) operations
- Add destructor for proper memory cleanup
- Implement bulk operations for efficiency
- Add persistent storage for player data
- Optimize with augmented BST (storing subtree sizes in nodes)

## 👨‍💻 Author

**Ishtiaq Ahmed**

Data Structures Lab - Final Exam Project

## 📄 License

This project is part of a Data Structures Lab Final Exam and is intended for educational purposes.

## 🙏 Acknowledgments

- Data Structures Lab Course
- Binary Search Tree fundamentals
- Competitive programming concepts

## 📞 Contact

For questions or feedback, feel free to reach out or open an issue on GitHub.

---

*Built with ❤️ for learning Data Structures and Algorithms*

**⭐ If you found this helpful, please star the repository!**
