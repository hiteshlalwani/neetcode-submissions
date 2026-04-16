class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        // Combine position and speed so we can sort them together
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i]; // Store the time
        }

        // Sort cars by position in descending order
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double currentMaxTime = 0;

        for (int i = 0; i < n; i++) {
            double arrivalTime = cars[i][1];
            
            // If this car takes more time than the current fleet lead, 
            // it starts a new fleet.
            if (arrivalTime > currentMaxTime) {
                fleets++;
                currentMaxTime = arrivalTime;
            }
        }

        return fleets;
    }
}