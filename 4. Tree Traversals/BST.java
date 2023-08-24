public class BST<T extends Comparable<? super T>> {
    private BSTNode<T> root;
    private int size;

    /*Constructor methods*/
    public BST(){
        this.root = null;
    }

    /*Methods*/
    public boolean isEmpty(){
        return (root == null);
    }

    public void add(T data){
        root = addH(data, root);
    }

    private BSTNode<T> addH(T data, BSTNode<T> curr){
        if(data == null){
            throw new IllegalArgumentException("Error: You cannot add null data to the tree");
        }
        if(curr == null){
            size++;
            BSTNode<T> node = new BSTNode<T>(data);
            return node;
        } 
        else if(data.compareTo(curr.getData())<0){
            curr.setLeft(addH(data, curr.getLeft()));
        }
        else if(data.compareTo(curr.getData())>0){
            curr.setRight(addH(data, curr.getRight()));
        }
        return curr;
    }

    public void remove(T data){
        root = removeH(data, root);
    }

    private BSTNode<T> removeH(T data, BSTNode<T> curr){
        if(data == null){
            throw new IllegalArgumentException("Error: You cannot add null data to the tree");
        }
        
    }

}
