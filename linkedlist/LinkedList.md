### Linked List
- [X] [Adding two numbers](https://leetcode.com/problems/add-two-numbers/description/)
- [X] [Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/description/)
- [X] [Sort 0's, 1's, 2's Linked List](https://takeuforward.org/plus/dsa/linked-list/logic-building/sort-a-ll-of-0's-1's-and-2's)
- [X] [19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)
- [X] [206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)
- [X] [Add One to LinkedList number](https://takeuforward.org/plus/dsa/linked-list/faqs--medium/add-one-to-a-number-represented-by-ll)
- [X] [876. Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/description/)
- [X] [Delete the Middle Node of a Linked List](https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/)
- [X] [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/description/)

#####  02 - Adding two numbers
```text
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
    order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.

    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1]
    example: 
    9 -> 9 -> 9 -> 9 -> 9 -> 9 -> 9 -> null
    9 -> 9 -> 9 -> 9 -> null
    8 -> 9 -> 9 -> 9 -> 0 -> 0 -> 0 -> 1 -> null
```
![img.png](src/test/java/linkedlist/img.png)

---
##### 03 - Odd Even Linked List
```text
    Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with
    even indices, and return the reordered list.

    The first node is considered odd, and the second node is even, and so on.
    Note that the relative order inside both the even and odd groups should remain as it was in the input.
    You must solve the problem in O(1) extra space complexity and O(n) time complexity.

    Input: head = [1,2,3,4,5]
    Output: [1,3,5,2,4]
    1 -> 2 -> 3 -> 4 -> 5 -> null
    1 -> 3 -> 5 -> 2 -> 4 -> null

    Input: head = [2,1,3,5,6,4,7]
    Output: [2,3,6,7,1,5,4]
    2 -> 1 -> 3 -> 5 -> 6 -> 4 -> 7 -> null
    2 -> 3 -> 6 -> 7 -> 1 -> 5 -> 4 -> null
```
---
##### 04 - Sort LinkedList 0, 1, 2
```text
    Given the head of a singly linked list consisting of only 0, 1 or 2. Sort the given linked list and return the head
    of the modified list. Do it in-place by changing the links between the nodes without creating new nodes.

    Input: head -> 1 -> 0 -> 2 -> 0 -> 1
    Output: head -> 0 -> 0 -> 1 -> 1 -> 2
    Explanation: The values after sorting are [0, 0, 1, 1, 2].
```
---
##### 05 - RemoveNthNodeBack
```text
    Given the head of a linked list, remove the nth node from the end of the list and return its head

    Input: head = [1,2,3,4,5], n = 2
    Output: [1,2,3,5]
```
--- 
##### 06 - Reverse Linked List
```text
    Given the head of a singly linked list, reverse the list, and return the reversed list.

    Input: head = [1,2,3,4,5]
    Output: [5,4,3,2,1]    
```