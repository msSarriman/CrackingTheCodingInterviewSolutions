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
package chapter._02two;

public class IntQuest8 {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addNode(3);
        list.addNode(5);
        list.addNode(9);

        Node<Integer> node1 = new Node<>(15);
        Node<Integer> node2 = new Node<>(16);
        Node<Integer> node3 = new Node<>(17);
        Node<Integer> node4 = new Node<>(18);
        Node<Integer> node5 = new Node<>(19);

        list.addNodeByReference(node1);
        list.addNodeByReference(node2);
        list.addNodeByReference(node3);
        list.addNodeByReference(node4);
        list.addNodeByReference(node5);
        list.addNodeByReference(node1);
        System.out.println(list.isCircular()); // Should be true;


        MyLinkedList<Integer> list1 = new MyLinkedList<>();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(3);
        list1.addNode(4);
        list1.addNode(5);
        System.out.println(list1.isCircular()); // Should be false;
    }
}
