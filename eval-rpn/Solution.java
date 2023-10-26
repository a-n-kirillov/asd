import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> tokenStack = new ArrayDeque<>();

        for (String token : tokens) {
            Integer potentialNumber = tryParse(token);
            if (potentialNumber != null) {
                tokenStack.addLast(potentialNumber);
                continue;
            }

            Integer secondOperand = tokenStack.removeLast();
            Integer firstOperand = tokenStack.removeLast();

            Integer result = switch (token) {
                case "+" -> firstOperand + secondOperand;
                case "-" -> firstOperand - secondOperand;
                case "/" -> firstOperand / secondOperand;
                case "*" -> firstOperand * secondOperand;
                default -> 0;
            };

            tokenStack.addLast(result);
        }

        return tokenStack.removeLast();
    }

    public static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}