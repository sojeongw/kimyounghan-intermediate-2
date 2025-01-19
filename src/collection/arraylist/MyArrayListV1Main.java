package collection.arraylist;

public class MyArrayListV1Main {
    public static void main(String[] args) {
        // List: 순서가 있고 중복을 허용한다. 배열과 달리 크기가 동적으로 변한다.
        MyArrayListV1 list = new MyArrayListV1();

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

        System.out.println("=== 범위 초과 ===");
        list.add("f");
    }
}
