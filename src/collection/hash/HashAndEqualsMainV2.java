package collection.hash;

public class HashAndEqualsMainV2 {

    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2(10);

        MemberHashNoEq m1 = new MemberHashNoEq("A");
        MemberHashNoEq m2 = new MemberHashNoEq("A");

        // 같은 해시 코드가 나온다.
        System.out.println("m1.hashCode() = " + m1.hashCode());
        System.out.println("m2.hashCode() = " + m2.hashCode());

        // 같지 않다.
        System.out.println("m1.equals(m2) = " + m1.equals(m2));

        // 중복으로 들어가면 안되는데 들어간다.
        set.add(m1);
        set.add(m2);
        System.out.println("set = " + set);

        // 해당 해시 인덱스에 값은 있으나 equals 비교에서 실패한다.
        MemberHashNoEq searchValue = new MemberHashNoEq("A");
        System.out.println("searchValue.hashCode() = " + searchValue.hashCode());
        System.out.println("set.contains(searchValue) = " + set.contains(searchValue));
    }
}
