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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = new ListNode(); 
        dummy = cur;
        int carry = 0;
        int remaining = 0;
        while (l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            remaining = sum % 10;

            cur.next = new ListNode(remaining);

            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;

        } 

        while (l1 != null){
            int sum = l1.val + carry;
            carry = sum / 10;
            remaining = sum % 10;
            
            cur.next = new ListNode(remaining);

            
            l1 = l1.next;
            cur = cur.next;

        }
        
        while (l2 != null){
            int sum = l2.val + carry;
            carry = sum / 10;
            remaining = sum % 10;
            
            cur.next = new ListNode(remaining);
            
            l2 = l2.next;
            cur = cur.next;

        }

        if (carry > 0){
            cur.next = new ListNode(carry);
            cur = cur.next;

        }

        return dummy.next;
    }
}
