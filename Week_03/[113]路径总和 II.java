//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

import java.lang.reflect.Array;
import java.util.ArrayList;

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
    // 5.1 第一遍
    // 思路一：这道题和 112 很相似。不同之处在于 112 题只要求返回一个路径之和是否等于 target，这个题目还要求返回整个路径上的元素.
    // 有一点不同的是，因为 List 传入的并不是值，而是对值的地址的引用，所以要 `ans.add(new ArrayList<>(tmp))` 而不是简单的
    // `ans.add(tmp)`，否则在之后 tmp 值变化的时候，ans 中之前传入的 tmp 也会发生变化。
    // 思路二：在第一个方法中，我们传入的参数是 `ArrayList<Integer> tmp` 和 `List<List<Integer>> ans`，但实际上我们也可以将ans
    // 设计为全局变量，不再作为参数传入，而是传入另一个 `int curSum`，这样可以方便将 sum 分开看。同时判断空叶子节点的时候也可以
    // 选择 `if (root.left != null)`，这样方便思考。
    // 注意：
    // 复杂度分析：

    private List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        if (root == null) return  ans;
        helper(root, sum, 0, tmp);
        return ans;
    }

    private void helper(TreeNode root, int sum, int curSum, List<Integer> tmp) {
        tmp.add(root.val);
        curSum += root.val;
        if (root.left == null && root.right == null) {
            if (curSum == sum) {
                ans.add(new ArrayList<>(tmp));
            }
            tmp.remove(tmp.size() - 1);
            return;
        }

        if (root.left != null) {
            helper(root.left, sum, curSum, tmp);
        }

        if (root.right != null) {
            helper(root.right, sum, curSum, tmp);
        }
        tmp.remove(tmp.size() - 1);
    }



    // public List<List<Integer>> pathSum(TreeNode root, int sum) {
    //     List<List<Integer>> ans = new ArrayList<>();
    //     if (root == null) return ans;
    //     helper(root, sum, new ArrayList<Integer>(), ans);
    //     return ans;
    // }

    // private void helper(TreeNode root, int sum, ArrayList<Integer> tmp, List<List<Integer>> ans) {
    //     // Terminator
    //     if (root.left == null && root.right == null) {
    //         if (root.val == sum) {
    //             tmp.add(root.val);
    //             ans.add(new ArrayList<>(tmp));
    //             tmp.remove(tmp.size() - 1);
    //         }
    //         return;
    //     }
    //     // Process Logic
    //     if (root.left == null) {
    //         tmp.add(root.val);
    //         helper(root.right, sum - root.val, tmp, ans);
    //         tmp.remove(tmp.size() - 1);
    //         return;
    //     }

    //     if (root.right == null) {
    //         tmp.add(root.val);
    //         helper(root.left, sum - root.val, tmp, ans);
    //         tmp.remove(tmp.size() - 1);
    //         return;
    //     }

    //     tmp.add(root.val);
    //     helper(root.left, sum - root.val, tmp, ans);
    //     tmp.remove(tmp.size() - 1);

    //     tmp.add(root.val);
    //     helper(root.right, sum - root.val, tmp, ans);
    //     tmp.remove(tmp.size() - 1);

    //     // Recur

    //     // Restore status
    // }
}
//leetcode submit region end(Prohibit modification and deletion)
