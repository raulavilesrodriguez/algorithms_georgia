public class TestSinglyLinked {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> lista = new SinglyLinkedList<>();
        System.out.println("SIZE: " + lista.getSize());
        System.out.println("REMOVE FRONT: " + lista.removeFromFront());
        lista.addToBack(69);
        lista.addToBack(45);
        lista.addToFront(3);
        lista.addToFront(8);
        lista.addToFront(5);
        lista.addToBack(1);
        lista.addToBack(14);
        System.out.println(lista.toString());
        System.out.println(lista.getHead());
        System.out.println(lista.getTail());
        System.out.println("SIZE: " + lista.getSize());

        // Remove
        System.out.println("REMOVE FRONT: " + lista.removeFromFront());
        System.out.println(lista.toString());
        System.out.println(lista.getHead());
        System.out.println(lista.getTail());
        System.out.println("SIZE: " + lista.getSize());

        System.out.println("REMOVE FRONT: " + lista.removeFromFront());
        System.out.println("REMOVE BACK: " + lista.removeFromBack());
        System.out.println(lista.toString());
        System.out.println(lista.getHead());
        System.out.println(lista.getTail());
        System.out.println("SIZE: " + lista.getSize());

        System.out.println("REMOVE BACK: " + lista.removeFromBack());
        System.out.println(lista.toString());
        System.out.println(lista.getHead());
        System.out.println(lista.getTail());
        System.out.println("SIZE: " + lista.getSize());

        System.out.println("REMOVE BACK: " + lista.removeFromBack());
        System.out.println(lista.toString());
        System.out.println(lista.getHead());
        System.out.println(lista.getTail());
        System.out.println("SIZE: " + lista.getSize());

        System.out.println("REMOVE BACK: " + lista.removeFromBack());
        System.out.println(lista.toString());
        System.out.println(lista.getHead());
        System.out.println(lista.getTail());
        System.out.println("SIZE: " + lista.getSize());

        System.out.println("REMOVE BACK: " + lista.removeFromBack());
        System.out.println(lista.toString());
        System.out.println(lista.getHead());
        System.out.println(lista.getTail());
        System.out.println("SIZE: " + lista.getSize());

    }
}
