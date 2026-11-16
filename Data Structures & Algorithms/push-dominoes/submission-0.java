
class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] forces = new int[n];

        // Pass 1: Calculate forces from left to right
        int force = 0;

        for (int i = 0; i < n; i++) {

            if (dominoes.charAt(i) == 'R') {
                force = n;
            } 
            else if (dominoes.charAt(i) == 'L') {
                force = 0;
            } 
            else {
                force = Math.max(force - 1, 0);
            }

            forces[i] += force;
        }

        // Pass 2: Calculate forces from right to left
        force = 0;

        for (int i = n - 1; i >= 0; i--) {

            if (dominoes.charAt(i) == 'L') {
                force = n;
            } 
            else if (dominoes.charAt(i) == 'R') {
                force = 0;
            } 
            else {
                force = Math.max(force - 1, 0);
            }

            forces[i] -= force;
        }

        // Build the final domino string
        StringBuilder result = new StringBuilder();

        for (int f : forces) {
            if (f > 0) {
                result.append('R');
            } 
            else if (f < 0) {
                result.append('L');
            } 
            else {
                result.append('.');
            }
        }

        return result.toString();
    }
}
