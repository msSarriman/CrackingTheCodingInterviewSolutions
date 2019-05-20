/**
 * Debugger: Explain what the following code does: ( (n & (n - 1) ) == 0) .
 * Hints: #151, #202, #261, #302, #346, #372, #383, #398
 * - Reverse engineer this, starting from the outermost layer to the innermost layer.
 * - What does it mean if A & B == 0?
 * - If A & B == 0, then it means that A and B never have a 1 at the same spot. Apply this
 * to the equation in the problem.
 * - If (n & (n - 1)) == 0, then this means that n and n - 1 never have a 1 in the same
 * spot. Why would that happen?
 * - What is the relationship between how n looks and how n - 1 looks? Walk through a
 * binary subtraction
 * - When you do a binary subtraction, you flip the rightmost Os to a 1, stopping when you
 * get to a 1 (which is also flipped). Everything (all the 1s and Os) on the left will stay put
 * - Picture nand n -1.To subtract 1 from n, you flipped the rightmost 1 to a 0 and all the Os
 * on its right to 1s. lf n & n-1 == e,then there are no 1s to the left of the first 1. What
 * does that mean about n?
 * - We know that n must have only one 1 if n & (n -1) == e.What sorts of numbers have
 * only one 1?
 */
package chapter._05five;

public class IntQuest5 {
    /**
     * A & B == 0, when A and B have no common bits set to 1.
     * In this case A = n
     * and          B = n - 1
     * What happens at bit subtraction: (?)
     * 110 0001 0000
     *           - 1
     * -------------
     * 110 0000 1111
     * So all zero bits until the first one, are set to 1, and the first 1 is set to zero. Of course if there was a case
     * of 1 - 1, the only case would be that the first bit would become zero.
     *
     * So we are looking for numbers that are complements of one to another, after the substraction of 1.
     * That means,
     * 1 will become 0, 10 will become 01, 100 will become 011, etc...
     * Answer:
     * So n corresponds to numbers that are a power of two, including zero.
     */
}
