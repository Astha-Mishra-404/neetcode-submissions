class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int totalSum = 0;

        int currentMax = 0;
        int maxSum = Integer.MIN_VALUE;

        int currentMin = 0;
        int minSum = Integer.MAX_VALUE;

        for (int num : nums) {

            // Kadane's Algorithm for Maximum Subarray
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            // Kadane's Algorithm for Minimum Subarray
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);

            totalSum += num;
        }

        // If all elements are negative,
        // totalSum - minSum would become 0,
        // which is not a valid non-empty subarray.
        if (maxSum < 0) {
            return maxSum;
        }

        // Maximum of:
        // 1. Normal maximum subarray
        // 2. Circular maximum subarray
        return Math.max(maxSum, totalSum - minSum);
    }
}