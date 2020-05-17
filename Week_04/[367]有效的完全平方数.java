//给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。 
//
// 说明：不要使用任何内置的库函数，如 sqrt。 
//
// 示例 1： 
//
// 输入：16
//输出：True 
//
// 示例 2： 
//
// 输入：14
//输出：False
// 
// Related Topics 数学 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.16 第一遍
 思路：二分查找。和 69 题 x 的平方根一摸一样的思路。
 复杂度：O（logN）
 */

class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int start = 0, end = num - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if ((long) mid * mid > num) {
                end = mid - 1;;
            } else if ((long) mid * mid < num) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
