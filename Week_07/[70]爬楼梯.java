//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 4.10 第一遍，4.22 第二遍，5.4 第三遍，5.16 第四遍，6.4 第五遍
 思路一：递归。将到达第 n 级台阶拆解为到达第 n-1 和 n-2，然后再往前走 1 or 2 步。就能完成任务。
 步骤：先写停止递归条件（数学归纳法里面的首步条件，然后写递归公式
 注意：如果用斐波那契数列的写法，会造成时间过长，在这里我们要保存每一步的内容，需要用到动态规划
 思路二：递推。与递归不同，递推是从底向上的思维。我们先考虑 `f(1) = 1, f(2) = 2`，然后根据公式 `f(3) = f(2) + f(1)`，并依次进行，直到 f(n)
 注意：循环的起始位置应该为 i = 2，代表从第二季台阶开始爬楼梯
 复杂度分析：O（N）

 */

class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int first = 1, second = 2;
        for (int i = 2; i < n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
