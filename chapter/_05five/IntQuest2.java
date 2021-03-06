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
 * Binary to String: Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print
 * the binary representation. If the number cannot be represented accurately in binary with at most 32
 * characters, print "ERROR:'
 * Hints: #143, #167, #173, #269, #297
 * - To wrap your head around the problem, try thinking about how you'd do it for integers
 * - In a number like. 893 (in base 10), what does each digit signify? What then does each
 * digit in .10010 signify in base 2?
 * - A number such as .893 (in base 10) indicates 8 * 10-1 + 9 * 10-2 + 3 * 10-3•
 * Translate this system into base 2.
 * - How would you get the first digit in . 893? If you multiplied by 10, you'd shift the values
 * over to get 8.93.What happens if you multiply by 2?
 * - Think about what happens for values that can't be represented accurately in binary
 */
package chapter._05five;

public class IntQuest2 {

    /**
     * This method transforms the given number (<1) into a binary floating point.
     * @param number = the number to be converted
     * @return
     */
    public static String realToString(double number) {
        StringBuilder myStr = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            number *= 2;
            if (number >= 1) {
                myStr.append(1);
                number -= 1;
            } else {
                myStr.append(0);
            }
            if (number == 0.0) {
                return "0." + myStr.toString();
            }
        }
        return "ERROR";
    }


    public static void main(String[] args) {
        System.out.println(realToString(0.5));
        System.out.println(realToString(0.125));
        System.out.println(realToString(0.525));
        System.out.println(realToString(0.987));
        System.out.println(realToString(0.333));
        System.out.println(realToString(0.25));
        System.out.println(realToString(0.1));
    }
}
