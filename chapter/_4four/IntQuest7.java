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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class IntQuest7 {

    /**
     * createProjectOrder()
     * This method returns an ArrayList that persists of a sequence that corresponds to the correct order of the
     * @projects.
     * It accomplishes the above in the following way:
     * - Creates a HashMap (depenProjects) that contains as a key a project, and as it's value, a LinkedList of the
     * projects that are dependant by that project.
     * - Creates a HashSet (standAloneProjects) that contains only these projects that do not have any dependencies and
     * can start as is.
     * - for each (project in standAloneProjects), run a BFS-like exploration, using a queue, of all the other projects,
     * by iterating through the values of the corresponding keys of the above HashMap. Always through the iteration, add
     * a project onto the orderToReturn list.
     * Finally, if any projects left unexplored (projects.length != return.size(), return null, or return the created list.
     *
     * @param projects
     * @param dependencies
     * @return
     */
    public ArrayList createProjectOrder(int[] projects, int[][] dependencies) {
        HashSet<Integer> standAloneProjects = new HashSet<>();
        HashMap<Integer, LinkedList<Integer>> depenProjects  = new HashMap<>();
        ArrayList<Integer> orderToReturn = new ArrayList<>(projects.length);

        for (int i : projects) {
            standAloneProjects.add(i);
        }
        for (int[] i : dependencies) {
            standAloneProjects.remove(i[1]);
            if (depenProjects.containsKey(i[0])) {
                depenProjects.get(i[0]).add(i[1]);
            } else {
                depenProjects.put(i[0], new LinkedList<>());
                depenProjects.get(i[0]).add(i[1]);
            }
        }
        if (standAloneProjects.size() == 0) { // If there are ONLY dependencies, return null.
            return null;
        }
        for (Integer i : standAloneProjects) {
            if (depenProjects.containsKey(i)) {
                orderToReturn.add(i);
                LinkedList<Integer> myQueue = new LinkedList<>(depenProjects.get(i));
                while (!myQueue.isEmpty()) {
                    int current = myQueue.remove();
                    if (!orderToReturn.contains(current)) {
                        orderToReturn.add(current);
                        if (depenProjects.containsKey(current)) {
                            myQueue.addAll(depenProjects.get(current));
                        }
                    }
                }
            } else {
                orderToReturn.add(i);
            }
        }
        return (orderToReturn.size() == projects.length ? orderToReturn : null);
    }


    public static void main(String[] args) {
        int[] projects = new int[]{1,2,3,4,5,6};
        int[][] dependencies = new int[][]{{1,4},{2,4},{6,1},{6,2},{2,3}};

        IntQuest7 obj = new IntQuest7();
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
