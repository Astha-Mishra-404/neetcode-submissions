

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return 0;

        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0;
        int endPtr = 0;

        for (int i = 0; i < n; i++) {
            if (start[i] < end[endPtr]) {
                rooms++;
            } else {
                endPtr++;
            }
        }

        return rooms;
    }
}