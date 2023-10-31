class Solution {
    public record PositionSpeedPair(int position, int speed) {}
    public int carFleet(int target, int[] position, int[] speed) {
        List<PositionSpeedPair> positionSpeedPairs = createListOfPositionSpeedPairs(position, speed);
        Comparator<PositionSpeedPair> positionReverseComparator = Comparator
                .comparing(PositionSpeedPair::position, Comparator.reverseOrder());
        positionSpeedPairs.sort(positionReverseComparator);

        List<Double> flockArrivalTimes = new ArrayList<>();
        
        for (PositionSpeedPair pair : positionSpeedPairs) {
            double arrivalTime = (target - pair.position) / (double)pair.speed;
            flockArrivalTimes.add(arrivalTime);
            if (flockArrivalTimes.size() >= 2 && flockArrivalTimes.get(flockArrivalTimes.size() - 1) <= flockArrivalTimes.get(flockArrivalTimes.size() - 2)) {
                flockArrivalTimes.remove(flockArrivalTimes.size() - 1);
            }
        }

        return flockArrivalTimes.size();
    }

    private List<PositionSpeedPair> createListOfPositionSpeedPairs(int[] position, int[] speed) {
        List<PositionSpeedPair> result = new ArrayList<>();
        
        for (int i = 0; i < position.length; i++) {
            result.add(new PositionSpeedPair(position[i], speed[i]));
        }

        return result;
    }
}