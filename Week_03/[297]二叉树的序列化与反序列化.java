//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这
//个问题。 
//
// 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。 
// Related Topics 树 设计


//leetcode submit region begin(Prohibit modification and deletion)

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // 4.30 第一遍
    // 思路一：一开始看这个题目，感觉这不就是 94 和 105 的综合吗？先将一个二叉树前序/中序遍历完成 serialize，
    // 然后用它的前序和中序遍历来重建二叉树。这个思路没有太大问题，但是忽略了一个很重要的点，那就是给定序列的元素是可能重复的！
    // 例如 [3, 2, 4, 3]，这里有了重复的元素，那么用 105 的方法来重建的时候，就会出现在 inorder 数组中找不到 root 位置的情况
    // 思路二：既然 DFS works bad，那么就用 BFS。按照 102 题的方式来层序遍历，要注意的点是遇到 null 就记录 null。
    // 在还原的函数中，输入的是 String，所以首先我们要将其转换为 String 数组，然后再将其转换为 Integer，
    // 同时 null 也要判断与记录
    // 注意：在 serialize 函数中，因为返回的值是 String 而非 List<List<String>>，所以不再需要用 level 来控制 return 的维度
    // 注意：在 serialize 函数中，因为 node.val 是 Integer，所以用一个整型 List 去接收答案会比较好
    // 注意：在 deserialize 函数中，有一个小 bug 找了很久才找出来，那就是要记得在 String 数组转换为 Integer 数组的时候，
    // 使用 trim() 将空格切掉。
    // 总结：这道题的难点，不在于 serialize，而是如何重建二叉树。因为之前在 105 题中的经验不管用，所以需要用其他的方法来做。
    // 在这里我们使用了队列来保存即将访问的 root.left 和 root.right，并且根据二叉树的特征，即只有左子树和右子树，
    // 使用了两个 if 来往最终的二叉树中添加 node。并在每一个 node 之后将位置指针 curPos + 1
    // 复杂度分析：O（N）



    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // BFS, similar to Leetcode 102.
        List<Integer> ans = new ArrayList<>();
        if (root == null) return "";
        Queue<TreeNode> node = new LinkedList<>();
        node.offer(root);
        while (!node.isEmpty()) {
            TreeNode curNode = node.poll();
            if (curNode != null) {
                ans.add(curNode.val);
                node.offer(curNode.left);
                node.offer(curNode.right);
            } else {
                ans.add(null);
            }
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] strTree = data.substring(1, data.length() - 1).split(",");
        Integer[] bfsOrderTree = new Integer[strTree.length];
        for (int i = 0; i < strTree.length; i++) {
            if (strTree[i].trim().equals("null")) {
                bfsOrderTree[i] = null;
            } else {
                bfsOrderTree[i] = Integer.parseInt(strTree[i].trim());
            }
        }

        TreeNode root = new TreeNode(bfsOrderTree[0]);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int curPos = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (bfsOrderTree[curPos] != null) {
                curNode.left = new TreeNode(bfsOrderTree[curPos]);
                queue.add(curNode.left);
            }
            curPos += 1;
            if (bfsOrderTree[curPos] != null) {
                curNode.right = new TreeNode(bfsOrderTree[curPos]);
                queue.add(curNode.right);
            }
            curPos += 1;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
