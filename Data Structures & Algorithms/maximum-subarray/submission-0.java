
class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize max_sum with the first element to handle arrays of size 1
        // and arrays with only negative numbers.
        int max_sum = nums[0];
        int current_sum = 0;

        for (int n : nums) {
            // If the current running sum is negative, it's a drag on the total.
            // Reset it to 0 before adding the current element.
            if (current_sum < 0) {
                current_sum = 0;
            }
            
            current_sum += n;
            
            // Update the global maximum if the current sum is better
            max_sum = Math.max(max_sum, current_sum);
        }

        return max_sum;
    }
}
