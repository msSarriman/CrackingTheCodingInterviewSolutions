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
 * Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
 * before all nodes greater than or equal to x. lf x is contained within the list, the values of x only need
 * to be after the elements less than x (see below).The partition element x can appear anywhere in the
 * "right partition"; it does not need to appear between the left and right partitions.
 * EXAMPLE
 * Input: 3 -> 5 -> 8 -> 5 - > 10 -> 2 -> 1 [partition = 5)
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 * Hints: #3, #24
 * - There are many solutions to this problem, most of which are equally optimal in runtime.
 * Some have shorter, cleaner code than others. Can you brainstorm different solutions?
 * - Consider that the elements don't have to stay in the same relative order. We only need
 * to ensure that elements less than the pivot must be before elements greater than the
 * pivot. Does that help you come up with more solutions?
 */
package chapter._02two;

import java.util.Random;
import java.util.Scanner;

public class IntQuest4 {
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


        /* Populate the MyLinkedList */
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
        <command> : <getKend>, <add>, <getSize>, <remove>, <exit>, <partition>
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
            } else if (s[0].equals("partition")) {
                myList = myList.partitionList(myList, Integer.parseInt(s[1]));
                printList(myList);
            } else if (s[0].equals("exit")){
                break;
            }
        }
    }
}
