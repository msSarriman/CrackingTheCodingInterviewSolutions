package chapter._4four;

import java.util.LinkedList;

import static chapter._4four.Util_TopologicalSort.topologicalSort;

/**
 * This is a wrapper class, that represents the abstract idea of a graph
 * that has to be topologically sorted.
 * It stores the starting points of that Util_Graph.
 * If no starting points, the graph consists only of dependencies, and there is no topological sort available.
 */
public class Util_Graph {
    LinkedList<Util_Node<Integer>> startNodes;

    Util_Graph() {
        startNodes = new LinkedList<>();
    }


    /**
     * addStartNode()
     * This method adds a Util_Node, that can be used as a starting point on the graph.
     * @param node
     */
    public void addStartNode(Util_Node<Integer> node) {
        startNodes.add(node);
    }


    /**
     * createProjectOrder()
     * This method return a LinkedList of the topological sort algorithm's result, on a
     * Util_Graph object.
     *
     * @param projects = the projects that are contained in the graph.
     * @param dependencies = the dependencies that are contained in the projects.
     * @return LinkedList|null;
     */
    LinkedList createProjectOrder(int[] projects, int[][] dependencies) {
        return topologicalSort(this, projects, dependencies);
    }
}
