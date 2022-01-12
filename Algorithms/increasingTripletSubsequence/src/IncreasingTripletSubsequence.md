# [334. Increasing Triplet Subsequence](https://leetcode-cn.com/problems/increasing-triplet-subsequence/)

## 解题思路

只要在数组中找到一个由三个数组成的递增子序列即满足要求；

在遍历数组的过程中，先记录下两个递增的数 A , B （如果有的话）；

然后继续向后遍历，当 CURRENT (当前数)大于 B 时，即满足条件；

当CURRENT大于 A ，小于 B 时，则更新 B；

当CURRENT小于 A 时，则更新 A 。

（这当中有一个技巧，只更新 A，保留 B ，在后续的遍历中，如果出现 CURRENT 大于 B 的情况，我们能够知道**在原数组中 B 位置之前的数中存在一个数与 B 及 CURRENT 能够组成递增关系）