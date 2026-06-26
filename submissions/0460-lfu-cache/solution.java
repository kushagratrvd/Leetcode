class LFUCache {
    class Node{
        int key;
        int val;
        int freq;
        int rec;
        Node prev;
        Node next;
        
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            freq = 1;
            prev = null;
            next = null;
        }
    }
        Comparator<Node> taskComparator = (t1, t2) -> {
            if (t1.freq != t2.freq) {
                return Integer.compare(t1.freq, t2.freq); 
            }
            return Integer.compare(t1.rec, t2.rec); 
        };
        PriorityQueue<Node> pq = new PriorityQueue<>(taskComparator);
        HashMap<Integer, Node> map = new HashMap<>();
        Node head = new Node(-1, -1);
        Node tail = new Node(-1, -1);
        int limit;
        int recent = 1;

        /*public void addNode(Node newNode){
            Node oldNode = head.next;
            head.next = newNode;
            newNode.prev = head;
            oldNode.prev = newNode;
        }

        public void deleteNode(Node oldNode){
            Node prevNode = oldNode.prev;
            Node nextNode = oldNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }*/
     
    public LFUCache(int capacity) {
        limit = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        //deleteNode(node);
        map.remove(key);
        pq.remove(node);
        node.freq++;
        recent++;
        node.rec = recent;
        //addNode(node);
        map.put(key, node);
        pq.add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            //deleteNode(node);
            map.remove(key);
            pq.remove(node);
            node.freq++;
            recent++;
            node.rec = recent;
            node.val = value;
            //addNode(node);
            map.put(key, node);
            pq.add(node);
        }
        else{
            if(limit == map.size()){
                Node node = pq.poll();
                //deleteNode(node);
                map.remove(node.key);
                //pq.remove(node);
            }
            Node newNode = new Node(key, value);
            //addNode(newNode);
            newNode.rec = ++recent;
            map.put(key, newNode);
            pq.add(newNode); 
        } 

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
