package chapter._2two;

public class IntQuest8 {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addNode(3);
        list.addNode(5);
        list.addNode(9);

        Node<Integer> node1 = new Node<>(15);
        Node<Integer> node2 = new Node<>(16);
        Node<Integer> node3 = new Node<>(17);
        Node<Integer> node4 = new Node<>(18);
        Node<Integer> node5 = new Node<>(19);

        list.addNodeByReference(node1);
        list.addNodeByReference(node2);
        list.addNodeByReference(node3);
        list.addNodeByReference(node4);
        list.addNodeByReference(node5);
        list.addNodeByReference(node1);
        System.out.println(list.isCircular()); // Should be true;


        MyLinkedList<Integer> list1 = new MyLinkedList<>();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(3);
        list1.addNode(4);
        list1.addNode(5);
        System.out.println(list1.isCircular()); // Should be false;
    }
}
