package chapter._4four;

/**
 * Node class for Binary Trees
 * 
 * @param <T>
 */
public class BinTreeNode<T> {
    T data;
    BinTreeNode<T> left;
    BinTreeNode<T> right;


    /**
     * Default Constructor for BinTreeNode()
     */
    BinTreeNode() {
        this.data = null;
        this.left = null;
        this.right = null;
    }


    /**
     * Constructor to create a BinTreeNode with data;
     *
     * @param data = the data to be contained.
     */
    BinTreeNode(T data) {
        this.data = data;
        this.left = new BinTreeNode<>();
        this.right = new BinTreeNode<>();
    }


    /**
     * addLeft()
     * This method ads the left child.
     *
     * @param child = the left child to be added
     * @return = true|false
     */
    protected boolean addLeft(BinTreeNode child) {
        if (this.left == null){
            this.left = child;
            return true;
        }
        return false;
    }


    /**
     * addRight()
     * This method ads the left child.
     *
     * @param child = the left child to be added
     * @return = true|false
     */
    protected boolean addRight(BinTreeNode child) {
        if (this.right == null){
            this.right = child;
            return true;
        }
        return false;
    }


    /**
     * printInOrder()
     * This method prints inorder the Nodes of the tree described by root.
     *
     * @param node = the root of the tree
     */
    public static void printInOrder(BinTreeNode node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.println(node.data);
        printInOrder(node.right);
    }


    /**
     * getHeight()
     * This method return the height of the tree.
     * As height is defined the number of the arcs at the biggest path of the tree from the root to the leaves,
     * and not the number of the nodes.
     *
     * @param node = the root of the tree.
     * @return = the height of the tree.
     */
    protected static int getHeight(BinTreeNode node) {
        int leftSubTreeHeight = 0;
        int rightSubTreeHeight = 0;
        if (node.left != null) {
            leftSubTreeHeight += getHeight(node.left) + 1;
        }
        if (node.right != null) {
            rightSubTreeHeight += getHeight(node.right) + 1;
        }
        return leftSubTreeHeight > rightSubTreeHeight ? leftSubTreeHeight : rightSubTreeHeight;
    }


    /**
     * getLeft()
     * getter for this.left
     *
     * @return = this.left;
     */
    public BinTreeNode<T> getLeft() {
        return left;
    }


    /**
     * getRight()
     * getter for this.right
     *
     * @return = this.right;
     */
    public BinTreeNode<T> getRight() {
        return right;
    }
}
