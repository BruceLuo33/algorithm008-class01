//给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。 
//
// 注意： 
//
// 
// 给定的目标值 target 是一个浮点数 
// 题目保证在该二叉搜索树中只会存在一个最接近目标值的数 
// 
//
// 示例： 
//
// 输入: root = [4,2,5,1,3]，目标值 target = 3.714286
//
//    4
//   / \
//  2   5
// / \
//1   3
//
//输出: 4
// 
// Related Topics 树 二分查找


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
 思路：DFS遍历。用两个参数 res 和 rootVal 来控制输入。每次的差值为 `substract = Math.abs(root.val - target)`
 复杂度分析：O（N）
 */

class Solution {
    double res = Double.MAX_VALUE;
    int rootVal = 0;
    public int closestValue(TreeNode root, double target) {
        if (root != null) {
            double substract = Math.abs(target - root.val);
            if (substract < res) {
                rootVal = root.val;
                res = substract;
            }
            closestValue(root.left, target);
            closestValue(root.right, target);
        }
        return rootVal;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
