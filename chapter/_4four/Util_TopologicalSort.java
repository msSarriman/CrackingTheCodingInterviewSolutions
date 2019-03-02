package chapter._4four;

import java.util.*;


/**
 * This class performs a Topological Sort on the given projects.
 * Projects are injected as nodes into @graph
 * Dependencies act like vertices in the @graph.
 */
public class Util_TopologicalSort {
    static HashSet<Util_Node> visited; // The visited nodes of each algorithm's execution.


    /**
     * tiologicalSort()
     * This method performs the algorithm on the given Util_Graph. It also creates the required Util_Graph which is empty by the
     * time.
     *
     * @param graph = The initiated graph. To be populated.
     * @param projects = The nodes of the graph.
     * @param dependencies = The vertices of the graph.
     * @return = LinkedList|null
     */
    static LinkedList topologicalSort(Util_Graph graph, int[] projects, int[][] dependencies) {
        LinkedList<Integer> myList = new LinkedList<>();
        visited = new HashSet<>();
        createGraph(graph, projects, dependencies);
        if (graph.startNodes.size() == 0) {
            return null;
        }
        for (Util_Node<Integer> node : graph.startNodes) {
            if (node.getMyChilds().size() == 0) {
                myList.add(0, node.data);
            } else {
                Stack<Integer> myOrderedStack = new Stack<>();
                getDfsOrder(node, myOrderedStack);
                for (Integer i : myOrderedStack) {
                    myList.add(0, i);
                }
            }
        }
        return (myList.size() == projects.length ? myList : null);
    }


    /**
     * This method returns the appearance of the nodes, at a given @node, using the DFS algorithm.
     *
     * @param node = the node to run DFS to.
     * @param order = the order of the appeared items.
     */
    private static void getDfsOrder(Util_Node<Integer> node, Stack<Integer> order) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        int counter = 0;
        for (Util_Node<Integer> child : node.getMyChilds()) {
            getDfsOrder(child, /*visited,*/ order);
            if (visited.contains(child)) {
                counter ++;
            }
        }
        if (counter == node.getMyChilds().size()) {
            order.add(node.data);
        }
    }


    /**
     * createGraph()
     * This method creates the graph with @project nodes, and @dependencies arcs.
     *
     * @param graph = the Util_Graph to be created
     * @param projects =
     * @param dependencies
     */
    private static void createGraph(Util_Graph graph, int[] projects, int[][] dependencies) {
        HashMap<Integer, Util_Node<Integer>> myMap = new HashMap<>();
        for (int i : projects) {
            myMap.put(i, new Util_Node<>(i));
        }
        for (int[] i : dependencies) {
            myMap.get(i[0]).addChild(myMap.get(i[1]));
        }
        for (int i : identifyStrongNodes(projects, dependencies)) {
            graph.addStartNode(myMap.get(i));
        }
    }


    /**
     * identifyStrongNodes()
     * This method identifies the nodes in a graph that can be taken as starting point.
     *
     * @param projects = All the nodes
     * @param dependencies = All the arcs.
     * @return = The "strong" nodes.
     */
    private static HashSet<Integer> identifyStrongNodes(int[] projects, int[][] dependencies) {
        HashSet<Integer> mySet = new HashSet<>();
        for (int i : projects) {
            mySet.add(i);
        }
        for (int[] i : dependencies) {
            mySet.remove(i[1]);
        }
        return mySet;
    }
}
