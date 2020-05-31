//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
// 
//
// 若这两个字符串没有公共子序列，则返回 0。 
//
// 
//
// 示例 1: 
//
// 输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace"，它的长度为 3。
// 
//
// 示例 2: 
//
// 输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc"，它的长度为 3。
// 
//
// 示例 3: 
//
// 输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= text1.length <= 1000 
// 1 <= text2.length <= 1000 
// 输入的字符串只含有小写英文字符。 
// 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.25 第一遍
 - 思路：动态规划。这个题的思路非常巧妙，将两个一维的字符串，变成了一个二维的字符表。步骤如下：
 1. 如果矩阵某个位置的值不相等，即 `text1.charAt(i) == text2.charAt(j)` 不成立，那么这个位置的值，应该等于左上角所有元素的最大值，代表着到目前为止，仅有 x 个char相等；
 2. 如果某个位置的 char 相等，那么该对应位置的 dp[i][j] 应该将上斜对角的 dp[i-1][j-1] 矩阵的值加一。之所以不用 `Math.max(dp[i-1][j], dp[i][j-1]) + 1`，即上和左侧格子较大值 + 1 的原因是，子序列需要在两个 string 中都存在，如果采用这种方法，就会违背这个原则；
 3. 为了避免 dp[i-1][j-1] 出现数组越界错误，在一开始的时候设置矩阵的大小为 [m+1][n+1]
 - 复杂度分析：O（M x N）
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length() + 1, n = text2.length() + 1;
        int[][] dp = new int[m][n];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m-1][n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
