/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        
        // Step 1: Find the peak element index
        int peak = findPeak(mountainArr, n);
        
        // Step 2: Binary search on the increasing (left) side
        int leftIdx = binarySearchAscending(mountainArr, target, 0, peak);
        if (leftIdx != -1) {
            return leftIdx;
        }
        
        // Step 3: Binary search on the decreasing (right) side
        return binarySearchDescending(mountainArr, target, peak + 1, n - 1);
    }
    
    private int findPeak(MountainArray mountainArr, int n) {
        int low = 0;
        int high = n - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1; // Peak must be on the right
            } else {
                high = mid; // Peak could be mid or to the left
            }
        }
        return low; 
    }
    
    private int binarySearchAscending(MountainArray mountainArr, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = mountainArr.get(mid);
            
            if (val == target) {
                return mid;
            } else if (val < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    
    private int binarySearchDescending(MountainArray mountainArr, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = mountainArr.get(mid);
            
            if (val == target) {
                return mid;
            } else if (val < target) {
                high = mid - 1; // Since it's decreasing, smaller elements are to the right
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}