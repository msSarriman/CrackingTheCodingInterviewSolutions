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
package chapter._03three;

public class IntQuest3_SetOfStacks<T> {
    protected IntQuest3_SetOfStacks<T> next;
    protected IntQuest3_SetOfStacks<T> previous;
    protected Node<T> node;
    protected int threshold;
    protected int currentSize = 0;
    protected Node<T> currentStackTop;
    /**
     * protected IntQuest3_SetOfStacks<T> currentActive;
     * This variable holds a reference to the current inner stack that the Stack is currently referring to.
     */
    protected IntQuest3_SetOfStacks<T> currentActive;


    /**
     * Constructor to create the SetOfStacks
     *
     * @param threshold = the threshold for each stack.
     */
    IntQuest3_SetOfStacks(int threshold) {
        this.next = null;
        this.previous = null;
        this.node = new Node<>();
        this.threshold = threshold;
        this.currentActive = this;
    }


    /**
     * Constructor to create the inner stacks of the stack.
     *
     * @param threshold = the threshold
     * @param node      = a pointer to the previous "element" of the stack. (To the previous plate that got washed!!)
     * @param previous  = o pointer to the previous inner stack
     */
    private IntQuest3_SetOfStacks(int threshold, Node<T> node, IntQuest3_SetOfStacks<T> previous) {
        this.next = null;
        this.previous = previous;
        this.node = new Node<>(node);
        this.threshold = threshold;
        this.currentActive = this;
    }


    /**
     * push()
     * This method pushes an element into the stack.
     * If the current stack reached it's threshold, a new stack will be created and the element will be assigned
     * to that new stack.
     *
     * @param element = The element to be added to the stack
     */
    protected void push(T element) {
        IntQuest3_SetOfStacks<T> active = this.currentActive;
        active.node.setValue(element);
        active.currentStackTop = active.node;
        active.currentSize++;
        if (active.currentSize < threshold) {
            active.node = active.node.getNext();
        } else {
            active.next = new IntQuest3_SetOfStacks<>(this.threshold, active.node, active);
            this.currentActive = active.next;
            active.node = active.next.node;
        }
    }


    /**
     * This method returns the top of the SetOfTheStacks.
     * It is also re-defines the pointers in case that a pop action passed the reference to a previous stack.
     *
     * @return = The top element of the stack
     */
    protected T pop() {
        IntQuest3_SetOfStacks<T> active = this.currentActive;
        if (active.node.getBefore() == null) return null;
        T elementToReturn = active.node.getBefore().getValue();
        if (active.node.getBefore().getBefore() == null) {
            active.node.setBefore(null);
            active.currentSize--;
        } else {
            active.node.getBefore().getBefore().setNext(active.node);
            active.node.setBefore(active.node.getBefore().getBefore());
            active.currentStackTop = active.node.getBefore();
            active.currentSize--;
            if (active.currentSize <= 0) {
                active.previous.currentActive = active.previous;
            } else if (active.currentSize == active.threshold - 1) {
                active.next = null;
            }

        }
        return elementToReturn;
    }


    /**
     * This method pops the top element of the i-th inner stack.
     * <p>
     * popAt() is faulty
     * Hint: currentStackTop not getting updated at pop()? It always return the stacks max history
     * Hint: next stack references are never deleted as intended at line 91
     *
     * @param stackNumber = the i-th inner stack
     * @return = the top of the i-th inner stack
     */
    protected T popAt(int stackNumber) {
        IntQuest3_SetOfStacks<T> currentStack = this;
        for (int i = 0; i < stackNumber; i++) {
            if (i == stackNumber - 1) return currentStack.currentStackTop.getValue();
            else {
                if (currentStack.next == null) break;
                else currentStack = currentStack.next;
            }
        }
        return null;
    }
}
