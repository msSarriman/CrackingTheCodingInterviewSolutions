package chapter._4four;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


/**
 * UNDER CONSTRUCTION
 */
public class TopologicalSort {

    public static LinkedList topologicalSort(IntQuest7.Graph graph, int[] projects, int[][] dependencies) {
        createGraph(graph, projects, dependencies);
        if (graph.startNodes.size() == 0) {
            return null;
        }
        for (Node<Integer> node : graph.startNodes) {

        }
        return null;
    }


    /**
     * createGraph()
     * This method creates the graph with @project nodes, and @dependencies arcs.
     *
     * @param graph = the Graph to be created
     * @param projects =
     * @param dependencies
     */
    public static void createGraph(IntQuest7.Graph graph, int[] projects, int[][] dependencies) {
        HashMap<Integer, Node<Integer>> myMap = new HashMap<>();
        for (int i : projects) {
            myMap.put(i, new Node<>(i));
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
    public static HashSet<Integer> identifyStrongNodes(int[] projects, int[][] dependencies) {
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
