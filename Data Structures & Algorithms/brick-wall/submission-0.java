
class Solution {
    public int leastBricks(List<List<Integer>> wall) {

        Map<Integer, Integer> map = new HashMap<>();

        int maxGap = 0;

        // Count all internal gaps
        for (List<Integer> row : wall) {

            int prefixSum = 0;

            // Exclude the last brick
            for (int i = 0; i < row.size() - 1; i++) {

                prefixSum += row.get(i);

                map.put(prefixSum,
                    map.getOrDefault(prefixSum, 0) + 1);

                maxGap = Math.max(maxGap, map.get(prefixSum));
            }
        }

        // Minimum bricks crossed
        return wall.size() - maxGap;
    }
}
