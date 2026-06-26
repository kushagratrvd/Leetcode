
class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }

        Node head = new Node(-1, -1);
        Node tail = new Node(-1, -1);
        HashMap<Integer, Node> map = new HashMap<>();
        int limit;

        public void addNode(Node newNode){
            Node oldNode = head.next;
            head.next = newNode;
            newNode.next = oldNode;
            newNode.prev = head;
            oldNode.prev = newNode;
        }

        public void deleteNode(Node deleteN){
            Node prevNode = deleteN.prev;
            Node nextNode = deleteN.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

    public LRUCache(int capacity) {
        limit = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node value = map.get(key);
        deleteNode(value);
        addNode(value);
        return value.val;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            deleteNode(map.get(key));
            map.remove(key);
        }
        if(map.size() == limit){
            Node lastNode = tail.prev;
            deleteNode(lastNode);
            map.remove(lastNode.key);
        }
        Node newNode = new Node(key, value);
        addNode(newNode);
        map.put(key, newNode);

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
