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

/**
 * This class implement a simple stack that provides
 * pop, push, minValue,  in Time=O(1)
 * <p>
 * FOLLOW UP
 * IntQuest05: isEmpty, peek;
 *
 * @param <T>
 */
public class IntQuest2_MyStack<T> {
    private Node<T> node; // Pointer to the empty top (top+1) of the stack
    private Integer minValue; // constant to min value;


    /**
     * Constructor to create the stack
     */
    IntQuest2_MyStack() {
        this.node = new Node<>();
        this.minValue = null;
    }


    /**
     * push()
     * This method pushes an element to the top of the stack
     * TimeComplexity = O(1)
     *
     * @param element
     */
    protected void push(T element) {
        updateMinValue(element);
        this.node.setValue(element);
        this.node = this.node.getNext();
    }


    /**
     * updateMinValue()
     * This element keeps track of the minimum value
     *
     * @param element
     */
    protected void updateMinValue(T element) {
        String elementClass = element.getClass().getName();
        if (element.getClass().getName().equals("java.lang.Integer")) {
            if (minValue == null) {
                minValue = (Integer) element;
            } else if (minValue > (Integer) element) {
                minValue = (Integer) element;
            }
        }
    }


    /**
     * getMin()
     * This method returns the minimum value of the stack.
     * TimeComplexity = O(1)
     *
     * @return int
     */
    protected int getMin() {
        return this.minValue;
    }


    /**
     * pop()
     * This method returns and deletes the top element, on the stack
     * TimeComplexity = O(1)
     *
     * @return T
     */
    protected T pop() {
        if (this.node.getBefore() == null) { // The stack is empty
            return null;
        }
        T valueToReturn = this.node.getBefore().getValue();
        if (this.node.getBefore().getBefore() != null) {
            this.node.getBefore().getBefore().setNext(this.node);
            this.node.setBefore(this.node.getBefore().getBefore());
        } else {
            this.node.setBefore(null);
        }
        return valueToReturn;
    }


    /**
     * peek()
     * This method returns the top element of the Stack, without deleting it.
     *
     * @return = the top element of the stack
     */
    protected T peek() {
        if (this.node.getBefore() == null) { // The stack is empty
            return null;
        }
        return this.node.getBefore().getValue();
    }


    /**
     * isEmpty()
     * This method return a boolean value regarding on if the stack is empty.
     *
     * @return true|false
     */
    protected boolean isEmpty() {
        return peek() == null;
    }
}


