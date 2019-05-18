package chapter._03three;

/**
 * A node class that provides a node with capabilities to link to previous and next nodes.
 *
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


    protected Node(Node<T> before) {
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
