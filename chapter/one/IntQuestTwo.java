/**
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other
 * O(N)
 */
package chapter.one;

import java.util.Map;
import java.util.HashMap;


public class IntQuestTwo {

    /**
     * This function check if the s1 is a permutation of s2, or vice versa.
     * It uses a hashMap to count the occurrences of each character at s1.
     * It then subtracts a value from each key of the hashMap.
     * If success, all the values of the HashMap will be zero.
     * Else the s1 and s2 are not permutated.
     * @param s1
     * @param s2
     * @return
     */
    private static String checkPermutation(String s1, String s2){
        if (s1.length() != s2.length()) return "Not a match";

        Map<Character, Integer> myMap = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (!myMap.containsKey(c))
                myMap.put(c,1);
            else {
                int temp = myMap.get(c);
                myMap.put(c,temp+1);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (!myMap.containsKey(c))
                return "Not a match";
            else {
                int temp = myMap.get(c);
                myMap.put(c, temp - 1);
            }
        }
        for (Map.Entry<Character, Integer> kv : myMap.entrySet()){
            if (kv.getValue() != 0) return "Not a match";
        }

        return "Strings are permutated";
    }


    public static void main(String[] args) {
        String s1 = "absolute";
        String s2 = "luabsote";
        String s3 = "luubsote";
        String s4 = "absolutee";

        String a = "abcdefghijklmnopqrstuvwxyz";
        String b = "zyxwvutsrqponmlkjihgfedcba";

        System.out.println(checkPermutation(s1,s2));
        System.out.println(checkPermutation(s1,s3));
        System.out.println(checkPermutation(s1,s4));
        System.out.println(checkPermutation(a,b));
    }
}
