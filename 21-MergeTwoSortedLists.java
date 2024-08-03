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

// lists are sorted in ascending order

// 21

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list3 = new ListNode(0);
        ListNode head = list3;

        while(list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                list3.next = new ListNode(list2.val);
                list2 = list2.next;
            } else if (list1.val < list2.val) {
                list3.next = new ListNode(list1.val);
                list1 = list1.next;
            } else { // list1.val == list2.val
                list3.next = new ListNode(list1.val, new ListNode(list2.val)); // (int val, ListNode next) 
                list3 = list3.next; // since we are adding two nodes at a time,we have to make 1 jump here
                list1 = list1.next;
                list2 = list2.next;
            }
            list3 = list3.next;
        }

        while (list1 != null) {
            list3.next = new ListNode(list1.val);
            list1 = list1.next;
            list3 = list3.next;
        }

        while (list2 != null) {
            list3.next = new ListNode(list2.val);
            list2 = list2.next;
            list3 = list3.next;
        }

        return head.next;
    }
}

/*

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = list1 == null ? list2 : list1;
        return dummy.next;
    }
}

*/