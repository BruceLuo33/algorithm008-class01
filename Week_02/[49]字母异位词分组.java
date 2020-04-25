//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 4.24 第一遍
        // 思路：将string 数组中的每一个 string 都先转换为 char数组，然后sort，
        // sort 之后，ate 和 eat 就会以同一个 aet 表示出来。
        // 判断 HashMap 中是否containsKey，如果是，则将这个string 加到 value 中，
        // 因为 value 也是一个list，所以可以先get再add。
        // 如果没有这个key，将其放入 HashMap
        // 最终返回 hashmap 中的所有 value 值。
        // 复杂度：遍历 string 数组，假设最长的字符串为 M，则为 O（NKlogK）
        // 空间复杂度：O（NK）
        // 注意：要学习的地方在于对 String List 的处理
        // 将 strs[i] 先转换为 char[] 再用 valueOf 转换回来的原因，是需要用 Arrays.sort() 方法进行排序，
        // 注意：ArrayList<>() 中，括号内可以填写参数，在这里就需要填写 hashmap 的 values 值

        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] strArrayTmp = strs[i].toCharArray();

            Arrays.sort(strArrayTmp);
            String key = String.valueOf(strArrayTmp);

            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                List<String> tmp = new ArrayList<String>();
                tmp.add(strs[i]);
                map.put(key, tmp);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
