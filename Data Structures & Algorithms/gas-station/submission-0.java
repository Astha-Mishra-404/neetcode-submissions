class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;

            // If tank becomes negative, reset start
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        // If total gas is less than total cost, not possible
        return total >= 0 ? start : -1;
    }
}
