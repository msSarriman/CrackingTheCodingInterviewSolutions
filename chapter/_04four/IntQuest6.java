/**
 * Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
 * binary search tree. You may assume that each node has a link to its parent.
 * Hints: #79, #91
 * - Think about how an in-order traversal works and try to "reverse engineer" it.
 * - Here's one step of the logic: The successor of a specific node is the leftmost node of the
 * right subtree. What if there is no right subtree, though?
 */
package chapter._04four;

public class IntQuest6 {


    /**
     * nextNodeInOrder()
     * This method returns the next node that will be visited in an in-order traversal,
     * after the @node.
     *
     * @param node = the node that defines the next in-order node.
     * @return = null|Util_BinTreeNode
     */
    public static Util_BinTreeNode nextNodeInOrder(Util_BinTreeNode node) {
        if (node == null) return null;
        if (node.right != null && node.right.data != null) {
            return getLeftmostNode(node.right);
        } else {
            if (node.father == null) {
                return null;
            }
            while (node.father != null) {
                if (node == node.father.left) {
                    return node.father;
                }
                node = node.father;
            }
        }
        return null;
    }


    /**
     * getLeftmostNode()
     * This method, returns the leftmost node, of a given subtree, described by the @node
     *
     * @param node
     * @return
     */
    public static Util_BinTreeNode getLeftmostNode(Util_BinTreeNode node) {
        if (node.left != null && node.left.data != null) {
            return getLeftmostNode(node.left);
        }
        return node;
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

        System.out.println(nextNodeInOrder(root));                  // Must return 10
        System.out.println(nextNodeInOrder(root.right));            // Must return 19
        System.out.println(nextNodeInOrder(root.right.right.right));// Must return null
        System.out.println(nextNodeInOrder(root.left.left.left));   // Must return 2
        System.out.println(nextNodeInOrder(root.left.right.right)); // Must return 8
    }
}