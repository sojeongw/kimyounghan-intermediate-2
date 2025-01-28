package collection.linkedlist;

public class MyLinkedListV1Main {
    public static void main(String[] args) {
        MyLinkedListV1 list = new MyLinkedListV1();

        list.add("a");
        System.out.println("list = " + list);

        list.add("b");
        System.out.println("list = " + list);

        list.add("c");
        System.out.println("list = " + list);

        System.out.println("=== 기능 사용 ===");
        System.out.println("list.size() = " + list.size());
        System.out.println("list.get(1) = " + list.get(1));
        System.out.println("list.indexOf(\"c\") = " + list.indexOf("c"));
        System.out.println("list.set(2, \"z\") = " + list.set(2, "z"));   // 기존 값 반환

        list.add("d");
        list.add("e");

        // 동적으로 늘어나기 떄문에 범위 초과할 일이 없다.
        System.out.println("=== 범위 초과 ===");
        list.add("f");
        System.out.println("list = " + list);
    }
}
