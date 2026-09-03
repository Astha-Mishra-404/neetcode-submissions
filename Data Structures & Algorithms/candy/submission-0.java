class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] candies = new int[n];

        // Give every child at least 1 candy
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        // Left to right
        // If current rating is higher than left neighbor,
        // current child gets one more candy.
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to left
        // If current rating is higher than right neighbor,
        // make sure current child has more candies than right neighbor.
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Calculate total candies
        int total = 0;
        for (int candy : candies) {
            total += candy;
        }

        return total;
    }
}