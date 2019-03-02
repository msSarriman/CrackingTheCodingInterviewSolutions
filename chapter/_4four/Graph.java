package chapter._4four;

import java.util.LinkedList;

import static chapter._4four.TopologicalSort.topologicalSort;

/**
 * This is a wrapper class, that represents the abstract idea of a graph
 * that has to be topologically sorted.
 * It stores the starting points of that Graph.
 * If no starting points, the graph consists only of dependencies, and there is no topological sort available.
 */
public class Graph {
    LinkedList<Node<Integer>> startNodes;

    Graph() {
        startNodes = new LinkedList<>();
    }


    /**
     * addStartNode()
     * This method adds a Node, that can be used as a starting point on the graph.
     * @param node
     */
    public void addStartNode(Node<Integer> node) {
        startNodes.add(node);
    }


    /**
     * createProjectOrder()
     * This method return a LinkedList of the topological sort algorithm's result, on a
     * Graph object.
     *
     * @param projects = the projects that are contained in the graph.
     * @param dependencies = the dependencies that are contained in the projects.
     * @return LinkedList|null;
     */
    LinkedList createProjectOrder(int[] projects, int[][] dependencies) {
        return topologicalSort(this, projects, dependencies);
    }
}
