//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索


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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 4.28 第一遍，4.29 第二遍，5.4 第三遍
        // 思路：使用 BFS 对树进行层间遍历。每次都用一个队列来接受root，然后将其放入答案链表即可。
        // 注意：在判定当前子节点等级与 ans size 的关系的时候，要写 >= 而非 >，因为在一开始的时候，二者都是 0，如果不加 =，整个
        // 循环就无法开始。
        // 复杂度分析：O（N） 空间复杂度：O（N）

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> node = new LinkedList<>();
        Queue<Integer> nodeLevel = new LinkedList<>();
        node.offer(root);
        int level = 0;
        nodeLevel.offer(level);

        while (!node.isEmpty()) {
            TreeNode curNode = node.poll();
            Integer curLevel = nodeLevel.poll();
            if (curNode != null) {
                if (curLevel >= ans.size()) {
                    ans.add(new ArrayList<>());
                }
                ans.get(curLevel).add(curNode.val);
                level = curLevel + 1;
                node.offer(curNode.left);
                node.offer(curNode.right);
                nodeLevel.offer(level);
                nodeLevel.offer(level);
            }

        }
        return ans;



        // List<List<Integer>> ans = new ArrayList<>();
        // if (root == null) return ans;

        // Queue<TreeNode> node = new LinkedList<>();
        // Queue<Integer> nodeLevel = new LinkedList<>();
        // int level = 0;
        // node.offer(root);
        // nodeLevel.offer(level);

        // while(!node.isEmpty()) {
        //     TreeNode curNode = node.poll();
        //     int curLevel = nodeLevel.poll();
        //     if (curNode != null) {
        //         if (curLevel >= ans.size()) {
        //             ans.add(new ArrayList<>());
        //         }
        //         ans.get(curLevel).add(curNode.val);
        //         level = curLevel + 1;
        //         node.offer(curNode.left);
        //         node.offer(curNode.right);
        //         nodeLevel.offer(level);
        //         nodeLevel.offer(level);
        //     }
        // }
        // return ans;


        // List<List<Integer>> ans = new ArrayList<>();
        // if (root == null) return ans;

        // int level = 0;
        // Queue<TreeNode> treeNode = new LinkedList<>();
        // Queue<Integer> nodeLevel = new LinkedList<>();
        // treeNode.offer(root);
        // nodeLevel.offer(level);

        // while(!treeNode.isEmpty()) {
        //     TreeNode curNode = treeNode.poll();
        //     int curLevel = nodeLevel.poll();
        //     if(curNode != null) {
        //         if (ans.size() <= curLevel) {
        //             ans.add(new ArrayList<>());
        //         }

        //         ans.get(curLevel).add(curNode.val);
        //         level = curLevel + 1;
        //         treeNode.offer(curNode.left);
        //         treeNode.offer(curNode.right);
        //         nodeLevel.offer(level);
        //         nodeLevel.offer(level);
        //     }
        // }
        // return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
