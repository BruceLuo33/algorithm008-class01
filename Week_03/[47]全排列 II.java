//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 5.9 第一遍
    // 思路：这道题与上一题很像，不同之处在于这里需要剪枝。在剪枝之前，需要先对数据进行排序。尽管排序也会花一定的时间，但是与回溯算法本身的复杂度相比还是低很多
    // 同时要注意，这里给定的序列中就有重复元素，所以最终的排列结果，会出现[1,1,2] 和 [1,1,2]，需要去除其中的一个。
    // 1. 在主函数中，将 nums[] 排序
    // 2. 和 46 题相比，多用一个 used[] 的boolean 数组来记录某一个元素是否已经在前面出现过。具体方法为：在 `track.add(nums[i])` 之后，将 `used[i] = true`；同时，在回退状态之后，将 `used[i] = false`
    // 3. 核心的步骤，在于对重复元素的判断。在上一题中，我们使用的是 `if (track.contains(nums[i])) continue`，但是在这里行不通，原因是在给定的数组中就已经有了重复元素。这条语句的适用条件为 [1,2,3] 这样的数组，但是题目给出的是 [1,1,2] 等类似的数组。如果用这条语句来判断是否跳过，则会出现错误。
    // 4. 基于第三点，和之前设置的 used 数组，我们可以用这条语句来判定：`if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;`，它表示了两种情况：第一，used[i] 已经用过了，那么肯定要跳过；第二，used[i-1] 都没用过，但是nums[i] == nums[i-1]，这相当于在判断used[i] 之前，就已经判断了元素是否重复。因为我们事先排序了，所以这个判断才能实现。
    // 复杂度分析：

    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(nums);
        helper(nums, track, new boolean[nums.length]);
        return ans;
    }

    private void helper(int[] nums, LinkedList<Integer> track, boolean[] used) {
        if (nums.length == track.size()) {
            ans.add(new LinkedList<Integer>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
//            if (track.contains(nums[i])) continue;
            if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            track.add(nums[i]);

            helper(nums, track, used);
            used[i] = false;
            track.removeLast();

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
