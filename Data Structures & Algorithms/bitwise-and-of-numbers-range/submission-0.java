class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        
        // Keep shifting until left and right match (common prefix)
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        
        // Pad with zeros to restore original scale
        return left << shift;
    }
}