//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 4.25 第二遍
        // 思路一：很早之前做过这道题。直接用的两遍循环。暴力破解，复杂度O（N^2)
        // 思路二：降低复杂度，使用 HashMap。
        // 步骤：1、将nums 放入 HashMap；2、对于每一个元素 i，找出 target - i 是否在 map中；
        // 3、如果在，返回下标；如果不在，返回空数组。
        // 注意：判断map 是否有key 的时候，因为题目要求同一个元素不能使用两次，
        // 所以还需要判定 map.get(target - nums[i]) != i。

        int[] location = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if (map.containsKey(res) && map.get(res) != i) {
                location[0] = i ;
                location[1] = map.get(res) ;
                return location;
            }
        }
        return location;


        int sum = 0;
        int[] location = new int[2];
        for(int i = 0; i<nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum = nums[i] + nums[j];
                if (target == sum) {
                    location[0] = i;
                    location[1] = j;
                    break;
                    // return location;
                }
                // else {
                //     return null;
                // }
            }
        }
        return location;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
