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
/**
 * Intersection: Given _02two (singly) linked lists, determine if the _02two lists intersect. Return the intersecting node.
 * Note that the intersection is defined based on reference, not value. That is, if the kth
 * node of the first linked list is the exact same node (by reference) as the jth node of the second
 * linked list, then they are intersecting.
 * Hints: #20, #45, #55, #65, #76, #93, #111, #120, #129
 * - You can do this in 0 (A+B) time and 0 (1) additional space. That is, you do not need a
 * hash table (although you could do it with _01one).
 * - Examples will help you. Draw a picture of intersecting linked lists and _02two equivalent
 * linked lists (by value) that do not intersect.
 * - Focus first on just identifying if there's an intersection
 * - Observe that _02two intersecting linked lists will always have the same last node. Once they
 * intersect, all the nodes after that will be equal.
 * - You can determine if _02two linked lists intersect by traversing to the end of each and
 * comparing their tails.
 * - Now, you need to find where the linked lists intersect. Suppose the linked lists were the
 * same length. How could you do this?
 */
package chapter._02two;


import static chapter._02two.MyLinkedList.overlapping;

public class IntQuest7 {

    public static void main(String[] args) {
        MyLinkedList<Integer> list1 = new MyLinkedList<>();
        MyLinkedList<Integer> list2 = new MyLinkedList<>();

        list1.addNode(4);
        list2.addNode(7);
        list2.addNode(19);

        Node<Integer> node = new Node<>(352);
        list1.addNodeByReference(node);
        list2.addNodeByReference(node);

        Node<Integer> node1 = new Node<>(354);
        list1.addNodeByReference(node1);
        list2.addNodeByReference(node1);

        list1.printList();
        list2.printList();

        System.out.println(overlapping(list1, list2)); // those lists are overlapping;

        MyLinkedList<Integer> list3 = new MyLinkedList<>();
        list3.addNode(3);
        list3.addNode(4);
        System.out.println(overlapping(list1, list3)); // those lists are not overlapping;


    }
}
