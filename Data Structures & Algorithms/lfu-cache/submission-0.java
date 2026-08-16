class LFUCache {
    
    // Node structure for the Doubly Linked List
    class Node {
        int key, value, frequency;
        Node prev, next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1; // Initial frequency is always 1
        }
    }
    
    // Doubly Linked List to maintain LRU order for a specific frequency
    class DoublyLinkedList {
        Node head, tail;
        int size;
        
        DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        
        // Add node to the front (Most Recently Used for this frequency)
        void addNode(Node node) {
            Node nextNode = head.next;
            head.next = node;
            node.prev = head;
            node.next = nextNode;
            nextNode.prev = node;
            size++;
        }
        
        // Remove an arbitrary node from the list
        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        
        // Remove and return the last node (Least Recently Used for this frequency)
        Node removeTail() {
            if (size == 0) return null;
            Node res = tail.prev;
            removeNode(res);
            return res;
        }
    }

    private final int capacity;
    private int curSize;
    private int minFrequency;
    private final Map<Integer, Node> cache;
    private final Map<Integer, DoublyLinkedList> frequencyMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        updateFrequency(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        
        // If key already exists, update value and its frequency
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            updateFrequency(node);
            return;
        }
        
        // If cache is full, evict the LFU (and LRU if tie) element
        if (curSize == capacity) {
            DoublyLinkedList minFreqList = frequencyMap.get(minFrequency);
            Node deleteNode = minFreqList.removeTail();
            cache.remove(deleteNode.key);
            curSize--;
        }
        
        // Insert new node
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        
        // New node always starts with frequency 1
        minFrequency = 1;
        DoublyLinkedList list = frequencyMap.computeIfAbsent(1, k -> new DoublyLinkedList());
        list.addNode(newNode);
        curSize++;
    }
    
    // Helper method to increment frequency and shift node to the correct list
    private void updateFrequency(Node node) {
        int oldFreq = node.frequency;
        DoublyLinkedList oldList = frequencyMap.get(oldFreq);
        oldList.removeNode(node);
        
        // If the current minFrequency list becomes empty, increment minFrequency
        if (oldFreq == minFrequency && oldList.size == 0) {
            minFrequency++;
        }
        
        node.frequency++;
        DoublyLinkedList newList = frequencyMap.computeIfAbsent(node.frequency, k -> new DoublyLinkedList());
        newList.addNode(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */