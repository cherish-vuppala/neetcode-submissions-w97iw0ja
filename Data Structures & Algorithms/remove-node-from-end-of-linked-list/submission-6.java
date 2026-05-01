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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || (head.next == null && n == 1))
            return null;
        
        int size = 0;
        ListNode curr = head;

        while (curr != null) {
            size++;
            curr = curr.next;
        }

        int target = size - n;
        int count = 1;
        curr = head;

        if (target == 0)
            return head.next;

        while (count <= target-1 && curr != null) {
            count++;
            curr = curr.next;
        }

        if (curr != null)
            curr.next = curr.next.next;
        
        return head;
    }
}
