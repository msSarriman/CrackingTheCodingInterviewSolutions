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
 * Insertion: You are given two 32-bit numbers, N and M, and two bit positions, i and
 * j. Write a method to insert M into N such that M starts at bit j and ends at bit i. You
 * can assume that the bits j through i have enough space to fit all of M. That is, if
 * M = 10011, you can assume that there are at least 5 bits between j and i. You would not, for
 * example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
 * EXAMPLE
 * Input: N 10000000000, Μ = 10011, i 2, j 6
 * Output: N 10001001100
 * Hints: # 137, #169, #215
 * - Break this into parts. Focus first on clearing the appropriate bits
 * - To clear the bits, create a "bit mask"that looks like a series of 1s, then Os, then 1s
 * - It's easy to create a bit mask of Os at the beginning or end. But how do you create a bit
 * mask with a bunch of zeroes in the middle? Do it the easy way: Create a bit mask for the
 * left side and then another one for the right side.Then you can merge those.
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
