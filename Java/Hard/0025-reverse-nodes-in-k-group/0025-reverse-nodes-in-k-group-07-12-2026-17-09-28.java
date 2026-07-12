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
        // 第一步：检查是否有k个节点
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }
        
        // 不足k个，直接返回
        if (count < k) return head;
        
        // 第二步：反转k个节点
        ListNode prev = null;
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        
        // 第三步：递归处理剩余，接到当前组尾部
        // head现在是反转后的尾节点
        // node是下一组的头节点
        head.next = reverseKGroup(node, k);
        
        // prev是反转后的头节点
        return prev;
    }
}