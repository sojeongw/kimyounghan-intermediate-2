package collection.linkedlist;

public class NodeMainV2 {

    public static void main(String[] args) {
        // 노드 생성하고 연결 A -> B -> C
        Node first = new Node("A");
        first.next = new Node("B");
        first.next.next = new Node("C");

        System.out.println("first = " + first);
        System.out.println("second = " + first.next);
    }
}
