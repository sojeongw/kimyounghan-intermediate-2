package collection.arraylist;

public class MyArrayListV4Main {
    public static void main(String[] args) {
        MyArrayListV4<String> list = new MyArrayListV4<>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println("list = " + list);
        System.out.println("list.get(0) = " + list.get(0));

        // 숫자 불가
//        list.add(1);
    }
}
