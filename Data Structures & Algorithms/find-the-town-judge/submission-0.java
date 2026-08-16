class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] score = new int[n + 1];

        for (int[] relation : trust) {
            score[relation[0]]--; // Person trusts someone
            score[relation[1]]++; // Person is trusted
        }

        for (int i = 1; i <= n; i++) {
            if (score[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}