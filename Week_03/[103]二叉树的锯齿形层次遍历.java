//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
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
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索


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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 4.28 第一遍，4.29 第二遍，5.4 第三遍
        // 思路：这道题和102题几乎一样，唯一的不同之处在于如果 level 为奇，就是从左往右，
        // 如果是偶数，就是从右往左。因此对 curLevel 增加一个奇偶判断就可以了
        // 复杂度分析：O（N），空间复杂度：O（N）

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> node = new LinkedList<>();
        Queue<Integer> nodeLevel = new LinkedList<>();
        int level = 0;
        node.offer(root);
        nodeLevel.offer(level);

        while (!node.isEmpty()) {
            TreeNode curNode = node.poll();
            int curLevel = nodeLevel.poll();
            if (curNode != null) {
                if (curLevel >= ans.size()) {
                    ans.add(new ArrayList<>());
                }
                if (curLevel % 2 == 0 ) {
                    ans.get(curLevel).add(curNode.val);
                } else {
                    ans.get(curLevel).add(0, curNode.val);
                }
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
