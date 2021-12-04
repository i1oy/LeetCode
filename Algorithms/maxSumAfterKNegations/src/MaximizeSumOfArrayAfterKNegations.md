# [1005. Maximize Sum Of Array After K Negations](https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/)

## 解题思路

1. 遍历数组，记录负数和绝对值最小的数，并对其他数求和 SUM；
2. 对负数进行排序，根据 k 值从较大负数开始进行取反并加到 SUM；
   1. 如果 k 大于负数的个数，则所有负数取反后，将剩余的取反次数应用到绝对值最小的数，然后加到结果值；
   2. 如果 k 小于负数的个数，则直接对剩余的数值进行求和。