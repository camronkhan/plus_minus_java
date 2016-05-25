# plus_minus_java

##Pseudocode

```java
private static void recursiveSum(LinkedList list, Node currentNode, int left, int right) {
    IF the current node is null {
        Create an iterator to iterate over the list
        WHILE there is still another item in the list {
            IF the difference between the two subsets (i.e., left and right) is equal to the current node’s value {
                Print “Yes”
                Exit the program
            }
            Otherwise, iterate to the next node
        }
    }
    ELSE perform a “pseudo” pre-order binary tree traversal {
        Recursively add each list item to the left subset
        Recursively add each list item to the right subset
    }
}
```

##Explanation

This sequence of operations correctly solves the problem because it generates all possible pairs of sums.  The algorithm recursively adds each list item to either a left subset representing positive numbers or a right subset representing negative numbers.  By making two recursive calls the algorithm acts as if it is performing depth-first, pre-order traversal on a binary tree.
For example, the figure below depicts the algorithm’s processing of the list [27, 6, 12, 11] by recursively performing the following 3 steps:
1 Evaluate the current value of the root
2 "Traverse” the left sub-tree by recursively calling recursiveSum
3 “Traverse” the right sub-tree by recursively calling recursiveSum

The first step evaluates the current value.  Next, the algorithm recursively adds the current node’s value to the left (i.e., positive) subset.  When a leaf is reached, it begins recursively adding the current node’s value to the right (i.e., negative) subset.  After both leaves have been evaluated, it backs up one level and continues the recursive process.  

After each leaf evaluation, the list of numbers to be added to a given subset is exhausted.  Consequently, the base case is met wherein the difference of the left subset minus the right subset for each path is compared against each number in the list.  If a match is found, “Yes” is printed to the console and a call to exit is made.  Otherwise, if no match is found, recursion continues to the next leaf.


##Algorithm Complexity Analysis

The worst case scenario is in which no difference of leaf subsets matches any element in the list.  In such cases, the algorithm performs a brute force traversal in which every possible subset combination (or leaf) is evaluated.  The two recursive calls required to produce all possible subset combinations results in an O(2n) complexity.  However, since the worst case scenario involves comparing each subset difference against each item in the list, a more accurate complexity is O(n*2n).  In either case, this algorithm is extremely inefficient.