class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        
        // Step 1: Count frequencies of each number
        for (int n : arr) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        
        int res = -1;
        
        // Step 2: Find the largest lucky integer
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            
            if (num == freq) {
                res = Math.max(res, num);
            }
        }
        
        return res;
    }
}