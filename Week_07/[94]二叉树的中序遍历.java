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
/**
 4.24 第一遍，5.4 第二遍，6.1 第三遍
 - 思路一：递归中序遍历，二叉树经典算法。
 1. 递归左树
 2. append root value
 3. 递归右树
 - 复杂度分析：O（N），空间复杂度：O（logN）~ O（N），取决于 root 的形态
 - 思路二：使用 Stack 来辅助完成。考虑到 stack 的特征是后进先出：
 1. 先将 root 放入到 satck 中，然后当 root != null 的时候，不断将 root 左移，并将其放入 stack，最终会导致最左侧的子节点位于 stack 最上端
 2. 当 `cur == null` 但是 stack 不为空的时候，说明已经走到最左边了，这时候就将其从 stack 中取出，并加入到 ans 中；
 3. 同时，将取出的节点重新赋值给 cur，并令 `cur = cur.right`，这样，当下一次循环的时候，就会发现 `cur != null`，于是会将右节点也放入 satck，并在下一次循环中继续放入 ans
 - 复杂度分析：O（N）
 */
class Solution {
    // Solution Two: Iteration
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                ans.add(cur.val);
                cur = cur.right;
            }
        }
        return ans;
    }
    // Solution One: Recursive
    public List<Integer> inorderTraversal(TreeNode root) {
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
//leetcode submit region end(Prohibit modification and deletion)
