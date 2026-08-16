class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        int totalLeft = (m + n + 1) / 2;

        while (left <= right) {

            int i = left + (right - left) / 2;
            int j = totalLeft - i;

            int L1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int R1 = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int L2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int R2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (L1 <= R2 && L2 <= R1) {

                if ((m + n) % 2 == 1) {
                    return Math.max(L1, L2);
                } else {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                }

            } else if (L1 > R2) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }

        return 0.0;
    }
}

