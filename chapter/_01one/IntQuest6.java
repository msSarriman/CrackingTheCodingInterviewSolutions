/*
MIT License

Copyright (c) 2019 Emmanouil Sarris

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
/**
 * String Compression: Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 * Hints: #92, # 110
 * - Do the easy thing first. Compress the string, then compare the lengths
 * - Be careful that you aren't repeatedly concatenating strings together. This can be very
 * inefficient.
 */
package chapter._01one;

public class IntQuest6 {

    /**
     * This function compresses the String given as the argument s1.
     * It holds a temp char and an incremental counter that when the char changes,
     * appends the char and the counter's current value, into a string builder.
     * Then it assigns to the char the new value, and sets the counter to 1.
     * After the for finished, it appends the last elements, since the final else statement,
     * didn't trigger.
     *
     * @param s1 = string to be compressed
     * @return s1 < compressedString ? s1 : compressedString
     */
    public static String compressString(String s1) {
        StringBuilder sb = new StringBuilder();
        int occurrencesCounter = 0;
        char temp = s1.charAt(0);
        for (int i = 0; i < s1.length(); i++) {
            if (temp == s1.charAt(i)) occurrencesCounter++;
            else {
                sb.append(temp);
                sb.append(occurrencesCounter);
                temp = s1.charAt(i);
                occurrencesCounter = 1;
            }
        }
        sb.append(temp);
        sb.append(occurrencesCounter);
        String strToReturn = sb.toString();
        if (s1.length() > strToReturn.length()) return strToReturn;
        else return s1;
    }


    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "aaabbbbccccdeeeeeeeeee";
        String s3 = "abcdeeeeeee";

        System.out.println(compressString(s1));
        System.out.println(compressString(s2));
        System.out.println(compressString(s3));
    }
}
