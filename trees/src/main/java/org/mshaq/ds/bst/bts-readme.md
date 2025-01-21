    Largest BST in a given Tree

- Problem is Similar to `Validate BST` with few changes, if you don't know that learn `Validate BST` first
- Now that we have to apply the Business logic after iteration of `left` and `right`, we can use `Post Order Traversal`
- Find `Max` of `left subtree` as it will be the most `maximum` in the whole left subtree
- Find `Min` of `right subtree` as it will be the most `Minimum` in the whole right subtree
- Compare those `Max` and `Min` with `root's value` to validate BST condition,
- Apply the BST conditions `root.val > left.max && root.val < right.min `
    - if it is `true`, get the `size` of `left` and `right` subtree, add `+1` for `root's size` and modify the `max` and `min` values
    - `Max` will be `maximum` of `root's values` and `right node's value`, as it is `BST` and `max` will be on `right`
    - `Min` will be `minimum` of `root's values` and `left node's value`, as it is `BST` and `min` will be on `left`
    - if it is `false` just get the `maximum` size of `left` and `right` trees and return `max` value as some `highest max(Integer.MAX_VALUE)` and `min` values as `lowest min(Integer.MIN_VALUE)`, so that while comparing with other trees it cannot interfere


    Time Complexity - O(N) for Tree Traversal

    Space Complexity - O(1) excluding auxilary stack space