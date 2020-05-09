//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 5.9 第一遍
    // 思路：回溯算法。套模板就可以了。
    // 注意：模板中不再需要 if 来判断结束条件，因为这道题求子集，相当于决策树上的每一个节点的路径数组都要访问到。


    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) return ans;
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, 0, track);
        return ans;
    }

    private void backtrack(int[] nums, int start, LinkedList<Integer> track) {
        ans.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i + 1, track);
            track.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
