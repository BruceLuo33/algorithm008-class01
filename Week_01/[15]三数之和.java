//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int first = i + 1, last = nums.length - 1;
            int sum = nums[i] + nums[first] + nums[last];
            int target = -nums[i];
            while (first < last) {
                if (nums[first] + nums[last] == target) {
//                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[first], nums[last]));
                    first += 1;
                    last -= 1;
                    while (first < last && nums[first] == nums[first - 1]) {
                        first += 1;
                    }
                    while (first < last && nums[last] == nums[last + 1]) {
                        last -= 1;
                    }
                } else if (nums[first] + nums[last] > target) {
                    last -= 1;
                } else {
                    first += 1;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
