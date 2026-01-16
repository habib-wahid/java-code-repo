# Java Code Repository

A comprehensive collection of Java implementations covering **Data Structures & Algorithms**, **Design Patterns**, **LeetCode Problems**, **Java Core Features**, **SOLID Principles**, **Multithreading**, and **Stream API**.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Project Structure](#project-structure)
- [Algorithms](#algorithms)
- [Design Patterns](#design-patterns)
- [LeetCode Problems](#leetcode-problems)
- [Core Java Features](#core-java-features)
- [SOLID Principles](#solid-principles)
- [Multithreading & Concurrency](#multithreading--concurrency)
- [Stream API](#stream-api)
- [Getting Started](#getting-started)
- [Contributing](#contributing)

---

## 🎯 Overview

This repository serves as a learning resource and reference implementation for:

- **Interview Preparation**: Commonly asked coding problems and system design concepts
- **Algorithm Practice**: Classic algorithms with clear implementations
- **Design Patterns**: Industry-standard software design patterns
- **Java Mastery**: Modern Java features, concurrency, and best practices

---

## 📁 Project Structure

```
src/
├── algorithm/          # Data structures & classic algorithms
├── designpattern/      # Design pattern implementations
├── leetcode/           # LeetCode problem solutions
│   └── interviewprep/  # Interview-focused problems
├── rawjava/            # Core Java concepts & features
│   ├── multi_threading/ # Threading examples
│   └── stream/         # Stream-related utilities
├── solid/              # SOLID principles demonstrations
├── stream/             # Stream API examples
└── thread/             # Threading concepts
```

---

## 🔢 Algorithms

### Graph Algorithms
| File | Description |
|------|-------------|
| `BFS.java` | Breadth-First Search traversal with adjacency list |
| `DFS.java` | Depth-First Search recursive implementation |
| `Dijkstra.java` | Shortest path algorithm using Priority Queue |
| `UnionFind.java` | Disjoint Set Union with path compression |
| `SpanningTree.java` | Minimum Spanning Tree algorithms |

### Tree Data Structures
| File | Description |
|------|-------------|
| `BinarySearchTree.java` | BST with insert, search, delete operations |
| `BinaryHeap.java` | Max-heap with heapify, insert, delete |
| `TreeTraversal.java` | Inorder, Preorder tree traversals |
| `BalancedBinaryTree.java` | AVL/Balanced tree implementation |
| `FullBinaryTree.java` | Full binary tree validation |

---

## 🏗️ Design Patterns

### Creational Patterns

#### Singleton Pattern (`SingleTon.java`)
Multiple singleton implementations with detailed explanations:
- **Eager Initialization** - Instance created at class loading
- **Lazy Initialization** - Instance created on demand
- **Synchronized Singleton** - Thread-safe but slow
- **Double-Check Locking** - Volatile + synchronized
- **Bill Pugh Singleton** - Inner static helper class (recommended)

#### Factory Pattern
| File | Description |
|------|-------------|
| `FactoryClient.java` | Client code demonstrating factory usage |
| `factory/ProductFactory.java` | Factory for creating products |
| `interfaces/Product.java` | Product interface |
| `concrete_implementation/ProductA.java, ProductB.java` | Concrete products |

### Behavioral Patterns

#### Strategy Pattern
Payment processing with interchangeable strategies:
- `interfaces/PaymentStrategy.java` - Strategy interface
- `context/PaymentContext.java` - Context class
- `concrete_implementation/` - PayPalStrategy, CreditCardStrategy, DebitCardStrategy

#### Observer Pattern
Stock notification system:
- `observable/StockObservable.java` - Subject interface
- `observable/IPhoneStockObservable.java` - Concrete subject
- `observer/Observer.java` - Observer interface
- `observer/EmailObserver.java, MessageObserver.java` - Concrete observers

### Structural Patterns

#### Decorator Pattern (`decorator/DecoratorMain.java`)
Coffee decoration example with dynamic feature addition.

---

## 💻 LeetCode Problems

### Graph Problems
| Problem | Difficulty | Topics |
|---------|------------|--------|
| `NumberOfIslands.java` | Medium | BFS, DFS, Matrix |
| `CloneGraph.java` | Medium | DFS, HashMap |
| `CourseSchedule.java` | Medium | Topological Sort, DFS |
| `CourseSchedule2.java` | Medium | Topological Sort |
| `SurroundedRegions.java` | Medium | DFS, Matrix |
| `GraphValidTree.java` | Medium | Union Find, DFS |
| `NetworkDelayTime.java` | Medium | Dijkstra |
| `WordLadder.java` | Hard | BFS |
| `EvaluateDivision.java` | Medium | Graph, DFS |

### Tree Problems
| Problem | Difficulty | Topics |
|---------|------------|--------|
| `BinaryTreeRightSideView.java` | Medium | BFS, DFS |
| `LowestCommonAncestor.java` | Medium | Tree, Recursion |
| `SerializeDeserializeBinaryTree.java` | Hard | BFS, Tree |
| `SubtreeOfAnotherTree.java` | Easy | Tree, DFS |
| `ConstructBinaryTree.java` | Medium | Tree, Recursion |
| `TreeDiameter.java` | Medium | DFS |
| `SumRootToLeaf.java` | Easy | Tree, DFS |
| `MinimumDifferenceBST.java` | Easy | BST, Inorder |

### Heap & Priority Queue
| Problem | Difficulty | Topics |
|---------|------------|--------|
| `KthLargest.java` | Easy | Heap |
| `KthLargestElement.java` | Medium | Heap, QuickSelect |
| `KClosestPointsToOrigin.java` | Medium | Heap |
| `FindKPairsWithSmallestSums.java` | Medium | Heap |
| `TaskSchedular.java` | Medium | Heap, Greedy |
| `SmallestInfiniteSet.java` | Medium | Heap, Set |

### String Problems
| Problem | Difficulty | Topics |
|---------|------------|--------|
| `LongestSubstringWithoutRepeatingCharacter.java` | Medium | Sliding Window |
| `GCDofString.java` | Easy | String, Math |
| `MergeStringAlternately.java` | Easy | String |
| `Urlify.java` | Easy | String |

### Design Problems
| Problem | Difficulty | Topics |
|---------|------------|--------|
| `DesignTwitter.java` | Medium | Heap, HashMap, Design |
| `RandomizedSet.java` | Medium | HashMap, ArrayList |
| `MinimumGeneticMutation.java` | Medium | BFS |

### Interview Prep (`leetcode/interviewprep/`)
| File | Description |
|------|-------------|
| `DynamicProgramming.java` | DP problems (Climbing Stairs, House Robber, Min Cost) |
| `Graph.java` | Pacific Atlantic Water Flow, Clone Graph |
| `LruCache.java` | LRU Cache with doubly linked list + HashMap |
| `Trie.java` | Trie data structure, Word Search II |
| `LinkedList.java` | Linked list operations |
| `BackTrack.java` | Backtracking problems |
| `Neet75ArrayAndHashing.java` | Array & hashing patterns |

---

## ☕ Core Java Features

### Lambda & Functional Programming
| File | Description |
|------|-------------|
| `JavaLambda.java` | Lambda expressions, method references |
| `FunctionalInterface.java` | Custom functional interface |
| `FunctionalInterfaceExample.java` | FunctionalInterface annotation, default methods |

### Object-Oriented Concepts
| File | Description |
|------|-------------|
| `EqualsAndHashCodeEmpl.java` | Proper equals() and hashCode() implementation |
| `ClassExample.java` | Java class fundamentals |
| `Dog.java` | Inheritance example |
| `Comparision.java` | Comparator and Comparable |

---

## 🎯 SOLID Principles

### Liskov Substitution Principle (`LiskovSubstitution.java`)
Demonstrates proper inheritance hierarchy with Vehicle, EngineVehicle, Car, MotorCycle, and ByCycle classes.

---

## 🔄 Multithreading & Concurrency

### Thread Basics
| File | Description |
|------|-------------|
| `ThreadCreationExample.java` | Thread creation using Runnable and Thread |
| `SynchronizedExample.java` | synchronized method, block, and static sync |
| `ThreadRaceConditionSolution.java` | Handling race conditions |

### Advanced Concurrency
| File | Description |
|------|-------------|
| `AtomicExample.java` | AtomicInteger, atomic operations |
| `JavaLockImpl.java` | ReentrantLock implementation |
| `ExecutorExample.java` | Executor framework basics |
| `ExecutorThreadPoolExample.java` | Thread pool management |
| `CompletableFutureExample.java` | Async programming |
| `VolatileExample.java` | Volatile keyword usage |

---

## 🌊 Stream API

| File | Description |
|------|-------------|
| `StreamApiExample.java` | Stream laziness, map, filter, reduce |
| `rawjava/stream/MySerializable.java` | Serialization with streams |

---

## 🚀 Getting Started

### Prerequisites
- Java 17 or higher
- Any Java IDE (IntelliJ IDEA recommended)

### Running Examples

1. Clone the repository:
```bash
git clone <repository-url>
cd java-code-repo
```

2. Open in your IDE and navigate to any file

3. Run the `main()` method of any class to see the implementation in action

### Example:
```bash
# Compile and run BFS algorithm
cd src
javac algorithm/BFS.java
java algorithm.BFS
```

---

## 📚 Learning Path

1. **Beginners**: Start with `rawjava/` for Java fundamentals
2. **Data Structures**: Move to `algorithm/` for classic implementations
3. **Problem Solving**: Practice with `leetcode/` problems
4. **Design**: Study `designpattern/` for software design
5. **Advanced**: Explore `rawjava/multi_threading/` for concurrency

---

## 🤝 Contributing

Contributions are welcome! Feel free to:
- Add new algorithm implementations
- Add more LeetCode solutions
- Improve existing code with better approaches
- Add documentation and comments

---

## 📄 License

This project is open source and available for educational purposes.

---

**Happy Coding! 🎉**

