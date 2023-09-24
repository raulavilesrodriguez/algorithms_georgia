public class Test {
    public static void main(String[] args){
        AVL<Integer> avl = new AVL<>();
        
        // Example ADD to do double rotations
        System.out.println("Example ADD to do DOUBLE rotations"); 
        avl.add(6);
        avl.add(3);
        avl.add(9);
        avl.add(1);
        avl.add(4);
        avl.preOrder();
        // Next is where the two double rotations occur
        System.out.println("Next is where the two double rotations occur");
        avl.add(5);
        avl.preOrder();
        System.out.println("IS THIS DATA: " + avl.get(3));
        System.out.println("IS THIS DATA: " + avl.contains(19));
        System.out.println("HEIGHT: " + avl.height());
        System.out.println("SIZE: " + avl.size());
        avl.clear();
        System.out.println("HEIGHT: " + avl.height());
        System.out.println("SIZE: " + avl.size());

        // Example ADD to do an LEFT rotation
        System.out.println("2. Example ADD to do an LEFT rotation");
        avl.add(6);
        avl.add(4);
        avl.add(9);
        avl.add(1);
        avl.add(5);
        avl.add(8);
        avl.add(2);
        avl.preOrder();
        System.out.println("Next is where LEFT rotation occur");
        avl.add(3);
        avl.preOrder();
        avl.clear();

        // Example ADD to do an RIGHT rotation
        System.out.println("3. Example ADD to do an RIGHT rotation");
        System.out.println("SIZE: " + avl.size());
        avl.add(6);
        avl.add(4);
        avl.add(9);
        avl.add(1);
        avl.add(5);
        avl.preOrder();
        System.out.println("Next is where RIGHT rotation occur");
        avl.add(0);
        avl.add(9);
        avl.preOrder();
        avl.clear();

        // Example of 4 rotations
        System.out.println("4. Example of 4 rotation");
        System.out.println("SIZE: " + avl.size());
        avl.add(1);
        avl.add(2);
        avl.add(3);
        avl.add(4);
        avl.add(5);
        avl.add(6);
        avl.add(7);
        avl.add(8);
        avl.preOrder();
        avl.clear();

        //REMOVE
        System.out.println("5. Example of REMOVE  DOUBLE rotations");
        System.out.println("SIZE: " + avl.size());
        avl.add(6);
        avl.add(4);
        avl.add(12);
        avl.add(1);
        avl.add(5);
        avl.add(10);
        avl.add(13);
        avl.add(0);
        avl.add(9);
        avl.add(11);
        avl.add(14);
        avl.add(8);
        avl.remove(5);
        avl.preOrder();
        avl.clear();

        System.out.println("6. Example of REMOVE the ROOT 1 rotation");
        System.out.println("SIZE: " + avl.size());
        avl.add(6);
        avl.add(4);
        avl.add(12);
        avl.add(5);
        avl.add(10);
        avl.add(13);
        avl.add(11);
        avl.remove(6);
        avl.preOrder();
        avl.clear();

        System.out.println("7. Example of REMOVE and trigger a DOUBLE rotation");
        System.out.println("SIZE: " + avl.size());
        avl.add(5);
        avl.add(2);
        avl.add(10);
        avl.add(1);
        avl.add(4);
        avl.add(7);
        avl.add(12);
        avl.add(3);
        avl.add(6);
        avl.add(9);
        avl.add(11);
        avl.add(13);
        avl.add(8);
        avl.remove(2);
        avl.preOrder();

        System.out.println(avl.elementsWithinDistance(8, 3));

    } 
}
