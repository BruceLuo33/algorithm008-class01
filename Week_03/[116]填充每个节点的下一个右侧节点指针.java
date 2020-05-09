//给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下： 
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
// 示例： 
//
// 
//
// 输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"ri
//ght":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right
//":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left"
//:null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":nu
//ll,"next":null,"right":null,"val":7},"val":3},"val":1}
//
//输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4
//","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next"
//:null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":
//null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":
//"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"va
//l":1}
//
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
// 
//
// 
//
// 提示： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
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
    // 5.8 第一遍
    // 思路一：递归。递归非常简洁，是必须要会的一个技巧。简单来说，将 node 指向右侧节点有三种情况：
    // 第一，node 本身为空，那么返回 null 就好了
    // 第二，node 的左子节点不为空，那么直接 `node.left.next = node.right`，将左子节点指向右子节点
    // 第三，node 的右子节点不为空，那么就需要判断 node.next 是否为空，如果是，说明右边没有节点了，将 node.right = null 就行；如果不是，则将其指向 node.next 的左子节点。`node.right.next = node.next.left`
    // 复杂度分析：O（N）
    // 思路二：迭代。题目要求空间复杂度为 O（1)。所以采用迭代来达到这个要求。
    // 在这里我们设置三个指针：第一个 level，指向每一层的最左边的节点；第二个 prev，指向要延伸出 next 指向右边的节点；第三个是 cur， 指向 prev 右边一个节点。所以 cur 可以为 null，代表的是 prev 已经到达了这一层的最右端。
    // 连接的关键在于通过 level 来控制在哪一层进行操作，通过 cur 来控制是否到达最右端、是否需要下移三个指针，通过 prev 来将 prev 的子节点连接起来：`prev.left.next = prev.right` 以及 `prev.right.next = cur.left`
    // 思路三：BFS。其实观察题目的要求，就会发现这其实就是层序遍历的一个绝佳案例。虽然题目要求使用常数空间，但我们也可以用这道题来练习 BFS 的技巧。
    //

    // Solution 1:
    // public Node connect(Node root) {
    //     if (root == null) return root;
    //     if (root.left != null) root.left.next = root.right;
    //     if (root.right != null) root.right.next = root.next == null? null : root.next.left;
    //     connect(root.left);
    //     connect(root.right);
    //     return root;
    // }



    // Solution 2:
    public Node connect(Node root) {
        if (root == null) return root;
        Node level = root;
        Node prev = root;
        Node cur = null;

        while (prev.left != null) {
            if (cur == null) {
                // prev.next = cur;
                prev.left.next = prev.right;
                prev = level.left;
                cur = level.right;
                level = level.left;
            } else {
                prev.left.next = prev.right;
                prev.right.next = cur.left;
                prev = cur;
                cur = cur.next;
            }
        }
        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
