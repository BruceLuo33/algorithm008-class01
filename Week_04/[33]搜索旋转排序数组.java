//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.14 第一遍，5.16 第二遍
 思路：二分查找。乍一看会想到是不是需要先找出旋转的基点，但是这样的话时间复杂度就不符合要求。如果用二分查找就可以比较好的解决问题：
 1. 先拿出中间的数，与最右边的数字比较，如果大于，说明左半段是有序的，而后比较 target 与左半段第一个与最后一个数字的大小，判断是否在这段区间内；
 2. 如果不在，则舍弃掉左半边的部分，继续取剩下的部分的中间值判断，每次都在有序的半部分进行判断。以此类推。
 注意：判断 target 和 nums[start]/nums[end] 的关系时，等号是否取很重要。
 注意：等号放在哪里很重要。
 */
class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
