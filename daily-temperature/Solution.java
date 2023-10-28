class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<TemperatureIndexPair> unmatchedTemperatures = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {

            while (unmatchedTemperatures.size() > 0 && temperatures[i] > unmatchedTemperatures.getLast().temperature()) {
                TemperatureIndexPair latestUnmatchedTemperatureIndexPair = unmatchedTemperatures.removeLast();
                result[latestUnmatchedTemperatureIndexPair.index()] = i - latestUnmatchedTemperatureIndexPair.index();
            }

            unmatchedTemperatures.addLast(new TemperatureIndexPair(temperatures[i], i));
        }

        return result;
    }

    record TemperatureIndexPair(int temperature, int index) {}
}