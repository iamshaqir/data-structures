## Arrays

---

- [X] [A1_BuyAndSellStocks](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
- [X] A2_ReverseArray
- [X] [A3_ContainerWithMostWater](https://leetcode.com/problems/container-with-most-water/description/)
- [ ] [A4_MaximumSubArraySum](https://leetcode.com/problems/maximum-subarray/description/)
- [ ] A5_LongestConsecutiveSequence
- [ ] A6_LongestSubArraySumLength
- [ ] A7_KthSpecificElement
- [ ] A8_RemoveDuplicatesSorted
- [ ] A9_RotateArray
- [ ] A10_SearchRotatedSortArray
- [ ] A11_TwoSum
- [ ] A12_ThreeSum
- [ ] A13_TrapRainWater

---
#### A1_BuyAndSellStocks
```text
    You are given an array prices where prices[i] is the price of a given stock on the ith day.

    You want to maximize your profit by choosing a single day to buy one stock and choosing a
    different day in the future to sell that stock.

    Return the maximum profit you can achieve from this transaction. If you cannot achieve any
    profit, return 0.

    Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

    Input: prices = [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transactions are done and the max profit = 0.
```
---
#### A3_ContainerWithMostWater
```text
    You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of
    the ith line are (i, 0) and (i, height[i]).

    Find two lines that together with the x-axis form a container, such that the container contains the most water.
    Return the maximum amount of water a container can store.
    Notice that you may not slant the container.

    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of
    water (blue section) the container can contain is 49
```
![img.png](src/test/java/arrays/img.png)
---
#### A4_MaximumSubArraySum
```text
    Given an integer array nums, find the subarray with the largest sum, and return its sum.

    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: The subarray [4,-1,2,1] has the largest sum 6.

    1 <= nums.length <= 105
    -104 <= nums[i] <= 104
```