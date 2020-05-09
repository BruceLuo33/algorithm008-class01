//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索


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
    // 4.27 第一遍，5.4 第二遍
    // 思路一：中序遍历。题目的要求是判断二叉树值得大小是否为从小到大排列。因此用中序遍历得 左-->根-->右，
    // 就可以比较好的解决这个问题。只要相邻两个元素不满足前项小于后项的关系，就返回false。
    // 注意：在存储树的 val 时，数据结构可以用 stack 或者是 arraylist。
    // 注意：判断左子节点的 value（已经存入 ans）与 root.val 关系的时候，要判断是否 >=，而不仅仅是 >
    // 复杂度分析：O（N），空间复杂度：O（N）

    // 思路二：递归。对于每一个节点，正确的范围应该是小于右子树中的最小值 + 大于左子树中的最大值。
    // 因此，我们可以设置递归，每次都已上一个节点作为左/右的一个边界，如果越界，代表出错。举例如下：
    //             10 (-inf, inf)
    //             /            \
    //       5(-inf, 10)      17(10, inf)
    //        /     \             /       \
    //  3(-inf, 5)  7(5,10)  13(10, 17)   20(17, inf)
    //
    // 从上图，我们可以总结出结论：如果是左子节点，那么应该以父节点为右边界，以父节点的左边界为左边界；
    // 如果是右子节点，应该以父节点为左边界，以父节点的右边界为右边界。
    // 注意：设置max/min 的时候，要将其再扩大一个位置，MAX_VALUE + 1 和 MIN+VALUE - 1
    // 注意：判定是否越界的时候，要用`node.val >= max` 而不能用 `node.left.val >= node.val`，
    // 因为我们的 terminator 条件只判定了 `node ！= null`，但没有检查 node.left，所以会出现空指针错误。
    // 正确的做法应该是 `if (node.val >= max)`
    // 复杂度分析：O（N），空间复杂度：O（1）

    public boolean isValidBST(TreeNode root) {
        long max = (long) Integer.MAX_VALUE + 1;
        long min = (long) Integer.MIN_VALUE - 1;
        return isOrder(root, max, min);
    }

    private boolean isOrder(TreeNode root, long max, long min) {
        if (root == null) return true;

        if (root.val >= max) return false;

        if (root.val <= min) return false;

        return isOrder(root.left, root.val, min) && isOrder(root.right, max, root.val);
    }



    // Solution Two Codes:
    public boolean isValidBST(TreeNode root) {
        long max = (long) Integer.MAX_VALUE + 1;
        long min = (long) Integer.MIN_VALUE - 1;
        return isOrder(root, min, max);
    }

    public boolean isOrder(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val >= max) {
            return false;
        }
        if (node.val <= min) {
            return false;
        }
        return isOrder(node.left, min, node.val) && isOrder(node.right, node.val, max);
    }


    // Solution One Codes：
    List<Integer> ans = new ArrayList<>();
    boolean result = true;
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        return result;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (ans.size() > 0) {
            if (ans.get(ans.size() - 1) >= root.val) {
                result = false;
            }
        }
        ans.add(root.val);
        inOrder(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
