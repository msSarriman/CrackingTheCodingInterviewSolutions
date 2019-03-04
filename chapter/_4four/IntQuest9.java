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


import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Credits to the book's solutions.
 */
public class IntQuest9 {


    /**
     * allSequences()
     * This method creates all the suquences of a tree/subtree, with the root @node.
     *
     * @param node = the root of the tree|subtree
     * @return
     */
    public static ArrayList<LinkedList<Integer>> allSequences(Util_BinTreeNode node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();

        if (node == null || node.data == null) {
            result.add(new LinkedList<>());
            return result;

        }

        LinkedList<Integer> prefix = new LinkedList<Integer> ();
        prefix.add((Integer)node.data);
        /* Recurse on left and right subtrees. */
        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

        /* Weave together each list from the left and right sides. */
        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                ArrayList <LinkedList<Integer>> weaved = new ArrayList<>() ;
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }


    /**
     * weaveLists()
     * This method creates all the permutations of a given list.
     *
     * @param first
     * @param second
     * @param results
     * @param prefix
     */
    public static void weaveLists(LinkedList<Integer> first, LinkedList <Integer> second,
                        ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        /* One list is empty. Add remainder to [a cloned] prefix and store result. */
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone() ;
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }
        /* Recurse with head of first added to the prefix. Removing the head will damage
                * first, so we'll need to put it back where we found it afterwards. */
        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);
        /* Do the same thing with second, damaging and then restoring the list.*/
        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
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
        root.add(2);        root.add(6);        root.add(11);       root.add(20);
        /*
        Caution. Adding the bellow nodes, causes the java.lang.OutOfMemoryError: GC overhead limit exceeded
        root.add(1);        root.add(3);        root.add(5);        root.add(7);
        root.add(10);       root.add(12);       root.add(19);       root.add(21);
        */
        System.out.println(java.time.LocalTime.now());
        ArrayList<LinkedList<Integer>> aofl = allSequences(root);
        System.out.println(java.time.LocalTime.now());

        for (LinkedList<Integer> list : aofl) {
            for (Integer i : list) {
                System.out.print(i + ",");
            }
            System.out.println("  ");
        }
    }
}
