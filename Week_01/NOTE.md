# 学习笔记

## No.26: Remove Duplicates from sorted array

这个题自己想出来了大半部分，用双指针的做法。但是在自己写代码的过程中考虑了太多的 corner cases。感觉写的很烦躁。后面发现其实不用管那么多，直接先将最核心部分的代码写出来才是最高效的。

## No.189: Rotate Arrays
一开始的时候觉得很熟悉，觉得可以用环形数组来做，设定first = k，first 即为目标数组的开始项。但是将元素调换的时候发现没那么简单，也是要考虑很多corner cases。参考了答案，写了一个reverse 方法。思路是第一次先将整个数组flip，第二次将0~k-1 flip，最后将 k~len-1 flip。就完成了整个目标。

## No.283: Move Zeros
这个题的解法很巧妙，利用了双指针来解题。第一个指针 first 指向从起点开始计数的最后一个非零数，第二个指针 second 用来移动：如果遇到非零元素，则与 first + 1 交换，否则 last += 1.
