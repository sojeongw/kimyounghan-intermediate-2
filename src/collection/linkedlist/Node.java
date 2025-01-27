package collection.linkedlist;

public class Node {

    Object item;
    Node next;

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        // loop에서 문자를 더할 때는 StringBuilder를 사용한다.
        StringBuilder sb = new StringBuilder();
        Node x = this;

        sb.append("[");
        while (x != null) {
            sb.append(x.item);

            if (x.next != null) {
                sb.append("->");
            }
            x = x.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
