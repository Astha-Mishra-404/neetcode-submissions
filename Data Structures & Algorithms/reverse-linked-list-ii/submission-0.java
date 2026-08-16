/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Base case: if no reversal is needed or list is empty
        if (head == null || left == right) {
            return head;
        }
        
        // Create a dummy node to ease handling of edge cases (e.g., when left = 1)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // 1. Move prev pointer to the node right before the sublist starts
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        
        // 2. Set curr to the first node of the sublist to be reversed
        ListNode curr = prev.next;
        
        // 3. Reverse the sublist using the 'then' pointer shifting mechanism
        for (int i = 0; i < right - left; i++) {
            ListNode then = curr.next;
            curr.next = then.next;
            then.next = prev.next;
            prev.next = then;
        }
        
        return dummy.next;
    }
}