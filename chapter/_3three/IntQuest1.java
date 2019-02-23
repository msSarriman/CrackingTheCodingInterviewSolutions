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
package chapter._3three;


/**
 * This class is virtualizing the idea of 3 stacks into a single array.
 * The above is done by splitting the indexes of the array, into 3 sets. Each set is the multiple of 3, starting from 0.
 * e.g.
 * Stack 1: indexes @ 0,3,6,9,...... myArray.length
 * Stack 2: indexes @ 1,4,7,10,...... myArray.length-1
 * Stack 3: indexes @ 2,5,8,11,...... myArray.length-2
 *
 * @param <T> the type of the array's elements.
 */
class ThreeStacks<T> {
    T[] myArray;        // The array to include the 3 stacks into.
    int[] nextIndex;    // A 3 cell array. Each array will constantly contain the next available index of the corresponding stack.


    /**
     * This constructor initializes the DataStructure.
     *
     * @param size
     */
    public ThreeStacks(int size) {
        this.myArray = (T[]) new Object[size * 3];
        this.nextIndex = new int[]{0, 1, 2};
    }


    /**
     * This method adds an element to the corresponding stack.
     *
     * @param element = the element to be added to the corresponding stack.
     * @param stack   = the stack to add the element to.
     * @return = true|false
     */
    public boolean add(T element, int stack) {
        if (!(stack >= 1 && stack <= 3) && isFull(stack))
            return false;
        if (isFull(stack)) {
            return false;
        }
        int availableIndex = getAvailableIndex(stack);
        set(element, availableIndex);
        return true;
    }


    /**
     * This method check if the corresponding stack is full
     *
     * @param stack = Stack to check
     * @return true|false
     */
    public boolean isFull(int stack) {
        int i = stack - 1;
        int length = myArray.length;
        for (; i < length; i += 3) {
            if (myArray[i] == null) return false;
        }
        return true;
    }


    /**
     * The method returns the next available index on the corresponding stack.
     *
     * @param stack = the stack to retrieve the next available index.
     * @return = the next available index
     */
    public int getAvailableIndex(int stack) {
        int indexToReturn = nextIndex[stack - 1];
        nextIndex[stack - 1] = (nextIndex[stack - 1] + 3) % myArray.length;
        return indexToReturn;
    }


    /**
     * Setter for the element at the i-th position of the myArray
     *
     * @param element        = element to add at the i-th position
     * @param availableIndex = the i-th position
     */
    public void set(T element, int availableIndex) {
        myArray[availableIndex] = element;
    }


    /**
     * The method return the top of the stack
     *
     * @param stack = the stack to peek from
     * @return = the top of the stack
     */
    public T peek(int stack) {
        int index = nextIndex[stack - 1] - 3 < 0 ? nextIndex[stack - 1] - 3 + myArray.length : nextIndex[stack - 1] - 3;
        return myArray[index];
    }


    /**
     * This method removes the top from the stack and returns it.
     * The next element (if (element)) will be the next top of the corresponding stack.
     *
     * @param stack = the stack to pop() from.
     * @return = the element at the top of the stack.
     */
    public T pop(int stack) {
        int index = nextIndex[stack - 1] - 3 < 0 ? nextIndex[stack - 1] - 3 + myArray.length : nextIndex[stack - 1] - 3;
        T valueToReturn = myArray[index];
        nextIndex[stack - 1] = index;
        myArray[index] = null;
        return valueToReturn;
    }


    /**
     * This method return the current number of element at the corresponding stack.
     *
     * @param stack = The stack to check.
     * @return = The elements of the corresponding stack.
     */
    public int getSize(int stack) {
        int start = nextIndex[stack - 1] - 3 < 0 ? nextIndex[stack - 1] - 3 + myArray.length : nextIndex[stack - 1] - 3;
        int i = start;
        int size = 0;
        while (myArray[i] != null) {
            size++;
            i = i - 3 < 0 ? i - 3 + myArray.length : i - 3;
            if (start == i) break;
        }
        return size;
    }


    /**
     * This method returns the maxSize of each stack.
     *
     * @return
     */
    public int getMaxSize() {
        return myArray.length / 3;
    }


    /**
     * This method prints a stack from top to bottom.
     *
     * @param stack = the stack to print.
     */
    public void printStack(int stack) {
        if (getSize(stack) == 0) {
            System.out.println("Stack is empty");
        }
        System.out.print("Printing stack " + stack + ": ");
        int length = myArray.length;
        int start = nextIndex[stack - 1] - 3 < 0 ? nextIndex[stack - 1] - 3 + length : nextIndex[stack - 1] - 3;
        int index = start;
        while (myArray[index] != null) {
            System.out.print(myArray[index] + " ");
            index = index - 3 < 0 ? index - 3 + length : index - 3;
            if (index == start) break;
        }
        System.out.println();
    }
}

public class IntQuest1 {
    public static void main(String[] args) {
        ThreeStacks<Integer> myStacks = new ThreeStacks<>(10);

        myStacks.add(1, 1);
        myStacks.add(2, 1);
        myStacks.add(3, 1);
        myStacks.add(4, 1);
        myStacks.add(5, 1);
        myStacks.add(6, 1);
        myStacks.add(7, 1);
        myStacks.add(8, 1);
        myStacks.add(9, 1);
        myStacks.add(0, 1); // Stack 1 gets full
        myStacks.add(10, 1); // this addition will not take place

        myStacks.add(21, 2);
        myStacks.add(22, 2);
        myStacks.add(23, 2);
        myStacks.add(24, 2);
        myStacks.add(25, 2);
        myStacks.add(26, 2);
        myStacks.add(27, 2);
        myStacks.add(28, 2);
        myStacks.add(29, 2);
        myStacks.add(20, 2); // stack 2 gets full

        myStacks.add(31, 3);
        myStacks.add(32, 3);
        myStacks.add(33, 3);
        myStacks.add(34, 3);
        myStacks.add(35, 3);
        myStacks.add(36, 3);
        myStacks.add(37, 3);
        myStacks.add(38, 3);
        myStacks.add(39, 3);
        myStacks.add(30, 3); // stack 3 gets full

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
