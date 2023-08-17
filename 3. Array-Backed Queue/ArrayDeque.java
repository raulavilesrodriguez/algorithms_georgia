public class ArrayDeque<T>{
    private int size;
    private int front;
    private static final int INITIAL_CAPACITY = 9;
    private Object arr [];

    /*Constructor methods*/
    public ArrayDeque(){
        arr = new Object[INITIAL_CAPACITY];
    }
    public ArrayDeque(int capacity){
        arr = new Object[capacity];
    }

    /*Methods*/
    public int size(){
        return size;
    }

    public void enqueue(T data){
        if(data == null){
            throw new IllegalArgumentException("You cannot add null data to the Array list");
        }
        if(size == arr.length){
            Object [] newArray = new Object[2*size];
            for(int i = 0; i <= size-1; i++){
                newArray[i] = arr[(front + i) % arr.length];
            }
            arr = newArray;
            front = 0;
        }
        arr[(front + size) % arr.length] = data;
        size++;
    }

    public T dequeue(){
        if(size == 0){
            System.out.print("Queue IS EMPTY");
            @SuppressWarnings("unchecked") T empty = (T) "";
            return empty;
        }
        Object data = arr[front];
        arr[front] = null;
        front = (front + 1) % arr.length;
        size--;
        @SuppressWarnings("unchecked") T oldValue = (T) data;
        return oldValue;
    }

    public void clear(){
        size = 0;
        front = 0;
    }

    public T peek(){
        if(size == 0){
            @SuppressWarnings("unchecked") T empty = (T) "Queue IS EMPTY BROO ";
            return empty;
        } else{
            Object data = arr[front];
            @SuppressWarnings("unchecked") T head = (T) data;
            return head;
        }
    }

    public String toString(){
        String result = "";
        for(int i = 0; i < arr.length; i++){
            result = result + arr[i] + ", ";
        }
        result = "[" + result.replaceAll(", $", "") + "]";
        return  result;
    }

    public int getFront(){
        return front;
    }

}