//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
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
    // 4.29 第一遍，5.5第二遍
    // 思路：这道题和 105 题基本思路一样。不同之处在于将前序遍历换成了后序遍历。所以在找 root 的时候换一下位置，其他不变就可以了
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        int iStart = 0, iEnd = inorder.length;
        int pStart = 0, pEnd = postorder.length;
        return buildTreeHelper(inorder, iStart, iEnd, postorder, pStart, pEnd, map);
    }

    private TreeNode buildTreeHelper(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd, HashMap<Integer, Integer> map) {
        if (pStart == pEnd) return null;
        int rootVal = postorder[pEnd - 1];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        int leftLen = rootIndex - iStart;
        // root.right 中，iStart + leftLen 其实就是 rootIndex
        root.left = buildTreeHelper(inorder, iStart, rootIndex, postorder, pStart, pStart + leftLen, map);
        root.right = buildTreeHelper(inorder, iStart + leftLen + 1, iEnd, postorder, pStart + leftLen, pEnd - 1, map);
        return root;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
