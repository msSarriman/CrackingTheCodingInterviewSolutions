package chapter._02two;

import java.util.*;

/**
 * This Class simulates some basic functionalities of a LinkedList.
 * Functions implemented:
 * void addNode(T data)
 * T getiData(int nodeIndex)
 * int getSize()
 * void removeNotEdge(int index)
 * MyLinkedList<T> getTail()
 * MyLinkedList<Integer> partitionList(MyLinkedList<Integer> list, int pivotElement)
 * void printList()
 * MyLinkedList getHead()
 * boolean isPalindrome()
 * MyLinkedList getNode(int index)
 * void addNodeByReference(Util_Node node)
 *
 * @param <T> . Type can be defined by user.
 */
class MyLinkedList<T> implements Iterable<T> {
    private MyLinkedList<T> next;
    private Node<T> data;


    MyLinkedList() {
        this.data = new Node<>();
    }


    /**
     * Constructor to add first's node data upon instantiation.
     *
     * @param data = data of the first node.
     */
    MyLinkedList(T data) {
        this.data = new Node<>(data);
        this.next = new MyLinkedList<>();
    }


    /**
     * addNode
     * Method that adds a node to the MyLinkedList, that contains data
     *
     * @param data = the data to be contained.
     */
    protected void addNode(T data) {
        if (this.data.getData() == null) {
            this.data.setData(data);
            this.next = new MyLinkedList<>();
        } else {
            addNode(data, this.next);
        }
    }

    private void addNode(T data, MyLinkedList<T> node) {
        if (node.data.getData() == null) {
            node.data.setData(data);
            node.next = new MyLinkedList<>();
        } else {
            addNode(data, node.next);
        }
    }


    /**
     * getiData
     * This method returns the data contained in the nodeIndex'th node of the MyLinkedList
     * TimeComplexity = O(N)
     *
     * @param nodeIndex = the node to retriece the data from.
     * @return the data at the specific node
     * @throws IndexOutOfBoundsException = Can throw out of bounds exception
     */
    protected T getiData(int nodeIndex) throws IndexOutOfBoundsException {
        if (nodeIndex == 0) return this.data.getData();
        else {
            if (this.next != null) return getiData(nodeIndex - 1, this.next);
            else throw new IndexOutOfBoundsException();
        }
    }

    private T getiData(int nodeIndex, MyLinkedList<T> node) throws IndexOutOfBoundsException {
        if (nodeIndex == 0) return node.data.getData();
        else {
            if (node.next != null) return getiData(nodeIndex - 1, node.next);
            else throw new IndexOutOfBoundsException();
        }
    }


    /**
     * getSize()
     * Return the size of the linked list.
     * TimeComplexity = O(N)
     *
     * @return = The size (int) of the MyLinkedList object
     */
    protected int getSize() {
        if (this.data.getData() != null && this.next.data.getData() == null) return 1;
        else return 1 + getSize(this.next);
    }

    private int getSize(MyLinkedList<T> node) {
        if (node.data.getData() == null) return 0;
        else return 1 + getSize(node.next);
    }


    /**
     * removeNotEdge()
     * Method to remove a node from the MyLinkedList, that does not belong at the edges.
     *
     * @param index = the index of the node.
     */
    protected void removeNotEdge(int index) {
        if (index < 0) return;
        if (index > this.getSize()) return;
        if (index == 0 || index == (this.getSize() - 1)) {
            System.out.println("Do not provide me an edge!!!");
            return;
        }
        if (index - 1 == 0) {
            this.next = this.next.next;
            return;
        }
        removeNotEdge(--index, this.next);
    }

    private void removeNotEdge(int index, MyLinkedList<T> node) {
        if (index - 1 == 0) {
            node.next = node.next.next;
        } else {
            removeNotEdge(--index, node.next);
        }
    }


    /**
     * getTail()
     * Method to retrieve the tail.
     *
     * @return the tail of the LinkedList.
     */
    protected MyLinkedList<T> getTail() {
        if (next.data.getData() == null) return this;
        else return getTail(this.next);
    }

    private MyLinkedList<T> getTail(MyLinkedList node) {
        if (node.next.data.getData() == null) return node;
        else return getTail(node.next);
    }


    /**
     * partitionList()
     * This method partitions a given T->Integer list. The partition is taking place based on the @pivotElement.
     * The partition breaks the list into _02two halves.
     * The first half contains all those numbers of the list, that are smaller than the pivotELement.
     * The second half contains all those numbers of the list, that are greater or equal than the pivotElement.
     * TimeComplexity = O(N)
     *
     * @param list         = The list to be partitioned.
     * @param pivotElement = The element to partition the list.
     * @return = The partitioned list.
     */
    protected MyLinkedList<Integer> partitionList(MyLinkedList<Integer> list, int pivotElement) {
        MyLinkedList<Integer> bufferListLeft = new MyLinkedList<>();
        MyLinkedList<Integer> bufferListRight = new MyLinkedList<>();
        for (Integer i : list) {
            if (i < pivotElement) {
                bufferListLeft.addNode(i);
            } else {
                bufferListRight.addNode(i);
            }
        }
        list.data = null;
        list.next = null;
        for (Integer i : bufferListLeft) {
            list.addNode(i);
        }
        for (Integer i : bufferListRight) {
            list.addNode(i);
        }
        return list;
    }


    /**
     * printList()
     * Simple void method that prints all the elements on the list.
     */
    protected void printList() {
        for (T i : this) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    /**
     * getHead()
     * Return a reference to the head of the LinkedList;
     *
     * @return a Reference to the head of the LinkedList;
     */
    protected MyLinkedList getHead() {
        return this;
    }


    /**
     * isPalindrome()
     * This method checks if the instance of the LinkedList is a palindrome.
     * TimeComplexity = O(N)
     * SpaceComplexity = O(N+(M/2))
     *
     * @return true|false
     */
    protected boolean isPalindrome() {
        Stack<T> myStack = new Stack<>();
        int listSize = this.getSize();
        for (int i = 0; i < listSize; i++) {
            if (listSize % 2 == 1 && i == (listSize / 2)) continue;
            T currentValue = this.getiData(i);
            if (i < (listSize / 2)) {
                myStack.add(currentValue);
            } else {
                if (myStack.peek() != currentValue) {
                    return false;
                } else {
                    myStack.pop();
                }
            }
        }
        return true;
    }


    /**
     * getNode()
     * This method and its overloaded function, server the purpose of returning a reference to the Util_Node
     * with the index given as parameter to the function
     * TimeComplexity = O(N)
     *
     * @param index = the i-th node to retrieve
     * @return = Reference to i-th node
     */
    protected MyLinkedList getNode(int index) {
        if (index == 0) return this;
        else return getNode(--index, this.next);
    }

    private MyLinkedList getNode(int index, MyLinkedList node) throws IndexOutOfBoundsException {
        if (index == 0) return node;
        else {
            if (node.next == null) throw new IndexOutOfBoundsException();
            else return getNode(--index, node.next);
        }
    }


    /**
     * addNodeByReference()
     * Adds a note to the LinkedList, by reference to a Util_Node object.
     *
     * @param node = a Util_Node object to add to the list
     */
    protected void addNodeByReference(Node<T> node) {
        MyLinkedList lastNull = getTail().next;
        lastNull.data = node;
        lastNull.next = new MyLinkedList<>();
    }


    /**
     * iterator()
     * Method that implements the for each function for the list's elements.
     *
     * @return forEach iterator on the list
     */
    @Override
    public Iterator<T> iterator() {
        return new CustomIterator<>(this);
    }


    /**
     * class CustomIterator<T>
     * List's iterator implementation.
     *
     * @param <T>
     */
    class CustomIterator<T> implements Iterator<T> {
        MyLinkedList<T> node;

        CustomIterator(MyLinkedList<T> node) {
            this.node = node.getHead();
        }

        @Override
        public boolean hasNext() {
            return (node.data.getData() != null);
        }

        @Override
        public T next() {
            T data = node.data.getData();
            node = node.next;
            return data;
        }
    }


    /**
     * getNodeReference()
     * Returns a reference to the node of the current link.
     *
     * @return
     */
    protected Node getNodeReference() {
        return this.data;
    }


    /**
     * overlapping()
     * This static method can check if the _02two given as parameters lists, overlap.
     * It returns the first node that they overlapping.
     * TimeComplexity = O(N)
     * SpaceComplexity = O(N+M)
     *
     * @param list1 = the first list
     * @param list2 = the second list
     * @return a reference to the node that the lists are overlapping
     */
    protected static MyLinkedList overlapping(MyLinkedList list1, MyLinkedList list2) {
        Set<Integer> mySet = new HashSet<>();
        for (int i = 0; i < list1.getSize(); i++) {
            Integer temp = System.identityHashCode(list1.getNode(i).getNodeReference());
            mySet.add(temp);
        }
        for (int i = 0; i < list1.getSize(); i++) {
            MyLinkedList tempMyLL = list2.getNode(i);
            Node tempNode = tempMyLL.getNodeReference();
            Integer tempValue = System.identityHashCode(tempNode);
            if (mySet.contains(tempValue)) {
                return tempMyLL;
            }
        }
        return null;
    }


    /**
     * isCircular()
     * This method checks is the object that is calling it, is a circular linkedList.
     *
     * @return true|false
     */
    protected boolean isCircular() {
        Set<Integer> mySet = new HashSet<>();
        for (int i = 0; i < this.getSize(); i++) {
            int temp = System.identityHashCode(getNode(i).getNodeReference());
            if (mySet.contains(temp)) return true;
            else mySet.add(temp);
        }
        return false;
    }
}

class Node<T> {
    private T data;


    Node() {
        this.data = null;
    }


    Node(T data) {
        this.data = data;
    }

    protected void setData(T data) {
        this.data = data;
    }


    protected T getData() {
        return this.data;
    }
}
