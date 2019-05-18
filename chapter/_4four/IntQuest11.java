/**
 * Random Node: You are implementing a binary tree class from scratch which, in addition to
 * insert, find, and delete, has a method getRandomNode() which returns a random node
 * from the tree. All nodes should be equally likely to be chosen. Design and implement an algorithm
 * for getRandomNode, and explain how you would implement the rest of the methods.
 * Hints: #42, #54, #62, #75, #89, #99, #112, #119
 * - Be very careful in this problem to ensure that each node is equally likely and that
 * your solution doesn't slow down the speed of standard binary search tree algorithms
 * (like insert, find, and delete). Also, remember that even if you assume that it's a
 * balanced binary search tree, this doesn't mean that the tree is full/complete/perfect.
 * - This is your own binary search tree class, so you can maintain any information about the
 * tree structure or nodes that you'd like (provided it doesn't have other negative implications,
 * like making insert much slower). In fact, there's probably a reason the interview
 * question specified that it was your own class. You probably need to store some additional information in order
 * to implement this efficiently
 * - As a naive "brute force" algorithm, can you use a tree traversal algorithm to implement
 * this algorithm? What is the runtime of this?
 * - Alternatively, you could pick a random depth to traverse to and then randomly traverse,
 * stopping when you get to that depth. Think this through, though. Does this work?
 * - Picking a random depth won't help us much. First, there's more nodes at lower depths
 * than higher depths. Second, even if we re-balanced these probabilities, we could
 * hit a "dead end" where we meant to pick a node at depth 5 but hit a leaf at depth 3.
 * Re-balancing the probabilities is an interesting, though.
 * - A naive approach that many people come up with is to pick a random number between
 * 1 and 3. If it's 1, return the current node. If it's 2, branch left. If it's 3, branch right. This
 * solution doesn't work. Why not? Is there a way you can adjust it to make it work?
 * - The reason that the earlier solution (picking a random number between 1and 3) doesn't
 * work is that the probabilities for the nodes won't be equal. For example, the root will be
 * returned with probability .x,even if there are 50+ nodes in the tree. Clearly, not all the
 * nodes have probability .x,so these nodes won't have equal probability. We can resolve
 * this one issue by picking a random number between 1 and size_of_tree instead.
 * This only resolves the issue for the root, though.What about the rest of the nodes?
 * - The issue with the earlier solution is that there could be more nodes on one side of a
 * node than the other. So, we need to weight the probability of going left and right based
 * on the number of nodes on each side. How does this work, exactly? How can we know
 * the number of nodes?
 */
package chapter._4four;

import java.util.LinkedList;

public class IntQuest11 {

    /**
     * This method traverses the Tree with an inOrder notation, and stores the Nodes in a LinkedList. Then
     * it extracts a random node form the created list.
     * Space and time Complexity is O(N)
     * @param node = The root of the tree
     * @return
     */
    public static Util_BinTreeNode getRandomBigON(Util_BinTreeNode<Integer> node) {
        LinkedList<Util_BinTreeNode> myNodes = new LinkedList<>();
        traverseAndStore(myNodes, node);
        int randomIndex = (int) (Math.random() * (myNodes.size() - 1));
        return myNodes.get(randomIndex);
    }

    /**
     * The inorder traversal that is needed in getRandomBigON method()
     * @param myList The list that will get populated with the nodes of the tree.
     * @param node The node that is needed to make the recursive traversal
     */
    private static void traverseAndStore(LinkedList<Util_BinTreeNode> myList, Util_BinTreeNode node) {
        if (node.left != null && node.left.data != null) {
            traverseAndStore(myList, node.left);
        }
        myList.add(node);
        if (node.right != null && node.right.data != null) {
            traverseAndStore(myList, node.right);
        }
    }


    public static void main(String[] args) {
        Util_BigTree_Question11 myTree = new Util_BigTree_Question11();
        Util_BinTreeNode<Integer> randomResult = getRandomBigON(myTree.bigRoot);

        System.out.printf("The random result in O(N) is: <%d>\n", randomResult.data);


    }
}

