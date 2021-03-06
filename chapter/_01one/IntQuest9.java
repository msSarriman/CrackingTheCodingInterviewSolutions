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
 * String Rotation: Assume you have a method isSubstring which checks if _01one word is a substring
 * of another. Given _02two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only _01one
 * call to isSubstring (e.g.,"waterbottle" is a rotation of"erbottlewat").
 * Hints: #34, #88, #104
 * - If a string is a rotation of another, then it's a rotation at a particular point. For example,
 * a rotation of waterbottle at character 3 means cutting waterbottle at character 3
 * and putting the right half (erbottle) before the left half (wat)
 * - We are essentially asking if there's a way of splitting the first string into _02two parts, x and
 * y, such that the first string is xy and the second string is yx. For example, x = wat and
 * y = erbottle. The first string is xy = waterbottle. The second string is yx =
 * erbottlewat
 * - Think about the earlier hint. Then think about what happens when you concatenate
 * erbottlewat to itself. You get erbottlewaterbottlewat.
 */
package chapter._01one;

import java.util.Map;
import java.util.HashMap;

public class IntQuest9 {


    /**
     * This function checks if s1 is a substring os s2.
     * It does so by updating a HashMap with keys being the characters of each string,
     * and value the occurrences of the specific character.
     * Every occurrence on s1 is incrementing the value at the corresponding key, and
     * every occurrence on s2 is decrementing the value at the corresponding key.
     *
     * @param s1 = first string
     * @param s2 = second string
     * @return true or false
     */
    private static boolean isSubstring(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        Map<Character, Integer> myMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char s1c = s1.charAt(i);
            char s2c = s2.charAt(i);
            if (!myMap.containsKey(s1c)) {
                myMap.put(s1c, 1);
            } else {
                int temp = myMap.get(s1c);
                myMap.put(s1c, temp + 1);
            }
            if (!myMap.containsKey(s2c)) {
                myMap.put(s2c, -1);
            } else {
                int temp = myMap.get(s2c);
                myMap.put(s2c, temp - 1);
            }
        }
        int count = 0;
        for (Map.Entry<Character, Integer> kv : myMap.entrySet()) {
            count += kv.getValue();
        }
        return count == 0;
    }


    public static void main(String[] args) {
        String s1 = "thisisastring";
        String s2 = "isthistringas";
        String s3 = "abcdefghijklmnop";
        String s4 = "mbfplencgakhodji";

        System.out.println(isSubstring(s1, s2));
        System.out.println(isSubstring(s1, s3));
        System.out.println(isSubstring(s3, s4));
        System.out.println(isSubstring(s3, s1));

    }
}
