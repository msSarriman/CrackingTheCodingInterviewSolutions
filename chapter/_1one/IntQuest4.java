/**
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome. A
 * palindrome is a word or phrase that is the same forwards and backwards. A permutation
 * is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat". "atco cta". etc.)
 * Hints: #106, #121, #134, #136
 * -You do not have to-and should not-generate all permutations. This would be very
 * inefficient.
 * -What characteristics would a string that is a permutation of a palindrome have?
 * -Have you tried a hash table? You should be able to get this down to 0 (N) time.
 * -Can you reduce the space usage by using a bit vector?
 */
package chapter._1one;


import java.util.Set;
import java.util.HashSet;


public class IntQuest4 {


    /**
     * A string is a palindrome permutation when it contains the same number of characters at both sides of it.
     * A side is considered to be, each half of that string.
     * Strings that have an even number of characters, can have _2two perfect halves.
     * Strings with an odd number of characters, have a SINGLE character (the center) that appears
     * also an odd number of times (therefore the if statement on % 2)
     *
     * @param str = String to be evaluated
     * @return = true|false
     */
    private static boolean isPaliPerm(String str) {
        int len = str.length();
        Set<Character> mySet = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (mySet.contains(c)) mySet.remove(c);
            else mySet.add(c);
        }

        if (len % 2 == 0) {
            if (mySet.isEmpty()) return true;
            else return false;
        } else {
            if (mySet.size() == 1) return true;
            else return false;
        }
    }


    public static void main(String[] args) {
        String s1 = "thisisacccthisisa"; // this is a palindrome permutation
        String s2 = "thisisaacccthisisa"; // this isn't a palindrome permutation
        String s3 = "thisadfvadsvas;df";

        System.out.println(isPaliPerm(s1));
        System.out.println(isPaliPerm(s2));
        System.out.println(isPaliPerm(s3));
    }
}
