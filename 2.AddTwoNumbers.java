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

// 

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode l4 = l3;
        int carry = 0;

        // get out of loop when
        // l1 == null && l2 == null && carry == 0
        // carry should not be left over
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;
            int sum = carry + x + y;

            //suppose sum is two digit like 18
            // 8 should be taken 
            // 1 should be carried over
            l3.next = new ListNode(sum % 10);
            carry = sum / 10;
            l3 = l3.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        return l4.next;

        /*
        Explanation
        lets say 999 and 999
        l4,l3 point to same node which contains

       l3 = l4 = (0,->) carry = 0
        now l3 = (8,->) sum = carry + 9 + 9 = 0 + 9 + 9 = 18
        now l3 = (9,->) sum = carry + 9 + 9 = 1 + 9 + 9 = 19
        now l3 = (9,->) sum = carry + 9 + 9 = 1 + 9 + 9 = 19
        now l3 = (1,->) sum = carry + 0 + 0 = 1 + 0 + 0 = 19
        
        l3 = l3.next

        now we are returning l4.next, that is
        (8,->)
        (9,->)
        (9,->)
        (1,->) null
        */
    }
}



// mine-time limit exceeded 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int a,b;
        a = b = 0;
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(0,l3);

        // getting the number in same order 
        // as stored in ListNode
        // and yes it may have some zeroes at the end 

        // get out of loop only when l1 == null AND l2 = null 
        while (l1 != null || l2 != null) {
            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;
            a = a * 10 + x; 
            b = b * 10 + y;
            if (l1.next != null) {
                l1.next = l1;
            }
            if (l2.next != null) {
                l2.next = l2;
            }
        }

        // reversing the numbers 
        int t1 = a;
        int t2 = b;
        a = 0;
        b = 0;
        while (t1 > 0) { // if t1 == 0 , stop as having 0 in starting means nothing
             a = a*10 + (t1 % 10);
             t1 /= 10;
        } 
        while (t2 > 0) { // if t2 == 0 , stop as having 0 in starting means nothing
             b = b*10 + (t2 % 10);
             t2 /= 10;
        }

        // the sum
        int c = a+b;
        int t3 = c;
        int digits = 0;
        // count digits
        while (t3 > 0) {
            digits++;
            t3 /= 10;
        }

        // now putting the sum in ListNode
        for (int i = 0; i < digits; i++) {
            l3.next = new ListNode(c % 10);
        }
        return l4.next;
    }
}




// official leetcode
class Solution {
    // Add Two Numbers (Java improved)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummyHead.next;
    }
}