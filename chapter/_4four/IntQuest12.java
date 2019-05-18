/**
 * Paths with Sum: You are given a binary tree in which each node contains an integer value (which
 * might be positive or negative). Design an algorithm to count the number of paths that sum to a
 * given value. The path does not need to start or end at the root or a leaf, but it must go downwards
 * (traveling only from parent nodes to child nodes).
 * Hints: #6, #14, #52, #68, #77, #87, #94, #103, #108, #115
 * - Try simplifying the problem. What if the path had to start at the root?
 * - Don't forget that paths could overlap. For example, if you're looking for the sum 6, the
 * paths 1-> 3 - >2 and 1->3->2->4->-6->2 are both valid.
 * - If each path had to start at the root we could traverse all possible paths starting from
 * the root. We can track the sum as we go, incrementing totalPaths each time we
 * find a path with our target sum. Now, how do we extend this to paths that can start
 * anywhere? Remember: Just get a brute-force algorithm done. You can optimize later.
 * - To extend this to paths that start anywhere, we can just repeat this process for all nodes.
 * - If you've designed the algorithm as described thus far, you'll have an O(N log N)
 * algorithm in a balanced tree. This is because there are Nnodes, each of which is at depth
 * o(log N) at worst. A node is touched once for each node above it. Therefore, the N
 * nodes will be touched O(log N) time. There is an optimization that will give us an
 * o(N) algorithm.
 * - What work is duplicated in the current brute-force algorithm?
 * - Consider each path that starts from the root (there are N such paths) as an array. What
 * our brute-force algorithm is really doing is taking each array and finding all contiguous
 * subsequences that have a particular sum. We're doing this by computing all subarrays
 * and their sums. It might be useful to just focus on this little subproblem. Given an array,
 * how would you find all contiguous subsequences with a particular sum? Again, think
 * about the duplicated work in the brute-force algorithm.
 * - We are looking for subarrays with sum targetSum. Observe that we can track in
 * constant time the value of runningSum 1, where this is the sum from element 0 through
 * element i. For a subarray of element i through element j to have sum targetSum,
 * runningSum1_1 + targetSum must equal runningSum j (try drawing a picture of
 * an array or a number line). Given that we can track the runningSum as we go, how can
 * we quickly look up the number of indices i where the previous equation is true?
 * - Try using a hash table that maps from a runningSum value to the number of elements
 * with this runningSum.
 * - Once you've solidified the algorithm to find all contiguous subarrays in an array with a
 * given sum, try to apply this to a tree. Remember that as you're traversing and modifying
 * the hash table, you may need to "reverse the damage" to the hash table as you traverse
 * back up.
 */
package chapter._4four;

import java.util.HashSet;
import java.util.LinkedList;

public class IntQuest12 {
    public static HashSet<LinkedList<Integer>> mySet = new HashSet<>();
    public static int sumRequired = 393;
    public static int totalCounter = 0;


    /**
     * This method provides the required results by doing the following two things.
     * 1) By using the method constructPaths, it creates a set, with all the path combinations, that there are in the
     * tree, described by the @myRoot node.
     * 2) By using the method calculatePaths, it traverses all the paths and their subpaths, and counts how many of those
     * end up in the requiredSum.
     * @param myRoot = The root of the given tree.
     */
    public static void countPathsToSum(Util_BinTreeNode<Integer> myRoot) {
        LinkedList<Integer> myList = new LinkedList<>();
        constructPaths(mySet, myRoot, myList);
        calculatePaths(mySet);
        System.out.printf("total counter is <%d>", totalCounter);
    }


    /**
     * This recursive method, constructs all the paths from root to leaves. It does so by using the preorder traversal.
     * Each node that finished its call on the stack, will popUp the last item from the LinkedList, in order for it's
     * father to continue the passing of the LinkedList, down to the recursive calls, without the presence of those
     * elements inside it.
     * @param mySet = The HashSet that will store the paths.
     * @param curNode = The current node of the recursion.
     * @param tempList = The path so far.
     */
    private static void constructPaths(HashSet<LinkedList<Integer>> mySet,
                                      Util_BinTreeNode<Integer> curNode,
                                      LinkedList<Integer> tempList) {
        tempList.add(curNode.data);
        populateSet(mySet, tempList, curNode);
        if (curNode.left != null && curNode.left.data != null) {
            constructPaths(mySet, curNode.left, tempList);
        }
        if (curNode.right != null && curNode.right.data != null) {
            constructPaths(mySet, curNode.right, tempList);
        }
        calibrateList(tempList);
    }


    /**
     * This method checks the @node is a leaf. If it is, it must add the path so far (described by @myList), to the
     * collection of paths, preserved by @mySet
     * @param mySet = The collection of paths.
     * @param myList = The path so far.
     * @param node = The current node.
     */
    private static void populateSet(HashSet<LinkedList<Integer>> mySet,
                                   LinkedList<Integer> myList,
                                   Util_BinTreeNode<Integer> node) {
        if ((node.left == null || node.left.data == null) &&
        (node.right == null || node.right.data == null)) {
            mySet.add(new LinkedList(myList));
        }
    }


    /**
     * This method, removes the last element from @myList.
     * This method is invoked at the end of the recursive method, so it can presume the path at the above calls of the
     * recursive stack, in a correct way.
     * @param myList = The path so far, that needs to be cleaned from the last node.
     */
    private static void calibrateList(LinkedList<Integer> myList) {
        myList.removeLast();
    }


    /**
     * This method, calculates the sum of a path and all its subpaths, given at the @list variable, and taken by the
     * @mySet collection of paths.
     * @param mySet = The collection of all the paths of the Tree.
     */
    private static void calculatePaths(HashSet<LinkedList<Integer>> mySet) {
        for (LinkedList<Integer> list : mySet) {
            checkPathAndSubPaths(list);
        }
    }


    /**
     * This method calculates the sum of the nodes that are present in the given path, described by @myList, and all
     * the subpaths, that this path can create.
     * It increments the static counter @totalCounter, in case the sum of a path asserts to static @sumRequired.
     * @param myList = The path, to calculate it and all it's subpaths.
     */
    private static void checkPathAndSubPaths(LinkedList<Integer> myList) {
        for (int i = 0; i < myList.size(); i++) {
            int sum = 0;
            for (int j = i; j < myList.size(); j++) {
                sum += myList.get(j);
                if (sum == sumRequired) {
                    totalCounter++; // The loop will continue because there can be negative numbers that will end up in the same sum again in the path.
                }
            }
        }
    }


    public static void main(String[] args) {
        Util_BigTree_Question11 myTree = new Util_BigTree_Question11();
        countPathsToSum(myTree.bigRoot);
    }

}
