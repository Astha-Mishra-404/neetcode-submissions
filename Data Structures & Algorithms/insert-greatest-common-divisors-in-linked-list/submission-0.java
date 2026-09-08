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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            // Find GCD of current node and next node
            int gcdValue = gcd(curr.val, curr.next.val);

            // Create a new node containing the GCD
            ListNode gcdNode = new ListNode(gcdValue);

            // Insert the new node between curr and curr.next
            gcdNode.next = curr.next;
            curr.next = gcdNode;

            // Move to the original next node
            curr = gcdNode.next;
        }

        return head;
    }

    // Euclidean Algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}