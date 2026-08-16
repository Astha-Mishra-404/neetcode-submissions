
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {
            // Case 1: no overlap, interval is completely before newInterval
            if (interval[1] < newInterval[0]) {
                result.add(interval);
            }
            // Case 2: no overlap, interval is completely after newInterval
            else if (interval[0] > newInterval[1]) {
                result.add(newInterval);
                newInterval = interval; // update newInterval
            }
            // Case 3: overlap → merge
            else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        // Add the last interval
        result.add(newInterval);

        return result.toArray(new int[result.size()][]);
    }
}