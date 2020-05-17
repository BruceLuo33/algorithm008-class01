//给定一个二叉树 
//
// struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// 
//
// 示例： 
//
// 
//
// 输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。 
//
// 
//
// 提示： 
//
// 
// 树中的节点数小于 6000 
// -100 <= node.val <= 100 
// 
//
// 
//
// 
// 
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    class Solution {
        // 5.8 第一遍，5.11 第二遍
        // 思路：和116题比较类似，但是区别在于这里不再是完美二叉树，而是一棵普通的二叉树，那么就可能存在空子节点，所以在连接next 的时候就需要增加一些判断。
        // 依旧使用递归，不过在这里，因为需要判断每一层的空子节点数，所以需要一个 hasNext 来遍历整层，相当于 BFS 的层序遍历。
        // 遍历的核心代码见下：
        // 复杂度分析：O（N）

        public Node connect(Node root) {
            if (root == null) return root;
            if (root.left != null && root.right != null) {
                root.left.next = root.right;
            }
            if (root.left != null && root.right == null) {
                root.left.next = getNext(root.next);
            }
            if (root.right != null) {
                root.right.next = getNext(root.next);
            }
            connect(root.right);
            connect(root.left);
            return root;
        }

        private Node getNext(Node root) {
            if (root == null) return null;
            if (root.left != null) return root.left;
            if (root.right != null) return root.right;
            if (root.next != null) return getNext(root.next);
            return null;
        }
}
//leetcode submit region end(Prohibit modification and deletion)
