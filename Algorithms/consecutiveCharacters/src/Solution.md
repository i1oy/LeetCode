# 1446. Consecutive Characters

## 解题思路

遍历字符串，计算重复字符的数量；

需要注意的是如果最长连续子串一直到最后一个字符，可能会被漏掉，因此返回是`return res > count ? res : count;`（也可以在遍历时处理掉这种情况）。