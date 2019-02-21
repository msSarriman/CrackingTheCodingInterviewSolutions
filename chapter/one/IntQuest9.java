/**
 * String Rotation: Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
 * call to isSubstring (e.g.,"waterbottle" is a rotation of"erbottlewat").
 * Hints: #34, #88, #104
 * - If a string is a rotation of another, then it's a rotation at a particular point. For example,
 * a rotation of waterbottle at character 3 means cutting waterbottle at character 3
 * and putting the right half (erbottle) before the left half (wat)
 * - We are essentially asking if there's a way of splitting the first string into two parts, x and
 * y, such that the first string is xy and the second string is yx. For example, x = wat and
 * y = erbottle. The first string is xy = waterbottle. The second string is yx =
 * erbottlewat
 * - Think about the earlier hint. Then think about what happens when you concatenate
 * erbottlewat to itself. You get erbottlewaterbottlewat.
 */
package chapter.one;

import java.util.Map;
import java.util.HashMap;

public class IntQuest9 {


    /**
     * This function checks if s1 is a substring os s2.
     * It does so by updating a HashMap with values beeing the characters of the string.
     * Every occurrence on s1 is incrementing the value at the corresponding key, and
     * every occurrence on s2 is decrementing the value at the corresponding key.
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
                myMap.put(s1c,1);
            } else {
                int temp = myMap.get(s1c);
                myMap.put(s1c, temp + 1);
            }
            if (!myMap.containsKey(s2c)) {
                myMap.put(s2c,-1);
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

        System.out.println(isSubstring(s1,s2));
        System.out.println(isSubstring(s1,s3));
        System.out.println(isSubstring(s3,s4));
        System.out.println(isSubstring(s3,s1));

    }
}
