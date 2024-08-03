// 206

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

class ReverseLinkedList {
	
}
class Solution {
    public ListNode reverseList(ListNode head) {
        // basically , three pointers 
        // p = prev,n = next, c = current
        if(head == null)
            return head;
        ListNode c = null;
        ListNode p = null;
        c = head;
        while (c != null) {
            ListNode n = c.next;
            c.next = p;
            p = c;
            c = n; 
        }
        return p;
    }
}

/*
TLE
WRONG 

ListNode c = null;
        ListNode n = null;
        n = head;
        c = head;
        while (head.next != null) {
            c = head.next;
            if (c.next != null)
                n = c.next;
            c.next = head;
            head = head.next
        }
        return c;

*/

/*

ListNode *h=NULL, *p=NULL;
        while (head){
            p = head->next;
            head->next = h;
            h = head;
            head = p;
        }
        return h;
*/