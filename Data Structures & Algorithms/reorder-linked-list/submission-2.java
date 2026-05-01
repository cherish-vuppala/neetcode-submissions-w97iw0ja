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
    public void reorderList(ListNode head) {


        if (head == null || head.next == null)
            return ;

        ListNode fast = head;
        ListNode slow = head;
        ListNode prevSlow = null;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        // find mid
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prevSlow = slow;
            slow = slow.next;
        }

       
        prevSlow.next = null;
        ListNode l2 = reverse(slow);

        while (head != null && l2 != null) {
            tail.next = head;
            ListNode temp = head.next;

            tail.next.next = l2;

            l2 = l2.next;
            head = temp;

            if (tail != null && tail.next != null)
                tail = tail.next.next;
        }

        head = dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }
}
