class MyCircularQueue {
    private int[] queue;
    private int head;
    private int count;
    private int capacity;

    // Initializes the object with the size of the queue to be k.
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
        this.head = 0;
        this.count = 0;
    }
    
    // Inserts an element into the circular queue. Return true if the operation is successful.
    public boolean enQueue(int value) {
        if (this.isFull()) {
            return false;
        }
        // Calculate the next available insertion index
        int tail = (this.head + this.count) % this.capacity;
        this.queue[tail] = value;
        this.count++;
        return true;
    }
    
    // Deletes an element from the circular queue. Return true if the operation is successful.
    public boolean deQueue() {
        if (this.isEmpty()) {
            return false;
        }
        // Move the head forward circularly
        this.head = (this.head + 1) % this.capacity;
        this.count--;
        return true;
    }
    
    // Gets the front item from the queue. If the queue is empty, return -1.
    public int Front() {
        if (this.isEmpty()) {
            return -1;
        }
        return this.queue[this.head];
    }
    
    // Gets the last item from the queue. If the queue is empty, return -1.
    public int Rear() {
        if (this.isEmpty()) {
            return -1;
        }
        int tail = (this.head + this.count - 1) % this.capacity;
        return this.queue[tail];
    }
    
    // Checks whether the circular queue is empty or not.
    public boolean isEmpty() {
        return this.count == 0;
    }
    
    // Checks whether the circular queue is full or not.
    public boolean isFull() {
        return this.count == this.capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */