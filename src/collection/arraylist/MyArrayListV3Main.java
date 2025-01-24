package collection.arraylist;

public class MyArrayListV3Main {
    public static void main(String[] args) {
        MyArrayListV3 list = new MyArrayListV3();

        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("list = " + list);

        System.out.println("=== 추가 ===");
        // O(1)
        list.add(3, "e");
        System.out.println("list = " + list);
        // O(n)
        list.add(0, "addFirst");
        System.out.println("list = " + list);

        System.out.println("=== 삭제 ===");
        // O(1)
        list.remove(4);
        System.out.println("list = " + list);
        // O(n)
        list.remove(0);
        System.out.println("list = " + list);
    }
}
