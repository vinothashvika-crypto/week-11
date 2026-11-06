# Week 11 – Quiz and Concept Question Answers

Topic: data structures, complexity, searching, two pointers and sliding windows.

## Part B – Quiz

| Q | Answer | Why |
|---|--------|-----|
| 1 | **B** | A data structure defines how data is organized, stored and accessed efficiently for the operations you need. |
| 2 | **D** | Non-primitive structures (arrays, lists, maps…) are built from primitives and hold collections of values. |
| 3 | **C** – O(1) | Array access by index is a direct address calculation. |
| 4 | **C** – O(n²) | A loop of n nested inside a loop of n runs n × n times. |
| 5 | **B** – O(m + n) | Sequential, independent loops add. |
| 6 | **A, C, D** | Deletion, traversal and updating are data-structure operations. Debugging and compilation are not. |
| 7 | **C** | Sorting by date enables O(log n) binary search for date ranges. |
| 8 | **D** – Sorted array | Fast O(log n) search, keeps order, and inserts and deletes are rare. |
| 9 | **C** | Two pointers rely on sorted or otherwise ordered data to skip brute-force pairs. |
| 10 | **C** | A sliding window reuses the overlap between windows, turning O(n × k) or O(n²) into O(n). |

## Part C – Concept Questions

**1. Primitive vs. non-primitive data structures.**
A **primitive** type holds a single value of a fixed, language-defined size and is built into the language. A Java `boolean` is one example (beyond the usual `int` and `char`). A **non-primitive** structure is built from primitives, can hold many values, and is often user-defined or provided by a library. Examples include a `PriorityQueue` of tasks, or a `Matrix` class that wraps a `double[][]`.

**2. Why a linked list is still linear.**
"Linear vs. non-linear" is about the **logical arrangement** of elements, not where they sit in memory. In a linked list, every element has at most one predecessor and one successor, and you traverse it in a single sequence from head to tail, so it is **linear**. Contiguous vs. scattered storage is a separate property (array vs. linked storage). Non-linear structures such as trees and graphs let one element connect to *several* others in a hierarchy or network.

**3. O(m + n) vs. O(m × n).**
Two *independent, sequential* loops do m steps and then n steps, so their costs **add**: O(m + n). When one loop is *nested* inside the other, the inner loop's m steps repeat for each of the outer loop's n iterations, so the costs **multiply**: O(m × n). The rule: sequential blocks add, nested blocks multiply. Also, two different inputs keep separate variables. You can't merge them into a single "n".

**4. Trading memory for time (a real scenario).**
A ride-sharing app shows "estimated fare" thousands of times per second. Recomputing the route distance between two map zones on every request is expensive. Instead, the app precomputes and **caches** a table of zone-to-zone distances (a `HashMap<ZonePair, Double>`, or an in-memory cache like Redis). Each request becomes an O(1) lookup instead of a path computation (for example Dijkstra's algorithm, roughly O(E log V)). The trade is **extra memory** for the cached table in exchange for much **lower lookup time** on a very frequent operation.

**5. Hash map vs. sorted array for employee records.**
- **Hash map (keyed by employee ID):** O(1) average search, insert and delete. It is best when the main operation is "find employee by ID" and records change often. It does *not* keep order, and range queries such as "IDs between E100 and E200" or ordered listing need a full scan or a sort.
- **Sorted array (sorted by ID):** O(log n) search with binary search and O(1) access by position. Ordered listing and range queries are easy and memory use is compact. But insert and delete are O(n) because elements must shift.

So: choose a hash map for frequent lookups and frequent changes keyed by an exact ID. Choose a sorted array when the data is mostly read, needs to stay ordered, or needs range queries, and updates are rare.
