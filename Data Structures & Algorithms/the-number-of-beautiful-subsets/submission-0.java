
class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        return backtrack(nums, k, 0, freq) - 1;
    }

    private int backtrack(int[] nums, int k, int index,
                          Map<Integer, Integer> freq) {

        // All elements processed
        if (index == nums.length) {
            return 1;
        }

        // Option 1: Skip current element
        int count = backtrack(nums, k, index + 1, freq);

        // Option 2: Include current element
        int num = nums[index];

        if (freq.getOrDefault(num - k, 0) == 0 &&
            freq.getOrDefault(num + k, 0) == 0) {

            freq.put(num, freq.getOrDefault(num, 0) + 1);

            count += backtrack(nums, k, index + 1, freq);

            // Backtrack: remove current element
            freq.put(num, freq.get(num) - 1);

            if (freq.get(num) == 0) {
                freq.remove(num);
            }
        }

        return count;
    }
}
