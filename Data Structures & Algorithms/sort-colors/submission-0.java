class Solution {
    public void sortColors(int[] nums) {
        int left = 0;                  // position for 0
        int right = nums.length - 1;  // position for 2
        int i = 0;

        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
                i++;
            } 
            else if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
            } 
            else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}