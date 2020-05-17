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
class Solution {
    // 4.30 第一遍，5.12 第二遍
    // 思路：这道题是超哥在视频中详细讲解的。对我的启发有两点：自顶向下编程与结构化思维。
    // 结构化思维：递归都是四个步骤：terminator, process logic, drill down, restore status
    // 对于题目的要求，要作以下几个考虑：
    // 第一、left < n，那么就将 left + 1，并且在 string s 后面再加一个 (；
    // 第二、right < left，同上，不过将left换成right。
    // 注意：因为题目要求“有效的”括号，意味着每一个时刻而言，都要求 `left >= right`，所以判断条件不能是 right < n
    // 注意：递归函数不能用 List<String>，要传入 String s，然后将 s 加到全局变量 List<String> 中

    private List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(0, 0, n, "");
        return ans;
    }

    private void helper(int left, int right, int n, String s) {
        if (left == n && right == n) ans.add(s);

        if (left < n) helper(left + 1, right, n, s + "(");

        if (right < left) helper(left, right + 1, n, s + ")");
    }





    private List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        helper(0, 0, n, "");
        return ans;
    }

    private void helper(int left, int right, int n, String s) {
        // terminator
        if (left == n && right == n) ans.add(s);
        // process logic
        // drill down
        if (left < n) {
            helper(left + 1, right, n, s + "(");
        }
        if (right < left) {
            helper(left, right + 1, n, s + ")");
        }

        // resotre status


    }
}
//leetcode submit region end(Prohibit modification and deletion)
