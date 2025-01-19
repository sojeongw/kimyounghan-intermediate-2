package collection.array;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] arr = new int[5];

        System.out.println("arr = " + Arrays.toString(arr));

        // 입력: O(1)
        // 배열의 시작 참조값 + 자료의 크기 * 인덱스 위치
        // x100 + (4byte * 2) = x108
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        System.out.println("arr = " + Arrays.toString(arr));

        // 변경: O(1)
        arr[2] = 10;
        System.out.println("arr = " + Arrays.toString(arr));

        // 조회: O(1)
        System.out.println("arr[2] = " + arr[2]);

        // 검색: O(n)
        int value = 10;
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
            if (arr[i] == value) {
                System.out.println("value = " + value);
                break;
            }
        }
    }
}
