//给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的 k 个值。 
//
// 注意： 
//
// 
// 给定的目标值 target 是一个浮点数 
// 你可以默认 k 值永远是有效的，即 k ≤ 总结点数 
// 题目保证该二叉搜索树中只会存在一种 k 个值集合最接近目标值 
// 
//
// 示例： 
//
// 输入: root = [4,2,5,1,3]，目标值 = 3.714286，且 k = 2
//
//    4
//   / \
//  2   5
// / \
//1   3
//
//输出: [4,3] 
//
// 拓展： 
//假设该二叉搜索树是平衡的，请问您是否能在小于 O(n)（n 为总结点数）的时间复杂度内解决该问题呢？ 
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
/**
 5.17 第一遍
 思路：中序遍历。一开始的时候搞错了意思，以为还要按照从大到小的顺序输出 List，但是只要里面的元素一致就可以了。
 复杂度分析：O（N）
 */
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans, target, k);
        return ans;
    }
    private void inorder(TreeNode root, List<Integer> ans, double target, int k) {
        if (root == null) return;

        inorder(root.left, ans, target, k);
        if (ans.size() < k) {
            ans.add(root.val);
        } else if (Math.abs(ans.get(0) - target) > Math.abs(root.val - target)) {
            ans.remove(0);
            ans.add(root.val);
        } else {
            return;
        }
        inorder(root.right, ans, target, k);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
