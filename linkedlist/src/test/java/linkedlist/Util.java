package linkedlist;

public class Util {
    public static <T> void print(Node<T> node) {
        Node<T> tempNode = node;
        while (tempNode != null) {
            System.out.print(tempNode.data + " -> ");
            tempNode = tempNode.next;
        }
        System.out.println("null");
    }
}
