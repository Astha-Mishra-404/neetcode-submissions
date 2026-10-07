class Solution {
    public String kthDistinct(String[] arr, int k) {

        // Count frequency of every string
        HashMap<String, Integer> freq = new HashMap<>();

        for (String s : arr) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }

        // Find the k-th string that appears exactly once
        for (String s : arr) {
            if (freq.get(s) == 1) {
                k--;

                if (k == 0) {
                    return s;
                }
            }
        }

        // Fewer than k distinct strings
        return "";
    }
}