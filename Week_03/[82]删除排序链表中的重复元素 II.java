//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表


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
    public ListNode deleteDuplicates(ListNode head) {

        // 4.20 第一遍，5.7 第二遍
        // 思路：双指针。第一个指针指向没有重复的上一个节点，第二个指针用来移动判断
        // 如果第二个指针的值和第三个（second.next）相等，则加一个while循环，一直到不相等的node，
        // 注意：first 移动有两种情况：
        // 1、second 和 second.next 不相等，则 first 和 second 同时后移一位
        // 2、second 和 second.next 相等，first 指向 second.next.next
        // 基于以上判断，新建一个布尔变量 isEqual 来判断是二者中的哪个情况
        // 注意：second 指针的移动要放在else之后，以保证无论如何，第二个指针都会移动
        // 或者在 if 和 else 语句中都加入 second = second.next，以保证second指针的移动
        // 注意：移动 second 判断是否有连续相等 node 的时候，要先判断 second.next 不为空，即：
        // `while (second.next != null && second.val == second.next.val ) `
        // 举例来说，当提供数组是 [1,1] 的时候，如果 second 移动到了第二个 1，这时候如果先判断 `second.val == second.next.val`
        // 因为 second.next 是 null，所以就不存在 value，就会出现空指针错误。而先判断 second.next 是否为空就可以避免这个情况
        // 复杂度分析：O（N）

        if (head == null || head.next == null) return head;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode first = sentinel;
        ListNode second = head;
        boolean isEqual = false;

        while (second != null && second.next != null) {
            while (second.next != null && second.val == second.next.val ) {
                second = second.next;
                isEqual = true;
            }
            if (isEqual) {
                first.next = second.next;
                second = second.next;
                isEqual = false;
            } else {
                first = first.next;
                second = second.next;
            }
        }
        return sentinel.next;













        // 思路：双指针。第一个指针指向没有重复的上一个节点，第二个指针用来移动判断
        // 如果第二个指针的值和第三个（second.next）相等，则加一个while循环，一直到不相等的node，

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode first = sentinel;
        ListNode second = head;
        while(second != null && second.next != null) {
            // first 移动有两种情况：
            // 1、second 和 second.next 不相等，则 first 和 second 同时后移一位
            // 2、second 和 second.next 相等，first 指向 second.next.next
            // 基于以上判断，新建一个布尔变量 isequal 来判断是二者中的哪个情况

            boolean isEqual = false;
            while (second.next != null && second.val == second.next.val) {
                isEqual = true;
                second = second.next;
            }
            if (isEqual) {
                first.next = second.next;
                second = second.next;
                isEqual = false;
            } else {
//                first = second;
                first = first.next;
                second = second.next;
            }
            // second 指针的移动要放在else之后，以保证无论如何，第二个指针都会移动
            // 或者在 if 和 else 语句中都加入 second = second.next，以保证second指针的移动
//            second = second.next;
        }
        return sentinel.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
