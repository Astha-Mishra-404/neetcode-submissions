class Solution {
    public boolean hasDuplicate(int[] nums) {
        // Create a hash set to store the unique numbers we encounter
        HashSet<Integer> seen = new HashSet<>();
        
        for (int num : nums) {
            // If the number is already in the set, a duplicate exists
            if (seen.contains(num)) {
                return true;
            }
            // Otherwise, add the number to the set
            seen.add(num);
        }
        
        // No duplicates found after scanning the whole array
        return false;
    }
}