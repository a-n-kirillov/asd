import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> inputNumbersSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int currentSequenceLength = 0;
        int longestSequenceLength = 0;

        for (int currentNumber : nums) {
            if (!inputNumbersSet.contains(currentNumber - 1)) {
                while (inputNumbersSet.contains(currentNumber)) {
                    currentNumber++;
                    currentSequenceLength++;
                }

                longestSequenceLength = Math.max(longestSequenceLength, currentSequenceLength);
                currentSequenceLength = 0;
            }
        }

        return longestSequenceLength;
    }
}