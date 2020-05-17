//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个位置。 
//
// 示例 1: 
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
// 
//
// 示例 2: 
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
// 
// Related Topics 贪心算法 数组


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.15 第一遍
 思路一：贪心算法，反向贪心。这道题是超哥在视频中讲到了的。解题思路并不是完全和题目给定的一致，而是从最后一项往前走，
 思路二：从起点出发，设置其为起跳点：
 1. 如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点。
 2. 可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新。
 3. 如果可以一直跳到最后，就成功了。
 复杂度分析：O（N）
 */
class Solution {

    // Solution 1
    public boolean canJump(int[] nums) {
        int min = nums.length - 1;
        for (int i = nums.length - 2; i > 0; i--) {
            if (i + nums[i] >= min) {
                min = i;
            }
        }
        return nums[0] >= min;
    }

    //Solution 2
    public boolean canJump(int[] nums) {
        int canReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > canReach) return false;
            canReach = Math.max(canReach, i + nums[i]);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
