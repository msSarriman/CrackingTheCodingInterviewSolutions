/**
 * Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
 * route between two nodes.
 * Hints: #127
 * - Two well-known algorithms can do this. What are the tradeoffs between them?
 */
package chapter._4four;

import java.util.HashSet;

import static chapter._4four.Node.findPathDFS;
import static chapter._4four.Node.findPathBFS;

public class IntQuest1 {


    /**
     * A wrapping class for the nodes of the graph created from the Class
     * @param <T>
     */
    static class Graph<T> extends Node<T> {
        Node<T> root;

        Graph(Node<T> root) {
            this.root = root;
        }
    }


    /**
     * For demonstration purposes, the graph in the following adjacency matrix, has been constructed.
     * 	    1	2	3	4	5	6	7	8	9
     * 	    ---------------------------------
     * 1  |	0	0	1	1	0	0	0	0	1
     * 2  |	1	0	1	0	0	0	0	1	0
     * 3  |	0	0	0	0	1	0	0	0	0
     * 4  |	0	0	0	0	0	0	0	1	1
     * 5  |	0	0	0	0	0	0	1	0	0
     * 6  |	0	0	1	0	0	0	0	0	0
     * 7  |	0	0	0	0	0	1	0	1	0
     * 8  |	0	0	0	0	0	0	1	0	0
     * 9  |	0	0	0	0	0	0	0	0	0
     *
     * The paths have been explored by the usage of BFS and DFS algorithms.
     * The advantages of DFS is that its a very easy algorithm to implement but it can stray very
     * far away from a solution because first it is going deep.
     * The advantages of BFS is that it can provide an optimal solution, much faster than DFS,
     * but it's a little bit trickier to implement.
     * In general for paths BFS > DFS
     * For simplicity DFS > BFS
     * @param args
     */
    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        Node<Integer> node6 = new Node<>(6);
        Node<Integer> node7 = new Node<>(7);
        Node<Integer> node8 = new Node<>(8);
        Node<Integer> node9 = new Node<>(9);

        node1.addChild(node3); node1.addChild(node4); node1.addChild(node9);
        node2.addChild(node1); node2.addChild(node3); node2.addChild(node8);
        node3.addChild(node5);
        node4.addChild(node8); node4.addChild(node9);
        node5.addChild(node7);
        node6.addChild(node3);
        node7.addChild(node6); node7.addChild(node8);
        node8.addChild(node7);

        Graph<Integer> graph = new Graph<>(node1);
        HashSet<Node> visited = new HashSet<>();

        /* DFS results */
        System.out.println(findPathDFS(node1, node1, visited)); visited.clear();  // true
        System.out.println(findPathDFS(node1, node6, visited)); visited.clear();  // true
        System.out.println(findPathDFS(node9, node4, visited)); visited.clear();  // false
        System.out.println(findPathDFS(node3, node4, visited)); visited.clear();  // false
        System.out.println(findPathDFS(node3, node8, visited)); visited.clear();  // true

        System.out.println();

        /* BFS results */
        System.out.println(findPathBFS(node1, node1));  // true
        System.out.println(findPathBFS(node1, node6));  // true
        System.out.println(findPathBFS(node9, node4));  // false
        System.out.println(findPathBFS(node3, node4));  // false
        System.out.println(findPathBFS(node3, node8));  // true

    }
}
