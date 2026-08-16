
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        // Add current subset (important!)
        result.add(new ArrayList<>(current));
        
        for (int i = start; i < nums.length; i++) {
            // Choose
            current.add(nums[i]);
            
            // Explore
            backtrack(nums, i + 1, current, result);
            
            // Un-choose (backtrack)
            current.remove(current.size() - 1);
        }
    }
}