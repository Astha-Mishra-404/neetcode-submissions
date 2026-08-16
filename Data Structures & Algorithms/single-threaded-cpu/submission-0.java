class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = tasks[i][0]; // enqueue time
            arr[i][1] = tasks[i][1]; // processing time
            arr[i][2] = i;           // original index
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[2], b[2]);
        });

        int[] ans = new int[n];
        int idx = 0;
        int i = 0;
        long time = 0;

        while (idx < n) {

            if (pq.isEmpty() && time < arr[i][0]) {
                time = arr[i][0];
            }

            while (i < n && arr[i][0] <= time) {
                pq.offer(arr[i]);
                i++;
            }

            int[] cur = pq.poll();
            ans[idx++] = cur[2];
            time += cur[1];
        }

        return ans;
    }
}