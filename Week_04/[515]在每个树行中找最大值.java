//您需要在二叉树的每一行中找到最大的值。 
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
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
 5.13 第一遍
 思路：BFS。递归每一层，找到每一层的最大值，将其放入ans 数组即可。
 注意：
 1. max 的初始化 `int max = Integer.MIN_VALUE` 要放在第一个 while 循环中
 2. 对 queue 首元素的提取，要放在第二个 while 里面
 3. 继续往 queue 中添加的是 node 的左右子节点
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                size -= 1;
                max = Math.max(max, node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ans.add(max);
        }

        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
