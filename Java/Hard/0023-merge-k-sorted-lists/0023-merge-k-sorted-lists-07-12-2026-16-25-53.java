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
    public ListNode mergeKLists(ListNode[] lists) {
        // 最小堆，按节点val排序
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // 把所有链表的头节点加入堆
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while (!pq.isEmpty()) {
            // 取出最小节点
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            
            // 把这个节点的下一个加入堆
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        
        return dummy.next;
    }
}