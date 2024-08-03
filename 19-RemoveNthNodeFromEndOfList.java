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

// this may throw NullPointerExpression
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode left = dummy;
        ListNode right = head;

        while(n > 0 && right) { // right != null
            right = right.next;
            n--;
        }

        while(right) {
            if (left.next != null) {
               left = left.next; 
            }
            right = right.next;
        }

        ListNode l2 = left.next;
        left.next = l2.next;

        return dummy.next;
    }
}



/*
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode prev = head;
        //Base Case
        if(head == null || head.next == null) {
            return null;
        }

        // Reaching P2 to nth Node if exists
        for(int i=0;i<n;i++) {
            if(p2 == null) {
                return null;
            }
            p2 = p2.next;
        }

       // If p2 is already null, then remove the fist node
        if(p2 == null) {
            head = head.next;
            return head;
        }

        //Else we move p1 to nth node and take its prev pointer
        while(p2 != null) {
            p2 = p2.next;
            prev = p1;
            p1 = p1.next;
        }

        //Remove p1 node
        prev.next = p1.next;
        return head;
    }
}

*/

/*

tc wise

class Solution {
    // 无论遍历一次链表和遍历两次链表的时间复杂度都是 O(N)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode x = findFromEnd(dummy, n + 1);
        x.next = x.next.next;
        // 考虑head被删掉的情况
        return dummy.next;
    }

    private ListNode findFromEnd(ListNode head, int k) {
        // 倒数第 k 个节点就是正数第 n - k + 1 个节点
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }   

        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}


sc wise

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        int len = 0;
        ListNode temp = head;

        while(temp != null) {
            len ++;
            temp = temp.next;
        }

        //this means need to delete the starting node
        if(len == n) { //n is from back
            return head.next;
        }

        int prevIndx = len - n;
        temp = head;
        
        while(temp != null) {
            prevIndx --;
            if(prevIndx == 0) {
                break;
            }
            temp = temp.next;
        }

        ListNode deleteNode = temp.next;
        temp.next = deleteNode.next;

        return head;
    }
}

*/