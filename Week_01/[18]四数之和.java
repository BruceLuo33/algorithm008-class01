//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针


import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) return ans;
        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int minValueOne = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            int maxValueOne = nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1];
            if (minValueOne > target) continue;
            if ( maxValueOne < target) continue;

            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int first = j + 1;
                int last = len - 1;
                int minValueTwo = nums[i] + nums[j] + nums[first] + nums[first + 1];
                int maxValueTwo = nums[i] + nums[j] + nums[last - 1] + nums[last];
                if (minValueTwo > target) continue;
                if ( maxValueTwo < target) continue;

                while (first < last) {
                    int sum = nums[i] + nums[j] + nums[first] + nums[last];;
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[first], nums[last]));
                        first += 1;
                        last -= 1;
                        while (first < last && nums[first] == nums[first-1]) first += 1;
                        while (first < last && nums[last] == nums[last + 1]) {
                            last -= 1;
                        }
                    } else if (sum > target) {
                        last -= 1;
                    } else first += 1;
                }
            }
        }
        return ans;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
