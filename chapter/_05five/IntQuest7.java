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
 * Pairwise Swap: Write a program to swap odd and even bits in an integer with as few instructions as
 * possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
 * Hints: #145, #248, #328, #355
 */
package chapter._05five;

public class IntQuest7 {


    /**
     * This method swaps the binary digits at odd and even locations.
     * @param number
     * @return
     */
    public static int swapAddEven(int number) {
        char[] numberBin = Integer.toBinaryString(number).toCharArray();
        for (int i = numberBin.length - 1; i > 0 ; i -= 2) {
            if (numberBin[i] != numberBin[i-1]) {
                char temp = numberBin[i];
                numberBin[i] = numberBin[i-1];
                numberBin[i-1] = temp;
            }
        }

        return Integer.parseInt(String.valueOf(numberBin), 2);
    }


    public static void main(String[] args) {
        int a = 42;
        System.out.printf("a is <%d> with binary of <%s>\n", a, Integer.toBinaryString(a));
        a = swapAddEven(a);
        System.out.printf("After the flip would be <%d> with binary <%s>\n", a, Integer.toBinaryString(a));
    }
}
