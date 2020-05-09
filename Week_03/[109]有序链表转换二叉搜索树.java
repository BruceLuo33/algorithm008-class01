//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 深度优先搜索 链表


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    // 4.30 第一遍，5.5 第二遍
    // 分析：这道题和 108 题非常相似，区别在于链表不支持随机访问，所以获取根节点的坐标会相对困难。在此我们可以提出三种解法思路。
    // 思路一：既然链表无法随机访问，我改成一个可以随机访问的不就行了吗？于是可以新建一个 `ArrayList<Integer>` 用来接收给定
    // List 中的元素，其他的步骤和 108 题一模一样，时间/空间复杂度为 O（N）
    // 注意：对于线性表 ArrayList，随机访问的方式为 `listValue.get(mid)`，mid 为中间位置的 index
    // 思路二：如果不设立数组，我们怎么找链表的中点？双指针。双指针有前后指针和快慢指针，在这里我们才用快慢指针来找到中点，然后其余步骤与 108 题一样。
    // 但是这个方法的问题在于，由于我们并没有改变数据结构，所以每次递归都需要重新跑一边快慢指针。所以最终复杂度反而会升高，变成了O（NlogN），空间复杂度O（logN）
    // 思路三：参考了答案，得到了一种最佳的解法。这种做法是模仿中序遍历。在中序遍历中，我们采用的方式是将一个二叉树按顺序赋值给一个数组，在这里，我们可以采用相似的办法，但是不同的点在于这一次是利用中序遍历赋值给二叉树。
    // 注意：要设置一个全局变量的指针指向head，设置全局变量的原因是递归加入指针的参数会很麻烦
    // 注意：在遍历右子树之后，cur不再需要后移，


    // // Solution 3 codes：
    // ListNode curNode = null;
    // public TreeNode sortedListToBST(ListNode head) {
    //     int end = 0;
    //     curNode = head;
    //     while (head != null) {
    //         end += 1;
    //         head = head.next;
    //     }
    //     return helperThree(0, end);
    // }

    // private TreeNode helperThree(int start, int end) {
    //     if (start == end) return null;
    //     int mid = (int) (start + end) / 2;

    //     // 遍历左子树，找到左子根节点，此时 start == null，会返回 null
    //     TreeNode left = helperThree(start, mid);
    //     TreeNode root = new TreeNode(curNode.val);
    //     root.left = left;

    //     curNode = curNode.next;
    //     // 遍历右子树，找到右子根节点，此时 start == null，会返回 null
    //     TreeNode right = helperThree(mid + 1, end);
    //     root.right = right;

    //     return root;
    // }



    // // Solution 1 codes：
    // public TreeNode sortedListToBST(ListNode head) {
    //     ArrayList<Integer> listValue = new ArrayList<>();
    //     while (head != null) {
    //         listValue.add(head.val);
    //         head = head.next;
    //     }
    //     return helper(listValue, 0, listValue.size());
    // }

    // private TreeNode helper(ArrayList<Integer> listValue, int start, int end) {
    //     if (start == end) return null;
    //     int mid = (int) (start + end) / 2;
    //     TreeNode root = new TreeNode(listValue.get(mid));
    //     root.left = helper(listValue, start, mid);
    //     root.right = helper(listValue, mid + 1, end);
    //     return root;
    // }




    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> restore = new ArrayList<>();
        int count = 0;
        while (head != null) {
            restore.add(head.val);
            count += 1;
            head = head.next;
        }
        return helper(restore, 0, count);
    }

    private TreeNode helper(ArrayList<Integer> restore, int start, int end) {
        if (start == end) return null;
        int mid = (int) (start + end) / 2;
        int rootVal = restore.get(mid);
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(restore, start, mid);
        root.right = helper(restore, mid + 1, end);
        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
