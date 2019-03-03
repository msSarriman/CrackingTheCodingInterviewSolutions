/**
 * BST Sequences: A binary search tree was created by traversing through an array from left to right
 * and inserting each element. Given a binary search tree with distinct elements, print all possible
 * arrays that could have led to this tree.
 * EXAMPLE
 * Input:
 *               Node2
 *              /    \
 *             /      \
 *            \/      \/
 *           Node1   Node3
 * Output: {2, 1, 3}, {2, 3, 1}
 * Hints: #39, #48, #66, #82
 * - What is the very first value that must be in each array?
 * - The root is the very first value that must be in every array. What can you say about the
 * order of the values in the left subtree as compared to the values in the right subtree? Do
 * the left subtree values need to be inserted before the right subtree?
 * - The relationship between the left subtree values and the right subtree values is, essentially, anything.
 * The left subtree values could be inserted before the right subtree, or the
 * reverse (right values before left), or any other ordering
 * - Break this down into subproblems. Use recursion. If you had all possible sequences for
 * the left subtree and the right subtree, how could you create all possible sequences for
 * the entire tree?
 */
package chapter._4four;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Under Construction
 */
public class IntQuest9 {

    public static LinkedList<String> inputStringCalculator(Util_BinTreeNode<Integer> node) {
        HashMap<Integer, LinkedList<String>> myStrings = new HashMap<>();
        LinkedList<Util_BinTreeNode> myQueue = new LinkedList<>();
        myQueue.add(node);
        StringBuilder perHeightQueue = new StringBuilder();
        while (!myQueue.isEmpty()) {
            Util_BinTreeNode tempNode = myQueue.remove();
            if (tempNode.left != null && tempNode.left.data != null) {
                myQueue.add(tempNode.left);
            }
            if (tempNode.right != null && tempNode.left.data != null) {
                myQueue.add(tempNode.right);
            }
            int tempHeight = tempNode.height;
            perHeightQueue.append(tempNode.data);
            if (myQueue.isEmpty() || (myQueue.peek().height != tempHeight)) {
                LinkedList<String> tempList;
                if (myStrings.containsKey(tempHeight)) {
                    tempList = permutationResults(perHeightQueue.toString());
                    for (String str : tempList) {
                        myStrings.get(tempHeight).add(str);
                    }
                } else {
                    myStrings.put(tempHeight, new LinkedList<>());
                    tempList = permutationResults(perHeightQueue.toString());
                    for (String str : tempList) {
                        myStrings.get(tempHeight).add(str);
                    }
                }
                perHeightQueue = new StringBuilder();
            }
        }
        return valuesToLinkedList(myStrings);
    }


    public static LinkedList<String> valuesToLinkedList(HashMap<Integer, LinkedList<String>> map) {
        LinkedList<String> myList = new LinkedList<>();
        for (Map.Entry<Integer, LinkedList<String>> kv : map.entrySet()) {
            for (String str : kv.getValue()) {
                myList.add(str);
            }
        }
        return myList;
    }


    public static LinkedList<String> permutationResults(String str) {
        LinkedList<String> myList = new LinkedList<>();
        permutationResults(str, 0, str.length() - 1, myList);
        return myList;
    }


    private static void permutationResults(String str, int left, int right, LinkedList<String> myList) {
        if (left == right) {
            myList.add(str);
        } else {
            for (int i = left; i <= right; i++) {
                str = swap(str, left, i);
                permutationResults(str, left + 1, right, myList);
                str = swap(str, left, i);
            }
        }
    }


    private static String swap(String str, int left, int right) {
        char[] mySb = str.toCharArray();
        char temp = mySb[left];
        mySb[left] = mySb[right];
        mySb[right] = temp;
        return String.valueOf(mySb);
    }



    public static void main(String[] args) {
        /* Binary tree to be created:
         *                  8
         *          4               16
         *      2       6       11      20
         *    1   3   5   7   10   12 19   21
         * */
        Util_BinTreeNode<Integer> root = new Util_BinTreeNode<>();
        root.add(8);
        root.add(4);        root.add(16);
        /*root.add(2);        root.add(6);        root.add(11);       root.add(20);
        root.add(1);        root.add(3);        root.add(5);        root.add(7);
        root.add(10);       root.add(12);       root.add(19);       root.add(21);*/

        for (String str : inputStringCalculator(root)) {
            System.out.println(str);
        }
    }
}
