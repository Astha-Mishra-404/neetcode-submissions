
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {

        // Map each height to its corresponding name
        HashMap<Integer, String> map = new HashMap<>();

        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], names[i]);
        }

        // Sort heights in ascending order
        Arrays.sort(heights);

        // Store names in descending order of height
        String[] result = new String[names.length];

        int j = 0;

        for (int i = heights.length - 1; i >= 0; i--) {
            result[j] = map.get(heights[i]);
            j++;
        }

        return result;
    }
}
