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
