/**
 * Next Number: Given a positive integer, print the next smallest and the next largest number that
 * have the same number of 1 bits in their binary representation.
 * Hints: #147, # 175, #242, #312, #339, #358, #375, #390
 * - Get Next: Start with a brute force solution for each
 * - Get Next: Picture a binary number-something with a bunch of 1 s and Os spread out
 * throughout the number. Suppose you flip a 1 to a 0 and a 0 to a 1. ln what case will the
 * number get bigger? In what case will it get smaller?
 * - Get Next: Ifyou flip a 1 to a 0 and a0 to a 1, it will get bigger if the 0-> 1 bit is more significant than the 1->0 bit. How can you use this to create the next biggest number (with the
 * same number of 1s)?
 * - Get Next: Can you flip a 0 to a 1 to create the next biggest number?
 * - Get Next: Flipping a 0 to a 1 will create a bigger number. The farther right the index is
 * the smaller the bigger number is. If we have a number like 1001, we want to flip the
 * rightmost 0 (to create 1011). But if we have a number like 1010, we should not flip the
 * rightmost 1
 * - Get Next: We should flip the rightmost non-trailing O.The number 1010 would become
 * 1110. Once we've done that, we need to flip a 1 to a 0 to make the number as small
 * as possible, but bigger than the original number (1010). What do we do? How can we
 * shrink the number?
 * - Get Next: We can shrink the number by moving all the 1 s to the right of the flipped bit
 * as far right as possible (removing a 1 in the process).
 * - Get Previous: Once you've solved Get Next, try to invert the logic for Get Previous.
 */
package chapter._05five;

public class IntQuest4 {


    /**
     * getNextLargest()
     * This method finds the next biggest possible number, that can occur just by switching the place of a 1,
     * in the binary representation of @number.
     * @param number
     * @return
     */
    public static int getNextLargest(int number) {
        char[] numberBinary = Integer.toBinaryString(number).toCharArray();
        int indexMSB = -1, indexLSB = -1;
        for (int i = 0; i < numberBinary.length; i++) {
            if (numberBinary[i] == '0') {
                indexMSB = i;
                break;
            }
        }
        for (int i = numberBinary.length-1; i > 0; i--) {
            if (numberBinary[i] == '1') {
                indexLSB = i;
                break;
            }
        }
        if (indexLSB == -1 || indexMSB == -1) {
            throw new NullPointerException("Bits not found");
        }

        indexMSB = numberBinary.length - indexMSB - 1;
        indexLSB = numberBinary.length - indexLSB - 1;
        if (indexLSB == indexMSB) {
            throw new NullPointerException("There is no zero");
        }
        number |= (1 << indexMSB);
        number &= ~(1 << indexLSB);
        return number;
    }


    /**
     * getNextSmallest()
     * This method finds the next smallest possible number, that can occur just by switching the place of a 1,
     * in the binary representation of @number.
     * @param number
     * @return
     */
    public static int getNextSmallest(int number) {
        char[] numberBinary = Integer.toBinaryString(number).toCharArray();
        int indexLSB = -1, indexMSB = -1;
        for (int i = numberBinary.length - 1; i >= 0; i--) {
            if (indexLSB == -1 && numberBinary[i] == '1') {
                indexLSB = i;
            } else if (indexLSB != -1 && numberBinary[i] == '0') {
                indexMSB = i;
                break;
            }
        }
        if (indexLSB == -1 || indexMSB == -1) {
            throw new NullPointerException("Indexes not set");
        }
        indexLSB = numberBinary.length - indexLSB - 1;
        indexMSB = numberBinary.length - indexMSB - 1;
        if (indexLSB == indexMSB) {
            throw new NullPointerException("Indexes are the same");
        }
        number &= ~(1 << indexLSB);
        number |= (1 << indexMSB);
        return number;
    }



    public static void main(String[] args) {
        int number = 49;
        System.out.printf("Integer <%d>, binary <%s>\n", number, Integer.toBinaryString(number));
        int next = getNextLargest(number);
        System.out.printf("Integer <%d>, binary <%s>\n", next, Integer.toBinaryString(next));

        number = 49;
        System.out.printf("Integer <%d>, binary <%s>\n", number, Integer.toBinaryString(number));
        next = getNextSmallest(number);
        System.out.printf("Integer <%d>, binary <%s>\n", next, Integer.toBinaryString(next));

        number = 72;
        System.out.printf("Integer <%d>, binary <%s>\n", number, Integer.toBinaryString(number));
        next = getNextLargest(number);
        System.out.printf("Integer <%d>, binary <%s>\n", next, Integer.toBinaryString(next));

        number = 72;
        System.out.printf("Integer <%d>, binary <%s>\n", number, Integer.toBinaryString(number));
        next = getNextSmallest(number);
        System.out.printf("Integer <%d>, binary <%s>\n", next, Integer.toBinaryString(next));

    }
}
