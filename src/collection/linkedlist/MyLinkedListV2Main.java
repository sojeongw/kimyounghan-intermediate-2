package collection.linkedlist;

public class MyLinkedListV2Main {
    public static void main(String[] args) {
        MyLinkedListV2 list = new MyLinkedListV2();

        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("list = " + list);

        System.out.println("첫번째 항목 추가");
        list.add(0, "d");   // O(1)
        System.out.println("list = " + list);

        System.out.println("첫번째 항목 삭제");
        list.remove(0); // O(1)
        System.out.println("list = " + list);

        System.out.println("중간에 항목 추가");
        list.add(1, "e");   // O(n)
        System.out.println("list = " + list);

        System.out.println("중간 항목 삭제");
        list.remove(2); // O(n)
        System.out.println("list = " + list);
    }
}
