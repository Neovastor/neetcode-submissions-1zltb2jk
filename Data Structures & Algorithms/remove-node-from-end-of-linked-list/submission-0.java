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
        int total = 0;
        ListNode cur = head;
        while (cur != null){
            total++;
            cur = cur.next;
        }

        int target = total - n;
        int i = 0;
        cur = head;
        ListNode prev = new ListNode(); 
        while (cur != null && i <= target){
            if (i == target){
                
                prev.next = cur.next;
                if(target == 0){
                    head = prev.next; 
                }
                break;
            }
            prev = cur;
            cur = cur.next;
            i++;
        }
        return head;
    }
}
