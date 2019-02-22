/**
 * Sum Lists: You have two numbers represented by a linked list, where each node contains a single
 * digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a
 * function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (7-) 1 -) 6) + (5 -) 9 -) 2) .Thatis,617 + 295.
 * Output: 2 -) 1 -) 9.That is, 912.
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * EXAMPLE
 * Input: (6 -) 1 -) 7) + (2 -) 9 -) 5).Thatis,617 + 295.
 * Output: 9 -) 1 -) 2.That is, 912.
 * Hints: #7, #30, #71, #95, #109
 * - Of course, you could convert the linked lists to integers, compute the sum, and then
 * convert it back to a new linked list. If you did this in an interview, your interviewer would
 * likely accept the answer, and then see if you could do this without converting it to a
 * number and back.
 * - Try recursion. Suppose you have two lists, A = 1- >5 - >9 (representing 951) and B
 * 2 - >3 - >6 - > 7 (representing 7632), and afunction that operates on the remainder of the
 * lists (5 - >9 and 3- >6 - >7). Could you use this to create the sum method? What is the
 * relationship between sum(1->5->9, 2->3->6->7) and sum(5->9, 3->6->7)?
 * - Make sure you have considered linked lists that are not the same length.
 * - Does your algorithm work on linked lists like 9->7->8 and 6->8->5? Double check that.
 * - For the follow-up question:The issue is that when the linked lists aren't the same length,
 * the head of one linked list might represent the 1000's place while the other represents
 * the 1D's place. What if you made them the same length? Is there a way to modify the
 * linked list to do that, without changing the value it represents?
 */
package chapter.two;

import java.util.Random;

public class IntQuest5 {
    /**
     * This function sums into the result List, the needs of the current question.
     * @param number1 = the first number
     * @param number2 = the second number
     * @param result = the result of the 2 numbers
     */
    public static void addNumberLists(MyLinkedList<Integer> number1, MyLinkedList<Integer> number2, MyLinkedList<Integer> result) {
        int maxSize = number1.getSize() > number2.getSize() ? number1.getSize() : number2.getSize();
        int remaining = 0;
        for(int i = 0; i < maxSize; i++) {
            int value1 = i < number1.getSize() ? number1.getiData(i) : 0;
            int value2 = i < number2.getSize() ? number2.getiData(i) : 0;
            int tempRes = (value1 + value2) % 10;
            result.addNode(remaining == 1 ? (tempRes+1) : tempRes);
            remaining = (value1 + value2) / 10;
        }
        if (remaining == 1) result.addNode(1);
    }


    public static void main(String[] args) {
        MyLinkedList<Integer> number1 = new MyLinkedList<>();
        MyLinkedList<Integer> number2 = new MyLinkedList<>();

        Random rand = new Random();
        for (int i = 0; i < rand.nextInt(6)+1; i++) {
            number1.addNode(rand.nextInt(8)+1);
        }
        for (int i = 0; i < rand.nextInt(6)+1; i++) {
            number2.addNode(rand.nextInt(8)+1);
        }

        number1.printList();
        number2.printList();

        MyLinkedList<Integer> result = new MyLinkedList<>();
        addNumberLists(number1, number2, result);
        result.printList();
    }
}
