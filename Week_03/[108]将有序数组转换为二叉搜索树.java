//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // 4.30 第一遍，5.5 第二遍
    // 思路一：一开始的时候想到了能否用 weighted-Union Find 算法，但是对于一道算法题，应该不需要这么复杂。
    // 思路二：联想到之前做过的题目：从 98 和 99 题我们可以知道，一个二叉树的中序遍历刚好就是一个升序的数组；
    // 从 105 和 106 我们知道，如果有了中序遍历与前序 or 后序遍历的数组，我们就能重建一个二叉树。
    // 而还原二叉树的关键，就在于找到根节点。那么这道题也就做出来了：
    // 因为给定的是有序数组，且要求我们实现一个高度平衡的二叉树，所以我们找根节点也就很简单了：直接用中间的数字当作根节点即可
    // 注意：数组的 End 应该是 nums.length，不需要 -1，如果 -1，则相当于丢掉了数组的最后一项
    // 注意：求中间位置索引的时候，用 Math.floor 方法会超时，直接 /2 就可以了
    // 复杂度分析：O（N）

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start == end) return null;

        int mid = (int) (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid);
        root.right = helper(nums, mid + 1, end);
        return root;
    }



    // public TreeNode sortedArrayToBST(int[] nums) {
    //     return helper(0, nums.length, nums);
    // }

    // private TreeNode helper(int start, int end, int[] nums) {
    //     if (start == end) return null;

    //     int mid = (int) (start + end)/2;
    //     TreeNode root = new TreeNode(nums[mid]);
    //     root.left = helper(start, mid, nums);
    //     root.right = helper(mid + 1, end, nums);
    //     return root;
    // }
}
//leetcode submit region end(Prohibit modification and deletion)
