package collection.arraylist;

public class MyArrayListV2Main {
    public static void main(String[] args) {
        MyArrayListV2 list = new MyArrayListV2();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println("list = " + list);

        System.out.println("=== 추가 ===");
        list.add("f");
        System.out.println("list = " + list);
    }
}
