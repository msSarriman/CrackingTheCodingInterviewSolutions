/**
 * URLify: Write a method to replace all spaces in a string with '%20: You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: If implementing in Java, please use a character array so that you can
 * perform this operation in place.)
 * EXAMPLE
 * Input: "Mr John Smith"
 * Output: "Mr%20John%20Smith"
 * Hints:
 * - It's often easiest to modify strings by going from the end of the string to the beginning.
 * - You might find you need to know the number of spaces. Can you just count them?
 */
package chapter._01one;

public class IntQuest3 {
    /**
     * this function returns a urlified version of the str string.
     * What it really does is that it replaces all the spaces with "%20"
     *
     * @param str
     * @return
     */
    private static String urlifyWithBuffer(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    /**
     * This function performs the same action but it does the operation in place, as ordered by the needs of this
     * implementation.
     *
     * @param str
     * @return
     */
    private static String urlifyInPlace(String str) {
        int len = str.length(), numOfSpaces = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') numOfSpaces++;
        }
        char[] charArray = new char[(len - numOfSpaces) + (3 * numOfSpaces)];
        int i = 0;
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                charArray[i] = '%';
                charArray[i + 1] = '2';
                charArray[i + 2] = '0';
                i += 3;
            } else {
                charArray[i++] = c;
            }
        }
        return String.valueOf(charArray);
    }


    public static void main(String[] args) {
        String s1 = "This is a sample string to edit";
        String s2 = urlifyWithBuffer(s1);
        String s3 = urlifyInPlace(s1);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
