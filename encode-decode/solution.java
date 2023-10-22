import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public static String encode(List<String> strs) {
        StringBuilder encodedInputBuilder = new StringBuilder();

        for (String s : strs) {
            encodedInputBuilder.append(s.length() + "#" + s);
        }

        return encodedInputBuilder.toString();
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public static List<String> decode(String str) {
        List<String> decodedStrings = new ArrayList<>();
        StringBuilder currentWordLengthBuilder = new StringBuilder();
        int currentWordLength = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '#') {
                currentWordLengthBuilder.append(str.charAt(i));
            } else {
                currentWordLength = Integer.parseInt(currentWordLengthBuilder.toString());
                decodedStrings.add(str.substring(i + 1, i + currentWordLength + 1));
                i += currentWordLength;
                currentWordLengthBuilder.setLength(0);
            }
        }

        return decodedStrings;
    }

    public static void main(String[] args) {
        List<String> testSuite = List.of("lint", "code","love","you");
        List<String> decodedTestSuite = decode(encode(testSuite));
        List<String> shouldBeEmpty = testSuite.stream()
                .filter(item -> !decodedTestSuite.contains(item))
                .toList();
        System.out.println(shouldBeEmpty.size() == 0);
    }
}