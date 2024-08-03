// 876

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
    public ListNode middleNode(ListNode head) {
        int mid = 0;
        int count = 0;
        ListNode t = head;
        while (t.next != null) {
            count++;
            t = t.next;
        }
        if (count % 2 == 0)
            mid = count/2;
        else
            mid = (count+1)/2;
        t = head;
        for (int i = 0; i < mid; i++) {
            t = t.next;
        }
        return t;
    }
}

// tc = o(n+mid) = o(1.5n)
// sc = o(1)