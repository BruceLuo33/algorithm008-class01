# 第六周学习记录(5.25-5.31)

<span id ="0">
 
## [一、刷题记录](#1)

| [周一](#1.1)  |[周二](#1.2)  | [ 周三](#1.3) |[周四](#1.4) | [周五](#1.5) |[周六](#1.6) | [周日](#1.7) |
| :---: | :----: | :---: | :----: | :----: | :----: | :----: |




 
## [二、数据结构与算法笔记](#2)
  * [1. 动态规划](#2.1)
  * [2. ](#2.2)
  * [3. ](#2.3)



<h2 id = "1">一、刷题记录</h2>


| 题目类型 | 知识点 | 题目 | 完成情况 | 地址 |
| --- | --- | --- | --- | --- |
| 实战 | 动态规划 | Leetcode 62：不同路径  |  :ok:  | [周一](#1.1) |
|  |  |   |    | [](#) |
|  |  |   |    | [](#) |
|  |  |   |    | [](#) |



<h3 id = "1.1">周一(5.25)</h3>

[返回目录](#0)

主题：动态规划；技巧：自顶向下、自底向顶；题数：新题 4 道，复习 3 道




#### [1.1. Leetcode 53：最大子序和](https://leetcode-cn.com/problems/maximum-subarray/)
5.25 第一遍
- 思路：动态规划。首先，一道题想要快速做出来，理解题意才是最重要的。对于这道题而言，我们需要找出一个连续的子序列，其和应该是所有的子序列最大的。
  1. 设置 ans，动态存储每一个子序列的最大值；
  2. 设置 sum，其代表的意思是在 n 之前的所有数的和，如果 sum 大于零，那么 sum + n 一定是递增的，反之，sum + n 将会递减，与我们的期望不符合；
  3. 所以，当 sum > 0 的时候，令 sum += n，而当 sum < 0 时，就舍弃掉以前的 sum，并重置为当前的 n
  4. 最后在每次循环的时候，ans 取 ans 与 sum 中的较大值。
- 复杂度分析：O（N）

```Java
class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0], sum = 0;
        for (int n : nums) {
            if (sum >= 0) {
                 sum += n;
            } else {
                sum = n;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
```

#### [1.2. Leetcode 152：乘积最大的子数组](https://leetcode-cn.com/problems/maximum-product-subarray/)
5.25 第一遍
- 思路：动态规划。这道题和 53 题最大子序和很相似，但是不同之处在于，这里负数的存在，会影响最终的结果。
  1. 要求最大值，那么一定是比较前序的最大值和当前的数列的值，即 `Math.max(max * n, n)`；
  2. 但是，由于负数的存在，会令最大值的乘积变成最小的，因此还需要一个 min 变量，以处理出现负数的情况。
- 复杂度分析：O（N）
```Java
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int max = 1, min = 1;
        for (int n : nums) {
            if (n < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(max * n, n);
            min = Math.min(min * n, n);
            ans = Math.max(max, ans);
        }
        return ans;
    }
```


#### [1.3. Leetcode 120：三角形最小路径和](https://leetcode-cn.com/problems/triangle/)
5.25 第一遍
- 思路：动态规划。仔细观察题目，要求的不是说每一行中的最小值之和，而是“相邻结点”。
  1. 因此这个问题和 62/63/1143 都有了相似之处，那就是都从左上角出发，往右下走；
  2. 不同之处在于这里不一定是要到达右下角。并且每次都必须往下走一步，但是是否往右走就不一定。基于此，我们的思考最佳路径，还是与以前一样，用二维数组来解决；
  3. 不能仅仅比较某一行的两个对应相邻位置值得大小，因为这样其实是贪心算法，算出来的只是局部最优，但不一定是全局最优。
  4. 既然自顶向下不行，那么就考虑自底向顶。从倒数第二行开始更新，每个数字都等于 dp[i][j] + min(dp[i+1][j], dp[i+1][j+1])，从而到顶部得值，就是最终的答案。
  5. 同时，如果直接在原 List 上用 set 方法去操作，时间会比较慢，可以考虑用一个 dp 二维数组来操作。要注意如果用数组来做，dp 矩阵的维度应该是 (m+1) x (m+1)，这是因为数组内的元素一开始都是0，如果不对原 List 的最后一行进行录入dp 数组的操作，就会出现将最后一行丢失的情况。
  6. 然而，这个问题还可以优化，可以直接在一维数组上不改变原List 进行操作。时间复杂度不会变化，但是空间复杂度会降低为 O（N）
- 复杂度分析：O（N^2）

```Java
// Solution one：直接在 list 上操作
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
// Solution Two：在数组上操作
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int m = triangle.size();
        int[][] dp = new int[m + 1][m + 1];
        for (int i = m - 1; i >= 0; i--) {
            List<Integer> curLayer = triangle.get(i);
            int n = triangle.get(i).size();
            for (int j = 0; j < n; j++) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + curLayer.get(j);
            }
        }
        return dp[0][0];
    }
```

#### [1.4. Leetcode 1143：最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/)
5.25 第一遍
- 思路：动态规划。这个题的思路非常巧妙，将两个一维的字符串，变成了一个二维的字符表。步骤如下：
  1. 如果矩阵某个位置的值不相等，即 `text1.charAt(i) == text2.charAt(j)` 不成立，那么这个位置的值，应该等于左上角所有元素的最大值，代表着到目前为止，仅有 x 个char相等；
  2. 如果某个位置的 char 相等，那么该对应位置的 dp[i][j] 应该将上斜对角的 dp[i-1][j-1] 矩阵的值加一。之所以不用 `Math.max(dp[i-1][j], dp[i][j-1]) + 1`，即上和左侧格子较大值 + 1 的原因是，子序列需要在两个 string 中都存在，如果采用这种方法，就会违背这个原则；
  3. 为了避免 dp[i-1][j-1] 出现数组越界错误，在一开始的时候设置矩阵的大小为 [m+1][n+1]
- 复杂度分析：O（M x N）

```Java
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
```

#### 复习 [1.5. Leetcode 62：不同路径](https://leetcode-cn.com/problems/unique-paths/)
5.24 第一遍，5.25 第二遍
- 思路：动态规划。将大问题分解为小问题，大问题是到达最终的 finish，思考如何才能完成？很简单，从上方或者左方各自向终点移动一步即可。每一个位置都是这样的过程，一直自底向顶，回到start，说明完成。关键问题在于对初始状态的判断：
  1. 如果 `i == 0 || j == 0`，那么对应的 dp 矩阵的值为1，它表达的意思是，如果在上面和左侧的矩阵的“边”上，那么它只有一种可能达成，即由上一个同行/列的空格往下一直走，直到终点，因此此时的 dp 将不再是上和左两个格子共同构成的了，而是只有一种可能，那就是从起点直到终点一条路径；
  2. 不能设置 `if(m == 0 || n == 0) dp[m][n] = 0`，因为这实际上没有判断上/左边界的情况；
  3. 注意题目求的是到达终点的路径有多少条，而不是需要多少步到达，这也是状态转移方程为 `dp[i][j] = dp[i-1][j] + dp[i][j-1]` 的原因，它表示的是最后终点的可能性路径，与上左两个点的可能性之和是相同的。
- 复杂度分析：O（MxN）


#### 复习 [1.6. Leetcode 63：不同路径II](https://leetcode-cn.com/problems/unique-paths-ii/)
5.24 第一遍，5.25 第二遍
思路：动态规划。注意的是这里对于左/上边的处理有所不同。

####  复习 [1.7. Leetcode 198：打家劫舍](https://leetcode-cn.com/problems/house-robber/)
5.11 第一遍，5.25 第二遍
- 思路：一开始想的很简单，认为就是求奇数项和偶数项哪个大。这个读题太不仔细了。后面发现这是个动态规划问题，找到状态转移方程就可以了。
  1. 对于第 i 个位置的 dp[i]，它的取值为 dp[i-2] + nums[i] 与 dp[i-1] 中的较大值；
  2. 这个状态转移方程的得出，在于题目的要求：每间房屋要相隔一个屋子，所以现在的房屋的取值，要不就是前一个房屋的取值，要不就是前两个房屋的取值加上现在这个屋子中的价值； 
- 复杂度分析：O（N），因为要遍历整个数组




<h3 id = "1.2">周二(5.26)</h3>

[返回目录](#0)

主题：；技巧：；题数：新题 道，复习 道

#### [Leetcode 322：零钱兑换](https://leetcode-cn.com/problems/coin-change/)
5.26 第一遍
- 思路：动态规划。考虑从最后开始思考，设置一个 amount + 1 长度的数组，每一个 dp[i] 的值都是从其值减去所有的 coin 的结果中的最小值：
  1. 例如，dp[11] = Math,min(dp[10], dp[6], dp[1])，coins = [1, 5, 10], amount = 11；
  2. 因为我们不确定 coins 中元素的个数，所以需要遍历 coins 中的所有元素，每次比较 dp[i] 与 dp[i - coin] + 1，并更新较小值为新的 dp[i]；
  3. 之所以要将 dp[i - coin] 的值加一，是因为 “- coin” 的这个操作就已经将状态回退了，例如当我们比较 `dp[11]` 与 `dp[10]` 的时候，dp[10] 就已经是减掉了一个零钱，所以需要将其加一再比较。


<h3 id = "1.3">周三(5.27)</h3>

[返回目录](#0)

主题：动态规划；技巧：动态规划；题数：新题 2 道，复习 6 道


#### 复习 [Leetcode 198：打家劫舍](https://leetcode-cn.com/problems/house-robber/)
5.11 第一遍，5.25 第二遍，5.27 第三遍
思路见[前节 1.7 题](#1.1)
```Java
    public int rob(int[] nums) {
        int prev = 0, curr = 0;
        int ans = 0;
        for (int n : nums) {
            int tmp = curr;
            curr = Math.max(prev + n, tmp);
            prev = tmp;
        }
        return curr;
    }
```

#### [Leetcode 213：打家劫舍II](https://leetcode-cn.com/problems/house-robber-ii/)
5.27 第一遍
- 思路：动态规划。整体的解法和第一个打家劫舍相似，但是不同的地方在于多了一个对环形数组的判断。分析发现，整体抢劫的可能只有三种：
  1. 首尾都没有被抢；
  2. 抢了首个，最后一个没被抢；
  3. 第一个没被抢，最后一个被抢了；
- 调整数组的range，来完成这三个可能性，最后的答案就会在这三个中选出。
- 复杂度分析：O（N）


#### [Leetcode 337：打家劫舍III](https://leetcode-cn.com/problems/house-robber-iii/)
5.27 第一遍
- 思路：动态规划。整体抢劫的最大值，从两种可能中选出：
  1. 抢劫了根节点，以及左孩子节点的左右节点和右孩子节点的左右节点；
  2. 没有抢劫根节点，那么就抢劫了左右孩子节点。
- 从这两个可能性中选择一个最大值即可
- 复杂度分析：O（N）
```Java
    Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int doRob = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right)) 
                    + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int notRob = rob(root.left) + rob(root.right);
        int ans = Math.max(doRob, notRob);
        map.put(root, ans);
        return ans;
    }
```


#### 复习 [Leetcode 322：零钱兑换](https://leetcode-cn.com/problems/coin-change/)
5.26 第一遍，5.27 第二遍
思路见[前节](#1.2)
- DFS + 剪枝也是个很好的方法，待看


#### 复习 [ Leetcode 53：最大子序和](https://leetcode-cn.com/problems/maximum-subarray/)
5.25 第一遍，5.27 第二遍
思路见[前节 1.1 题](#1.1)


#### 复习 [ Leetcode 152：乘积最大的子数组](https://leetcode-cn.com/problems/maximum-product-subarray/)
5.25 第一遍，5.27 第二遍
思路见[前节 1.2 题](#1.1)


#### 复习 [ Leetcode 120：三角形最小路径和](https://leetcode-cn.com/problems/triangle/)
5.25 第一遍，5.27 第二遍
思路见[前节 1.3 题](#1.1)，优化了算法，将空间复杂度降低到了O（N）
```Java
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[] dp = new int[m+1];
        for (int i = m - 1; i >= 0; i--) {
            List<Integer> curLayer = triangle.get(i);
            int n = curLayer.size();
            for (int j = 0; j < n; j++) {
                dp[j] = curLayer.get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
```


#### 复习 [ Leetcode 1143：最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/)
5.25 第一遍，5.27 第二遍
思路见[前节 1.4 题](#1.1)




<h3 id = "1.4">周四(5.28)</h3>

[返回目录](#0)

主题：；技巧：；题数：新题 道，复习 道








<h3 id = "1.5">周五(5.29)</h3>

[返回目录](#0)

主题：；技巧：；题数：新题 道，复习 道




<h3 id = "1.6">周六(5.30)</h3>

[返回目录](#0)

主题：；技巧：；题数：新题 道，复习 道




<h3 id = "1.7">周日(5.31)</h3>

[返回目录](#0)

主题：；技巧：；题数：新题 道，复习 道







<h2 id = "2">二、数据结构与算法笔记</h2>


<h3 id = "2.1">1. 动态规划</h3>

[返回目录](#0)




<h3 id = "2.2">2. </h3>

[返回目录](#0)



<h3 id = "2.3">3. </h3>

[返回目录](#0)






<h3 id = "2.4">4. </h3>

[返回目录](#0)




<h3 id = "2.5">5. </h3>

[返回目录](#0)


<h3 id = "2.6">6. </h3>

[返回目录](#0)













