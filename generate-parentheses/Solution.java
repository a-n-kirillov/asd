import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        final char[] combination = new char[2 * n];
        proceed(n, 0, 0, combination, result);
        return result;
    }

    private void proceed(int desiredParenthesesCount, int openParenthesesCount, int closedParenthesesCount, char[] combination, List<String> result) {
        if (openParenthesesCount == desiredParenthesesCount && closedParenthesesCount == desiredParenthesesCount) {
            result.add(new String(combination));
            return;
        }

        int currentIndex = openParenthesesCount + closedParenthesesCount;

        if (openParenthesesCount < desiredParenthesesCount) {
            combination[currentIndex] = '(';
            proceed(desiredParenthesesCount, openParenthesesCount + 1, closedParenthesesCount, combination, result);
        }

        if (closedParenthesesCount < openParenthesesCount) {
            combination[currentIndex] = ')';
            proceed(desiredParenthesesCount, openParenthesesCount, closedParenthesesCount + 1, combination, result);
        }
    }
}