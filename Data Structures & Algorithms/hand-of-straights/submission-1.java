class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        // Step 1: Count frequencies
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : hand) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min heap to always pick smallest card
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(count.keySet());

        // Step 3: Form groups
        while (!minHeap.isEmpty()) {
            int start = minHeap.peek();

            // Try to build group of size groupSize
            for (int i = 0; i < groupSize; i++) {
                int card = start + i;

                if (!count.containsKey(card)) return false;

                count.put(card, count.get(card) - 1);

                if (count.get(card) == 0) {
                    if (card != minHeap.peek()) return false;
                    minHeap.poll();
                }
            }
        }

        return true;
    }
}
