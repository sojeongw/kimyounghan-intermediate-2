package collection.compare;

import java.util.Arrays;

public class SortMainV3 {
    public static void main(String[] args) {
        MyUser myUser1 = new MyUser("a", 30);
        MyUser myUser2 = new MyUser("b", 20);
        MyUser myUser3 = new MyUser("c", 10);

        MyUser[] array = {myUser1, myUser2, myUser3};
        System.out.println("array = " + Arrays.toString(array));

        Arrays.sort(array);
        System.out.println("array = " + Arrays.toString(array));

        Arrays.sort(array, new IdComparator());
        System.out.println("array = " + Arrays.toString(array));
    }
}
