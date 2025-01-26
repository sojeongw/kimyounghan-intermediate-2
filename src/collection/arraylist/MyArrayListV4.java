package collection.arraylist;

import java.util.Arrays;

public class MyArrayListV4<E> {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData;
    private int size = 0;

    public MyArrayListV4() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV4(int initialCapacity) {
        this.elementData = new Object[initialCapacity];
    }

    public int size() {
        return size;
    }

    public void add(E e) {
        // 코드 추가
        if (size == elementData.length) {
            grow();
        }

        elementData[size] = e;
        size++;
    }

    public E remove(int index) {
        E oldValue = get(index);

        // 삭제하고 난 뒤 빈 곳으로 하나씩 데이터를 이동한다.
        shiftLeftFrom(index);
        size--;
        // 마지막에 옮겨주고 남아있는 데이터를 비워준다.
        elementData[size] = null;

        return oldValue;
    }

    private void shiftLeftFrom(int index) {
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
    }

    public void add(int index, E o) {
        if (size == elementData.length) {
            grow();
        }

        // 데이터를 다 밀어주고 추가한다.
        shiftRightFrom(index);
        elementData[index] = o;
        size++;
    }

    private void shiftRightFrom(int index) {
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
    }

    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity * 2;

        // 기존 배열을 새로운 배열에 복사
        // 기존 배열은 더 이상 참조하지 않으므로 GC의 대상이 된다.
        elementData = Arrays.copyOf(elementData, newCapacity);

        // 데이터를 하나 추가할 때마다 크기를 1씩 추가하면 연산이 너무 많이 일어난다.
        // 새로 배열을 만들고 복사하는 시간까지 있으므로 가능한 줄이는 것이 좋다.
        // 반면 너무 크게 증가하면 메모리가 낭비될 수 있다.
        // 보통은 50% 정도 증가하는 방법을 사용한다.
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) elementData[index];
    }

    public E set(int index, E element) {
        E oldValue = get(index);
        elementData[index] = element;

        return oldValue;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "MyArrayListV1{" +
                // 빈 칸을 출력하지 않기 위함
                "elementData=" + Arrays.toString(Arrays.copyOf(elementData, size)) +
                ", size=" + size +
                ", capacity=" + elementData.length +
                '}';
    }
}
