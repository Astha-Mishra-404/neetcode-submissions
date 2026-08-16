class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % k != 0) return false;

        int target = sum / k;

        Arrays.sort(nums);

        // Largest element cannot fit
        if (nums[nums.length - 1] > target) return false;

        boolean[] used = new boolean[nums.length];
        return backtrack(nums, used, k, 0, 0, target);
    }

    private boolean backtrack(int[] nums, boolean[] used,
                              int k, int start,
                              int currSum, int target) {

        // Successfully formed k - 1 subsets.
        // Remaining numbers automatically form the last subset.
        if (k == 1) return true;

        // Current subset complete.
        if (currSum == target) {
            return backtrack(nums, used, k - 1, 0, 0, target);
        }

        for (int i = start; i < nums.length; i++) {
            if (used[i]) continue;

            if (currSum + nums[i] > target) continue;

            used[i] = true;

            if (backtrack(nums, used, k, i + 1, currSum + nums[i], target))
                return true;

            used[i] = false;

            // Pruning
            if (currSum == 0) return false;

            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return false;
    }
}