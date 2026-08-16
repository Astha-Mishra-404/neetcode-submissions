class MedianFinder {

    // Max heap for the smaller half
    private PriorityQueue<Integer> small;
    // Min heap for the larger half
    private PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Step 1: always push into small first
        small.offer(num);

        // Step 2: move the largest from small to large
        large.offer(small.poll());

        // Step 3: balance sizes (small should have equal or 1 more element)
        if (large.size() > small.size()) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {

        // If even number of elements
        if (small.size() == large.size()) {
            return (small.peek() + large.peek()) / 2.0;
        }

        // If odd, small has one extra element
        return small.peek();
    }
}