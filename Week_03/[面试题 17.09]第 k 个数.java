//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
// Related Topics 堆 队列 数学


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getKthMagicNumber(int k) {
        // 4.27 第一遍
        // 思路：这道题和丑数II 一样。三指针。
        int factor3 = 0, factor5 = 0, factor7 = 0;
        int index3 = 0, index5 = 0, index7 = 0;
        int[] ans = new int[1690];
        ans[0] = 1;
        for (int i = 1; i < k; i++) {
            factor3 = 3 * ans[index3];
            factor5 = 5 * ans[index5];
            factor7 = 7 * ans[index7];
            int min = Math.min(Math.min(factor3, factor5), factor7);
            ans[i] = min;
            if (min == factor3) index3 += 1;
            if (min == factor5) index5 += 1;
            if (min == factor7) index7 += 1;
        }
        return ans[k-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
