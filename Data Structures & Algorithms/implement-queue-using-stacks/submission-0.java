class MyQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    // Pushes element x to the back of the queue.
    public void push(int x) {
        s1.push(x);
    }
    
    // Removes the element from the front of the queue and returns it.
    public int pop() {
        shiftStacks();
        return s2.pop();
    }
    
    // Returns the element at the front of the queue.
    public int peek() {
        shiftStacks();
        return s2.peek();
    }
    
    // Returns true if the queue is empty, false otherwise.
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    // Helper method to move elements from s1 to s2 when s2 is empty
    private void shiftStacks() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }
}