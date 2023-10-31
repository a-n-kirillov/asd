class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        float[] timesLeftIndexedByPosition = new float[target];
        for (int i = 0; i < position.length; i++) {
            timesLeftIndexedByPosition[position[i]] = (target - position[i]) / (float) speed[i];
        }

        int distinctFlocksCounter = 0;
        float furtherFlockArrivalTime = 0;
        for (int i = target - 1; i >= 0; i--) {
            if (timesLeftIndexedByPosition[i] > furtherFlockArrivalTime) {
                distinctFlocksCounter++;
                furtherFlockArrivalTime = timesLeftIndexedByPosition[i];
            }
        }

        return distinctFlocksCounter;
    }
}