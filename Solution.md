<!--
 * @Author: your name
 * @Date: 2020-12-02 14:17:07
 * @LastEditTime: 2020-12-06 17:04:47
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/Solution.md
-->

# Solution

## 80. Remove Duplicates from Sorted Array II

1. create 2 pointers: slow and fast

2. the fast pointer iterates through the array, and the slow one represents the end of the 'new array'

3. if the fast pointer satisfy the condition, it will be added to the 'new array'

4. return the slow array's index, which is the length of the 'new array'

## 33, 81. Search in Rotated Sorted Array I, II

1. The array can be divided into 2 parts, all of the member in 1st part are greater than those in the 2nd part

2. Use a binary search

3. There are 4 possibilities for mid point and target: Figure out whether the mid point and the target are in the same part, if yes, turn to the normal binary search problem; if not, shorten the search scope according to which part the mid point is in.

4. (II)If there are duplicates in the array, there's another possibility when the mid point is the same as start point or end point, we won't know about which part is mid point in in this situation. So we have to step in the start point.

## 382. Linked List Random Node

Using a reservoir sampling, each number has the same probability in current scope.

# Binary Tree

Whether we need a helper function to recurse binary tree depends on whether the return node is the root.

## 114. Flatten Binary Tree to Linked List

post-order  traversal

## 897. Increasing Order Search Tree

in-order traversal

## 95. Unique Binary Search Trees II

for i in [1, n], left subtree contains [1, i - 1], right subtree contains [i + 1, n].

## 96. Unique Binary Search Trees

Dynamic Programming: sum of for each number of root, answer of left subtree * answer of right subtree.

i: ith num,  n: in total n nums
F(i, n) = G(i - 1) * G(n - i)
G(i) = F(1, i) + F(2, i) + ... + F(i-1, i)

## 222.Count Complete Tree Nodes

Solution 1: Recursion
return 1 + count(root.left) + count(root.right);
Time Complexity: O(n)

Solution 2: halve the tree in each recursion step, find if the left subtree and right subtree has the same height.
If they have the same height, the left tree is complete, we recursively count the nodes in right subtree plus 2^(h-1)-1 in left subtree and 1 on root;
If they are not, the right tree is complete, we recursively count the nodes in left subtree plus 2^h-1 in right subtree and 1 on root.
Time Complexity: O(log(n)^2)

## 86. Partition List

1. Make two linked lists, with two dummy nodes and two pointers, one for smaller nodes, the other for bigger nodes.

2. Iterate from head, put each node into new linked list.

3. Connect these two linked lists.

## 93. Restore IP Addresses

1. Use backtracking algorithm.

2. for each number in the scope of 1 to 3 digit and less than 255, backtrack the following part, when 4 numbers are found and all 4 numbers are correct, add it to the result.

3. Be careful of the starting with '0' case.
