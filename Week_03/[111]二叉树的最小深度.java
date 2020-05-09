//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
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
class Solution {
    public int minDepth(TreeNode root) {
        // 4.24 第一遍
        // 思路：一开始的时候，想着和 104 题很相似，那是不是直接将 return 的项由 Math.max 转换成 Math.min 就可以呢？
        // 明显不是。因为如果某一个子节点为 null，则这个方法就会选择这个子节点。但事实上这样算出来对于 spindly 的case，
        // 也就是 worst case，会出现明显的误判。因此需要加两行判断，即如果左子节点为 null，就 return minDepth(root.left) + 1，
        // 如果右子节点为 null，则返回左子节点。
        // 注意：判断左右子节点为null，return 的项要 +1. 这表示循环往下走了一层。否则循环往下走，但是 height 没有记录，就会出错。
        // 复杂度分析：O(N)

        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
