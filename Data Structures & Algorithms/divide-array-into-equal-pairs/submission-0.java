class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int freq : count.values()) {
            if (freq % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}