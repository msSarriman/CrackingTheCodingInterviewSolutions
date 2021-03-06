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

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Util_Node class for graphs or K-Trees
 *
 * @param <T>
 */
public class Util_Node<T> {
    T data;
    private LinkedList<Util_Node<T>> myChilds;


    /**
     * Default Constructor for Util_Node()
     */
    Util_Node() {
        this.data = null;
        this.myChilds = new LinkedList<>();
    }


    /**
     * Constructor to create a Util_Node with data;
     *
     * @param data = the data to be contained.
     */
    Util_Node(T data) {
        this.data = data;
        this.myChilds = new LinkedList<>();
    }


    /**
     * addChild()
     * This method ads the arcs between the Nodes in a graph.
     *
     * @param child = the destination of the arc to be created (this -> child)
     * @return = true|false
     */
    protected boolean addChild(Util_Node child) {
        if (!myChilds.contains(child)){
            myChilds.add(child);
            return true;
        }
        return false;
    }


    /**
     * findPathDFS()
     * This method uses the Depth First Search algorithm, to determine if there is a path
     * between the @source and the @destination.
     * It uses the set @visited to avoid running into a circle in the graph, and therefore in a
     * deadloop.
     *
     * @param source = the source node
     * @param destination = the destination node
     * @param visited = the visited nodes
     * @return = true|false
     */
    protected static <T> boolean findPathDFS(Util_Node<T> source, Util_Node<T> destination, HashSet<Util_Node> visited) {
        if (source == destination) {
            return true;
        }
        if (visited.contains(source)) {
            return false;
        }
        visited.add(source);
        if (source.myChilds.contains(destination)){
            return true;
        }
        for (Util_Node<T> node : source.myChilds) {
            if (node.findPathDFS(node, destination, visited)){
                return true;
            }
        }
        return false;
    }


    /**
     * findPathBFS()
     * This method uses the Breadth First Search algorithm, to determine if there is a path
     * between the @source and the @destination.
     *
     * @param source = the source node
     * @param destination = the destination node
     * @return = true|false
     */
    protected static <T> boolean findPathBFS(Util_Node<T> source, Util_Node<T> destination) {
        if (source == destination) {
            return true;
        }
        LinkedList<Util_Node<T>> queue = new LinkedList<>();
        HashSet<Util_Node<T>> visited = new HashSet<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            Util_Node<T> node = queue.remove();
            if (!visited.contains(node)) {
                visited.add(node);
                for (Util_Node child : node.myChilds) {
                    if (child == destination) {
                        return true;
                    } else {
                        queue.add(child);
                    }
                }
            }
        }
        return false;
    }


    /**
     * getMyChilds()
     * Getter for myChilds
     *
     * @return this.myChilds
     */
    public LinkedList<Util_Node<T>> getMyChilds() {
        return myChilds;
    }
}
