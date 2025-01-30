package collection.hash;

public class HashAndEqualsMainV1 {

    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2(10);

        MemberNoHashNoEq m1 = new MemberNoHashNoEq("A");
        MemberNoHashNoEq m2 = new MemberNoHashNoEq("A");

        // 해시 코드를 재정의 하지 않아서 객체 참조값이 나온다.
        System.out.println("m1.hashCode() = " + m1.hashCode());
        System.out.println("m2.hashCode() = " + m2.hashCode());

        // 해시 코드도 값도 같지 않다.
        System.out.println("m1.equals(m2) = " + m1.equals(m2));

        // 중복으로 들어가면 안되는데 들어간다.
        // contains에서 equals()를 사용하기 때문
        set.add(m1);
        set.add(m2);
        System.out.println("set = " + set);

        // 해당 해시 인덱스에 값이 없으니 검색도 안 된다.
        MemberNoHashNoEq searchValue = new MemberNoHashNoEq("A");
        System.out.println("searchValue.hashCode() = " + searchValue.hashCode());
        System.out.println("set.contains(searchValue) = " + set.contains(searchValue));
    }
}
