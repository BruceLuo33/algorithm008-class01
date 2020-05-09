//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
//


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
    public int[] reversePrint(ListNode head) {
        // 4.29 第一遍
        // 思路：很简单的一道题。两个循环，第一个遍历链表，得到数组的大小。
        // 第二个反向将链表的值放入数组。
        // 注意：要设置额外的指针来指向链表，因为不能改动原来的 head 链表。
        // 复杂度分析：O（N），空间复杂度：O（N）
        ListNode move = head;
        int count = 0;
        while (move != null) {
            count += 1;
            move = move.next;
        }
        int[] ans = new int[count];
        move = head;
        for (int i = count - 1; i >= 0; i--) {
            ans[i] = move.val;
            move = move.next;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
