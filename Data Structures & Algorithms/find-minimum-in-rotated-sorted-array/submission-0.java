class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[r]) {
                // minimum is in the right half
                l = mid + 1;
            } else {
                // minimum is at mid or in the left half
                r = mid;
            }
        }

        return nums[l];
    }
}
