/**
 * Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
 * projects, where the second project is dependent on the first project). All of a project's dependencies
 * must be built before the project is. Find a build order that will allow the projects to be built. If there
 * is no valid build order, return an error.
 * EXAMPLE
 * Input:
 * projects: a, b, c, d, e, f
 * dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
 * Output: f, e, a, b, d, c
 * Hints: #26, #47, #60, #85, # 125, # 133
 * - Build a directed graph representing the dependencies. Each node is a project and an
 * edge exists from A to B if B depends on A (A must be built before B). You can also build
 * it the other way if it's easier for you.
 * - Look at this graph. Is there any node you can identify that will definitely be okay to build
 * first?
 * - If you identify a node without any incoming edges, then it can definitely be built. Find
 * this node (there could be multiple) and add it to the build order. Then, what does this
 * mean for its outgoing edges?
 * - Once you decide to build a node, its outgoing edge can be deleted. After you've done
 * this, can you find other nodes that are free and clear to build?
 * - As a totally different approach: Consider doing a depth-first search starting from an arbitrary node.
 * What is the relationship between this depth-first search and a valid build
 * order?
 * - Pick an arbitrary node and do a depth-first search on it. Once we get to the end of a path,
 * we know that this node can be the last one built, since no nodes depend on it. What
 * does this mean about the nodes right before it?
 */
package chapter._4four;

import java.util.LinkedList;
import static chapter._4four.TopologicalSort.topologicalSort;
public class IntQuest7 {
    static class Graph {
        LinkedList<Node<Integer>> startNodes;

        Graph() {
            startNodes = new LinkedList<>();
        }


        public void addStartNode(Node<Integer> node) {
            startNodes.add(node);
        }

        public LinkedList createProjectOrder(int[] projects, int[][] dependencies) {
            return topologicalSort(this, projects, dependencies);
        }
    }



    public static void main(String[] args) {
        int[] projects = new int[]{1,2,3,4,5,6};
        int[][] dependencies = new int[][]{{1,4},{2,4},{6,1},{6,2},{2,3}};

        Graph obj = new Graph();
        System.out.println(obj.createProjectOrder(projects, dependencies)); //valid

        projects = new int[]{1,2,3,4,5,6,7,8,9};
        dependencies = new int[][]{{5,7},
                {4,3},
                {4,8},
                {4,5},
                {3,6},
                {8,2},
                {1,7},
                {6,1},
                {9,4}
        };
        System.out.println(obj.createProjectOrder(projects, dependencies)); //valid

        projects = new int[]{1,2,3,4,5,6,7,8,9};
        dependencies = new int[][]{{5,7},
                {4,3},
                {4,8},
                {4,5},
                {3,6},
                {8,2},
                {1,7},
                {6,1},
                {9,4},
                {4,9} //creates a deadlock in dependencies
        };
        System.out.println(obj.createProjectOrder(projects, dependencies)); //null
    }

}