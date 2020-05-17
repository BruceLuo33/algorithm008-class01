//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 你可以假设数组中不存在重复元素。 
//
// 示例 1: 
//
// 输入: [3,4,5,1,2]
//输出: 1 
//
// 示例 2: 
//
// 输入: [4,5,6,7,0,1,2]
//输出: 0 
// Related Topics 数组 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.16 第一遍
 思路：二分查找。数组的最小值，一定出现在发生旋转的点上。
 1. 比较 nums[start], nums[end], nums[mid] 的值的大小，找到升序的那一半部分
 2. 旋转节点一定在非升序部分，将升序部分舍弃
 3. 如此循环，直到找到旋转的支点
 注意：while 的条件中 start < end 而非 <=；
 边界问题很重要，
 */
class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) return len;
        int start = 0, end = len - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else if (nums[mid] > nums[end]) {
                start = mid + 1;
            }
        }
        return nums[start];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
