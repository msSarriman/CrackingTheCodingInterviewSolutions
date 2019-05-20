/**
 * Flip Bit to Win: You have an integer and you can flip exactly one bit from a 0 to a 1.Write code to
 * find the length of the longest sequence of ls you could create.
 * EXAMPLE
 * Input: 1775 (or: 11011101111)
 * Output: 8
 * Hints: #159, #226, #314, #352
 * - Start with a brute force solution. Can you try all possibilities?
 * - Flipping a 0 to a 1 can merge two sequences of 1s-but only if the two sequences are
 * separated by only one O.
 * - Each sequence can be lengthened by merging it with an adjacent sequence (if any) or
 * just flipping the immediate neighboring zero.You just need to find the best choice.
 * - Try to do it in linear time, a single pass, and 0 (1) space.
 */
package chapter._05five;

import java.util.LinkedList;

public class IntQuest3 {


    /**
     * This method does so, by creating in a LinkedList, a representation of the binary form of the @number,
     * as follows:
     * 1s, Zeroes, 1s, Zeroes, etc....
     * e.g. 11101111011110011111[3,1,4,1,4,-1,5]
     * At even indexes there are the occurrences of the number of consecutive ones.
     * At odd indexes there is 1 or -1. 1 indicates, that there is only one zero separating the two groups on both sides
     * of it. -1 indicates that there are more than one zero, therefore the sides next to it, must not be added.
     * @param number = The number to investigate
     * @return = The number of consecutive ones.
     */
    public static int flipBitToWin(int number) {
        String binaryNumber = numberToBinary(number);
        LinkedList<Integer> myList = new LinkedList<>();
        int max = 0;
        int counter = 0;
        boolean zero = false;
        for (char c : binaryNumber.toCharArray()) {
            if (c == '1') {
                counter++;
                if (zero) {
                    myList.add(1);
                }
                zero = false;
            } else if (c == '0') {
                if (zero) {
                    myList.add(-1);
                }
                zero = true;
                myList.add(counter);
                counter = 0;
            }
        }
        myList.add(counter);
        return calculateMaxSum(myList);
    }


    /**
     * This method traverses the @myList, and calculates the maximum of pairs.
     * The pairs (found at even indexes) can only be added if the index in between them,
     * is 1. If it is -1, they must not be summed up.
     * @param myList = A list tha represent the occurences of 1s and 0s of a number's representation.
     *               e.g. [3,1,4,-1,5]. 3+4=7, 5, return 7
     * @return The maximum occurrence of the myList
     */
    private static int calculateMaxSum(LinkedList<Integer> myList) {
        int max = 0;
        LinkedList<Integer> mySums = new LinkedList<>();
        boolean flag = false;
        for (int i = 0; i < myList.size(); i++) {
            if (i % 2 == 0) {
                mySums.add(myList.get(i));
                if (mySums.size() == 2) {
                    int temp = mySums.get(0) + mySums.get(1);
                    if (max < temp) {
                        max = temp;
                    }
                    mySums.clear();
                    mySums.add(myList.get(i));
                }
            } else {
                int temp = myList.get(i);
                if (temp == -1) {
                    if (max < mySums.get(0)) {
                        max = mySums.get(0);
                    }
                    flag = false;
                    mySums.clear();
                }
            }
            if (i == myList.size() - 1) {
                int temp;
                if (mySums.size() == 2) {
                    temp = mySums.get(0) + mySums.get(1);
                } else {
                    temp = mySums.get(0);
                }
                if (max < temp) {
                    max = temp;
                }
            }
        }
        return max + 1;
    }


    /**
     * This method returns the binary representation of the @number.
     * @param number
     * @return
     */
    private static String numberToBinary(int number) {
        StringBuilder myStr = new StringBuilder();
        while (number != 0) {
            myStr.insert(0, number%2);
            number /= 2;
        }
        return myStr.toString();
    }

    public static void main(String[] args) {
        System.out.println(flipBitToWin(1775));
        System.out.println(flipBitToWin(3535));
        System.out.println(flipBitToWin(56575));

    }
}