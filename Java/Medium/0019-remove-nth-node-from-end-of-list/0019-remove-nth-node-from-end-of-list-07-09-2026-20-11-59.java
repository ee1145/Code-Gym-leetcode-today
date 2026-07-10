class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        // fast先走n+1步
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        
        // 同步走，直到fast==null
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // 删除slow的下一个节点
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}