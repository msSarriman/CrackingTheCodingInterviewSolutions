package chapter._4four;

import static chapter._4four.IntQuest5.isBST;
/**
 * Util_Node class for Binary Trees
 * Create root with default constructor, and add elements with add()
 * The tree is not BST!
 * The tree is not Balanced!
 * 
 * @param <T>
 */
public class Util_BinTreeNode<T>{
    T data;
    Util_BinTreeNode<T> left;
    Util_BinTreeNode<T> right;
    Util_BinTreeNode<T> father;
    int height;


    /**
     * Default Constructor for Util_BinTreeNode()
     * Used to create the root
     */
    Util_BinTreeNode() {
        this.data = null;
        this.left = null;
        this.right = null;
        this.father = null;
        this.height = 0;
    }


    /**
     * Constructor to assign the father
     * used to create nodes!=root
     */
    Util_BinTreeNode(Util_BinTreeNode father) {
        this.data = null;
        this.left = null;
        this.right = null;
        this.father = father;
        this.height = father.height + 1;
    }


    /**
     * Constructor to create a Util_BinTreeNode with data;
     *
     * @param data = the data to be contained.
     */
    Util_BinTreeNode(T data) {
        this.data = data;
        this.left = new Util_BinTreeNode<>(this);
        this.right = new Util_BinTreeNode<>(this);
        this.father = null;
    }


    /**
     * Constructor to create a Util_BinTreeNode with data and father;
     *
     * @param data = the data to be contained.
     */
    Util_BinTreeNode(T data, Util_BinTreeNode<T> father) {
        this.data = data;
        this.left = new Util_BinTreeNode<>(this);
        this.right = new Util_BinTreeNode<>(this);
        this.father = father;
    }


    /**
     * addLeft()
     * This method ads the left child.
     *
     * @param child = the left child to be added
     * @return = true|false
     */
    protected boolean addLeft(Util_BinTreeNode child) {
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
    protected boolean addRight(Util_BinTreeNode child) {
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
    public static void printInOrder(Util_BinTreeNode node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.println(node.data);
        printInOrder(node.right);
    }


    /**
     * add()
     * This method adds a value to the Binary Tree
     *
     * @param value = The value to be added to the tree
     */
    protected void add(T value) {
        Util_BinTreeNode node = findNode(value, this);
        node.data = value;
        node.left = new Util_BinTreeNode<>(node);
        node.right = new Util_BinTreeNode<>(node);
    }


    /**
     * findNode()
     * Return a reference to a node, that the @value will be inserted
     *
     * @param value = the value to add
     * @param index = the root of the tree
     * @return = a reference to an empty node
     */
    private Util_BinTreeNode findNode(T value, Util_BinTreeNode index) {
        if (index.data == null) {
            return index;
        }
        Util_BinTreeNode next = ((Integer) index.data > (Integer) value) ? index.left : index.right;
        return findNode(value, next);
    }


    /**
     * getLeft()
     * getter for this.left
     *
     * @return = this.left;
     */
    public Util_BinTreeNode<T> getLeft() {
        return left;
    }


    /**
     * getRight()
     * getter for this.right
     *
     * @return = this.right;
     */
    public Util_BinTreeNode<T> getRight() {
        return right;
    }


    /**
     * getHeight()
     * This method returns the height of the tree with root @node.
     * As height is defined the number of the arcs at the biggest path of the tree from the root to the leaves,
     * and not the number of the nodes.
     *
     * @param node = the root of the tree.
     * @return = the height of the tree.
     */
    protected static int getHeight(Util_BinTreeNode node) {
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
     * getNodeHeight()
     * Applies only in BST
     * This method returns the height of the given Util_Node
     *
     * @param node = node to search for its height.
     * @return = the height of the node.
     */
    protected int getNodeHeight(Util_BinTreeNode node) {
        if (!isBST(node)) return -1;
        return getNodeHeight(this, node);
    }
    private int getNodeHeight(Util_BinTreeNode<T> source, Util_BinTreeNode<T> destination) {
        if (source == destination) {
            return 0;
        }
        if ((Integer)destination.data > (Integer)source.data) {
            return getNodeHeight(source.right, destination) + 1;
        } else {
            return getNodeHeight(source.left, destination) + 1;
        }
    }


    /**
     * getDataHeight()
     * Applies only in BST
     * This method returns the height of the given data.
     *
     * @param data = data to search for its height.
     * @return = the height of the data.
     */
    private int getDataHeight(T data) {
        Util_BinTreeNode index = this;
        if (!isBST(index)) return -1;
        int height = 0;
        while (index != null && (Integer)index.data != (Integer)data) {
            if ((Integer)index.data > (Integer)data) {
                index = index.left;
            } else {
                index = index.right;
            }
            height++;
        }
        return index == null ? Integer.MIN_VALUE : height;
    }


    /**
     * isBigger()
     * This method compares two generic objects to find which one is bigger,
     * depending that their classes implement the compareTo() method.
     *
     * @param a = first object
     * @param b = second object
     * @param <T> = the type of the objects
     * @return = true|false
     */
    protected static <T extends Comparable<T>> boolean isBigger(T a, T b) {
        return a.compareTo(b) > 0;
    }


    /**
     * toString()
     * Overided default object output.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Current node holds data " + this.data;
    }
}

