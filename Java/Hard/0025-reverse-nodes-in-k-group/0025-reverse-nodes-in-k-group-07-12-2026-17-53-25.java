/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //check if we have K node or not:
        int count = 0;
        ListNode curr = head;
        while (curr != null && count < k) {
            count++;
            curr = curr.next;
        }

        if (count < k) {
            return head;
        }

        //反转
        ListNode prev = null;
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        head.next = reverseKGroup(node, k);

        return prev;
    }
}