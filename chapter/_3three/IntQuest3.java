package chapter._3three;

/**
 * Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
 * threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
 * composed of several stacks and should create a new stack once the previous one exceeds capacity.
 * SetOfStacks. push () and SetOfStacks. pop () should behave identically to a single stack
 * (that is, pop ( ) should return the same values as it would if there were just a single stack).
 * FOLLOW UP
 * Implement afunction popAt (int index) which performs a pop operation on aspecific sub-stack.
 * Hints: #64, #87
 */

public class IntQuest3 {
    public static void main(String[] args) {
        IntQuest3_SetOfStacks<Integer> mySetOfStacks = new IntQuest3_SetOfStacks<>(5);

        mySetOfStacks.push(1); // stack 1 ...
        mySetOfStacks.push(2);
        mySetOfStacks.push(3);
        mySetOfStacks.push(4);
        mySetOfStacks.push(5); // end of stack 1 // top of stack1
        mySetOfStacks.push(6); // stack 2 ...
        mySetOfStacks.push(7);
        mySetOfStacks.push(8);
        mySetOfStacks.push(9);
        mySetOfStacks.push(10); // end of stack 2 //top of stack1
        mySetOfStacks.push(11); // stack 3 ...
        mySetOfStacks.push(12);
        mySetOfStacks.push(13);
        mySetOfStacks.push(14);
        mySetOfStacks.push(15); // end of stack 3 //top of stack3
        mySetOfStacks.push(16); // stack 4 ...
        mySetOfStacks.push(17);
        mySetOfStacks.push(18);
        mySetOfStacks.push(19);

        System.out.println("popAt(): " + mySetOfStacks.popAt(1)); //5
        System.out.println("popAt(): " + mySetOfStacks.popAt(2)); //10
        System.out.println("popAt(): " + mySetOfStacks.popAt(3)); //15
        System.out.println("popAt(): " + mySetOfStacks.popAt(4)); //19
        System.out.println("popAt(): " + mySetOfStacks.popAt(5)); //null
        System.out.println("popAt(): " + mySetOfStacks.popAt(6)); //null

        System.out.println("pop(): " + mySetOfStacks.pop());
        System.out.println("pop(): " + mySetOfStacks.pop());
        System.out.println("pop(): " + mySetOfStacks.pop());
        System.out.println("pop(): " + mySetOfStacks.pop());
        System.out.println("pop(): " + mySetOfStacks.pop());
        System.out.println("pop(): " + mySetOfStacks.pop());
        System.out.println("pop(): " + mySetOfStacks.pop());
        System.out.println("pop(): " + mySetOfStacks.pop());
        System.out.println("pop(): " + mySetOfStacks.pop());
        System.out.println("pop(): " + mySetOfStacks.pop());
        System.out.println("pop(): " + mySetOfStacks.pop());
        System.out.println("pop(): " + mySetOfStacks.pop());
        System.out.println("pop(): " + mySetOfStacks.pop());
        System.out.println("pop(): " + mySetOfStacks.pop());
        System.out.println("pop(): " + mySetOfStacks.pop());
        System.out.println("pop(): " + mySetOfStacks.pop());
        System.out.println("pop(): " + mySetOfStacks.pop());
        System.out.println("pop(): " + mySetOfStacks.pop());
        System.out.println("pop(): " + mySetOfStacks.pop());
        System.out.println("pop(): " + mySetOfStacks.pop());
        System.out.println("pop(): " + mySetOfStacks.pop());
        System.out.println("pop(): " + mySetOfStacks.pop());
        System.out.println("pop(): " + mySetOfStacks.pop());
        System.out.println("pop(): " + mySetOfStacks.pop());
        System.out.println("pop(): " + mySetOfStacks.pop());
        System.out.println("pop(): " + mySetOfStacks.pop());


        /* popAt() is faulty
         * Hint: currentStackTop not getting updated at pop() ?*/
        System.out.println("popAt(): " + mySetOfStacks.popAt(1)); //1
        System.out.println("popAt(): " + mySetOfStacks.popAt(2)); //null
        System.out.println("popAt(): " + mySetOfStacks.popAt(3)); //null
        System.out.println("popAt(): " + mySetOfStacks.popAt(4)); //null
        System.out.println("popAt(): " + mySetOfStacks.popAt(5)); //null
        System.out.println("popAt(): " + mySetOfStacks.popAt(6)); //null

    }
}
