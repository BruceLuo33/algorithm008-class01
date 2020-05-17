//给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。 
//
// 例如，从根到叶子节点路径 1->2->3 代表数字 123。 
//
// 计算从根到叶子节点生成的所有数字之和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//    1
//   / \
//  2   3
//输出: 25
//解释:
//从根到叶子节点路径 1->2 代表数字 12.
//从根到叶子节点路径 1->3 代表数字 13.
//因此，数字总和 = 12 + 13 = 25. 
//
// 示例 2: 
//
// 输入: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//输出: 1026
//解释:
//从根到叶子节点路径 4->9->5 代表数字 495.
//从根到叶子节点路径 4->9->1 代表数字 491.
//从根到叶子节点路径 4->0 代表数字 40.
//因此，数字总和 = 495 + 491 + 40 = 1026. 
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
/**
 5.14 第一遍
 思路：DFS。一开始的时候直接用了`count += root.val`，然后发现这是将每一个结点的值累加了，但是没有进行进位。因此，我们不能仅用 count 一个参数来控制，应该还需要另一个参数与一个helper 函数。
 复杂度分析：O（N）
 */
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        // int sum = 0;
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int val) {
        if (root == null) return;
        val= (root.val + val * 10);
        if (root.left == null && root.right == null) {
            sum += val;
        }
        helper(root.left, val);
        helper(root.right, val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
