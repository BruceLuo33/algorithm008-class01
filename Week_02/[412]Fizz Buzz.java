//写一个程序，输出从 1 到 n 数字的字符串表示。 
//
// 1. 如果 n 是3的倍数，输出“Fizz”； 
//
// 2. 如果 n 是5的倍数，输出“Buzz”； 
//
// 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。 
//
// 示例： 
//
// n = 15,
//
//返回:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
//]
// 
//


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> fizzBuzz(int n) {
        // 4.23 第一遍
        // 思路：按照要求，取余分析。
        // 注意：List 的初始化，不能直接 new List，而是需要 new ArrayList
        // 注意：if 条件判断是 i，而不是 n
        // 注意：将int 转换为 string 的方法：Integer.toString()

        // 4.23 codes
        if (n < 0) return null;
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                ans.add("Fizz");
            }
            else if (i % 5 == 0 && i % 3 != 0) {
                ans.add("Buzz");
            }
            else if (i % 3 ==0 && i % 5 == 0) {
                ans.add("FizzBuzz");
            }
            else {
                ans.add(Integer.toString(i));
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
