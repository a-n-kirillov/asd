import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> closeToOpen = Map.of(
                ')', '(',
                ']', '[',
                '}', '{'
        );

        Deque<Character> visitorStack = new ArrayDeque<>(s.length());

        for (int i = 0; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);
            if (!closeToOpen.containsKey(currentCharacter)) {
                visitorStack.addLast(currentCharacter);
            } else {
                Character lastVisitedOpenParentheses = visitorStack.pollLast();
                if (lastVisitedOpenParentheses != closeToOpen.get(currentCharacter)) {
                    return false;
                }
            }
        }

        return visitorStack.size() == 0;
    }
}