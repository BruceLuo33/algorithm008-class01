//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索


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
 思路：BFS。套模板就行了，注意当 size == 0 的时候将 curNode.val 加入ans。
 复杂度分析：O（N）
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> node = new LinkedList<>();
        node.offer(root);
        while (!node.isEmpty()) {
            int size = node.size();
            while (size > 0) {
                size -= 1;
                TreeNode curNode = node.poll();
                if (curNode.left != null) {
                    node.offer(curNode.left);
                }
                if (curNode.right != null) {
                    node.offer(curNode.right);
                }
                if (size == 0) {
                    ans.add(curNode.val);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
