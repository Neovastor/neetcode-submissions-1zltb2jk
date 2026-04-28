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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int i = 1;
        ListNode group1 = head; 
        ListNode group2 = head;
        ListNode curHead = head;
        ListNode curTail = null;
        List<ListNode> list = new ArrayList<>();
        
        while(cur != null){

            if (i % k == 0){
                curTail = cur;
                ListNode originalHead = curHead;
                list.add(curTail);// newHead
                list.add(curHead);// newTail
                
                curHead = cur.next;
                curTail.next = null;

                //reverse process
                reverse(originalHead);        
                cur = curHead;
            } else {
                cur = cur.next;
            }
            i++;            
        }



        for (int j = 0; j < list.size() - 1; j++){
            

            if (j % 2 == 1){
                list.get(j).next = list.get(j+1);
            }
        }
        
        if (curHead != null){
            list.get(list.size() - 1).next = curHead;

        }

        return list.get(0);
    }

    

    private ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode cur = node;
        ListNode next = node;
        while (next != null){            
            next = cur.next;
            cur.next = prev;
            
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
