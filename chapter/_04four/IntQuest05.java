/**
 * Validate BST: Implement a function to check if a binary tree is a binary search tree.
 * Hints: #35, #57, #86, # 113, # 128
 * - If you traversed the tree using an in-order traversal and the elements were truly in
 * the right order, does this indicate that the tree is actually in order? What happens for
 * duplicate elements? If duplicate elements are allowed, they must be on a specific side
 * (usually the left).
 * - To be a binary search tree, it's not sufficient that the left. value <= current.
 * value < right. value for each node. Every node on the left must be less than the
 * current node, which must be less than all the nodes on the right
 * - If every node on the left must be less than or equal to the current node, then this is really
 * the same thing as saying that the biggest node on the left must be less than or equal to
 * the current node.
 * - Rather than validating the current node's value against leftTree. max and
 * rightTree. min, can we flip around the logic? Validate the left tree's nodes to ensure
 * that they are smaller than current. value.
 * - Think about the checkBST function as a recursive function that ensures each node is
 * within an allowable (min J max) range. At first, this range is infinite.When we traverse
 * to the left, the min is negative infinity and the max is root. value. Can you implement
 * this recursive function and properly adjust these ranges as you traverse the tree?
 */
package chapter._04four;

public class IntQuest05 {

    /**
     * isBST()
     * Credits to the book's solutions.
     * This function checks if a tree is binary by checking the rule
     * all.left <= node < all.right
     *
     * @param node = The root node of the tree to be tested
     * @return
     */
    public static boolean isBST(Util_BinTreeNode node) {
        return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private static boolean isBST(Util_BinTreeNode node, Integer min, Integer max) {
        if (node == null || node.data == null) {
            return true;
        }
        if ((Integer) node.data < min || (Integer) node.data > max) {
            return false;
        }
        if (!isBST(node.left, min, (Integer) node.data) || !isBST(node.right, (Integer) node.data, max)) {
            return false;
        }
        return true;
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
        root.add(1);        root.add(3);        root.add(5);        root.add(7);
        root.add(10);       root.add(12);       root.add(19);       root.add(21);
        root.add(10);       root.add(12);       root.add(19);       root.add(21);
        System.out.println(isBST(root)); // is BST


        /* Binary tree to be created:
         *                  8
         *          4               16
         *      2       6       11      20
         *    1   3   5   7   10   12 19   21
         *                 90
         * */
        root = new Util_BinTreeNode<>();
        root.add(9);
        root.add(4);        root.add(16);
        root.add(2);        root.add(6);        root.add(11);        root.add(20);
        root.add(1);        root.add(3);        root.add(5);        root.add(7);
        root.add(10);        root.add(12);        root.add(19);        root.add(21);
        Util_BinTreeNode<Integer> injectedNode = new Util_BinTreeNode<>(90);
        injectedNode.father = root.left.right.right;
        root.left.right.right.right = injectedNode;

        System.out.println(isBST(root)); // is not BST
    }
}
