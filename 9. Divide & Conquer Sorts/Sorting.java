import java.util.Comparator;
import java.util.LinkedList;
//import java.util.ArrayList;
//import java.util.Random;

/**
 * Your implementation of various sorting algorithms.
 *
 * @author RAÚL AVILÉS RODRÍGUEZ
 * @version 41.6
 * @userid bravile
 * @GTID 9976 (i.e. 900000000)
 *
 * Collaborators: NONE
 *
 * Resources: NONE
 */
public class Sorting {


    /**
     * Implement bubble sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of:
     * O(n^2)
     *
     * And a best case running time of:
     * O(n)
     *
     * NOTE: See pdf for last swapped optimization for bubble sort. You
     * MUST implement bubble sort with this optimization
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        if(arr == null){
            throw new IllegalArgumentException("Cannot sort null array BROO");
        }
        if(comparator == null){
            throw new IllegalArgumentException("Cannot sort with a null comparator PARCE");
        }

        int swapCount = 0;
        int compaCount = 0;

        int end = arr.length - 1;
        int start = 0;
        while(end != 0){
            int i = start;
            int swapped = start;
            while(i < end){
                if(comparator.compare(arr[i], arr[i+1])>0){
                    T dummy = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = dummy;
                    swapped = i;
                    swapCount++;
                }
                i++;
                compaCount++;
            }
            end = swapped;
        }
        System.out.println("SWAP COUNT:" + swapCount);
        System.out.println("COMPARASION COUNT:" + compaCount);
    }


    /**
     * Implement selection sort.
     *
     * It should be:
     * in-place
     * unstable
     * not adaptive
     *
     * Have a worst case running time of:
     * O(n^2)
     *
     * And a best case running time of:
     * O(n^2)
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        if(arr == null){
            throw new IllegalArgumentException("Cannot sort null array BROO");
        }
        if(comparator == null){
            throw new 
            IllegalArgumentException("Cannot sort with a null comparator PARCE");
        }

        int swapCount = -1;
        int compaCount = 0;

        for(int i = arr.length-1; i>=0; i--){
            int max = i;
            for(int j= i -1; j>=0; j--){
                if(comparator.compare(arr[j], arr[max])>0){
                    max = j;
                }
                compaCount++;
            }
            T dummy = arr[i];
            arr[i] = arr[max];
            arr[max] = dummy;
            swapCount++;
        }
        System.out.println("SWAP COUNT:" + swapCount);
        System.out.println("COMPARASION COUNT:" + compaCount);
    }

    /**
     * Implement insertion sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of:
     * O(n^2)
     *
     * And a best case running time of:
     * O(n)
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        if(arr == null){
            throw new IllegalArgumentException("Cannot sort null array BROO");
        }
        if(comparator == null){
            throw new 
            IllegalArgumentException("Cannot sort with a null comparator PARCE");
        }

        int swapCount = 0;

        for(int i = 1; i<= arr.length-1; i++){
            int j = i;
            while(j>0 && comparator.compare(arr[j-1], arr[j])>0){
                T dummy = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = dummy;
                j--;
                swapCount++;
            }
        }

        System.out.println("SWAP COUNT:" + swapCount);

    }

    /**
     * Implement cocktail sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of:
     * O(n^2)
     *
     * And a best case running time of:
     * O(n)
     *
     * NOTE: See pdf for last swapped optimization for cocktail sort. You
     * MUST implement cocktail sort with this optimization
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void cocktailSort(T[] arr, Comparator<T> comparator) {
        if(arr == null){
            throw new IllegalArgumentException("Cannot sort null array BROO");
        }
        if(comparator == null){
            throw new IllegalArgumentException("Cannot sort with a null comparator PARCE");
        }

        int swapCount = 0;

        int end = arr.length - 1;
        int start = 0;
        boolean swapsMade = true;
        int swapped = start;

        while(swapsMade){
            swapsMade = false;
            for(int i = start; i< end; i++){
                if(comparator.compare(arr[i], arr[i+1])>0){
                    T dummy = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = dummy;
                    swapsMade = true;
                    swapped = i;
                    swapCount++;
                }
            
            }
            end = swapped;
            if(swapsMade){
                swapsMade = false;
                for(int i = end; i>=start; i--){
                    if(i>0 && comparator.compare(arr[i-1], arr[i])>0){
                        T dummy = arr[i-1];
                        arr[i-1] = arr[i];
                        arr[i] = dummy;
                        swapsMade = true;
                        swapped = i;
                        swapCount++;
                    }
                    
                }
                start = swapped;
            }
        }

        System.out.println("SWAP COUNT:" + swapCount);

    }

    /**
     * Implement merge sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of:
     * O(n log n)
     *
     * And a best case running time of:
     * O(n log n)
     *
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     *
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     *
     * Hint: If two data are equal when merging, think about which subarray
     * you should pull from first
     *
     * @param <T>        data type to sort
     * @param arr        the array to be sorted
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    @SuppressWarnings("unchecked")
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator){
        if(arr == null){
            throw new IllegalArgumentException("Cannot sort null array BROO");
        }
        if(comparator == null){
            throw new IllegalArgumentException("Cannot sort with a null comparator PARCE");
        }
        if(arr.length == 1){
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
        int swapCount = 0; // to test

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
            swapCount++;
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
        System.out.println("SWAP COUNT:" + swapCount);
    }

    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * Make sure you code the algorithm as you have been taught it in class.
     * There are several versions of this algorithm and you may not get full
     * credit if you do not implement the one we have taught you!
     *
     * Remember you CANNOT convert the ints to strings at any point in your
     * code! Doing so may result in a 0 for the implementation.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of:
     * O(kn)
     *
     * And a best case running time of:
     * O(kn)
     *
     * You are allowed to make an initial O(n) passthrough of the array to
     * determine the number of iterations you need.
     *
     * At no point should you find yourself needing a way to exponentiate a
     * number; any such method would be non-O(1). Think about how how you can
     * get each power of BASE naturally and efficiently as the algorithm
     * progresses through each digit.
     *
     * Refer to the PDF for more information on LSD Radix Sort.
     *
     * You may use ArrayList or LinkedList if you wish, but it may only be
     * used inside radix sort and any radix sort helpers. Do NOT use these
     * classes with other sorts. However, be sure the List implementation you
     * choose allows for stability while being as efficient as possible.
     *
     * Do NOT use anything from the Math class except Math.abs().
     *
     * @param arr the array to be sorted
     * @throws java.lang.IllegalArgumentException if the array is null
     */
    @SuppressWarnings("unchecked")
    public static void lsdRadixSort(Integer[] arr){
        if(arr == null){
            throw new IllegalArgumentException("Cannot sort null array BROO");
        }        
        LinkedList<Integer>[] buckets = new LinkedList[10];
        // Initialize each LinkedList in the array
        for(int i = 0; i < buckets.length; i++){
            buckets[i] = new LinkedList<>();
        }
        int largest = arr[0];
        for(int i = 0; i<arr.length-1; i++){
            if(arr[i]>=arr[i+1] && arr[i]>largest){
                largest = arr[i];
            } 
            if(arr[i]<=arr[i+1] && arr[i+1]>largest){
                largest = arr[i+1];
            }
        }
        System.out.println("VER LARGE: " + largest);
        int iterations = 0;
        int temp = largest;
        while(temp != 0){
            temp = temp / 10;
            iterations++;
        }
        System.out.println("VER ITERATIONS: " + iterations);
        for(int i = 1; i<=iterations; i++){
            for(int j = 0; j<= arr.length-1; j++){
                int value = arr[j];
                int go = 0;
                int digit = 0;
                while(go < i){
                    digit = Math.abs(value % 10);
                    value /= 10;
                    go++;
                }
                LinkedList<Integer> bucket = buckets[digit];
                bucket.add(arr[j]);
                buckets[digit] = bucket;
            }
            int index = 0;

            int base = 9; // base 10, 0 to 9
            for(int z = 0; z<=base; z++){
                LinkedList<Integer> bucket = buckets[z];
                while(!bucket.isEmpty()){
                    arr[index] =bucket.removeFirst();
                    index++;
                }
            }
        }     
    }
    
    
}
