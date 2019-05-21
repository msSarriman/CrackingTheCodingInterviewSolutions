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
