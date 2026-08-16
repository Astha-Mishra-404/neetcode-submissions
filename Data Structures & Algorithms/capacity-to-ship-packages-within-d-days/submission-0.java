class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        
        // Find the boundary for binary search
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }
        
        // Binary search for the minimum capacity
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (canShip(weights, days, mid)) {
                high = mid; // Try to find a smaller feasible capacity
            } else {
                low = mid + 1; // Increase the capacity
            }
        }
        
        return low;
    }
    
    // Helper function to check if a capacity 'mid' can ship everything within 'days'
    private boolean canShip(int[] weights, int days, int capacity) {
        int requiredDays = 1;
        int currentWeight = 0;
        
        for (int weight : weights) {
            if (currentWeight + weight > capacity) {
                requiredDays++;
                currentWeight = weight; // Start a new day with the current package
                
                if (requiredDays > days) {
                    return false;
                }
            } else {
                currentWeight += weight;
            }
        }
        
        return true;
    }
}