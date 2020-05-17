//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
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
 5.10 第一遍，5.11 第二遍，5.15 第三遍
 思路：递归。关键问题在于对参数 `left` 和 `right` 的理解，因为这是递归，所以在写递归语句的时候，可以认为左右子树都已经算出来了结果。
 1. 如果当前节点 root 为 null，那么就直接返回 null；
 2. 如果 root 等于 p 或者是 q，那么就返回 p or q；
 3. 接着往下递归。如上所述，递归的时候可以直接认为我们已经求出来了 left 和 right，用它们来表示即可；
 4. 对于返回值，有以下几种情况：第一，left 和 right 同时为空，说明左右子树都不包含p、q，返回null；第二，同时不为空，说明在root 的两侧，返回root；第三，left 为空，right不为空，说明p、q都在右边；第四，right 为空，left不为空，说明都在左边
 复杂度分析：O（N）
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


        if (root == null || root == q || root == p) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) return null;
        if (left != null && right != null) return root;
        if (left == null) return right;
        if (right == null) return left;
        return null;



        // if (root == null) return null;
        // if (root == null || root == p || root == q) return root;

        // TreeNode left = lowestCommonAncestor(root.left, p, q);
        // TreeNode right = lowestCommonAncestor(root.right, p, q);

        // if (left == null) return right;
        // if (right == null) return left;
        // if (left != null && right != null) return root;
        // return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
