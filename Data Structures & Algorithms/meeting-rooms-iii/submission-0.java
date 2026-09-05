class Solution {
    public int mostBooked(int n, int[][] meetings) {
        
        // Sort meetings by starting time
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // Available rooms: smallest room number first
        PriorityQueue<Integer> available = new PriorityQueue<>();

        // Busy rooms: [endTime, roomNumber]
        // First compare by endTime, then roomNumber
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> a[0] == b[0]
                    ? Long.compare(a[1], b[1])
                    : Long.compare(a[0], b[0])
        );

        // Initially all rooms are available
        for (int i = 0; i < n; i++) {
            available.offer(i);
        }

        // Count meetings held by each room
        int[] count = new int[n];

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            // Free all rooms whose meetings have ended
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                available.offer((int) busy.poll()[1]);
            }

            if (!available.isEmpty()) {
                // Use the available room with the smallest number
                int room = available.poll();

                busy.offer(new long[]{end, room});
                count[room]++;
            } else {
                // No room is available.
                // Take the room that becomes free earliest.
                long[] earliest = busy.poll();

                long freeTime = earliest[0];
                int room = (int) earliest[1];

                // Delay the meeting
                busy.offer(new long[]{freeTime + duration, room});
                count[room]++;
            }
        }

        // Find the room with the maximum number of meetings
        int answer = 0;

        for (int i = 1; i < n; i++) {
            if (count[i] > count[answer]) {
                answer = i;
            }
        }

        return answer;
    }
}