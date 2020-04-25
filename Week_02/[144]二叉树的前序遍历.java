//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树


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
    public List<Integer> preorderTraversal(TreeNode root) {
        // 4.24 第一遍
        // 思路：前序遍历，经典算法。
        // 第一步：append root value
        // 第二步：递归左树
        // 第三步：递归右树
        // 复杂度分析：O（N），空间复杂度：O（logN）~ O（N），取决于 root 的形态

        List<Integer> ans = new ArrayList<>();
        preOrderHelper(root, ans);
        return ans;
    }

    public void preOrderHelper(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        ans.add(root.val);
        preOrderHelper(root.left, ans);
        preOrderHelper(root.right, ans);
    }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
