//给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。 
//
// 示例: 
//
// 输入: 38
//输出: 2 
//解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
// 
//
// 进阶: 
//你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？ 
// Related Topics 数学


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int addDigits(int num) {
        // 4.23 第一遍
        // 思路：直接将 num 对10取模取余，然后相加。
        // 第一遍算完之后，ans 还是大于10，因此还需要将 ans 进行addDigits 的运算。
        // 复杂度分析：O（N），空间复杂度：O（1）

        if (num - 9 <= 0) {
            return num;
        }
        int ans = 0;
        while (num != 0) {
            ans = ans + num % 10;
            num /= 10;
        }
        return addDigits(ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
