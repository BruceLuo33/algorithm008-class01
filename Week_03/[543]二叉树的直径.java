//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
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
class Solution {
    // 4.25 第一遍，5.4第二遍
    // 思路：递归。一开始想的是树的直径就是root 往两边走的叶子节点最大深度之和。
    // 然而问题在于，叶子节点是对的，但是不一定经过 root。在这里采用递归，可以比较好的避免这个问题：
    // 遍历每一个节点，将这一个节点当作root，求出它的深度，则左子树加右子树的深度，就是当前节点作为 root 的直径；
    // 然后存入 maxDepth，以后的每一个节点都和 maxDepth 比较，如果大于则放入。直到完成循环。
    // 注意：递归 return 的项是 leftDepth 和 rightDepth 中较大值 +1，相当于在这里选定了只走较长边。
    // 注意：maxDepth 要设置为全局变量，否则只能当作参数输入 depth，会在递归的时候造成麻烦
    // 复杂度分析：O（N），空间复杂度：O（k），k为树的深度

    int maxDepth = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return maxDepth;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = helper(root.left);
        int rightDepth = helper(root.right);
        maxDepth = Math.max(maxDepth, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }




    // int maxDepth = 0;
    // public int diameterOfBinaryTree(TreeNode root) {
    //     depth(root);
    //     return maxDepth;
    // }

    // private int depth(TreeNode root) {
    //     if (root == null) return 0;
    //     int leftDepth = depth(root.left);
    //     int rightDepth = depth(root.right);
    //     maxDepth = Math.max(leftDepth + rightDepth, maxDepth);
    //     return Math.max(leftDepth, rightDepth) + 1;
    // }
}
//leetcode submit region end(Prohibit modification and deletion)
