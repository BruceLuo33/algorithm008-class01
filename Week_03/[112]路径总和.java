//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
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
    // 4.30 第一遍
    // 思路：这道题和 111 求最小深度的题很相似。同样的要注意的问题也很相似，那就是要避免出现 spindly 树，导致过早的结束递归所带来的误判
    // 复杂度分析：O（N），空间复杂度：O（logN）~ O（N）
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return helper(root, sum);
    }

    private boolean helper(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        if (root.left == null) {
            return helper(root.right, sum - root.val);
        }

        if (root.right == null) {
            return helper(root.left, sum - root.val);
        }

        return helper(root.left, sum - root.val) || helper(root.right, sum - root.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
