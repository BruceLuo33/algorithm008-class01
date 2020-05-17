//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        // 5.12 第一遍，5.16 第二遍
        // 思路：二分法。设置左边界为 0，右边界为 x。判断中点平方与x的大小关系，如果 mid^2 > x；就将右边界移动到 mid 左边；如果 mid^2 <= x，就将左边界移动到 mid 右边，并令 ans = mid（因为最终的答案是往下取整）然后不停迭代就好。
        // 注意，mid*mid 要 cast 成 long 的格式
        // 复杂度分析：O（logX）




        if (x == 0 || x == 1) return x;
        int start = 0, end = x - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if ((long) mid * mid > x) {
                end = mid - 1;
            } else if ((long) mid * mid < x) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return end;





        if (x == 0 || x == 1) return x;
        int left = 0, right = x , ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long) mid * mid <= x) {
                ans =  mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
