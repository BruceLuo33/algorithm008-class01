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
| 实战 | 动态规划 |   |    |  |
|  | 动态规划 | Leetcode 53：最大子序和  |  :ok:  | [周一](#1.1) |
|  | 动态规划 | Leetcode 152：乘积最大的子数组  |  :ok:  | [周一](#1.1) |
|  | 动态规划 | Leetcode 120：三角形最小路径和  |  :ok:  | [周一](#1.1) |
|  | 动态规划 | Leetcode 43：最长公共子序列  |  :ok:  | [周一](#1.1) |
|  | 动态规划 | Leetcode 62：不同路径  |  :ok:  | [周一](#1.1) |
|  | 动态规划 | Leetcode 63：不同路径II |  :ok:  | [周一](#1.1) |
|  | 动态规划 | Leetcode 198：打家劫舍 |  :ok:  | [周一](#1.1) |
|  | 动态规划 | Leetcode 322：零钱兑换 |  :ok:  | [周二](#1.2) |
|  | 动态规划 | Leetcode 213：打家劫舍II |  :ok:  | [周三](#1.3) |
|  | 动态规划 | Leetcode 337：打家劫舍III |  :ok:  | [周三](#1.3) |
|  | 回溯 | Leetcode 77：组合 |  :ok:  | [周四](#1.4) |
|  | 动态规划 | Leetcode 121：买卖股票的最佳时机 |  :ok:  | [周五](#1.5) |
|  | 动态规划 | Leetcode 122：买卖股票的最佳时机II |  :ok:  | [周五](#1.5) |
|  | 动态规划 | Leetcode 123：买卖股票的最佳时机III |  :ok:  | [周五](#1.5) |
|  | 动态规划 | Leetcode 186：买卖股票的最佳时机IV |  :ok:  | [周五](#1.5) |
|  | 动态规划 | Leetcode 309：买卖股票的最佳时机含冷冻期 |  :ok:  | [周五](#1.5) |
|  | 动态规划 | Leetcode 714：买卖股票的最佳时机含手续费 |  :ok:  | [周五](#1.5) |
|  | 动态规划 | Leetcode 434：字符串中的单词数 |  :ok:  | [周六](#1.6) |
|  | 动态规划 | Leetcode 64：最小路径和 |  :ok:  | [周六](#1.6) |
|  | 动态规划 | Leetcode 221：最大正方形 |  :ok:  | [周六](#1.6) |
|  | 动态规划 | Leetcode 621：任务调度器 |  :ok:  | [周日](#1.7) |

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


#### 复习 [3.1. Leetcode 198：打家劫舍](https://leetcode-cn.com/problems/house-robber/)
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

#### [3.2. Leetcode 213：打家劫舍II](https://leetcode-cn.com/problems/house-robber-ii/)
5.27 第一遍
- 思路：动态规划。整体的解法和第一个打家劫舍相似，但是不同的地方在于多了一个对环形数组的判断。分析发现，整体抢劫的可能只有三种：
  1. 首尾都没有被抢；
  2. 抢了首个，最后一个没被抢；
  3. 第一个没被抢，最后一个被抢了；
- 调整数组的range，来完成这三个可能性，最后的答案就会在这三个中选出。
- 复杂度分析：O（N）


#### [3.3. Leetcode 337：打家劫舍III](https://leetcode-cn.com/problems/house-robber-iii/)
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


#### 复习 [3.4. Leetcode 322：零钱兑换](https://leetcode-cn.com/problems/coin-change/)
5.26 第一遍，5.27 第二遍
思路见[前节](#1.2)
- DFS + 剪枝也是个很好的方法，待看


#### 复习 [3.5. Leetcode 53：最大子序和](https://leetcode-cn.com/problems/maximum-subarray/)
5.25 第一遍，5.27 第二遍
思路见[前节 1.1 题](#1.1)


#### 复习 [3.6. Leetcode 152：乘积最大的子数组](https://leetcode-cn.com/problems/maximum-product-subarray/)
5.25 第一遍，5.27 第二遍
思路见[前节 1.2 题](#1.1)


#### 复习 [3.7. Leetcode 120：三角形最小路径和](https://leetcode-cn.com/problems/triangle/)
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


#### 复习 [3.8. Leetcode 1143：最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/)
5.25 第一遍，5.27 第二遍
思路见[前节 1.4 题](#1.1)




<h3 id = "1.4">周四(5.28)</h3>

[返回目录](#0)

主题：回溯；技巧：回溯；题数：新题 0 道，复习 1 道

#### 复习 [Leetcode 77：组合](https://leetcode-cn.com/problems/combinations/)
5.9 第一遍，5.22 第二遍，5.28 第三遍
- 思路：回溯算法。和 46 题的思路非常相似，都是需要利用到回溯。
  1. track 要创建为 LinkedList<>() 对象，这样在回退状态的时候可以用 removeLast 方法，如果不创建为这个对象，需要改写成这样：`track.remove(track.size() - 1);`
  2. for 循环的判断，i <= n 而不仅仅是 <。因为 start 是从 1 开始取并且 n 是可以取得到的。





<h3 id = "1.5">周五(5.29)</h3>

[返回目录](#0)

主题：动态规划；技巧：状态转移方程；题数：新题 6 道，复习 0 道


#### [5.1. Leetcode 121：买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)
5.29 第一遍
- 思路：动态规划。关键在于找到状态转移方程，而找这个方程，就需要明确有多少种状态。在这里，有三种状态，分别是：天数、买卖次数和是否买or卖。
1. 天数 i 从 0 开始 循环到 n, `for (int i = 0, i < n; i++)`
2. 买卖次数 j 从零开始，循环到 k，`for (int j = 0; j < k, j++)`
3. 买卖是否发生，只有两种状态，因此用 {0, 1} 来分别表示。
4. Base Cases：
   - `dp[-1][j][0] = dp[i][0][0] = 0` (-1天表示股票市场还没开放，这时候在未持有 [0] 的状态下，盈利肯定是 0； 同样，任意一天 i 天，如果不能操作，那么 profit = 0)
   - `dp[-1][j][1] = dp[i][0][1] = -inf` (在 -1 天时，股票市场都没开放，就想进行买入操作是不可能的，用 -inf 来表示这种不可能；同理，任意一天如果都不允许进行任何操作，即 k = 0，那么肯定也是 -inf)
5. Recursive Cases：
   - `dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])`，第 i 天如果没持有股票，要么就是前一天也没持有，或者前一天持有但是今天卖了，取二者较大值；
   - `dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][1] - prices[i])`，第 i 天如果持有股票，要么就是前一天也持有，要么就是前一天每持有但是今天买了，取二者较大值。k - 1 是因为执行了一次买入的操作。
- 注意：
  1. i - 1 可能会出现数组越界的问题， 要提前判断
  2. recursive 公式为：`dp[i][1] = Math.max(dp[i-1][1],  - prices[i]);`
- 复杂度分析：O（N），空间复杂度：O（N），可以提升为 O（1）

```Java
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length, k = 1;
        int dp_i0 = 0, dp_i1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            dp_i1 = Math.max(dp_i1, -prices[i]);
        }
        return dp_i0;
    }
```

#### [5.2. Leetcode 122：买卖股票的最佳时机II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)
5.15 第一遍，5.29 第二遍
- 思路一：贪心算法。这是超哥课程上的例题，采用的算法就是低买高卖，求得累加最大值。
- 思路二：动态规划。参考 121 题的笔记，三个参数 i、k、s，这里变化的是 k，从 121 题的 `k = 1` 变成了 `k = inf`。看起来有很大的变化但是实际上还是一样的思路。因为当 `k -> inf` 的时候，`k = k - 1`，所以实际上 k 也可以省略。
  1. Recursive cases:
     - `dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])`
     - `dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k][0] - prices[i])`，这里最后一项是 k 而非 k - 1
     - 观察发现，两个式子中的 k 实际上都没有发生变化，所以可以省略不去管它
  2. Update Recursive cases:
     - `dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])`
     - `dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])`
复杂度分析：O（N）



#### [5.3. Leetcode 123：买卖股票的最佳时机III](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/)
5.29 第一遍
- 思路：动态规划。与 121、122 等题不同的是，这里的 k 不能忽略了。但是也不难，加上一个对 k 的循环即可。
- Recursive Cases：
  1. `dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + prices[i])`
  2. `dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - prices[i])`
  3. `dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])`
  4. `dp[i][1][1] = max(dp[i-1][1][1], - prices[i])`
复杂度分析：O（N），空间复杂度：O（1）
```Java
    public int maxProfit(int[] prices) {
        int n = prices.length, m = 2;
        int dp_i_2_0 = 0, dp_i_1_0 = 0;
        int dp_i_2_1 = Integer.MIN_VALUE, dp_i_1_1 = Integer.MIN_VALUE;
        for ( int i = 0; i < n; i++) {
            for (int k = m; k > 0; k--) {
                dp_i_2_0 = Math.max(dp_i_2_0, dp_i_2_1 + prices[i]);
                dp_i_2_1 = Math.max(dp_i_2_1, dp_i_1_0 - prices[i]);
                dp_i_1_0 = Math.max(dp_i_1_0, dp_i_1_1 + prices[i]);
                dp_i_1_1 = Math.max(dp_i_1_1, -prices[i]);
            }
        }
        return dp_i_2_0;
    }
```

#### [5.4. Leetcode 186：买卖股票的最佳时机IV](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iiii/)
5.29 第一遍
- 思路：动态规划。这道题和 123 比较相似，不同的是 k 从 2 变成了任意整数。需要注意的是，k 要考虑两个状态：
  1. `k <= n/2`，此时的 k 是有效的，因为股票想要有涨跌，当天买入卖出是不会有盈亏变化的，所以至少需要 2 天才能体现。如果交易次数大于了 n/2，那么可以将 k 视为 inf
  2. `k > n/2`，直接用 122 的方法。`k = inf`
  3. 注意对于数组的初始化，要在 k 值得判断之后，否则因为 k 太大了，数组会无法创建。
复杂度分析：O（NK)
```Java
    public int maxProfit(int k, int[] prices) {
        int n = prices.length, m = 2;
        if (k > n/2) {
            return maxProfitInfiniteK(prices);
        }
        int[][][] dp = new int[n][k + 1][2];
        for ( int i = 0; i < n; i++) {
            for (int j = k; j > 0; j--) {
                if (i - 1 == -1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                } 
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
                
            }
        }
        return dp[n-1][k][0];
    }
    private int maxProfitInfiniteK(int[] prices) {
        int n = prices.length;
        int dp_i0 = 0, dp_i1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i0;
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            dp_i1 = Math.max(dp_i1, tmp - prices[i]);
        }
        return dp_i0;
    }
```


#### [5.5. Leetcode 309：最佳买卖股票实际含冷冻期](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/submissions/)
5.29 第一遍
- 思路：动态规划。和 122 题非常类似，不同的是多了一个冷冻期，即从 T+0 变成了 T+1 交易。解决方法也很简单，用一个变量存下前两天的价格就可以了。
- Recursive Cases:
  1. `dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])`; 出售股票没有 T+1，所以是 i - 1
  2. `dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])`; 买入股票的操作，必须在卖出股票之后两天，所以是 i - 2
  3. `tmp = dp_i0`，代表的是 `i - 1  天的数值，在每一次 `for` 循环中，都是第 i 天的数值，循环完之后，就到了第 `i + 1` 天，如果将 `save = tmp`，即对于下一个循环而言，save 已经是 `i - 1`，即两天前的数值了，这样就达到了我们的要求。
- 复杂度分析：O（N），空间复杂度：O（1）
```Java
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        int dp_i0 = 0, dp_i1 = Integer.MIN_VALUE;
        int save = 0;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i0;
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            dp_i1 = Math.max(dp_i1, save - prices[i]);
            save = tmp;
        }
        return dp_i0;
    }
```

#### [55.6. Leetcode 714：买卖股票的最佳时期含手续费](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)
5.29 第一遍
- 思路：动态规划。这道题实际上还是 122 题的变种，即 `k = inf`。但是不同的是这里对于 k 的成本有了要求，即每一次买卖，都需要付出 `fee`。有两种做法，第一个是在第一个式子中减去 `fee`，第二个是在第二个式子中加上 `fee`，分别代表卖出股票的价格降低了 or 买入股票的价格升高了。
- Recursive Cases One：
  1. `dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i] - fee) `
  2. `dp[i][1] = max(dp[i-1][1], dp[i-1][1] - prices[i]) `
  3. 此时的 dp[i][1] 不能初始化为 `Integer.MIN_VALUE`，否则会出现数组越界错误
- Recursive Cases Two:
  1. `dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])`
  2. `dp[i][1] = max(dp[i-1][1], dp[i-1][1] - prices[i] - fee) `
- 复杂度分析：O（N），空间复杂度：O（1）
```Java
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp_i0 = 0, dp_i1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i0;
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            dp_i1 = Math.max(dp_i1, tmp - prices[i] - fee);
        }
        return dp_i0;
    }
```


<h3 id = "1.6">周六(5.30)</h3>

[返回目录](#0)

主题：；技巧：；题数：新题 道，复习 道

#### [Leetcode 434：字符串中的单词数](https://leetcode-cn.com/problems/number-of-segments-in-a-string/)
5.30 第一遍
- 思路：循环。单词的分割是根据空格来的，所以一开始的思路是找到多少个空格，再 +1 就可以了。但是发现有两种情况：
  1. ""，即空 String，对于这种情况，在一开始的时候加一个判断 `if(s.length() == 0) return count`
  2. "     "，这个其实也是空 String，但是对于之前的算法来说，就有问题了，因为它实际上有很多空格，那么再加上一个判断：`if (i > 0 && s.charAt(i-1) != ' ' && s.charAt(i) == ' ')`
  3. 但是问题还没有解决，现在不会返回 17 了，但是还是会返回 1.这是因为我们的 return 项是 count + 1. 在评论里看到一个很巧妙的方法，在一开始的时候，就到 s 的后面加上一个空格，`s += ' '`，这样一来，就可以解决问题了。同时最终也改成 `return count`
复杂度分析：O（N），空间复杂度：O（1）

#### [Leetcode 64：最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/)
5.30 第一遍
- 思路：动态规划。乍一看这道题和之前做的路径之和一样，不过这里求的是最小的路径，62 题求得是所有路径的可能。
  1. 如果 `i == 0 && j == 0`，说明就是左上角顶点，令 dp[i][j] = grid[i][j]
  2. 如果不是，继续判断 `i == 0 ` 和 `j == 0`，此时因为 i - 1 和 j - 1 分别都数组越界了，所以需要额外判断
  3. 最后就是状态转移方程：dp[i][j] = grid[i][j] + Math.min(dp[i][j-1], dp[i-1][j]);
- 复杂度分析：O（MN），空间复杂度：O（MN)




#### [Leetcode 221：最大正方形](https://leetcode-cn.com/problems/maximal-square/)
5.30 第一遍
- 思路：动态规划。从右下角开始思考，如果存在边长 >= 2 的正方形，那么从右下角开始，它的左、上、左上三个位置的小正方形以性都是另一个正方形的右下角。那么最终的正方形的范围，就是这三个位置的正方形边长中的最小值。否则的话，大的正方形就会出现缺角，也就不是正方形了。
  1. dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]);
  2. 为了减少对于边界条件的判断，将 dp 数组的大小设置为 `dp[m+1][n+1]`，并且从 i/j = 1 开始进行；
  3. 不能用 64 题那种分别判断 `i == 0 && j == 0, else if (i == 0), else if (j == 0)` 的方式，因为我们最终的目的是找到一个正方形，那么就要保证上、左、左上三个位置都要有格子，但是这种判断方式显然不能达成我们的目标。
- 复杂度分析：O（MN)






<h3 id = "1.7">周日(5.31)</h3>

[返回目录](#0)

主题：；技巧：；题数：新题 道，复习 道

#### [Leetcode 621：任务调度器](https://leetcode-cn.com/problems/task-scheduler/)
5.31 第一遍
- 思路：数学推导。最核心的公式就是最终 return 项的东西，` (count[25] - 1) * (n + 1) + maxCount`，思考思路如下：
  1. 假设数组 ["A","A","A","B","B","C"]，n = 2，A的频率最高，记为count = 3，所以两个A之间必须间隔2个任务，才能满足题意并且是最短时间（两个A的间隔大于2的总时间必然不是最短），因此执行顺序为： A->X->X->A->X->X->A，这里的X表示除了A以外其他字母，或者是待命，不用关心具体是什么，反正用来填充两个A的间隔的。上面执行顺序的规律是： 有count - 1个A，其中每个A需要搭配n个X，再加上最后一个A，所以总时间为 (count - 1) * (n + 1) + 1
  2. 要注意可能会出现多个频率相同且都是最高的任务，比如 ["A","A","A","B","B","B","C","C"]，所以最后会剩下一个A和一个B，因此最后要加上频率最高的不同任务的个数 maxCount
  3. 公式算出的值可能会比数组的长度小，如["A","A","B","B"]，n = 0，此时要取数组的长度
复杂度分析：O（N）




<h2 id = "2">二、数据结构与算法笔记</h2>


<h3 id = "2.1">1. 动态规划</h3>

[返回目录](#0)




<h3 id = "2.2">2. </h3>

[返回目录](#0)



<h3 id = "2.3">3. </h3>

[返回目录](#0)

















