import java.util.Comparator;

/**
 * Your implementation of Selection Sort.
 */
public class Sorting {

    /**
     * Implement selection sort.
     *
     * It should be: in-place unstable not adaptive
     *
     * Have a worst case running time of: O(n^2) And a best case running time of:
     * O(n^2)
     *
     * You may assume that the passed in array and comparator are both valid and
     * will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        for(int i = arr.length-1; i>=0; i--){
            int max = i;
            for(int j= i -1; j>=0; j--){
                if(comparator.compare(arr[j], arr[max])>0){
                    max = j;
                }
            }
            T dummy = arr[i];
            arr[i] = arr[max];
            arr[max] = dummy;
        }   
    }
}