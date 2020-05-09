//给定一个 N 叉树，找到其最大深度。 
//
// 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 我们应返回其最大深度，3。 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总不会超过 5000。 
// Related Topics 树 深度优先搜索 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        // 4.24 第一遍，5.3 第二遍
        // 思路：这道题的解法其实和 104 一样。不同之处在于 104 只有两个node，这里有很多个node
        // 所以只需要对整个 children 的 list 进行遍历就可以了。
        // 简单来说，一棵树的最大高度，就是所有子树中的最大高度 + 1
        // 注意：递归调用的位置，应该在 children 节点。
        // 复杂度分析：O（N）

        if (root == null) return 0;
        int maxVal = 0;
        for (Node child : root.children) {
            int tmp = maxDepth(child);
            maxVal = Math.max(maxVal, tmp);
        }
        return maxVal + 1;


        // if (root == null) return 0;
        // if (root.children.isEmpty()) return 1;
        // int maxHeight = 0;
        // for (Node i : root.children) {
        //     int tmp = maxDepth(i);
        //     maxHeight = Math.max(maxHeight, tmp);
        // }
        // return maxHeight + 1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
