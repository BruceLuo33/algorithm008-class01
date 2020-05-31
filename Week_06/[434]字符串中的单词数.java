//统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。 
//
// 请注意，你可以假定字符串里不包括任何不可打印的字符。 
//
// 示例: 
//
// 输入: "Hello, my name is John"
//输出: 5
//解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
// 
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.30 第一遍
 - 思路：循环。单词的分割是根据空格来的，所以一开始的思路是找到多少个空格，再 +1 就可以了。但是发现有两种情况：
 1. ""，即空 String，对于这种情况，在一开始的时候加一个判断 `if(s.length() == 0) return count`
 2. "     "，这个其实也是空 String，但是对于之前的算法来说，就有问题了，因为它实际上有很多空格，那么再加上一个判断：`if (i > 0 && s.charAt(i-1) != ' ' && s.charAt(i) == ' ')`
 3. 但是问题还没有解决，现在不会返回 17 了，但是还是会返回 1.这是因为我们的 return 项是 count + 1. 在评论里看到一个很巧妙的方法，在一开始的时候，就到 s 的后面加上一个空格，`s += ' '`，这样一来，就可以解决问题了。同时最终也改成 `return count`
 复杂度分析：O（N），空间复杂度：O（1）
 */

class Solution {
    public int countSegments(String s) {
        int count = 0;
        s += ' ';
        if (s.length() == 0) return count;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i-1) != ' ' && s.charAt(i) == ' ') {
                count += 1;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
