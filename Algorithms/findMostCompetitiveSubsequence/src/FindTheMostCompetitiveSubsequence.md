# [1673. Find the Most Competitive Subsequence](https://leetcode-cn.com/problems/find-the-most-competitive-subsequence/)

## 解题思路

### 单调栈

创建一个栈，从数组中依次取出各数，与栈顶元素做比较；

1. 如果栈顶元素大于当前数值，且数组中剩余数值的个数大于等于栈还需要元素的个数，则出栈（即`--top`）；
2. 否则，将数值入栈，直接全部数值遍历；

