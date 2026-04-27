class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSum = 0;
        int currentTank = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            int netChange = gas[i] - cost[i];
            totalSum += netChange;
            currentTank += netChange;

            // If the tank drops below 0, this startIndex (and all stations 
            // between it and i) cannot be the starting point.
            if (currentTank < 0) {
                // Reset tank and try starting at the next station
                currentTank = 0;
                startIndex = i + 1;
            }
        }

        // If total gas is less than total cost, it's impossible
        return (totalSum < 0) ? -1 : startIndex;
    }
}