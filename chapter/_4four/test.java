package chapter._4four;

import java.util.HashSet;

public class test {
    public static void main(String[] args) {
        HashSet<Integer> mySet = new HashSet<>();

        mySet.add(15);
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        mySet.add(1);
        mySet.add(4);
        mySet.add(3);
        mySet.add(2);
        mySet.add(1);
        for (int i : mySet) {
            System.out.println(i + " ");
        }
    }
}
