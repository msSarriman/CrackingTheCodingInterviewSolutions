/*
MIT License

Copyright (c) 2019 Emmanouil Sarris

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package chapter._04four;

import java.util.LinkedList;

import static chapter._04four.Util_TopologicalSort.topologicalSort;

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
