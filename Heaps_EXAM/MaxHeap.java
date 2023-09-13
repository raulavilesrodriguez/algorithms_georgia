/**
 * Your implementation of a MaxHeap.
 */
public class MaxHeap<T extends Comparable<? super T>> {

    /*
     * The initial capacity of the MaxHeap when created with the default
     * constructor.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MaxHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    @SuppressWarnings("unchecked")
    public MaxHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Removes and returns the max item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * You may assume that the heap is not empty.
     *
     * @return The data that was removed.
     */
    public T remove() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        int index = size;
        T data = backingArray[1];
        backingArray[1] = backingArray[index];
        backingArray[index] = null;
        index = 1;
        while(2*index < size){
            if(backingArray[2*index] != null && backingArray[2*index+1]!= null){
                if(backingArray[index].compareTo(backingArray[2*index]) > 0 
                && backingArray[index].compareTo(backingArray[2*index+1])>0){
                    index = size;  //to get out
                }
                else if(backingArray[2*index].compareTo(backingArray[2*index+1]) > 0){
                    T dummy = backingArray[index];
                    backingArray[index] = backingArray[2*index];
                    backingArray[2*index] = dummy;
                    index = 2 * index;
                } 
                else if(backingArray[2*index].compareTo(backingArray[2*index+1]) < 0){
                    T dummy = backingArray[index];
                    backingArray[index] = backingArray[2*index+1];
                    backingArray[2*index+1] = dummy;
                    index = 2*index + 1;
                }
            }
            else if(backingArray[2*index] != null){
                if(backingArray[index].compareTo(backingArray[2*index])>0){
                    index = size;
                } else {
                    T dummy = backingArray[index];
                    backingArray[index] = backingArray[2*index];
                    backingArray[2*index] = dummy;
                    index = 2*index;
                }    
            }
            else if(backingArray[2*index+1] != null){
                if(backingArray[index].compareTo(backingArray[2*index+1])>0){
                    index = size;
                } else {
                    T dummy = backingArray[index];
                    backingArray[index] = backingArray[2*index+1];
                    backingArray[2*index+1] = dummy;
                    index = 2*index + 1;
                }
            }
        }
        size--;
        return data;

    }

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
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
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}