
class Solution {
    public int[] frequencySort(int[] nums) {

        // Step 1: Count frequency of each number
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert int[] to Integer[]
        Integer[] arr = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        // Step 3: Sort using custom comparator
        Arrays.sort(arr, (a, b) -> {

            // Increasing frequency
            if (!freq.get(a).equals(freq.get(b))) {
                return Integer.compare(freq.get(a), freq.get(b));
            }

            // If frequency is same, decreasing value
            return Integer.compare(b, a);
        });

        // Step 4: Convert back to int[]
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

        return nums;
    }
}

