class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for (int p : piles) {
            right = Math.max(right, p);
        }

        int answer = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                answer = mid;
                right = mid - 1;   // try smaller speed
            } else {
                left = mid + 1;    // need faster speed
            }
        }

        return answer;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;

        for (int p : piles) {
            hours += (p + k - 1) / k;
            if (hours > h) return false;
        }

        return hours <= h;
    }
}
