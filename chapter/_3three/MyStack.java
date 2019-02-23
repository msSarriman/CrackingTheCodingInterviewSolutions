package chapter._3three;

/**
 * This class implement a simple stack that provides
 * pop, push, minValue in Time=O(1)
 *
 * @param <T>
 */
public class MyStack<T> {
    private Node<T> node; // Pointer to the empty top (top+1) of the stack
    private Integer minValue; // constant to min value;


    /**
     * Constructor to create the stack
     */
    MyStack() {
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
        if (this.node.getBefore() == null)
            System.out.println("The stack is empty");
        T valueToReturn = this.node.getBefore().getValue();
        if (this.node.getBefore().getBefore() != null) {
            this.node.getBefore().getBefore().setNext(this.node);
            this.node.setBefore(this.node.getBefore().getBefore());
        } else {
            this.node.setBefore(null);
        }
        return valueToReturn;
    }
}


/**
 * @param <T>
 */
class Node<T> {
    private T value;
    private Node<T> next;
    private Node<T> before;

    Node() {
        this.value = null;
        this.next = null;
        this.before = null;
    }


    private Node(Node<T> before) {
        this.value = null;
        this.next = new Node<>();
        this.before = before;
    }


    protected T getValue() {
        return this.value;
    }


    protected void setValue(T value) {
        this.value = value;
        this.next = new Node<>(this);
    }


    protected Node<T> getBefore() {
        return this.before;
    }


    protected void setBefore(Node<T> before) {
        this.before = before;
    }


    protected Node<T> getNext() {
        return this.next;
    }


    protected void setNext(Node<T> next) {
        this.next = next;
    }
}