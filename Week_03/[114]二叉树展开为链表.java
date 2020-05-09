//给定一个二叉树，原地将它展开为链表。 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 5.1 第一遍
    // 思路：观察最终需要的目标链表，实际上就是原二叉树的前序遍历。又因为题目要求我们原地展开，所以不能新建链表，
    // 而是应该将 `root.left` 指向 `root.right` 或者是反过来。
    // 然而如果直接按照从根节点出发，我们会发现右子树会丢失。原因是将 `root.right` 指向 `root.left`的时候，右子树丢失了。
    // 既然正向走行不通，那么能否自底向顶走？即：
    // 递归到 6，然后将 5 的指针指向6：`6 <- 5 4 3 2 1`
    // 递归到 5，然后将 4 的指针指向5：`6 <- 5 <- 4 3 2 1`
    // 综合起来，这就是一个变形的后序遍历：
    // 原后序遍历：左 -> 右 -> 根
    // 现后序遍历：右 -> 左 -> 根
    // 然后利用一个暂时的指针指向要移动的node，不停递归就可以了.
    // 复杂度分析：O（N）

    TreeNode tmp = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = tmp;
        root.left = null;
        tmp = root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
