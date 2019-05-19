/**
 * Insertion: You are given two 32-bit numbers, N and M, and two bit positions, i and
 * j. Write a method to insert M into N such that M starts at bit j and ends at bit i. You
 * can assume that the bits j through i have enough space to fit all of M. That is, if
 * M = 10011, you can assume that there are at least 5 bits between j and i. You would not, for
 * example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
 * EXAMPLE
 * Input: N 10000000000, Μ = 10011, i 2, j 6
 * Output: N 10001001100
 * Hints: # 137, #169, #215
 */
package chapter._05five;

public class IntQuest1 {


    /**
     * This method solves the problem by shifting the @m by i bits, and inserting it into @n, by logical OR
     * @param n
     * @param m
     * @param i
     * @param j
     * @return
     */
    public static int insertNtoM(int n, int m, int i, int j) {
        m = (m << i);
        n |= m;
        return n;
    }


    public static void main(String[] args) {
        int n = 1024;
        int m = 19;
        int i = 2;
        int j = 6;
        System.out.printf("n is 0x%s (%d)d\n", Integer.toBinaryString(n), n);
        System.out.printf("m is 0x%s (%d)d\n", Integer.toBinaryString(m), m);
        System.out.printf("And will be inserted into positions %d to %d\n", i, j);
        int result = insertNtoM(n, m, i, j);
        System.out.printf("Outcome is 0x%s or (%d)d", Integer.toBinaryString(result), result);
    }
}
