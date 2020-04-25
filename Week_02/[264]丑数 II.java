//编写一个程序，找出第 n 个丑数。 
//
// 丑数就是只包含质因数 2, 3, 5 的正整数。 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
// Related Topics 堆 数学 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        // 4.25 第一遍
        // 思路：和263不同，这里是需要将丑数的规律找出来，类似于找到一个通项公式。
        // 通过观察可以发现，每一个丑数，都是 2x1、3x1、5x1 …… 2xN、3xN、5xN 来得出的，
        // 或者从另一个角度而言，每一个丑数 Xn，都是前面的一个某丑数（不一定是Xn-1）对应地乘 2 or 3 or 5 得到的。
        // 那么我们问题的关键，就变成了判断这个某一个丑数是什么。
        // 为此，我们可以设置三个指针，Loc2 代表某丑数 X_loc2 乘2 之后，刚好等于 Xn，以此类推。
        // 注意：为了防止漏过对相同乘积，例如 6 = 2x3 = 3x2，的判断，
        // 我们找上一个丑数是 X_loc2 or X_loc3 or X_loc5 的过程中，要对他们都进行判定。所以不能用 if-else，
        // 而应该都是 if
        // 复杂度分析：O（N），空间复杂度：O（k），k为input n 的最大值，1690.

        int[] ans = new int[n];
        ans[0] = 1;
        int factor2 = 0, factor3 = 0, factor5 = 0;
        int index2 = 0, index3 = 0, index5 = 0;

        for (int i = 1; i < n; i++){
            factor2 = 2 * ans[index2];
            factor3 = 3 * ans[index3];
            factor5 = 5 * ans[index5];
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ans[i] = min;
            if (factor2 == min) index2 += 1;
            if (factor3 == min) index3 += 1;
            if (factor5 == min) index5 += 1;
        }
        return ans[n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
