//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 5.8 第一遍
    // 思路一：回溯。
    // 注意：在往ans数组中添加值得时候，要注意不能写 `ans.add(track)`，因为添加的事实上是一组指向值的地址，所以会随着track 每次路径的不同而改变。而最终track 会回到起始点，也就是空集，这样就会造成最后的所有subset都是空集。
        // 解决方法：`ans.add(new LinkedList<Integer>(track))` 即可
    // 复杂度分析：O（NxN!）
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        helper(nums, track);
        return ans;
    }

    private void helper(int[] nums, LinkedList<Integer> track) {
        if (nums.length == track.size()) {
            ans.add(new LinkedList<Integer>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) continue;

            track.add(nums[i]);
            helper(nums, track);
            track.removeLast();
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
