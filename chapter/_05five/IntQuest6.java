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
 * Conversion: Write a function to determine the number of bits you would need to flip to convert
 * integer A to integer B.
 * EXAMPLE
 * Input: 29 (or: 11101), 15 (or: 01111)
 * Output: 2
 * Hints: #336, #369
 * - How would you figure out how many bits are different between two numbers?
 * - Think about what an XOR indicates. If you do a XOR b, where does the result have 1s?
 * Where does it have Os?
 */
package chapter._05five;

public class IntQuest6 {


    /**
     * This method calculates the number of bits that need to be flipped, for @a and @b to match.
     * It does so by comparing from LSB to MSB, counting the differences, and summing up the length difference
     * of @a and @b (if there is any)
     * @param a
     * @param b
     * @return
     */
    public static int calculateBitConversions(int a, int b) {
        String myBinA = Integer.toBinaryString(a);
        String myBinB = Integer.toBinaryString(b);

        char[] binA = myBinA.length() > myBinB.length() ? myBinA.toCharArray() : myBinB.toCharArray(); // biggest
        char[] binB = myBinA.length() < myBinB.length() ? myBinA.toCharArray() : myBinB.toCharArray(); // smallest

        int counter = 0;
        int indexA = binA.length - 1;
        int indexB = binB.length - 1;
        while (indexB >= 0) {
            if (binA[indexA] != binB[indexB]) {
                counter++;
            }
            indexA--;
            indexB--;
        }
        return counter + (binA.length - binB.length);
    }

    public static void main(String[] args) {
        int a = 29, b = 15;
        System.out.printf("a is <%d> with binary of <%s>\n", a, Integer.toBinaryString(a));
        System.out.printf("b is <%d> with binary of <%s>\n", b, Integer.toBinaryString(b));
        System.out.printf("The number of bits that have to be flipped is <%d>\n", calculateBitConversions(a, b));

        a = 31;
        b = 0;
        System.out.printf("a is <%d> with binary of <%s>\n", a, Integer.toBinaryString(a));
        System.out.printf("b is <%d> with binary of <%s>\n", b, Integer.toBinaryString(b));
        System.out.printf("The number of bits that have to be flipped is <%d>\n", calculateBitConversions(a, b));
    }
}
