
class Solution {
    public int minCapability(int[] nums, int k) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        // Find the search space
        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }

        // Binary search
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canRob(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canRob(int[] nums, int k, int capability) {
        int count = 0;
        int i = 0;

        while (i < nums.length) {
            if (nums[i] <= capability) {
                count++;
                i += 2; // Skip adjacent house
            } else {
                i++;
            }

            if (count >= k) {
                return true;
            }
        }

        return false;
    }
}

