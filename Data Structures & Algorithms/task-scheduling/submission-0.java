class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] count = new int[26];

        // count frequency of each task
        for (char c : tasks) {
            count[c - 'A']++;
        }

        int maxFreq = 0;
        for (int c : count) {
            maxFreq = Math.max(maxFreq, c);
        }

        int maxCount = 0;
        for (int c : count) {
            if (c == maxFreq) {
                maxCount++;
            }
        }

        int partLength = (maxFreq - 1) * (n + 1) + maxCount;

        return Math.max(partLength, tasks.length);
    }
}