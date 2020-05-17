//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 说明：不允许修改给定的链表。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：tail connects to node index 1
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：tail connects to node index 0
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：no cycle
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//你是否可以不用额外空间解决此题？ 
// Related Topics 链表 双指针


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/**
 4.16 第一遍，5.17 第二遍
 思路：指针。这道题要和上一个环形链表的题目一起来看：
 1. 先利用找环形链表的技巧，设置两个指针：fast 与 slow，循环至二者相遇，否则返回 null；
 2. 设置一个 chase Node，从起点 head 出发，每次步进一个 node，同时从 fast/slow 节点出发，步进一；
 3. 当 chase 与 fast 相遇，即为环的入口。

 解题的时候发现几个很有意思的点：
 - fast 节点的初始化需要是 fast = head，而非 head.next，否则就会超出时间限制
 - 寻找 fast 和 slow 节点相遇的 while 循环，有两种做法，第一种是 while（true），然后当 fast == slow 的时候 break；第二种是常规的 while（fast !=null），然后 if（fast == slow）的时候再去调用下一个while
 - 在上述第二种 while 循环中，如果选择破坏结构，即 head=head.next，则时间为 0ms，而如果不破坏，选择一个指针指向 head，即 chase = head, 则时间为 1ms。前者超过100%，后者超过57%。非常奇怪的现象。

 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode meet = null;
        while (fast != null) {
            if (fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            //到达相遇点
            if (fast == slow) {
                meet = fast;
                while (head != meet) {
                    head = head.next;
                    meet = meet.next;
                }
                return head;
            }
        }
        return null;
    }
}




public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode meet = null;
        ListNode chase = null;
//        while (fast != null) {
//            if (fast.next == null) return null;
//            slow = slow.next;
//            fast = fast.next.next;
//            if (fast == slow) {
//                break;
//            }
//        }
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        meet = fast;
        chase = head;
        while (meet != chase) {
            meet = meet.next;
            chase = chase.next;
        }
        return chase;

//        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
