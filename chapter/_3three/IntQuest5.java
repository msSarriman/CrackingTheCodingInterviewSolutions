/**
 * Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
 * an additional temporary stack, but you may not copy the elements into any other data structure
 * (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty.
 * Hints: # 15, #32, #43
 * - One way of sorting an array is to iterate through the array and insert each element into
 * a new array in sorted order. Can you do this with a stack?
 * - Imagine your secondary stack is sorted. Can you insert elements into it in sorted order?
 * You might need some extra storage. What could you use for extra storage?
 * - Keep the secondary stack in sorted order, with the biggest elements on the top.Use the
 * primary stack for additional storage.
 */
package chapter._3three;

public class IntQuest5 {


    /**
     * This method sorts the stack given as a parameter.
     * It does so by using another tempStack and a tempValue;
     * While there are elements in @myStack, the algorithm places the elements in desc order into tempStack.
     * The top value of @myStack is pop-ed and held into a tempValue.
     * While tempValue > tempStack.peek(), we are pop-ing the elements of tempStack into @mystack, until we
     * push(tempValue) into it.
     * Finally we are emptying tempStack into @myStack and the elements will be in ascending order.
     *
     * @param myStack = The stack to be sorted
     */
    public static void sortStack(IntQuest2_MyStack<Integer> myStack) {
        IntQuest2_MyStack<Integer> tempStack = new IntQuest2_MyStack<>();
        Integer tempValue;

        while (!myStack.isEmpty()) {
            int numberOfPops = 0;
            if (tempStack.isEmpty()) {
                tempStack.push(myStack.pop());
            } else {
                tempValue = myStack.pop();
                while(true) {
                    Integer currentTop = tempStack.peek();
                    if (tempStack.isEmpty()) {
                        tempStack.push(tempValue);
                        break;
                    }
                    if (currentTop < tempValue) {
                        tempStack.push(tempValue);
                        break;
                    } else {
                        myStack.push(tempStack.pop());
                        numberOfPops++;
                    }
                }
                for (int i = 0; i < numberOfPops; i++) {
                    tempStack.push(myStack.pop());
                }
            }
        }
        while (!tempStack.isEmpty()) {
            myStack.push(tempStack.pop());
        }
    }


    public static void main(String[] args) {
        IntQuest2_MyStack<Integer> myStack = new IntQuest2_MyStack<>();

        myStack.push(7);
        myStack.push(2);
        myStack.push(9);
        myStack.push(1);
        myStack.push(19);
        /* Current stack state : 19 -> 1 -> 9 -> 2 -> 7 */

        sortStack(myStack);

        System.out.println("Printing stack ordered:");
        while (!myStack.isEmpty()) {
            System.out.print(" " + myStack.pop());
        }
        System.out.println();
    }
}
