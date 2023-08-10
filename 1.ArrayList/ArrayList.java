
public class ArrayList<T>{
    private int size = 0;
    private static final int INITIAL_CAPACITY = 9;
    private Object arr [];

    /*Constructor methods*/
    public ArrayList(){
        arr = new Object[INITIAL_CAPACITY];
    }

    public ArrayList(int capacity){
        arr = new Object[capacity];
    }

    
    /** 
     * @return int size
     */
    /*Methods*/
    public int size(){
        return size;
    }

    private void Capacity(){
        int newSize = arr.length * 2;
        Object [] copy = new Object[newSize];
        for(int i = 0; i < arr.length; i++){
            copy[i] = arr[i];
        }
        arr = new Object[newSize];
        arr = copy;
    }

    
    /** 
     * @param data
     */
    public void addToFront(T data){
        if(data == null){
            throw new IllegalArgumentException("You cannot add null data to the Array list");
        }
        if(size >= arr.length){
            Capacity();
        }
        for(int i = size - 1; i >=0; i--){
            arr[i+1] = arr[i];
        }
        arr[0] = data;
        size++;
    }

    
    /** 
     * @param data
     */
    public void addToBack(T data){
        if(data == null){
            throw new IllegalArgumentException("You cannot add null data to the Array list");
        }
        if(size >= arr.length){
            Capacity();
        }
        int i = size - 1;
        arr[i+1] = data;
        size++;
    }

    
    /** 
     * @return T
     */
    public T removeFromFront(){
        Object item = arr[0];
        arr[0] = null;
        for(int i = 0; i<= size-2; i++){
            arr[i] = arr[i+1];
        }
        size--;
        @SuppressWarnings("unchecked") T oldValue = (T) item;
        return oldValue;
    }

    
    /** 
     * @return T
     */
    public T removeFromBack(){
        Object item = arr[size - 1];
        arr[size - 1] = null;
        size--;
        @SuppressWarnings("unchecked") T oldValue = (T) item;
        return oldValue;
    }

    
    /** 
     * @param index
     * @return T
     */
    public T get(int index){
        if(index >= size || index < 0){
            throw new IllegalArgumentException("You cannot add null data to the Array list");
        }
        @SuppressWarnings("unchecked") T value = (T) arr[index];
        return value;
    }

    
    /** 
     * @return String
     */
    public String toString(){
        String result = "";
        for(int i = 0; i <= size-1; i++){
            result = result + arr[i] + ", ";
        }
        result = "[" + result.replaceAll(", $", "") + "]";
        return  result;
    }

    
    /** 
     * @param index
     * @param data
     */
    public void add(int index, T data){
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        if(data == null){
            throw new IllegalArgumentException("You cannot add null data to the Array list");
        }
        if(size >= arr.length){
            Capacity();
        }
        for(int i = size - 1; i >=index; i--){
            arr[i+1] = arr[i];
        }
        arr[index] = data;
        size++;
    }

    
    /** 
     * @param index
     * @return T
     */
    public T remove(int index){
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        Object item = arr[index];
        arr[index] = null;
        for(int i = index; i<= size-2; i++){
            arr[i] = arr[i+1];
        }
        size--;
        @SuppressWarnings("unchecked") T oldValue = (T) item;
        return oldValue;
    }

    public void clear(){
        size = 0;
    }
    
}