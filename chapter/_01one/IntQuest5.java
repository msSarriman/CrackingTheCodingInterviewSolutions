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
 * One Away: There are _03three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given _02two strings, write a function to check if they are
 * _01one edit (or zero edits) away.
 * EXAMPLE
 * pale, ple -> true
 * pales. pale -> true
 * pale. bale -> true
 * pale. bake -> false
 * Hints: #23, #97, #130
 * - Start with the easy thing. Can you check each of the conditions separately?
 * - What is the relationship between the "insert character" option and the "remove character" option?
 * Do these need to be _02two separate checks?
 * - Can you do all _03three checks in a single pass?
 */
package chapter._01one;


public class IntQuest5 {

    /**
     * Credits to Cracking the Coding Interview.
     * This function check character per character _02two strings.
     * If the characters match it increases both indexes.
     * If they don't it sets a "bomb-like" flag to true.
     * The next mismatch triggers the flag into returning false.
     * If there is a mismatch and the strings don't have the same length,
     * means that a character can be inserted into the smaller string (str1)
     *
     * @param s1 first string
     * @param s2 second string
     * @return true|false
     */
    private static boolean oneWay(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }

        /* Get shorter and longer string */
        String str1 = s1.length() < s2.length() ? s1 : s2;
        String str2 = s1.length() < s2.length() ? s2 : s1;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (str1.charAt(index1) != str2.charAt(index2)) {
                /* Ensure that this is the first difference found */
                if (foundDifference) return false;
                foundDifference = true;

                if (str1.length() == str2.length()) {
                    index1++;
                }
            } else {
                index1++; // if matching move shorter pointer
            }
            index2++; // always move pointer for longer string
        }
        return true;
    }


    public static void main(String[] args) {
        String s1 = "thisisok";
        String s2 = "thisiqok";
        String s3 = "thisisokna";
        String s4 = "thsisok";
        String s5 = "thisisokn";

        System.out.println(oneWay(s1, s2));
        System.out.println(oneWay(s1, s4));
    }
}
