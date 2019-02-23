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
public class ThreeStacks<T> {
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
    public boolean push(T element, int stack) {
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