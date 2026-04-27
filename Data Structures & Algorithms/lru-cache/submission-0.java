class LRUCache {
    Node head;
    Node tail;
    int cap;
    Map<Integer, Node> map;

    public void add(Node newNode) {
        Node headPrev = head.prev;
        headPrev.next = newNode;
        head.prev = newNode;
        newNode.next = head;
        newNode.prev = headPrev;
    }

    public Node removeLast() {
        Node cur = tail.next;

        Node nextCur = cur.next;

        this.tail.next = nextCur;
        nextCur.prev = this.tail;
        cur.next = null;
        cur.prev = null;
        
        return cur;
    }

    public void moveToHead(Node cur) {
        Node beforeCur = cur.prev;
        Node nextCur = cur.next;

        beforeCur.next = cur.next;
        nextCur.prev = cur.prev;

        cur.next = null;
        cur.prev = null;

        Node headPrev = this.head.prev;

        headPrev.next = cur;
        this.head.prev = cur;
        cur.next = this.head;
        cur.prev = headPrev;
    }

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-2, -2);
        tail.next = head;
        head.prev = tail;
    }

    public int get(int key) {

        if (map.containsKey(key)) {
            // move key to ahead
            Node cur = map.get(key);
            moveToHead(cur);
            return cur.value;
        }

        return -1;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node curNode = map.get(key);
            curNode.value = value;
            moveToHead(curNode);
        } else {

            Node newNode = new Node(key, value);
            add(newNode);

            map.put(key, newNode);
        }

        if (map.size() > this.cap) {

            Node removedNode = this.removeLast();

            map.remove(removedNode.key);
        }
    }
}

class Node {
    public int value;
    public int key;
    public Node next;
    public Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public Node() {
    }
}
