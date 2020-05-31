//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.25 第一遍，5.27 第二遍
 - 思路：动态规划。仔细观察题目，要求的不是说每一行中的最小值之和，而是“相邻结点”。
 1. 因此这个问题和 62/63/1143 都有了相似之处，那就是都从左上角出发，往右下走；
 2. 不同之处在于这里不一定是要到达右下角。并且每次都必须往下走一步，但是是否往右走就不一定。基于此，我们的思考最佳路径，还是与以前一样，用二维数组来解决；
 3. 不能仅仅比较某一行的两个对应相邻位置值得大小，因为这样其实是贪心算法，算出来的只是局部最优，但不一定是全局最优。
 4. 既然自顶向下不行，那么就考虑自底向顶。从倒数第二行开始更新，每个数字都等于 dp[i][j] + min(dp[i+1][j], dp[i+1][j+1])，从而到顶部得值，就是最终的答案。
 5. 同时，如果直接在原 List 上用 set 方法去操作，时间会比较慢，可以考虑用一个 dp 二维数组来操作。要注意如果用数组来做，dp 矩阵的维度应该是 (m+1) x (m+1)，这是因为数组内的元素一开始都是0，如果不对原 List 的最后一行进行录入dp 数组的操作，就会出现将最后一行丢失的情况。
 复杂度分析：O（N^2）
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int m = triangle.size();
        for (int i = m - 2; i >= 0; i--) {
            List<Integer> curLayer = triangle.get(i);
            int n = triangle.get(i).size();
            for (int j = 0; j < n; j++) {
                int min = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                int tmp = triangle.get(i).get(j);
                triangle.get(i).set(j, min + tmp);
            }
        }
        return triangle.get(0).get(0);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        // int[][] dp = new int[m + 1][m + 1];
        int[] dp = new int[m+1];
        for (int i = m - 1; i >= 0; i--) {
            List<Integer> curLayer = triangle.get(i);
            int n = curLayer.size();
            for (int j = 0; j < n; j++) {
                // dp[i][j] = curLayer.get(j) + Math.min(dp[i + 1][j], dp[i+1][j+1]);
                dp[j] = curLayer.get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
