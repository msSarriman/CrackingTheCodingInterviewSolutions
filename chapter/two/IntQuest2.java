/**
 * Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 * Hints: #8, #25, #47, #67, # 726
 * - What if you knew the linked list size? What is the difference between finding the Kth-tolast element
 * and finding the Xth element?
 * - If you don't know the linked list size, can you compute it? How does this impact the
 * runtime?
 * - Look at this graph. Is there any node you can identify that will definitely be okay to build
 * first?
 * - You might find it useful to return multiple values. Some languages don't directly support
 * this, but there are workarounds in essentially any language. What are some of those
 * workarounds?
 * - We're probably going to run this algorithm many times. If we did more preprocessing, is
 * there a way we could optimize this?
 */
package chapter.two;

import java.util.Random;
import java.util.Scanner;

/**
 * This class is a LinkedList class that can provide
 * add by addNode(T data),
 * getData(index) by getiData(int nodeIndex),
 * getSize().
 *
 * @param <T> . Type can be defined by user.
 */
class LinkedList<T> {
    LinkedList<T> next;
    T data;

    LinkedList() {
    }


    /**
     * Constructor to add first's node data upon instantiation.
     *
     * @param data = data of the first node.
     */
    LinkedList(T data) {
        this.data = data;
        this.next = new LinkedList<>();
    }


    /**
     * Method that adds a node to the LinkedList, that contains data
     *
     * @param data = the data to be contained.
     */
    protected void addNode(T data) {
        if (this.data == null) {
            this.data = data;
            this.next = new LinkedList<>();
        } else {
            addNode(data, this.next);
        }
    }


    /**
     * Overloaded method, created for recursion purposes.
     *
     * @param data
     * @param node
     */
    protected void addNode(T data, LinkedList<T> node) {
        if (node.data == null) {
            node.data = data;
            node.next = new LinkedList<>();
        } else {
            addNode(data, node.next);
        }
    }


    /**
     * This method returns the data contained in the nodeIndex'th node of the LinkedList
     *
     * @param nodeIndex = the node to retriece the data from.
     * @return the data at the specific node
     * @throws IndexOutOfBoundsException = Can throw out of bounds exception
     */
    protected T getiData(int nodeIndex) throws IndexOutOfBoundsException {
        if (nodeIndex == 0) return this.data;
        else {
            if (this.next != null) return getiData(nodeIndex - 1, this.next);
            else throw new IndexOutOfBoundsException();
        }
    }


    /**
     * Overloaded method built for recursion purposes.
     *
     * @param nodeIndex = the index to retrieve the data from
     * @param node      = the node that is currently being investigated.
     * @return = returns the data of the i'th node.
     * @throws IndexOutOfBoundsException = can throw out of bounds exception.
     */
    private T getiData(int nodeIndex, LinkedList<T> node) throws IndexOutOfBoundsException {
        if (nodeIndex == 0) return node.data;
        else {
            if (node.next != null) return getiData(nodeIndex - 1, node.next);
            else throw new IndexOutOfBoundsException();
        }
    }


    /**
     * Return the size of the linked list.
     *
     * @return = The size (int) of the LinkedList object
     */
    protected int getSize() {
        if (this.data != null && this.next.data == null) return 1;
        else return 1 + getSize(this.next);
    }


    /**
     * Method built for recursion purposes
     *
     * @param node = the node currently iterating through.
     * @return = the size of the linked list.
     */
    private int getSize(LinkedList<T> node) {
        if (node.data == null) return 0;
        if (node.data != null && node.next.data == null) return 1;
        else return 1 + getSize(node.next);
    }
}


public class IntQuest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        LinkedList<Integer> myList = new LinkedList<>();


        System.out.println("Enter the number of elements to populate the list:");
        int listSize = sc.nextInt();
        System.out.println("Which k-th from the end element do you want to retrieve:");
        int kth = sc.nextInt();


        /* Populate the LinkedList */
        for (int i = 0; i < listSize; i++) {
            myList.addNode(rand.nextInt(256));
        }

        /* Print it */
        for (int i = 0; i < listSize; i++) {
            System.out.print(myList.getiData(i) + " ");
        }
        System.out.println();

        int size = myList.getSize();
        int result = myList.getiData(size - kth);
        System.out.println("The result is: " + result);
    }
}
