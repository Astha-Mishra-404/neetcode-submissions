class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;

        if (n == 1) {
            return 1;
        }

        int left = 0;
        int ans = 1;

        for (int right = 1; right < n; right++) {

            // If equal, turbulence breaks completely
            if (arr[right] == arr[right - 1]) {
                left = right;
            }

            // Check whether the current comparison
            // continues the alternating pattern
            else if (right == 1 || 
                    (arr[right] > arr[right - 1]) != 
                    (arr[right - 1] > arr[right - 2])) {
                // Continue the turbulent subarray
            }

            // Pattern did not alternate
            else {
                left = right - 1;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}