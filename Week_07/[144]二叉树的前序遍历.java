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
/**
 4.24 第一遍，5.4 第二遍
 - 思路一：前序遍历，经典算法。
 1. append root value
 2. 递归左树
 3. 递归右树
 - 复杂度分析：O（N），空间复杂度：O（logN）~ O（N），取决于 root 的形态
 - 思路二：与 94 题一样，用 stack 来辅助进行递归，步骤如下：
 1. 把根结点加入stack中。
 2. 开始遍历 while(!stack.isEmpty()) 执行下面的3、4步
 3. 从stack中取出栈顶的TreeNode node结点，把它加入到结果集res中
 4. 依次加入node的右孩子、左孩子（如果存在的话）
 5. 得到结果集res，返回
 */
class Solution {

    // Solution Two：Iteration
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return ans;
    }


    // Solution One：Recursive
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> ans = new ArrayList<>();
    //     helper(root, ans);
    //     return ans;
    // }
    // private void helper(TreeNode root, List<Integer> ans) {
    //     if (root == null) return;

    //     ans.add(root.val);
    //     helper(root.left, ans);
    //     helper(root.right, ans);
    // }
}
//leetcode submit region end(Prohibit modification and deletion)
