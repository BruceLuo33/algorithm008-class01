//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        // 5.7 第一遍
        // 思路一：数学方法。因为多数元素表示的是在整个数组中占比超过 1/2，那么将数组排序后 n/2 位置的元素一定就是多数元素
        // 复杂度分析：O（NlogN）
        // 思路二：HashMap。将元素都放入 HashMap，并判断个数是否 >= n/2。如果是，则返回该元素
        // 复杂度分析：O（N）
        // 思路三：投票法。我们假设这样一个场景，在一个游戏中，分了若干个队伍，有一个队伍的人数超过了半数。所有人的战力都相同，不同队伍的两个人遇到就是同归于尽，同一个队伍的人遇到则战力值+1。

        // Solution 1：
        Arrays.sort(nums);
        return nums[nums.length / 2];

        // Solution 2：
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int count = map.getOrDefault(nums[i], 0);
            if (count >= len/2) return nums[i];
            map.put(nums[i], count+1);
        }
        return -1;


        // Solution 3：
        int count = 1, len = nums.length;
        int move = nums[0];
        for (int i = 1; i < len; i++) {
            if (count == 0) {
                move = nums[i];
                count += 1;
                continue;
            }
            if (move == nums[i]) {
                count += 1;
            } else {
                count -= 1;
            }
        }
        return move;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
