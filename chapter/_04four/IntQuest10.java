/**
 * Check Subtree: Tl and T2 are two very large binary trees, with Tl much bigger than T2. Create an
 * algorithm to determine if T2 is a subtree of Tl.
 * A tree T2 is a subtree ofTi if there exists a node n in Ti such that the subtree of n is identical to T2.
 * That is, if you cut off the tree at node n, the two trees would be identical.
 * Hints: #4, #11, #18, #31, #37
 * - If T2 is a subtree of Tl, how will its in-order traversal compare to Tl's? What about its
 * pre-order and post-order traversal?
 * - The in-order traversals won't tell us much. After all, every binary search tree with the
 * same values (regardless of structure) will have the same in-order traversal. This is what
 * in-order traversal means: contents are in-order. (And if it won't work in the specific case
 * of a binary search tree, then it certainly won't work for a general binary tree.) The preorder traversal,
 * however, is much more indicative.
 * - You may have concluded that if T2. preorderTraversal () is a substring of
 * Tl. preorderTraversal (), then T2 is a subtree of Tl. This is almost true, except
 * that the trees could have duplicate values. Suppose Tl and T2 have all duplicate values
 * but different structures. The pre-order traversals will look the same even though T2 is
 * not a subtree of Tl . How can you handle situations like this?
 * - Although the problem seems like it stems from duplicate values, it's really deeper than
 * that. The issue is that the pre-order traversal is the same only because there are null
 * nodes that we skipped over (because they're null). Consider inserting a placeholder
 * value into the pre-order traversal string whenever you reach a null node. Register the
 * null node as a"real" node so that you can distinguish between the different structures.
 * - Alternatively, we can handle this problem recursively. Given a specific node within T1,
 * can we check to see if its subtree matches T2?
 */
package chapter._04four;


import java.util.LinkedList;


public class IntQuest10 {

    /**
     * isSubTree_wf() -- is sub tree with father
     * This method assumes that the nodes of the given trees, have access to their parent nodes.
     * It checks if @smallTreeRoot is a subtree of @bigTreeRoot. Does so by traversing upwards from
     * the @smallTreeRoot, until it finds @bigTreeRoot
     *
     * @param bigTreeRoot =  The root of the big tree
     * @param smallTreeRoot = the root of the small tree
     * @return = true|false
     */
    public static boolean isSubTree_wf(Util_BinTreeNode bigTreeRoot, Util_BinTreeNode smallTreeRoot) {
        Util_BinTreeNode currentNode = smallTreeRoot;
        while (currentNode != null) {
            if (currentNode == bigTreeRoot) {
                return true;
            }
            currentNode = currentNode.father;
        }
        return false;
    }


    /**
     * isSubTree()
     * This method checks if the trees described by roots given as input arguments, have the relationship
     * of T2 beeing a subTree of T1.
     *
     * @param bigTreeRoot = The root of the big tree
     * @param smallTreeRoot = The root of the small tree
     * @return true|false
     */
    public static boolean isSubTree(Util_BinTreeNode bigTreeRoot, Util_BinTreeNode smallTreeRoot) {
        /* DFS the bigTreeRoot, until smallTreeRoot appears (or not) */
        LinkedList<Util_BinTreeNode> myQueue = new LinkedList<>();
        myQueue.add(bigTreeRoot);
        while (!myQueue.isEmpty()) {
            Util_BinTreeNode currentNode = myQueue.remove();
            if (currentNode == smallTreeRoot) {
                return checkTrees(currentNode, smallTreeRoot);
            }
            if (currentNode.left != null) {
                myQueue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                myQueue.add(currentNode.right);
            }
        }
        return false;
    }


    /**
     * checkTrees()
     * This method checks if the tree described by nodea, is the same as the tree described by nodeb.
     *
     * @param nodea
     * @param nodeb
     * @return = true|false
     */
    public static boolean checkTrees(Util_BinTreeNode nodea, Util_BinTreeNode nodeb) {
        LinkedList<Util_BinTreeNode> myQueueA = new LinkedList<>();
        LinkedList<Util_BinTreeNode> myQueueB = new LinkedList<>();
        myQueueA.add(nodea);
        myQueueB.add(nodeb);
        while (!myQueueA.isEmpty() && !myQueueB.isEmpty()) {
            Util_BinTreeNode currentNodeA = myQueueA.remove();
            Util_BinTreeNode currentNodeB = myQueueB.remove();
            addChildrenToQueue(myQueueA, currentNodeA);
            addChildrenToQueue(myQueueB, currentNodeB);
            if (currentNodeA != currentNodeB) {
                return false;
            }
        }
        return true;
    }


    /**
     * addChildrenToQueue()
     * This method adds the right and the left child of a node, to @queue
     *
     * @param queue = the queue to add the nodes.
     * @param node = the node to add it's children to the @queue.
     */
    public static void addChildrenToQueue(LinkedList<Util_BinTreeNode> queue, Util_BinTreeNode node) {
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
    }


    public static void main(String[] args) {
        Util_BigTree_Question10 bigTree = new Util_BigTree_Question10();

        System.out.println(isSubTree(bigTree.bigRoot, bigTree.smallRoot)); // must return true

        System.out.println(isSubTree(bigTree.bigRoot, bigTree.irrelevantRoot)); // must return false
    }
}
