### Sliding window
- [X] Maximum consecutive good numbers
- [X] Count unique not repeating substrings
- [X] [Diet Plan Performance](https://takeuforward.org/plus/dsa/problems/diet-plan-performance)
- [X] [Count SubArray Sum equals to K](https://takeuforward.org/plus/dsa/problems/count-subarrays-with-given-sum)
- [X] [Find K closest elements](https://leetcode.com/problems/find-k-closest-elements/)
- [X] [Minimum Swaps to Groups 1's](https://takeuforward.org/plus/dsa/problems/minimum-swaps-to-group-all-1s-together)
- [X] [Maximum points from Cards](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/)
- [X] [Length of longest substring](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/)
- [X] [Max consecutive ones](https://takeuforward.org/plus/dsa/sliding-window-and-2-pointer/longest-and-smallest-window-problems/max-consecutive-ones-iii)
- [X] [Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/description/)
- [X] [Character replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)
- [X] [Minimum window string](https://leetcode.com/problems/minimum-window-substring/description/)

##### SW12 - Minimum window string
```
    Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that
    every character in t (including duplicates) is included in the window. If there is no such substring,
    return the empty string "".

    Input: s = "ADOBECODEBANC", t = "ABC"
    Output: "BANC"
    Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

    CASE-1: "aaaaaaaaaaaabbbbbcdd", "abcdd" -> "abbbbbcdd"

    CASE-2: "cabwefgewcwaefgcf", ""cae"" -. DURING REVISION DO DRY-RUN -> "cwae"
```