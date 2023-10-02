import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        @SuppressWarnings("unchecked")
        Numeros<Integer>[] arr = new Numeros[10];

        Numeros<Integer> x1 = new Numeros<Integer>(3);
        Numeros<Integer> x2 = new Numeros<Integer>(12);
        Numeros<Integer> x3 = new Numeros<Integer>(5);
        Numeros<Integer> x4 = new Numeros<Integer>(1);
        arr[0] = x1;
        arr[1] = x2;
        arr[2] = x3;
        arr[3] = x4;

        ArrayList<MyObject> list = new ArrayList<MyObject>();
        list.add(new MyObject(3));
        list.add(new MyObject(12));
        list.add(new MyObject(5));
        //Comparacion<Integer> comp = new Comparacion<>();
        

        Integer[] arr2 = {9,13,10,13,10,2,7};
        System.out.println("Unsorted array:");
        String result = toString(arr2);
        System.out.println(result);
        System.out.println("Sorted array with BUBBLE SORT:");
        //Sorting.bubbleSort(arr2, comp);
        Sorting.bubbleSort(arr2, (a, b) -> a - b);
        String resultSorted = toString(arr2);
        System.out.println(resultSorted);

    }

    // Method to print results
    public static <T> String toString(T[] arr){
        String result = "";
        for (int i =0; i < arr.length; i++){
            result = result + arr[i] + ", ";
        }
        result = "[" + result.replaceAll(", $", "") + "]";
        return result;
    }


}

