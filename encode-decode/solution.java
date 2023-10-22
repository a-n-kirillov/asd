public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
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
    public List<String> decode(String str) {
        // write your code here
    }
}