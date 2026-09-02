class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();

        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        // Store indices of senators
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        // Simulate the voting
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int r = radiant.poll();
            int d = dire.poll();

            if (r < d) {
                // Radiant acts first
                radiant.offer(r + n);
            } else {
                // Dire acts first
                dire.offer(d + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}