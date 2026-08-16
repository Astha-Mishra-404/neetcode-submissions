

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int[][] q = new int[n][2];
        
        // Store query value with original index
        for (int i = 0; i < n; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        // Sort intervals by start
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Sort queries
        Arrays.sort(q, (a, b) -> a[0] - b[0]);

        int[] ans = new int[n];

        // Min-heap: [intervalLength, intervalEnd]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        int i = 0;

        for (int[] query : q) {
            int val = query[0];
            int idx = query[1];

            // Add all intervals whose start <= query
            while (i < intervals.length && intervals[i][0] <= val) {
                int left = intervals[i][0];
                int right = intervals[i][1];
                int len = right - left + 1;

                pq.offer(new int[]{len, right});
                i++;
            }

            // Remove intervals that cannot contain query
            while (!pq.isEmpty() && pq.peek()[1] < val) {
                pq.poll();
            }

            // Top of heap is smallest valid interval
            ans[idx] = pq.isEmpty() ? -1 : pq.peek()[0];
        }

        return ans;
    }
}