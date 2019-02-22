package chapter.two;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * This class is a MyLinkedList class that can provide
 * add by addNode(T data),
 * getData(index) by getiData(int nodeIndex),
 * getSize().
 *
 * @param <T> . Type can be defined by user.
 */
class MyLinkedList<T> implements Iterable<T> {
    MyLinkedList<T> next;
    T data;

    MyLinkedList() {
    }


    /**
     * Constructor to add first's node data upon instantiation.
     *
     * @param data = data of the first node.
     */
    MyLinkedList(T data) {
        this.data = data;
        this.next = new MyLinkedList<>();
    }


    /**
     * Method that adds a node to the MyLinkedList, that contains data
     *
     * @param data = the data to be contained.
     */
    protected void addNode(T data) {
        if (this.data == null) {
            this.data = data;
            this.next = new MyLinkedList<>();
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
    protected void addNode(T data, MyLinkedList<T> node) {
        if (node.data == null) {
            node.data = data;
            node.next = new MyLinkedList<>();
        } else {
            addNode(data, node.next);
        }
    }


    /**
     * This method returns the data contained in the nodeIndex'th node of the MyLinkedList
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
    private T getiData(int nodeIndex, MyLinkedList<T> node) throws IndexOutOfBoundsException {
        if (nodeIndex == 0) return node.data;
        else {
            if (node.next != null) return getiData(nodeIndex - 1, node.next);
            else throw new IndexOutOfBoundsException();
        }
    }


    /**
     * Return the size of the linked list.
     *
     * @return = The size (int) of the MyLinkedList object
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
    private int getSize(MyLinkedList<T> node) {
        if (node.data == null) return 0;
        else return 1 + getSize(node.next);
    }


    /**
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


    /**
     * Overloaded method for recursion purposes.
     *
     * @param index = index to remove
     * @param node  = the current node
     */
    private void removeNotEdge(int index, MyLinkedList<T> node) {
        if (index - 1 == 0) {
            node.next = node.next.next;
        } else {
            removeNotEdge(--index, node.next);
        }
    }


    /**
     * Method to return the head of the LinkedList object
     *
     * @return the head of the linked list object.
     */
    protected MyLinkedList<T> getHead() {
        return this;
    }


    /**
     * Method with overloaded version, to retrieve the tail.
     *
     * @return the tail of the LinkedList.
     */
    protected MyLinkedList<T> getTail() {
        if (next.data == null) return this;
        else return getTail(this.next);
    }

    private MyLinkedList<T> getTail(MyLinkedList<T> node) {
        if (node.next.data == null) return this;
        else return getTail(node.next);
    }


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

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator<>(this);
    }


    class CustomIterator<T> implements Iterator<T> {
        MyLinkedList<T> node;

        CustomIterator(MyLinkedList<T> node) {
            this.node = node.getHead();
        }

        @Override
        public boolean hasNext() {
            return (node.data != null);
        }

        @Override
        public T next() {
            T data = node.data;
            node = node.next;
            return data;
        }
    }
}
