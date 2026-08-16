class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4)
            return false;

        int sum = 0;
        for (int stick : matchsticks)
            sum += stick;

        if (sum % 4 != 0)
            return false;

        int target = sum / 4;

        Arrays.sort(matchsticks);

        // Reverse to descending order
        int left = 0, right = matchsticks.length - 1;
        while (left < right) {
            int temp = matchsticks[left];
            matchsticks[left] = matchsticks[right];
            matchsticks[right] = temp;
            left++;
            right--;
        }

        int[] sides = new int[4];

        return dfs(matchsticks, 0, sides, target);
    }

    private boolean dfs(int[] matchsticks, int index, int[] sides, int target) {
        if (index == matchsticks.length) {
            return sides[0] == target &&
                   sides[1] == target &&
                   sides[2] == target &&
                   sides[3] == target;
        }

        int stick = matchsticks[index];

        for (int i = 0; i < 4; i++) {
            if (sides[i] + stick > target)
                continue;

            sides[i] += stick;

            if (dfs(matchsticks, index + 1, sides, target))
                return true;

            sides[i] -= stick;

            // Symmetry pruning
            if (sides[i] == 0)
                break;
        }

        return false;
    }
}