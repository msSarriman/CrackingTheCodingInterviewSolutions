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
 * Three in One: Describe how you could use a single array to implement three stacks.
 * Hints: #2, #72, #38, #58
 * - A stack is simply a data structure in which the most recently added elements are
 * removed first. Can you simulate a single stack using an array? Remember that there are
 * many possible solutions, and there are tradeoffs of each.
 * - Picture the list 1- > 5- >9 - >12.Removing 9 would make it look like 1- > 5 - >12.You only
 * have access to the 9 node. Can you make it look like the correct answer?
 * - If you want to allow for flexible divisions, you can shift stacks around. Can you ensure
 * that all available capacity is used?
 * - Try thinking about the array as circular, such that the end of the array "wraps around" to
 * the start of the array.
 */
package chapter._03three;

public class IntQuest1 {
    public static void main(String[] args) {
        IntQuest1_ThreeStacks<Integer> myStacks = new IntQuest1_ThreeStacks<>(10);

        myStacks.push(1, 1);
        myStacks.push(2, 1);
        myStacks.push(3, 1);
        myStacks.push(4, 1);
        myStacks.push(5, 1);
        myStacks.push(6, 1);
        myStacks.push(7, 1);
        myStacks.push(8, 1);
        myStacks.push(9, 1);
        myStacks.push(0, 1); // Stack 1 gets full
        myStacks.push(10, 1); // this addition will not take place

        myStacks.push(21, 2);
        myStacks.push(22, 2);
        myStacks.push(23, 2);
        myStacks.push(24, 2);
        myStacks.push(25, 2);
        myStacks.push(26, 2);
        myStacks.push(27, 2);
        myStacks.push(28, 2);
        myStacks.push(29, 2);
        myStacks.push(20, 2); // stack 2 gets full

        myStacks.push(31, 3);
        myStacks.push(32, 3);
        myStacks.push(33, 3);
        myStacks.push(34, 3);
        myStacks.push(35, 3);
        myStacks.push(36, 3);
        myStacks.push(37, 3);
        myStacks.push(38, 3);
        myStacks.push(39, 3);
        myStacks.push(30, 3); // stack 3 gets full

        myStacks.printStack(1);
        myStacks.printStack(2);
        myStacks.printStack(3);

        System.out.println("Peek stack 1: " + myStacks.peek(1));
        System.out.println("Peek stack 2: " + myStacks.peek(2));
        System.out.println("Peek stack 3: " + myStacks.peek(3));

        System.out.println("Pop stack 1: " + myStacks.pop(1));
        System.out.println("Pop stack 1: " + myStacks.pop(1));
        System.out.println("Pop stack 1: " + myStacks.pop(1));
        System.out.println("Pop stack 2: " + myStacks.pop(2));
        System.out.println("Pop stack 2: " + myStacks.pop(2));
        System.out.println("Pop stack 3: " + myStacks.pop(3));
        System.out.println("Pop stack 3: " + myStacks.pop(3));
        System.out.println("Pop stack 3: " + myStacks.pop(3));
        System.out.println("Pop stack 3: " + myStacks.pop(3));

        System.out.println("Size of stack1: " + myStacks.getSize(1));
        System.out.println("Size of stack2: " + myStacks.getSize(2));
        System.out.println("Size of stack3: " + myStacks.getSize(3));

        myStacks.printStack(1);
        myStacks.printStack(2);
        myStacks.printStack(3);
    }
}
