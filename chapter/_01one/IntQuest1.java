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
 * 1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 * Hints: #44, #777, #732
 */
package chapter._01one;


import java.util.Map;
import java.util.HashMap;

public class IntQuest1 {


    /**
     * Uses the hashmap ds to find if the argument str has any duplicates
     * O(N) where N is str.length()
     *
     * @param str
     * @return
     */
    private static String allUniqueWithDS(String str) {
        Map<Character, Integer> myMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (myMap.containsKey(c)) {
                int temp = myMap.get(c);
                myMap.put(c, temp + 1);
            } else {
                myMap.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> kv : myMap.entrySet()) {
            if (kv.getValue() > 1) {
                return "There are duplicates";
            }
        }
        return "All characters are unique";
    }


    /**
     * This function check without any additional DSs
     * if the str has all unique characters, by using a boolean array
     *
     * @param str
     * @return
     */
    private static boolean allUniqueNoDS(String str) {
        if (str.length() > 128) return false; // assuming the str is ASCII128

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int tempVal = str.charAt(i);
            if (charSet[tempVal]) {
                return false;
            }
            charSet[tempVal] = true;
        }
        return true;
    }


    /**
     * function that finds duplicates in a string by using the low level bit logic.
     * Checker will become an array of 32 bits.
     * if checks if the results of logical AND will be greater than zero (thus there qas already a bit set as true,
     * telling us that the character with index bit+'a' already exists.
     * checker |= (1 << tempVal), sets the bit at position tempVal+'a', to true, meaning that this bit exists, for
     * feature if lookups.
     *
     * @param str
     * @return
     */
    private static boolean allUniqueWithBitVector(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int tempVal = str.charAt(i) - 'a';
            if ((checker & (1 << tempVal)) > 1) {
                return false;
            }
            checker |= (1 << tempVal);
        }
        return true;
    }


    public static void main(String[] args) {
        String str = "abcddef";
        String str1 = "abcdef";


        // Using a HashMap
        System.out.println(allUniqueWithDS(str));
        System.out.println(allUniqueWithDS(str1));

        // Without using a Data Structure
        System.out.println(allUniqueNoDS(str));
        System.out.println(allUniqueNoDS(str1));

        // Without using a Data Structure
        System.out.println(allUniqueWithBitVector(str));
        System.out.println(allUniqueWithBitVector(str1));
    }
}
