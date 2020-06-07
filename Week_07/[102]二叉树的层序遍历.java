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
/**
 4.28 第一遍，4.29 第二遍，5.4 第三遍，5.11 第四遍，6.2 第五遍
 思路：使用 BFS 对树进行层间遍历。每次都用一个队列来接受root，然后将其放入答案链表即可。
 注意：在判定当前子节点等级与 ans size 的关系的时候，要写 >= 而非 >，因为在一开始的时候，二者都是 0，如果不加 =，整个
 循环就无法开始。
 注意：往队列里添加的应该是 curNode.left 而不是 root.left
 复杂度分析：O（N） 空间复杂度：O（N）

 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        //6.2 codes
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return ans;
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                size -= 1;
                TreeNode curNode = queue.poll();
                tmp.add(curNode.val);
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            ans.add(tmp);
        }
        return ans;



        // 5.11 codes
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
                node.offer(curNode.left);
                node.offer(curNode.right);
                level = curLevel + 1;
                nodeLevel.offer(level);
                nodeLevel.offer(level);
            }
        }
        return ans;


        // 5.4 codes
        // List<List<Integer>> ans = new ArrayList<>();
        // Queue<TreeNode> node = new LinkedList<>();
        // Queue<Integer> nodeLevel = new LinkedList<>();
        // node.offer(root);
        // int level = 0;
        // nodeLevel.offer(level);

        // while (!node.isEmpty()) {
        //     TreeNode curNode = node.poll();
        //     Integer curLevel = nodeLevel.poll();
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


        // 4.29 codes
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



        // 4.28 codes
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
