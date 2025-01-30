package collection.hash;

public class HashAndEqualsMainV3 {

    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2(10);

        MemberHashEq m1 = new MemberHashEq("A");
        MemberHashEq m2 = new MemberHashEq("A");

        // 같은 해시 코드가 나온다.
        System.out.println("m1.hashCode() = " + m1.hashCode());
        System.out.println("m2.hashCode() = " + m2.hashCode());

        // 같다.
        System.out.println("m1.equals(m2) = " + m1.equals(m2));

        // 중복으로 들어가지 않는다..
        set.add(m1);
        set.add(m2);
        System.out.println("set = " + set);

        // 해당 해시 인덱스에 동일한 값이 있다.
        MemberHashEq searchValue = new MemberHashEq("A");
        System.out.println("searchValue.hashCode() = " + searchValue.hashCode());
        System.out.println("set.contains(searchValue) = " + set.contains(searchValue));
    }
}
