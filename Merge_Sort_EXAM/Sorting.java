import java.util.Comparator;

/**
 * Your implementation of Merge Sort.
 */
public class Sorting {

    /**
     * Implement merge sort.
     *
     * It should be: out-of-place stable not adaptive
     *
     * Have a worst case running time of: O(n log n) And a best case running time
     * of: O(n log n)
     *
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     *
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     *
     * Hint: You may need to create a helper method that merges two arrays back into
     * the original T[] array. If two data are equal when merging, think about which
     * subarray you should pull from first.
     *
     * You may assume that the passed in array and comparator are both valid and
     * will not be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array to be sorted.
     * @param comparator The Comparator used to compare the data in arr.
     */
    @SuppressWarnings("unchecked")
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(arr.length <= 1){
            return;
        }
        int length = arr.length;
        int midIdx = length / 2;
        
        T[] leftArray = (T[]) new Object[midIdx];
        for(int i = 0; i < midIdx; i++){
            leftArray[i] = arr[i];
        }

        T[] rightArray = (T[]) new Object[length - midIdx];
        for(int i = 0; i < (length - midIdx); i++){
            rightArray[i] = arr[midIdx + i];
        }
        mergeSort(leftArray, comparator);
        mergeSort(rightArray, comparator);

        int leftIdx = 0;
        int rightIdx = 0;
        int currIdx = 0;

        while(leftIdx < midIdx && rightIdx < (length-midIdx)){
            
            if(comparator.compare(leftArray[leftIdx], rightArray[rightIdx])<=0){
                arr[currIdx] = leftArray[leftIdx];
                leftIdx++;
            }
            else {
                arr[currIdx] = rightArray[rightIdx];
                rightIdx++;
            }
            currIdx++;
        }
        while(leftIdx < midIdx){
            arr[currIdx] = leftArray[leftIdx];
            leftIdx++;
            currIdx++;
        }
        while(rightIdx < (length-midIdx)){
            arr[currIdx] = rightArray[rightIdx];
            rightIdx++;
            currIdx++;
        }   
    }
}