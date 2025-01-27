package collection.linkedlist;

public class NodeMainV3 {

    public static void main(String[] args) {
        Node first = new Node("A");
        first.next = new Node("B");
        first.next.next = new Node("C");

        System.out.println("first = " + first);

        System.out.println("모든 노드 탐색하기");
        printAll(first);

        System.out.println("마지막 노드 조회하기");
        Node lastNode = getLastNode(first);
        System.out.println("lastNode = " + lastNode);

        System.out.println("특정 인덱스의 노드 조회하기");
        int index = 2;
        Node node = getNode(first, index);
        System.out.println("node = " + node);

        System.out.println("데이터 추가하기");
        add(first, "D");
        add(first, "E");
        System.out.println("first = " + first);
    }

    private static void add(Node node, String param) {
        Node lastNode = getLastNode(node);
        lastNode.next = new Node(param);
    }

    private static Node getNode(Node node, int index) {
        Node x = node;

        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    private static Node getLastNode(Node node) {
        Node x  = node;

        // x.next == null이면 마지막
        while (x.next != null) {
            x = x.next;
        }
        return x;
    }

    private static void printAll(Node node) {
        Node x  = node;
        while (x != null) {
            System.out.println(x.item);
            x = x.next;
        }
    }
}
