class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        
        // Base case: sum 0 appears once
        prefixSum.put(0, 1);

        int currSum = 0;
        int count = 0;

        for (int num : nums) {
            currSum += num;

            // Check if there exists a prefix sum such that:
            // currSum - prefix = k
            if (prefixSum.containsKey(currSum - k)) {
                count += prefixSum.get(currSum - k);
            }

            // Store current prefix sum
            prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}