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
 */
package chapter._03three;

public class IntQuest2 {
    public static void main(String[] args) {
        IntQuest2_MyStack<Integer> myStack = new IntQuest2_MyStack<>();

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
        System.out.println("pop:" + myStack.pop());
        System.out.println("pop:" + myStack.pop());
        System.out.println("pop:" + myStack.pop());
        System.out.println("pop:" + myStack.pop());
        System.out.println("pop:" + myStack.pop());
        System.out.println("pop:" + myStack.pop());
        System.out.println("pop:" + myStack.pop());
        System.out.println("pop:" + myStack.pop());
        System.out.println("pop:" + myStack.pop());
        System.out.println("pop:" + myStack.pop());
        System.out.println("pop:" + myStack.pop());
        System.out.println("pop:" + myStack.pop());
    }
}
