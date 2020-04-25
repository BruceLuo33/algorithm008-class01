//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


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
    public List<Integer> postorder(Node root) {
        // 4.24 第一遍
        // 思路：与二叉树后序遍历一致：left --> right --> add

        List<Integer> ans = new ArrayList<>();
        postOrderHelper(root, ans);
        return ans;
    }

    private void postOrderHelper(Node root, List<Integer> ans) {
        if (root == null) return;
        for (Node i : root.children) {
            postOrderHelper(i, ans);
        }
        ans.add(root.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
