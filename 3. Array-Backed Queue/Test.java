public class Test {
    public static void main(String[] args){
        ArrayDeque<Integer> array = new ArrayDeque<>();

        System.out.println(array.dequeue());
        array.enqueue(4);
        System.out.println(array.toString());

        array.enqueue(5);
        array.enqueue(8);
        array.enqueue(9);
        System.out.println(array.toString());
        System.out.println("INDEX FRONT: " + array.getFront());
        System.out.println(array.dequeue());
        System.out.println(array.toString());
        System.out.println("INDEX FRONT: " + array.getFront());
        System.out.println(array.size());

        System.out.println(array.dequeue());
        System.out.println(array.toString());
        System.out.println("INDEX FRONT: " + array.getFront());

        array.enqueue(1);
        array.enqueue(2);
        array.enqueue(4);
        System.out.println(array.toString());
        System.out.println("INDEX FRONT: " + array.getFront());

        System.out.println(array.dequeue());
        System.out.println(array.toString());
        System.out.println("INDEX FRONT: " + array.getFront());

        array.enqueue(32);
        array.enqueue(22);
        array.enqueue(44);
        array.enqueue(6);
        System.out.println(array.toString());
        System.out.println("INDEX FRONT: " + array.getFront());

        array.enqueue(69);
        System.out.println(array.toString());
        System.out.println("INDEX FRONT: " + array.getFront());

        array.enqueue(7);
        System.out.println(array.toString());
        System.out.println("INDEX FRONT: " + array.getFront());
        System.out.println("PEEK: " + array.peek());

        System.out.println("---ARRAY 2 TEST----");
        ArrayDeque<Integer> array2 = new ArrayDeque<>(5);
        array2.enqueue(3);
        array2.enqueue(4);
        array2.enqueue(0);
        array2.enqueue(1);
        array2.enqueue(2);
        System.out.println(array2.toString());
        System.out.println("INDEX FRONT: " + array2.getFront());
        
        System.out.println(array2.dequeue());
        System.out.println(array2.dequeue());
        System.out.println(array2.dequeue());
        System.out.println(array2.dequeue());
        array2.enqueue(3);
        array2.enqueue(4);
        array2.enqueue(20);
        System.out.println(array2.toString());
        System.out.println("INDEX FRONT: " + array2.getFront());

        System.out.println(array2.dequeue());
        System.out.println(array2.toString());
        System.out.println("INDEX FRONT: " + array2.getFront());

        System.out.println(array2.dequeue());
        System.out.println(array2.dequeue());
        System.out.println(array2.toString());
        System.out.println("INDEX FRONT: " + array2.getFront());
        System.out.println("PEEK: " + array2.peek());

        System.out.println(array2.dequeue());
        System.out.println(array2.toString());
        System.out.println("INDEX FRONT: " + array2.getFront());
        System.out.println("PEEK: " + array2.peek());
        array2.enqueue(null);

    }
}
