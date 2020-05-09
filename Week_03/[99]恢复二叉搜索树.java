//二叉搜索树中的两个节点被错误地交换。 
//
// 请在不改变其结构的情况下，恢复这棵树。 
//
// 示例 1: 
//
// 输入: [1,3,null,null,2]
//
//   1
//  /
// 3
//  \
//   2
//
//输出: [3,1,null,null,2]
//
//   3
//  /
// 1
//  \
//   2
// 
//
// 示例 2: 
//
// 输入: [3,1,4,null,null,2]
//
//  3
// / \
//1   4
//   /
//  2
//
//输出: [2,1,4,null,null,3]
//
//  2
// / \
//1   4
//   /
//  3 
//
// 进阶: 
//
// 
// 使用 O(n) 空间复杂度的解法很容易实现。 
// 你能想出一个只使用常数空间的解决方案吗？ 
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
    // 4.27 第一遍, 5.4 第二遍
    // 思路：采用中序遍历。从 98 题中我们知道，对一个二叉树进行中序遍历，得到的数组将会从小到大排列。
    // 因为题中已经说明，仅有两个节点被错误的交换，因此我们可以使用双指针来遍历。对于两个节点被交换，会产生以下几种情况：
    // case 1：[1,2,3,4,5] 中，1和2被交换，因此会产生一个错误数值对。交换后是[2,1,3,4,5]，{2，1}是错误数值对
    // case 2：[1,2,3,4,5] 中，2和5被交换，此时会产生两个错误数值对。[1,5,3,4,2]中，{5，3}与{4，2}都是。
    // 所以我们可以将前后节点互相比较，如果前节点大于后节点，就违反了二叉树的定义，也就是我们要找的一种情况，用first 和 second 来分别保存；
    // 然后继续递归，找到第二组逆序的数字，则将second 赋值为第二组逆序中的后一个数字（case two 的2），然后交换first 和 second 即可。
    // 注意：判断前后结点的值的时候，应该是 pre.val > root.val，即前节点的值大于现节点的值。
    // 注意：赋值的时候，first 应该指向 pre，second 应该指向 root。对应着上面的case 2，将第一个逆序对的第一个元素和第二个逆序对的第二个元素，交换。
    // 注意：在寻找第一个逆序对的时候，`second = root` 的这个将 second 指向 root 的步骤不能省略。如果省略，就默认了只有 case 2
    // 会出现，忽略了 case 1 的情况。
    // 注意：中序遍历的时候，`pre = root` 和用 if 语句寻找逆序对的顺序不能交换
    // 复杂度分析：O（N）

    private TreeNode first = null;
    private TreeNode second = null;
    TreeNode pre = null;
    public void recoverTree(TreeNode root) {
        helper(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (pre != null && pre.val > root.val) {
            if (first == null) {
                first = pre;
                second = root;
            } else {
                second = root;
            }
        }
        pre = root;
        helper(root.right);
    }




    // private TreeNode first = null;
    // private TreeNode second = null;
    // private TreeNode pre = null;
    // public void recoverTree(TreeNode root) {
    //     inOrder(root);
    //     int tmp = first.val;
    //     first.val = second.val;
    //     second.val = tmp;
    // }

    // private void inOrder(TreeNode root) {
    //     if (root == null) return;

    //     inOrder(root.left);

    //     if (pre != null && pre.val > root.val) {
    //         // first == null 表示第一次遇到逆序对
    //         if (first == null) {
    //             first = pre;
    //             second = root;
    //         } else {
    //             // 第二次遇到逆序对
    //             second = root;
    //         }
    //     }
    //     pre = root;
    //     inOrder(root.right);
    // }
}
//leetcode submit region end(Prohibit modification and deletion)
