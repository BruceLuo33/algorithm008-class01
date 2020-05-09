//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组


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
    // 4.29 第一遍，5.5 第二遍
    // 思路：回顾一下，前序遍历指的是 root --> left --> right，中序遍历指的是 left --> root --> right
    // 根据两个遍历的特征，我们可以知道，前序遍历数组的第一个元素，即为根节点，再由这个根节点与中序遍历匹配，
    // 找到中序遍历中的根节点，则其左边就是左子树，右边就是右子树。
    // 然后再次回到前序遍历数组剩下的部分，第一个元素为右子树的根节点，以此类推。
    // 由上述分析可以看出，递归非常适合这道题目。
    // 注意：找 root 节点的时候，下标应该为 p_start 而不是 0
    // 注意：helper 函数 return null 的条件应该是 preorder 数组的 start == end
    // 注意：helper 函数的输入参数中，p_end 和 i_end 都不用 -1
    // 注意：在递归的过程中，p_start 更新应该要 +1. 因为将 preorder 的根节点拿出来后，左子树要从根节点之后开始计算。
    // 复杂度分析：O（N），空间复杂度：O（N)

    // 思路二：在上一个思路中，我们发现每一次从 inorder 数组中去找 root 节点，都需要用 for 循环去遍历，这样就无疑增加了复杂度，
    // 基于此，考虑加入一个 Map 来降低复杂度，将 inorder 的每一个数字和位置都输入 map，可以将复杂度降低很多
    //

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int p_start = 0, p_end = preorder.length;
        int i_start = 0, i_end = inorder.length;
        return buildTreeHelper(preorder, p_start, p_end, inorder, i_start, i_end, map);
    }

    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end, HashMap<Integer, Integer> map) {
        if (p_start == p_end) return null;
        TreeNode root = new TreeNode(preorder[p_start]);
        int rootIndex = map.get(root.val);
        int leftTreeLength = rootIndex - i_start;

        root.left = buildTreeHelper(preorder, p_start + 1, p_start + 1 + leftTreeLength, inorder, i_start, i_start + leftTreeLength, map);

        root.right = buildTreeHelper(preorder, p_start + leftTreeLength + 1, p_end, inorder, rootIndex + 1, i_end, map);
        return root;
    }




    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     for (int i = 0; i < inorder.length; i++) {
    //         map.put(inorder[i], i);
    //     }
    //     int p_start = 0, p_end = preorder.length;
    //     int i_start = 0, i_end = inorder.length;
    //     return buildTreeHelper(preorder, p_start, p_end, inorder, i_start, i_end, map);
    // }

    // private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end, HashMap<Integer, Integer> map) {
    //     if (p_start == p_end) return null;

    //     int rootVal = preorder[p_start];
    //     int rootIndex = map.get(rootVal);

    // Find the root index in the inorder array.
    // for (int i = 0; i < inorder.length; i++) {
    //     if (inorder[i] == rootVal) {
    //         rootIndex = i;
    //         break;
    //     }
    // }

    // TreeNode root = new TreeNode(rootVal);
    // int leftTreeLength = rootIndex - i_start;

    // root.left = buildTreeHelper(preorder, p_start + 1, p_start + 1 + leftTreeLength, inorder, i_start, rootIndex, map);
    // root.right = buildTreeHelper(preorder, p_start + leftTreeLength + 1, p_end, inorder, rootIndex + 1, i_end, map);

    // return root;
    // }
}
//leetcode submit region end(Prohibit modification and deletion)
