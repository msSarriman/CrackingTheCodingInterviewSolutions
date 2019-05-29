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
 * Draw Line: A monochrome screen is stored as a single array of bytes, allowing eight consecutive
 * pixels to be stored in one byte. The screen has width w, where w is divisible by 8 (that is, no byte will
 * be split across rows). The height of the screen, of course, can be derived from the length of the array
 * and the width. Implement a function that draws a horizontal line from (xl, y) to (x2, y) .
 * The method signature should look something like:
 * drawLine(byte[] screem, int width, int x1, int x2, int y)
 */
package chapter._05five;

import org.jetbrains.annotations.Contract;

import java.util.Scanner;
import java.util.Random;

// under construction
public class IntQuest8 {

    private static void printScreen(byte[][] myScreen) {
        System.out.println("Image follows:");
        for (byte b1[] : myScreen) {
            for (byte b2 : b1) {
                System.out.print(String.format("%8s", Integer.toBinaryString((b2 + 256) % 256))
                        .replace(' ', '0'));
            }
            System.out.println();
        }
    }


    private static byte[][] drawLine(byte[][] myScreen, int x1, int x2, int y) {
        // Normalize y start index at 0
        y--;

        // Calculate first and last byte, than tend towards manipulation
        int firstByte = x1 / myScreen.length;
        int lastByte = x2 / myScreen.length;

        // if there is only one byte to manipulate
        if (firstByte == lastByte) {
            myScreen[firstByte][y] =
                    startFromStopTo(myScreen[firstByte][y], x1, x2);
        } else {
            myScreen[firstByte / myScreen.length][y] =
                    stopToLSB(myScreen[firstByte / myScreen.length][y], x1);
            myScreen[lastByte / myScreen.length][y] =
                    startFromLSB(myScreen[lastByte / myScreen.length][y], x2);
            for (int i = firstByte + 1; i < lastByte; i++) {
                myScreen[i][y] = (byte) 0;
            }
        }
        return myScreen;
    }


    private static byte startFromStopTo(byte b, int x1, int x2) {
        int startAtLSB = x2 % 8 == 0 ? 0 : 8 - (x2 % 8);
        int endAtMSB = x1 % 8 == 0 ? 0 : 8 - (x1 % 8);
        for (int i = x2; i <= x1; i++) {
            b &= ~(1 << i);
        }
        return b;
    }


    private static byte stopToLSB(byte b, int x) {
        int endAtLsb = x % 8 == 0 ? 0 : 8 - (x % 8);
        for (int i = 7; i >= endAtLsb; i--) {
            b &= ~(1 << i);
        }
        return b;
    }


    private static byte startFromLSB(byte b, int x) {
        int startFromLsb = x % 8 == 0 ? 0 : 8 - (x % 8);
        for (int i = startFromLsb; i <= 8; i++) {
            b &= ~(1 << i);
        }
        return b;
    }

    public static void main(String[] args) {
        int w;
        Scanner sc = new Scanner(System.in);
        do {
            w = sc.nextInt();
            sc.nextLine();
            System.out.println("yo");
        } while ((w % 8) != 0);

        // Creation of the screen
        byte[][] myScreen = new byte[w][w];
        Random rand = new Random();
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < w; j++) {
                myScreen[i][j] = (byte) (rand.nextInt(254) - 127);
            }
        }
        printScreen(myScreen);

        // x1, x2 and y are some example values
        int x1 = 0;
        int x2 = 64;
        int y = 3;
        myScreen = drawLine(myScreen, x1, x2, y);
        printScreen(myScreen);
    }
}

// 00110000000100011011111111001100010010110000110111110000010011111100000001011110110000101100101000101000111101101000110010110000
// 00110000000100011011111111001100010010110000110111110000010011111100000001011110110000101100101000101000111101101000110010110000