/**
 * List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
 * at each depth (e.g., if you have a tree with depth 0, you'll have 0 linked lists).
 * Hints: #107, #123, #735
 * - Try modifying a graph search algorithm to track the depth from the root
 * - A hash table or array that maps from level number to nodes at that level might also be
 * useful.
 * - Can you expand the middle until the earlier condition is met?
 */
package chapter._4four;

import java.util.LinkedList;

public class IntQuest3<T> {
    LinkedList<LinkedList<T>> myList;

    IntQuest3() {
        myList = new LinkedList<>();
    }


    /**
     * bfsAddUp()
     * This method creates the List of List that is needed.
     *
     * @param node = the root of the tree.
     */
    public void bfsAddUp(BinTreeNode<T> node) {
        BinTreeNode<T> root = node;
        LinkedList<BinTreeNode<T>> myQueue = new LinkedList<BinTreeNode<T>>();
        myQueue.add(node);
        while (!myQueue.isEmpty()) {
            BinTreeNode<T> index = myQueue.remove();
            if (index.left != null && index.left.data != null) {
                myQueue.add(index.left);
            }
            if (index.right != null && index.right.data != null) {
                myQueue.add(index.right);
            }
            int height = index.height;
            if (myList.size() <= height) {
                myList.add(height, new LinkedList<>());
            }
            myList.get(height).add(index.data);
        }
    }


    /**
     * printList()
     * This method prints all the list that are contained and the lists that are the element of myList
     *
     * @param list = the List<List> to print
     */
    public void printList(LinkedList<LinkedList<T>> list) {
        for (int i = 0; i < list.size(); i++) {
            for (T j : list.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {

        BinTreeNode<Integer> root = new BinTreeNode<>();
        /* Binary tree to be created:
         *                  8
         *          4               16
         *      2       6       11      20
         *    1   3   5   7   10   12 19   21
         * */
        root.add(8);
        root.add(4);
        root.add(16);
        root.add(2);
        root.add(6);
        root.add(11);
        root.add(20);
        root.add(1);
        root.add(3);
        root.add(5);
        root.add(7);
        root.add(10);
        root.add(12);
        root.add(19);
        root.add(21);


        IntQuest3<Integer> obj = new IntQuest3<>();
        obj.bfsAddUp(root);
        obj.printList(obj.myList);

    }
}
