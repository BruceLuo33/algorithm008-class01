//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索


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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 4.29 第一遍
        // 思路：这道题和102基本一样，同样用到 BFS 来解题
        // 稍微不同的地方在于，102 是从根节点往下遍历，但是这里是从叶子节点往上遍历。
        // 所以只需要将两个地方更改，即将每一层的元素插入到 ans 数组的第一个位置，就可以了。
        // 注意：不仅仅在 ans.add 需要更改，还需要在 ans.get 将 curLevel 改成 0
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> node = new LinkedList<>();
        Queue<Integer> nodeLevel = new LinkedList<>();
        node.offer(root);
        int level = 0;
        nodeLevel.offer(level);

        while(!node.isEmpty()) {
            TreeNode curNode = node.poll();
            int curLevel = nodeLevel.poll();
            if (curNode != null) {
                if (curLevel >= ans.size()) {
                    ans.add(0, new ArrayList());
                }
                ans.get(0).add(curNode.val);

                level = curLevel + 1;
                node.offer(curNode.left);
                node.offer(curNode.right);
                nodeLevel.offer(level);
                nodeLevel.offer(level);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
