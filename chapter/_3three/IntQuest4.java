/**
 * Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.
 * Hints: #98, #114
 * - The major difference between a queue and a stack is the order of elements. A queue
 * removes the oldest item and a stack removes the newest item. How could you remove
 * the oldest item from a stack if you only had access to the newest item?
 * - We can remove the oldest item from a stack by repeatedly removing the newest item
 * (inserting those into the temporary stack) until we get down to one element. Then, after
 * we've retrieved the newest item, putting all the elements back. The issue with this is
 * that doing several pops in a row will require 0 (N) work each time. Can we optimize for
 * scenarios where we might do several pops in a row?
 */
package chapter._3three;

import java.util.Stack;

public class IntQuest4 {

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.push(5);
        myQueue.push(6);
        myQueue.push(7);

        System.out.println("peek " + myQueue.peek());

        System.out.println("pop " + myQueue.pop());
        System.out.println("pop " + myQueue.pop());
        System.out.println("pop " + myQueue.pop());
        System.out.println("pop " + myQueue.pop());

        myQueue.push(9);
        myQueue.push(10);
        myQueue.push(11);

        System.out.println("peek " + myQueue.peek());

        System.out.println("pop " + myQueue.pop());
        System.out.println("pop " + myQueue.pop());
        System.out.println("pop " + myQueue.pop());
        System.out.println("pop " + myQueue.pop());

    }
}

class MyQueue<T> {
    Stack<T> newStack, oldStack;

    MyQueue() {
        newStack = new Stack<>();
        oldStack = new Stack<>();
    }

    protected void push(T element) {
        if (!oldStack.empty()) {
            oldToNew();
        }
        newStack.push(element);
    }


    protected T peek() {
        newToOld();
        if (!newStack.empty()) {
            return newStack.peek();
        }
        return null;
    }


    protected T pop() {
        newToOld();
        if (!newStack.empty()) {
            return newStack.pop();
        }
        return null;
    }


    protected void oldToNew() {
        if (!newStack.empty()) {
            while (!oldStack.empty()) {
                newStack.push(oldStack.pop());
            }
        }
    }


    protected void newToOld() {
        if (!oldStack.empty()) {
            while (!newStack.empty()) {
                oldStack.push(newStack.pop());
            }
        }
    }
}
