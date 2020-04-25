//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        // 4.23 第一遍
        // 思路：1、暴力破解。将string sort，然后比较每一个元素。
        //      2、HashMap。第一个循环将 s 中的所有char 放入map，然后再去检查 t 中每一个元素是否在里面
        // 复杂度分析：1、O（NlogN）；2、O（N）
        // 注意：不要将 s/t 转换为 charArray，直接用 charAt 来做就可以了

        if (s.length() != t.length()) return false;
        int[] compare = new int[26];
        for (int i = 0; i < s.length(); i++) {
            compare[s.charAt(i) - 'a']++;
            compare[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < compare.length; i++) {
            if (compare[i] != 0) return false;
        }
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
