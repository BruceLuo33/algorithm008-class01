//实现 pow(x, n) ，即计算 x 的 n 次幂函数。 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
// Related Topics 数学 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
        // 5.10 第一遍
        // 思路：递归，快速幂。一开始的时候想着直接乘就完事了，但这样的话复杂度是 O（N），参考了解答，看到了一个很漂亮的递归代码。
        // 1. 列出三个 basic terminator，分别是 n = 0, 1, -1
        // 2. 根据快速幂的定义，当幂次为偶数的时候，将幂次 n 分解成 n/2 与 n/2；当幂次为奇数，则将其 -1 后再除 2
        // 3. 最后 `return rest * half * half` 即可
        // 复杂度分析：O（logN）

        // Terminator
        if (n == 0) return 1;
        if (n == 1) return x;
        if ( n == -1) return 1/x;
        double half = myPow(x, n / 2);
        double rest = myPow(x, n % 2);
        return rest * half * half;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
