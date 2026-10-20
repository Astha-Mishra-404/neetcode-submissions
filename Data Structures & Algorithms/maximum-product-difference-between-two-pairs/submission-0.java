class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // (largest1 * largest2) - (smallest1 * smallest2)
        return (nums[n - 1] * nums[n - 2]) - (nums[0] * nums[1]);
    }
}