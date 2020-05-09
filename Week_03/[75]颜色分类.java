//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 注意: 
//不能使用代码库中的排序函数来解决这道题。 
//
// 示例: 
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2] 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用计数排序的两趟扫描算法。 
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        // 4.26 第一遍，5.4 第二遍
        // 思路：双指针。第一个指针之前全都是0；第二个指针之后全都是2；二者中间全都是1.
        // 注意：在移动 twoLoc 的时候，交换了 twoLoc 与 i 的位置，此时for循环将会
        // 令 i++，但是这是不正确的。因为我们并不知道nums[twoLoc]到底值是多少，
        // 所以还需要将 i--，来判断交换了位置之后的 num[twoLoc]，或者说新的 nums[i] 的大小。
        // 注意：因为在 twoLoc 处将 i 往前移了一位，所以不再需要将循环条件设置为 i < nums.length-1,
        // 设置为 i < twoLoc 即可。否则 twoLoc 将会进一步翻转，将 1 翻到后面。
        // 复杂度分析：O（N），空间复杂度：O（1）

        int zero = 0, two = nums.length - 1;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = tmp;
                zero += 1;
                continue;
            }
            if (nums[i] == 1) continue;
            if (nums[i] == 2) {
                int tmp = nums[i];
                nums[i] = nums[two];
                nums[two] = tmp;
                two -= 1;
                i -= 1;
                len -= 1;
                continue;
            }
        }




        int zeroLoc = 0, twoLoc = nums.length - 1;
        // int receive = 0;
        for (int i = 0; i<= twoLoc; i++) {
            if (nums[i] == 0) {
                int tmp = nums[zeroLoc];
                nums[zeroLoc] = 0;
                nums[i] = tmp;
                zeroLoc += 1;
            } else if (nums[i] == 2) {
                int tmp = nums[twoLoc];
                nums[twoLoc] = 2;
                nums[i] = tmp;
                twoLoc -= 1;
                i -= 1;
            }
            // receive = i;
        }
}
//leetcode submit region end(Prohibit modification and deletion)
