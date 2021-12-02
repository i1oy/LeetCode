# 321. Create Maximum Number

## 解题思路

1. 从数组1中取i个数组成最大子序列（使用 **单调栈** ），从数组2中取(k - i)个数组成最大子序列；
2. 拼接两个子序列组成最大数值序列（合并函数）；
3. 重复步骤1、2，比较序列大小（compare函数），选择最大值。

## TIPS

- 生成最大子序列使用 **单调栈**；
- 使用`System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length);`复制数组；