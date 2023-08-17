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

    public T enqueue(){

    }

}