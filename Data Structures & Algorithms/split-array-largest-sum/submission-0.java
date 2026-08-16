class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }
        
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canSplit(nums, k, mid)) {
                ans = mid;
                high = mid - 1; // Try to look for a smaller minimized max sum
            } else {
                low = mid + 1;  // Increase the allowed maximum sum
            }
        }
        
        return ans;
    }
    
    private boolean canSplit(int[] nums, int k, int maxSubarraySum) {
        int subarrayCount = 1;
        int currentSum = 0;
        
        for (int num : nums) {
            if (currentSum + num > maxSubarraySum) {
                // Start a new subarray
                subarrayCount++;
                currentSum = num;
                
                // If we need more than k subarrays, this maxSubarraySum is too small
                if (subarrayCount > k) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }
        
        return true;
    }
}