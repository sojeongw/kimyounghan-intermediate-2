package collection.hash;

import java.util.Arrays;
import java.util.LinkedList;

public class HashStart {

    static final int CAPACITY = 10;

    public static void main(String[] args) {
        // 연결 리스트가 들어가는 배열
        LinkedList<Integer>[] buckets = new LinkedList[CAPACITY];
        System.out.println("buckets = " + Arrays.toString(buckets));

        for (int i = 0; i < CAPACITY; i++) {
            // 충돌이 일어날 때만 가끔 추가하므로 배열 리스트 대신 연결 리스트 사용
            buckets[i] = new LinkedList<>();
        }

        System.out.println("buckets = " + Arrays.toString(buckets));
        add(buckets, 1);
        add(buckets, 2);
        add(buckets, 5);
        add(buckets, 8);
        add(buckets, 14);
        add(buckets, 9);
        add(buckets, 99);
        System.out.println("buckets = " + Arrays.toString(buckets));

        int searchValue = 9;
        boolean contains = contains(buckets, searchValue);
        System.out.println("bucket.contains(" + searchValue + ") = " + contains);
    }

    private static boolean contains(LinkedList<Integer>[] buckets, int searchValue) {
        int hashIndex = hashIndex(searchValue);
        LinkedList<Integer> bucket = buckets[hashIndex];    //  O(1)
        return bucket.contains(searchValue);    // O(n)
    }

    private static void add(LinkedList<Integer>[] buckets, int value) {
        int hashIndex = hashIndex(value);

        // 중복으로 데이터가 들어갈 수 있으므로 배열 안에 있는 리스트에 넣는다.
        LinkedList<Integer> bucket = buckets[hashIndex];    //  O(1)
        if (!bucket.contains(value)) {  // O(n)
            bucket.add(value);
        }
    }

    static int hashIndex(int value) {
        return value % CAPACITY;
    }
}
