/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node cur = head;
        Node dummy = new Node(0);
        Node curDummy = dummy;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            
            curDummy.next = newNode; 
            map.put(cur, newNode);
            
            curDummy = curDummy.next;
            cur = cur.next;
        }

        cur = head;
        curDummy = dummy.next;

        while (curDummy != null && cur!= null) {
            if ( cur.random == null){
                curDummy.random = null;    
            } else {
                curDummy.random = map.get(cur.random);  

            }
            
            curDummy = curDummy.next;
            
            cur = cur.next;
        }

        return dummy.next;
    }
}
