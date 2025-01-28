package collection.list;

public class BatchProcessorMain {
    public static void main(String[] args) {
        // 크기: 50000, 계산 시간: 1018ms
//        MyArrayList<Integer> list = new MyArrayList<>();
        // 크기: 50000, 계산 시간: 1ms
        MyLinkedList<Integer> list = new MyLinkedList<>();

        BatchProcessor batchProcessor = new BatchProcessor(list);
        batchProcessor.logic(50_000);
    }
}
