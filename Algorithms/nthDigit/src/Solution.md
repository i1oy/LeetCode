# 400. Nth Digit

## 解题思路

1. 按照数值的位数对整个区间进行划分`[1-9],[10-99],[100-999]...`，找到目标数值所在的区间；
2. 找到到具体的数值；
3. 定位到数值特定位上的数字。

> 对问题进行拆解后，处理起来就会比较简单