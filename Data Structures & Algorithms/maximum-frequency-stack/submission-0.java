class FreqStack {
    // Maps element to its current frequency
    private Map<Integer, Integer> freq;
    // Maps a frequency to a stack of elements with that frequency
    private Map<Integer, Stack<Integer>> group;
    // Tracks the maximum frequency currently in the stack
    private int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        // Update the frequency of the element
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        
        // Update maxFreq if we found a new higher frequency
        if (f > maxFreq) {
            maxFreq = f;
        }
        
        // Add the element to the stack corresponding to its current frequency
        group.computeIfAbsent(f, k -> new Stack<>()).push(val);
    }
    
    public int pop() {
        // Get the top element from the stack of the maximum frequency
        int val = group.get(maxFreq).pop();
        
        // Decrement the frequency count of the popped element
        freq.put(val, freq.get(val) - 1);
        
        // If the stack for the max frequency becomes empty, reduce maxFreq
        if (group.get(maxFreq).isEmpty()) {
            maxFreq--;
        }
        
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */