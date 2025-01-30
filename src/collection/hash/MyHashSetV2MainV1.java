package collection.hash;

public class MyHashSetV2MainV1 {
    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2(10);

        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("AB");
        set.add("SET");
        System.out.println("set = " + set);

        System.out.println("\"A\".hashCode() = " + "A".hashCode());
        System.out.println("\"B\".hashCode() = " + "B".hashCode());
        System.out.println("\"AB\".hashCode() = " + "AB".hashCode());
        System.out.println("\"SET\".hashCode() = " + "SET".hashCode());

        String searchValue = "SET";
        boolean contains = set.contains(searchValue);
        System.out.println("set.contains(" +searchValue + ") = "+ contains);
    }
}
