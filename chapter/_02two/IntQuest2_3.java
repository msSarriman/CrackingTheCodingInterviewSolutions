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
 * 2)
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
 * 3)
 * Delete Middle Util_Node: Implement an algorithm to delete a node in the middle (i.e., any node but
 * the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
 * that node.
 * EXAMPLE
 * Input: the node c from the linked list a- >b- >c - >d - >e- >f
 * Result: nothing is returned, but the new linked list looks like a - >b- >d - >e- >f
 * Hints: #72
 * - Picture the list 1- > 5- >9 - >12.Removing 9 would make it look like 1- > 5 - >12.You only
 * have access to the 9 node. Can you make it look like the correct answer?
 */
package chapter._02two;

import java.util.Random;
import java.util.Scanner;


public class IntQuest2_3 {
    private static void printList(MyLinkedList<Integer> list) {
        for (int i = 0; i < list.getSize(); i++){
            System.out.print(list.getiData(i) + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        MyLinkedList<Integer> myList = new MyLinkedList<>();


        System.out.print("Enter the number of elements to populate the list:");
        int listSize = sc.nextInt();
        sc.nextLine();


        /* Populate the LinkedList */
        for (int i = 0; i < listSize; i++) {
            myList.addNode(rand.nextInt(256));
        }

        /* Print it */
        for (int i = 0; i < listSize; i++) {
            System.out.print(myList.getiData(i) + " ");
        }
        System.out.println();

        /*
        Simple command line interface:
        <command> <value>
        <command> : <getKend>, <add>, <getSize>, <remove>, <exit>
        <value>   : Integer
        Be aware at inputs as no exception is being handled.
         */
        while (true) {
            System.out.print("$");
            String cmd = sc.nextLine();
            String[] s = cmd.trim().split(" ");
            if (s[0].equals("getKend")) {
                int temp = Integer.parseInt(s[1]);
                System.out.println(myList.getiData(myList.getSize() - temp));
            } else if (s[0].equals("add")) {
                myList.addNode(Integer.parseInt(s[1]));
                printList(myList);
            } else if (s[0].equals("getSize")) {
                System.out.println(myList.getSize());
            } else if (s[0].equals("remove")) {
                myList.removeNotEdge(Integer.parseInt(s[1]));
                printList(myList);
            } else if (s[0].equals("exit")){
                break;
            }
        }
    }
}
