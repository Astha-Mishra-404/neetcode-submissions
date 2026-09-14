class Solution {
    public int[] replaceElements(int[] arr) {
        // Initial rightMax = -1
        int rightMax = -1;

        // Iterate backwards from the end of the array
        for (int i = arr.length - 1; i >= 0; i--) {
            int newMax = Math.max(rightMax, arr[i]);
            arr[i] = rightMax;
            rightMax = newMax;
        }

        return arr;
    }
}