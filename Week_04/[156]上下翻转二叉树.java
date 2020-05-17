//给定一个二叉树，其中所有的右节点要么是具有兄弟节点（拥有相同父节点的左节点）的叶节点，要么为空，将此二叉树上下翻转并将它变成一棵树， 原来的右节点将转换成左
//叶节点。返回新的根。 
//
// 例子: 
//
// 输入: [1,2,3,4,5]
//
//    1
//   / \
//  2   3
// / \
//4   5
//
//输出: 返回二叉树的根 [4,5,2,#,#,3,1]
//
//   4
//  / \
// 5   2
//    / \
//   3   1  
// 
//
// 说明: 
//
// 对 [4,5,2,#,#,3,1] 感到困惑? 下面详细介绍请查看 二叉树是如何被序列化的。 
//
// 二叉树的序列化遵循层次遍历规则，当没有节点存在时，'#' 表示路径终止符。 
//
// 这里有一个例子: 
//
//    1
//  / \
// 2   3
//    /
//   4
//    \
//     5
// 
//
// 上面的二叉树则被序列化为 [1,2,3,#,#,4,#,#,5]. 
// Related Topics 树


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
 思路：递归。这道题的关键还是先要搞懂题目的意思。主要的变化在于：
 1. 左子节点会变成当下节点的根节点
 2. 右子节点会变成新根节点的左子节点
 3. 根节点会变成左子节点所形成的新根节点的右子节点。
 注意：basic terminator 应该是 `root == null || root.left == null`，不需要判断 root.right == null，因为我们需要的是左子节点来建立新的根节点
 复杂度分析：O（N）
 */
class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) return root;
        TreeNode left = root.left, right = root.right;
        TreeNode ans = upsideDownBinaryTree(root.left);
        root.left = null;
        root.right = null;
        left.left = right;
        left.right = root;

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
