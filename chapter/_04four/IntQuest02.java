/**
 * Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm
 * to create a binary search tree with minimal height.
 * Hints: #19, #73, #176
 * - A minimal binary tree has about the same number of nodes on the left of each node as
 * on the right. Let'sfocus on just the root for now. How would you ensure that about the
 * same number of nodes are on the left of the root as on the right?
 * - You could implement this by finding the "ideal" next element to add and repeatedly
 * calling insertValue. This will be a bit inefficient, as you would have to repeatedly
 * traverse the tree.Try recursion instead. Can you divide this problem into subproblems?
 * - Think about what sort of expectations on freshness and accuracy of data is expected.
 * Does the data always need to be 100% up to date? Is the accuracy of some products
 * more important than others?
 */
package chapter._04four;

import java.util.Arrays;
import static chapter._04four.Util_BinTreeNode.printInOrder;

class IntQuest02 {

    public static Util_BinTreeNode<Integer> createMinimalBST(int[] array, Util_BinTreeNode<Integer> node) {
        if (node == null || array.length == 0){
            return null;
        }
        node = new Util_BinTreeNode<>(array[array.length / 2]);
        node.left = createMinimalBST(Arrays.copyOfRange(array, 0, array.length / 2)
                , node.getLeft());
        node.right = createMinimalBST(Arrays.copyOfRange(array, array.length / 2 + 1, array.length)
                , node.getRight());
        return node;
    }


    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,18,14,27};
        Util_BinTreeNode<Integer> root = createMinimalBST(array, new Util_BinTreeNode<>());
        printInOrder(root);
    }
}