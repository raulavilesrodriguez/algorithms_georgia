public class BSTest{
    public static void main(String[] args){
        BST<Integer> tree = new BST<>();
        tree.add(1);
        tree.add(0);
        tree.add(14);
        tree.add(10);
        tree.add(15);
        tree.add(5);
        tree.add(13);

        System.out.println("HEIGHT: " + tree.heigh());

        System.out.println("In-Order: ");
        tree.inOrder();
        System.out.println("");
        System.out.println("Post-Order:");
        tree.postOrder();
        System.out.println("");
        System.out.println("Pre-Order:");
        tree.preOrder();
        System.out.println("");

        System.out.println("REMOVE");
        tree.remove(10);
        
        System.out.println("In-Order: ");
        tree.inOrder();
        System.out.println("");
        System.out.println("Post-Order:");
        tree.postOrder();
        System.out.println("");
        System.out.println("Pre-Order:");
        tree.preOrder();
        System.out.println("");

        System.out.println("HEIGHT: " + tree.heigh());
        tree.contain();
        System.out.println("");

        System.out.println("CLEAR");
        tree.clear();
        tree.contain();

    }
}