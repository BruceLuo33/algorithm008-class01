//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {

        // 4.20 第一遍，5.7 第二遍
        // 思路：先找到第一个大于等于 x 的node，然后将 tail节点指向它
        // 然后不停的往后循环，遇到val 小于 x 的node，就将其移动到 tail 之前
        // 注意：一定要将 move 的初始位置设置在 sentinel。否则就会跳过对第一个元素的判断，从而造成错误。
        // 复杂度： O（N），空间复杂度：O（1）

        if (head == null || head.next == null) return head;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode subStart = head;
        ListNode move = sentinel;
        while (move != null && move.next != null) {
            if (move.next.val >= x) {
                subStart = move;
                move = move.next;
                break;
            } else {
                move = move.next;
            }
        }

        while (move != null && move.next != null) {
            if (move.next.val < x) {
                ListNode tmp = move.next;
                move.next = move.next.next;
                tmp.next = subStart.next;
                subStart.next = tmp;
                subStart = subStart.next;

            } else {
                move = move.next;
            }
        }
        return sentinel.next;


        









        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode tail = sentinel;
        // 将 head 指向 sentinel，防止只有一个node的时候，
        // while 判断中 head.next != null 报空指针的错误。
        head = sentinel;

        // 思路： 先找到第一个大于等于 x 的node，然后将 tail节点指向它
        // 然后不停的往后循环，遇到val 小于 x 的node，就将其删除，然后插入到tail后面
        // 复杂度： O（N），空间复杂度：O（1）
        while (head != null && head.next != null) {
            if (head.next.val >= x) {
                tail = head;
                head = head.next;
                break;
            } else {
                head = head.next;
            }
        }

        while (head != null && head.next != null) {
            // 节点小于x，则将其拿出，插入到tail后面
            if (head.next.val < x) {
                // 将要移动的node暂存在move中
                // 将head 指向下下个节点
                // 将暂时的move节点指向tail的下一个节点，
                // 则 tail.next 有两个指针指向它，一个是 tail，一个是move
                // 将tail 指向move。则插入操作完成
                // 最后，要记得移动tail节点
                ListNode move = head.next;
                head.next = head.next.next;
                move.next = tail.next;
                tail.next = move;
                tail = tail.next;
//                tail = move;
            } else {
                head = head.next;
            }
        }
        return sentinel.next;



    }
}
//leetcode submit region end(Prohibit modification and deletion)
