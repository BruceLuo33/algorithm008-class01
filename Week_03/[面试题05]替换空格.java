//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
//


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        // 4.29 第一遍
        // 思路：一开始想这道题似乎很简单，后面才发现难点在于在 JAVA 中，String 被设置为不可改变的类型，
        // 所以需要额外设置一个字符串来进行操作。
        // 复杂度分析：O（N），空间复杂度：O（N）

        StringBuilder ans = new StringBuilder();
        for (Character c : s.toCharArray()){
            if (c == ' ') {
                ans.append("%20");
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
