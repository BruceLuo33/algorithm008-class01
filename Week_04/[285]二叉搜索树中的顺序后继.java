//给你一个二叉搜索树和其中的某一个结点，请你找出该结点在树中顺序后继的节点。 
//
// 结点 p 的后继是值比 p.val 大的结点中键值最小的结点。 
//
// 
//
// 示例 1: 
//
// 
//
// 输入: root = [2,1,3], p = 1
//输出: 2
//解析: 这里 1 的顺序后继是 2。请注意 p 和返回值都应是 TreeNode 类型。
// 
//
// 示例 2: 
//
// 
//
// 输入: root = [5,3,6,2,4,null,null,1], p = 6
//输出: null
//解析: 因为给出的结点没有顺序后继，所以答案就返回 null 了。
// 
//
// 
//
// 注意: 
//
// 
// 假如给出的结点在该树中没有顺序后继的话，请返回 null 
// 我们保证树中每个结点的值是唯一的 
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
 5.17 第一遍
 思路：中序遍历。题目需要的是节点 p 的后继，即 val 比 p.val 大的 node 中最小的结点。考虑到中序遍历输出的序列是从小到大排列，因此采用中序遍历将会很合适。
 注意：用 `if (root.val > p.val && ans == null)` 就可以找到刚好比 p 大的下一个节点了。
 */
class Solution {
    TreeNode ans = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inOrder(root, p);
        return ans;
    }
    private void inOrder(TreeNode root, TreeNode p) {
        if (root == null) return;
        inOrder(root.left, p);
        if (root.val > p.val && ans == null) {
            ans = root;
        }
        inOrder(root.right, p);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
