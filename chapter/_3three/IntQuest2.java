/**
 * Stack Min: How would you design a stack which, in addition to push and pop, has a function min
 * which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 * Hints: #27, #59, #78
 * - Observe that the minimum element doesn't change very often. It only changes when a
 * smaller element is added, or when the smallest element is popped.
 * - What if we kept track of extra data at each stack node? What sort of data might make it
 * easier to solve the problem?
 * - Consider having each node know the minimum of its "substack" (all the elements
 * beneath it, including itself)
 *
 */
package chapter._3three;

public class IntQuest2 {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();

        myStack.push(5);
        myStack.push(6);
        myStack.push(7);
        myStack.push(8);
        myStack.push(9);
        System.out.println("pop:" + myStack.pop());
        System.out.println("pop:" + myStack.pop());
        System.out.println("pop:" + myStack.pop());
        myStack.push(1523);
        System.out.println("min:" + myStack.getMin());
        myStack.push(1);
        System.out.println("min:" + myStack.getMin());
        System.out.println("pop:" + myStack.pop());
        System.out.println("pop:" + myStack.pop());
        System.out.println("pop:" + myStack.pop());
        System.out.println("pop:" + myStack.pop());
    }
}
