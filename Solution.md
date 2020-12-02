<!--
 * @Author: your name
 * @Date: 2020-12-02 14:17:07
 * @LastEditTime: 2020-12-02 14:27:49
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
