//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
/**
 4.30 第一遍，5.12 第二遍，6.4 第三遍
 - 思路：递归。这道题是超哥在视频中详细讲解的。对我的启发有两点：自顶向下编程与结构化思维。
 1. 递归都是四个步骤：terminator, process logic, drill down, restore status
 2. 对于题目的要求，要作以下几个考虑：第一、left < n；第二、right < left，以这两个为判断递归的标准即可
 3. terminator 为 `left == n && right == n`，它代表的意思是已经完成了整个过程，这时候将 s 加到 ans 中就可以了
 4. 如果`left < n`，代表的是左括号还没用完，因此需要在 s 后面加上左括号，同时递归的时候 `left + 1`
 5. 如果 `right < left`，代表的是右括号还没有用完，因此在 s 后加上右括号，同时 `right + 1`，在这里不用 `right < n` 的原因是括号必须有效，也就是到任意一个状态，左括号的数量都必须大于等于右括号，因此必须是 `right < left`
 - 注意：递归函数不能用 List<String>，要传入 String s，然后将 s 加到全局变量 List<String> 中
 */
class Solution {
    private List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        // List<String> ans = new ArrayList<>();
        if (n == 0) return ans;
        int left = 0, right = 0;
        dfs(left, right, n, "");
        return ans;
    }
    private void dfs(int left, int right, int n, String s) {
        if (left == n && right == n)
            ans.add(s);
        if (left < n )
            dfs(left + 1, right, n, s+"(");
        if (right < left)
            dfs(left, right + 1, n, s + ")");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
