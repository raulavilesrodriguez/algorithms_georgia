import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Integer> data = new ArrayList<>();
        data.add(8);
        data.add(11);
        data.add(6);
        data.add(6);
        data.add(7);
        data.add(1);
        data.add(6);
        data.add(11);
        data.add(3);
        data.add(10);
        data.add(12);
        data.add(3);
        data.add(4);
        data.add(8);
        data.add(11);
        System.out.println(data);
        MinHeap<Integer> minHeap = new MinHeap<>(data);
        System.out.println(minHeap.toString());
        System.out.println(minHeap.size());

        System.out.println("ADD (ENQUEUE) in MinHeap:");
        minHeap.add(0);
        System.out.println(minHeap.toString());

        System.out.println("REMOVE (ENQUEUE) in MinHeap:");
        System.out.println("Removing element: " + minHeap.remove());
        System.out.println(minHeap.toString());
        System.out.println("REMOVE (ENQUEUE) in MinHeap:");
        System.out.println("Removing element: " + minHeap.remove());
        System.out.println(minHeap.toString());
        System.out.println("REMOVE (ENQUEUE) in MinHeap:");
        System.out.println("Removing element: " + minHeap.remove());
        System.out.println(minHeap.toString());

        System.out.println("MINIMUM: " + minHeap.getMin());
        System.out.println("IS EMPTY?: " + minHeap.isEmpty());
        minHeap.clear();
        System.out.println(minHeap.toString());
        System.out.println("Veamos: " + minHeap.getBackingArray());

    }
}
