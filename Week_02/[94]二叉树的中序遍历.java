//给定一个二叉树，返回它的中序 遍历。 
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
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表


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
    public List<Integer> inorderTraversal(TreeNode root) {
        // 4.24 第一遍
        // 思路：中序遍历，二叉树经典算法。
        // 第一步：递归左树
        // 第二步：append root value
        // 第三步：递归右树
        // 复杂度分析：O（N），空间复杂度：O（logN）~ O（N），取决于 root 的形态
        List<Integer> ans = new ArrayList<>();
        inOrderHelper(root, ans);
        return ans;
    }

    public void inOrderHelper(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        inOrderHelper(root.left, ans);
        ans.add(root.val);
        inOrderHelper(root.right, ans);
    }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
