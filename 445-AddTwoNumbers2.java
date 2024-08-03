// 445

// The most significant digit comes first
// add both of them normally

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
    ListNode reverseList(ListNode l) {
        // three pointers
        // p = previous, n = next, c = current
        ListNode c = l;
        ListNode p = null;
        while (c != null) { // will exit when c == null
            ListNode n = c.next; // n = c.next
            c.next = p; // reversed the link between p and c, c.next now points to p
            p = c;
            c = n;
        }
        return p; // c points to null and p is the head of the new list and tail of the original list
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode p = l3;
        l1 = this.reverseList(l1);
        l2 = this.reverseList(l2);
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 == null) ? 0: l1.val;
            int y = (l2 == null) ? 0: l2.val;
            int sum = carry + x + y;
            l3.next = new ListNode(sum % 10);
            carry = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            l3 = l3.next;
        }
        if (carry > 0)
            l3.next = new ListNode(carry);
        return this.reverseList(p.next); 
    }
}