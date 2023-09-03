import java.util.ArrayList;

/**
 * Your implementation of a MinHeap.
 *
 * @author RAUL AVILES
 * @version 1.0
 * @userid bravi
 * @GTID 900000000
 *
 * Collaborators: LIST ALL COLLABORATORS YOU WORKED WITH HERE
 *
 * Resources: LIST ALL NON-COURSE RESOURCES YOU CONSULTED HERE
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap when created with the default
     * constructor.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

    // Do not add new instance variables or modify existing ones.
    private T[] backingArray;
    private int size;

    /**
     * Constructs a new MinHeap.
     *
     * The backing array should have an initial capacity of INITIAL_CAPACITY.
     * To initialize the backing array, create a Comparable array and then cast
     * it to a T array.
     */
    @SuppressWarnings("unchecked")
     public MinHeap() {
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Creates a properly ordered heap from a set of initial values.
     *
     * You must use the BuildHeap algorithm that was taught in lecture! Simply
     * adding the data one by one using the add method will not get any credit.
     * As a reminder, this is the algorithm that involves building the heap
     * from the bottom up by repeated use of downHeap operations.
     *
     * Before doing the algorithm, first copy over the data from the
     * ArrayList to the backingArray (leaving index 0 of the backingArray
     * empty). The data in the backingArray should be in the same order as it
     * appears in the passed in ArrayList before you start the BuildHeap
     * algorithm.
     *
     * The backingArray should have capacity 2n + 1 where n is the
     * size of the passed in ArrayList (not INITIAL_CAPACITY). Index 0 should
     * remain empty, indices 1 to n should contain the data in proper order, and
     * the rest of the indices should be empty.
     *
     * @param data a list of data to initialize the heap with
     * @throws java.lang.IllegalArgumentException if data or any element in data
     *                                            is null
     */
    public MinHeap(ArrayList<T> data) {
        if(data == null){
            throw new IllegalArgumentException("You cannot add null data to the HEAP");
        }
        CapacityA(data);
        backingArray = BuildHeap(size/2);
    }

    @SuppressWarnings("unchecked")
    private void CapacityA(ArrayList<T> arr){
        ArrayList<T> arrN = new ArrayList<>();
        for(int i = 0; i < arr.size(); i++){
            int flag = 0;
            for(int j = 0; j < arrN.size(); j++){
                if(arrN.get(j)!= null && arrN.get(j) == arr.get(i)){
                    flag++;
                }
            }
            if(flag == 0){
                arrN.add(arr.get(i));
            }
        }
        int newSize = arrN.size() * 2 + 1;
        T [] copy = (T[]) new Comparable[newSize];
        size = 0;
        for(int i = 0; i < arrN.size(); i++){
            copy[i+1] = arrN.get(i);
            size++;
        }
        backingArray = (T[]) new Comparable[newSize];
        backingArray = copy;
    }

    private T[] BuildHeap(int index){
        while(index>=1){
            backingArray = downheap(index);
            index--;
        }
        return backingArray;
    }

    private T[] downheap(int index){
        if(2*index > size){
            return backingArray;
        }
        else if(backingArray[2*index] != null && backingArray[2*index+1]!= null){
            if(backingArray[index].compareTo(backingArray[2*index]) < 0 
            && backingArray[index].compareTo(backingArray[2*index+1])<0){
                backingArray = downheap(2*index);
                backingArray = downheap(2*index+1);
            } else if(backingArray[2*index].compareTo(backingArray[2*index+1]) < 0){
                T dummy = backingArray[index];
                backingArray[index] = backingArray[2*index];
                backingArray[2*index] = dummy;
                backingArray = downheap(2*index);
            } else if(backingArray[2*index].compareTo(backingArray[2*index+1]) > 0){
                T dummy = backingArray[index];
                backingArray[index] = backingArray[2*index+1];
                backingArray[2*index+1] = dummy;
                backingArray = downheap(2*index+1);
            }
        }
        else if(backingArray[2*index] != null){
            if(backingArray[index].compareTo(backingArray[2*index])<0){
                backingArray = downheap(2*index);
            } else {
                T dummy = backingArray[index];
                backingArray[index] = backingArray[2*index];
                backingArray[2*index] = dummy;
                backingArray = downheap(2*index);
            }    
        }
        else if(backingArray[2*index+1] != null){
            if(backingArray[index].compareTo(backingArray[2*index+1])<0){
                backingArray = downheap(2*index+1);
            } else {
                T dummy = backingArray[index];
                backingArray[index] = backingArray[2*index+1];
                backingArray[2*index+1] = dummy;
                backingArray = downheap(2*index+1);
            }
        }
        
        return backingArray;
    }


    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     * The order property of the heap must be maintained after adding. You can
     * assume that no duplicate data will be passed in.
     * 
     * @param data the data to add
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void add(T data) {
        if(data == null){
            throw new IllegalArgumentException("You cannot add null data to the Array list");
        }
        if(size >= backingArray.length){
            Capacity();
        }
        int index = size + 1;
        backingArray[index] = data;
        int parentIndex = index / 2;
        while(parentIndex >= 1 && backingArray[parentIndex].compareTo(backingArray[index])>0){
            T dummy = backingArray[parentIndex];
            backingArray[parentIndex] = backingArray[index];
            backingArray[index] = dummy;
            index = parentIndex;
            parentIndex = parentIndex / 2;
        }
        size++;
    }

    @SuppressWarnings("unchecked")
    private void Capacity(){
        int newSize = backingArray.length * 2;
        T [] copy = (T[]) new Object[newSize];
        for(int i = 0; i <= size; i++){
            copy[i] = backingArray[i];
        }
        backingArray = (T[]) new Object[newSize];
        backingArray = copy;
    }

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     * The order property of the heap must be maintained after removing.
     *
     * @return the data that was removed
     * @throws java.util.NoSuchElementException if the heap is empty
     */
    public T remove() {
        return backingArray[1];
    }

    /**
     * Returns the minimum element in the heap.
     *
     * @return the minimum element
     * @throws java.util.NoSuchElementException if the heap is empty
     */
    public T getMin() {
        return backingArray[1];
    }

    /**
     * Returns whether or not the heap is empty.
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return (size == 0) ? true: false; 
    }

    /**
     * Clears the heap.
     *
     * Resets the backing array to a new array of the initial capacity and
     * resets the size.
     */
    public void clear() {

    }

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    public String toString(){
        String result = "";
        for(int i = 0; i < backingArray.length; i++){
            result = result + backingArray[i] + ", ";
        }
        result = "[" + result.replaceAll(", $", "") + "]";
        return  result;
    }
}