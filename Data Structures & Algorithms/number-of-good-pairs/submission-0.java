class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int pairs = 0;

        for (int num : nums) {
            int count = freq.getOrDefault(num, 0);

            // Current number forms 'count' new pairs
            pairs += count;

            // Update frequency
            freq.put(num, count + 1);
        }

        return pairs;
    }
}