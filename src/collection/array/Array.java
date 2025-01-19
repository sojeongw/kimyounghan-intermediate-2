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

        // 데이터 추가: O(n)
        // 처음이나 중간에 추가하려면 기존 값을 오른쪽으로 한 칸씩 이동해줘야 한다.

        // 첫 칸에 추가할 경우: 배열의 위치를 찾는 데 O(1) + 데이터 이동에 O(n) = O(n)
        int newValue = 3;
        // 뒤에서부터 하나씩 옮긴다.
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = newValue;
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));

        // 중간에 추가할 경우: 배열의 위치를 찾는 데 O(1) + 데이터 이동에 O(n/2) = O(n)
        int index = 2;
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = 4;
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));

        // 마지막에 추가할 경우: 기존 배열을 이동하지 않으므로 위치 찾는 데만 O(1)
        arr[arr.length-1] = 9;
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }
}
