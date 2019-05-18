/**
 *  Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
 * this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
 * node never differ by more than one.
 * Hints: #21, #33, #49, # 105, # 124
 * - Think about the definition of a balanced tree. Can you check that condition for a single
 * node? Can you check it for every node?
 * - If you've developed a brute force solution, be careful about its runtime. If you are
 * computing the height of the subtrees for each node, you could have a pretty inefficient
 * algorithm.
 * - What if you could modify the binary tree node class to allow a node to store the height
 * of its subtree?
 * - You don't need to modify the binary tree class to store the height of the subtree. Can
 * your recursive function compute the height of each subtree while also checking if a
 * node is balanced? Try having the function return multiple values.
 * - Actually, you can just have a single checkHeight function that does both the height
 * computation and the balance check. An integer return value can be used to indicate
 * both
 */
package chapter._04four;

public class IntQuest4 {


    /**
     * isBalanced()
     * This method checks if a given tree with root @node, is balanced.
     *
     * @param node = the root of the tree to check
     * @return = true|false
     */
    public static boolean isBalanced(Util_BinTreeNode node) {
        int leftSubtreeHeight = getTreeDepth(node.left);
        int rightSubTreeHeight = getTreeDepth(node.right);
        return Math.abs(leftSubtreeHeight - rightSubTreeHeight) <= 1;
    }


    /**
     * getTreeDepth()
     * This method, returns the height of the Tree or Subtree, represented by the given @node
     *
     * @param node = the Tree to find out the maximum height
     * @return = the height of the Tree
     */
    public static int getTreeDepth(Util_BinTreeNode node) {
        if (node.data == null)
            return 0;
        int r = 0, l = 0;
        if (node.left != null)
            l = getTreeDepth(node.left) + 1;
        if (node.right != null)
            r = getTreeDepth(node.right) + 1;
        return Math.max(l, r);
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
        System.out.println(isBalanced(root)); // is balanced


        /* Binary tree to be created:
         *                  8
         *          4               16
         *      2       6       11      20
         *    1   3   5   7   10   12 19   21
         *                                   130
         *                                121   190
         *                                          211
         * */
        root = new Util_BinTreeNode<>();
        root.add(8);
        root.add(4);        root.add(16);
        root.add(2);        root.add(6);        root.add(11);       root.add(20);
        root.add(1);        root.add(3);        root.add(5);        root.add(7);
        root.add(10);       root.add(12);       root.add(19);       root.add(21);
        root.add(130);      root.add(121);      root.add(190);      root.add(211);
        System.out.println(isBalanced(root)); // is not balanced
    }

}
