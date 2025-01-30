package collection.hash;

public class MyHashSetV1Main {
    public static void main(String[] args) {
        MyHashSetV1 set = new MyHashSetV1(10);

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(9);
        set.add(99);

        System.out.println("set = " + set);

        int searchValue = 9;
        boolean contains = set.contains(searchValue);
        System.out.println("set.contains(" + searchValue + ") = " + contains);

        boolean remove = set.remove(searchValue);
        System.out.println("remove = " + remove);
        System.out.println("set = " + set);
    }
}
