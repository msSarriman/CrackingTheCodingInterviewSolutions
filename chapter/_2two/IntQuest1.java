/**
 * Remove Dups: Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 * Hints: #9, #40
 * - Have you tried a hash table? You should be able to do this in a single pass of the linked
 * list
 * - Without extra space, you'll need a(N2) time.Try using _2two pointers, where the second
 * _1one searches ahead of the first _1one.
 */
package chapter._2two;

import java.util.*;

public class IntQuest1 {


    /**
     * This function removes the duplicates from a given List, by using a Set to determine if the current
     * element is a duplicate or not.
     *
     * @param myList =  the List to remove the duplicates from
     * @return The given list with the duplicates removed
     */
    private static List removeDuplicates(List<Integer> myList) {
        Set<Integer> mySet = new HashSet<>();
        int myListSize = myList.size();
        for (int i = 0; i < myListSize; i++) {
            if (mySet.contains(myList.get(i))) {
                myList.remove(i--);
                myListSize--;
            } else {
                mySet.add(myList.get(i));
            }
        }
        return myList;
    }


    /**
     * FOLLOW UP
     *
     * @param myList =  the List to remove the duplicates from
     * @return The given list with the duplicates removed
     */
    private static List removeDuplicatesNoBuffer(List<Integer> myList) {
        int myListSize = myList.size();
        for (int i = 0; i < myListSize; i++) {
            for (int j = 0; j < myListSize; j++) {
                if (i == j) continue;
                if (myList.get(i) == myList.get(j)) {
                    myList.remove(j--);
                    myListSize--;
                }
            }
        }
        return myList;
    }


    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        myList.add(5);
        myList.add(5);
        myList.add(6);
        myList.add(6);
        myList.add(6);
        myList.add(7);
        myList.add(8);
        myList.add(9);
        myList.add(9);

        for (int i : myList) {
            System.out.print(i + " ");
        }
        System.out.println();

        List<Integer> noBuffer = removeDuplicatesNoBuffer(myList);
        for (int i : noBuffer) {
            System.out.print(i + " ");
        }
        System.out.println();

        /*List<Integer> withBuffer = removeDuplicates(myList);
        for (int i : myList) {
            System.out.print(i + " ");
        }
        System.out.println();*/
    }
}
