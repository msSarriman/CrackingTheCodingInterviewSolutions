/**
 * First Common Ancestor: Design an algorithm and write code to find the first common ancestor
 * of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE:This is not
 * necessarily a binary search tree.
 * Hints: #10, #16, #28, #36, #46, #70, #80, #96
 * - If each node has a link to its parent, we could leverage the approach from question 2.7
 * on page 95. However, our interviewer might not let us make this assumption.
 * - The first common ancestor is the deepest node such that p and q are both descendants.
 * Think about how you might identify this node.
 * - How would you figure out if p is a descendent of a node n?
 * - Start with the root. Can you identify if root is the first common ancestor? If it is not, can
 * you identify which side of root the first common ancestor is on?
 * - Try a recursive approach. Check if p and q are descendants of the left subtree and the
 * right subtree. If they are descendants of different subtrees, then the current node is the
 * first common ancestor. If they are descendants of the same subtree, then that subtree
 * holds the first common ancestor. Now, how do you implement this efficiently?
 * - In the more naive algorithm, we had one method that indicated if x is a descendent
 * of n, and another method that would recurse to find the first common ancestor.This is
 * repeatedly searching the same elements in a subtree. We should merge this into one
 * firstCommonAncestor function. What return values would give us the information
 * we need?
 * - The firstCommonAncestor function could return the first common ancestor (if p
 * and q are both contained in the tree), p if P is in the tree and not q, q if q is in the tree
 * and not p, and null otherwise.
 * - Careful! Does your algorithm handle the case where only one node exists? What will
 * happen? You might need to tweak the return values a bit.
 */
package chapter._4four;

public class IntQuest8 {


    /**
     * findCommonAncestor()
     * This method finds the first common ancestor of the given nodes @a and @b.
     * It does so by bringing the the reference of the nodes to the same height on the tree, by traversing it upwards,
     * through the parents.
     * Then both nodes traverse the tree up together, until the find the first common node that they will refer to.
     * That node is the first common ancestor.
     *
     * @param a = Node a
     * @param b = Node b
     * @return =  if common ancestor exists ? commonAncestor : null;
     */
    public static Util_BinTreeNode<Integer> findCommonAncestor(Util_BinTreeNode<Integer> a, Util_BinTreeNode<Integer> b) {
        int deptha = getDepth(a);
        int depthb = getDepth(b);
        Util_BinTreeNode<Integer> deepNode = deptha > depthb ? a : b;
        Util_BinTreeNode<Integer> shallowNode = deptha > depthb ? b : a;
        int depthDifference = Math.abs(deptha - depthb);
        while (deepNode != null && depthDifference-- != 0) {
            deepNode = deepNode.father;
        }
        if (deepNode == shallowNode) { // In that case the one Node was the ancestor of the other.
            return null;
        }
        /* Traverse simultaneously upwards until conditions are met. */
        while (deepNode != shallowNode && deepNode != null && shallowNode != null) {
            deepNode = deepNode.father;
            shallowNode = shallowNode.father;
        }
        return (deepNode == shallowNode ? deepNode : null);
    }


    /**
     * getDepth()
     * This method returns the depth of a node on a tree.
     * The node must have a reference to its parent.
     *
     * @param a = the node that it's height is desired
     * @return = the height of @a at the tree that it belongs.
     */
    public static int getDepth(Util_BinTreeNode a) {
        int counter = 0;
        Util_BinTreeNode node = a;
        while (node != null) {
            node = node.father;
            counter++;
        }
        return counter;
    }



    public static void main(String[] args) {
        /* Binary tree to be created:
         *                  8
         *          4               16
         *      2       6       11      20
         *    1   3   5   7   10   12 19   21
         *  */
        Util_BinTreeNode<Integer> node8 = new Util_BinTreeNode<>(8);
        Util_BinTreeNode<Integer> node4 = new Util_BinTreeNode<>(4, node8);
        Util_BinTreeNode<Integer> node16 = new Util_BinTreeNode<>(16, node8);
        Util_BinTreeNode<Integer> node2 = new Util_BinTreeNode<>(2, node4);
        Util_BinTreeNode<Integer> node6 = new Util_BinTreeNode<>(6, node4);
        Util_BinTreeNode<Integer> node11 = new Util_BinTreeNode<>(11, node16);
        Util_BinTreeNode<Integer> node20 = new Util_BinTreeNode<>(20, node16);
        Util_BinTreeNode<Integer> node1 = new Util_BinTreeNode<>(1, node2);
        Util_BinTreeNode<Integer> node3 = new Util_BinTreeNode<>(3, node2);
        Util_BinTreeNode<Integer> node5 = new Util_BinTreeNode<>(5, node6);
        Util_BinTreeNode<Integer> node7 = new Util_BinTreeNode<>(7, node6);
        Util_BinTreeNode<Integer> node10 = new Util_BinTreeNode<>(10, node11);
        Util_BinTreeNode<Integer> node12 = new Util_BinTreeNode<>(12, node11);
        Util_BinTreeNode<Integer> node19 = new Util_BinTreeNode<>(19, node20);
        Util_BinTreeNode<Integer> node21 = new Util_BinTreeNode<>(21, node20);

        //Util_BinTreeNode<Integer> root = node8;
        node8.addLeft(node4);
        node8.addRight(node16);
        node4.addLeft(node2);
        node4.addRight(node6);
        node2.addLeft(node1);
        node2.addRight(node3);
        node6.addLeft(node5);
        node6.addRight(node7);
        node16.addLeft(node11);
        node16.addRight(node20);
        node11.addLeft(node10);
        node11.addRight(node12);
        node20.addLeft(node19);
        node20.addRight(node21);

        System.out.println("The first common ancestor of 1 and 4: " + findCommonAncestor( node1, node4));
        System.out.println("The first common ancestor of 3 and 7: " + findCommonAncestor( node3, node7));
        System.out.println("The first common ancestor of 4 and 21: " + findCommonAncestor( node4, node21));
        System.out.println("The first common ancestor of 10 and 20: " + findCommonAncestor( node10, node20));
        System.out.println("The first common ancestor of 3 and 11: " + findCommonAncestor( node3, node11));
    }
}
