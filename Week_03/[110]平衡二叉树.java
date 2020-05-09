//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。 
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
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
    // 4.24 第一遍，5.3 第二遍
    // 思路：最简单的思路，利用104题已经做出来的计算 height，来判断左右节点的height 之差是否大于一
    // 但是这会造成一个问题，那就是大量的重复计算。
    // 思路二：直接在计算 height 的函数中，判断左右 node 的 height 相差是否大于 1.
    // 注意：如果左右子树都不是平衡的，则 `Math.abs(leftHeight - rightHeight) == 0 将会成立
    // 为了避免这个情况，需要对height 进行判断，是否为 -1
    // 复杂度分析：O（N）


    // 5.3 codes
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = helper(root.left);
        if (leftHeight == -1) return -1;

        int rightHeight = helper(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return 1 + Math.max(leftHeight, rightHeight);
    }



    // 4.24 codes
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = height(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
