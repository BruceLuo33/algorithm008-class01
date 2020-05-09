//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 5.9 第一遍
    // 思路：回溯算法。不过和之前不同之处在于，这里可选择的路径并非直接从节点到节点，而是需要先找到数字，每个数字提供三个可以选择的子节点，再在这三个子节点里面选择。对于这种情况，可以设置一个函数，输入数字，然后 return 对应的字符。
    // 在回溯的语句 `backtrack(digits, index + 1);` 中，是 index + 1 而不是 i + 1 的原因在于，i 只是在某一个数字的选择，数字和它所包含的三个字母实际上还是视为一个节点，但 backtrack 的东西应该是回到上一个节点，而这个节点就是由 index 来控制的，它代表的是第多少个数字。
    // 注意：时刻都要注意一些边界情况，例如输入为空，则应该返回的也是空 List。

    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int index = 0;
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0 || digits == null) return ans;
        backtrack(digits, 0);
        return ans;
    }

    private void backtrack(String digits, int index) {
        if (sb.length() == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        char c = digits.charAt(index);
        String s = transfer(c);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            backtrack(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private String transfer(char c) {
        if (c == '2') return "abc";
        if (c == '3') return "def";
        if (c == '4') return "ghi";
        if (c == '5') return "jkl";
        if (c == '6') return "mno";
        if (c == '7') return "pqrs";
        if (c == '8') return "tuv";
        if (c == '9') return "wxyz";
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
