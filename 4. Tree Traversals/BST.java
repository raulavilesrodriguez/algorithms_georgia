public class BST<T extends Comparable<? super T>> {
    private BSTNode<T> root;
    private int size;
    private BSTNode<T> succesor;

    /*Constructor methods*/
    public BST(){
        this.root = null;
    }

    
    /** 
     * @return boolean
     */
    /*Methods*/
    public boolean isEmpty(){
        return (root == null);
    }

    
    /** 
     * @param data
     * add node to the tree
     */
    public void add(T data){
        root = addH(data, root);
    }

    
    /** 
     * @param data
     * @param curr
     * @return BSTNode<T>
     */
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

    
    /** 
     * @param data
     * remove one node of the tree
     */
    public void remove(T data){
        root = removeH(data, root);
    }

    
    /** 
     * @param data
     * @param curr
     * @return BSTNode<T>
     */
    private BSTNode<T> removeH(T data, BSTNode<T> curr){
        if(data == null){
            throw new IllegalArgumentException("Error: You cannot add null data to the tree");
        }
        if(curr == null){
            return null;
        }
        else if(data.compareTo(curr.getData())<0){
            curr.setLeft(removeH(data, curr.getLeft()));
        }
        else if(data.compareTo(curr.getData())>0){
            curr.setRight(removeH(data, curr.getRight()));
        }
        else{
            size--;
            if(curr.getLeft() == null && curr.getRight() == null){
                return null;
            }
            else if(curr.getLeft() == null){
                return curr.getRight();
            }
            else if(curr.getRight() == null){
                return curr.getLeft();
            }
            else{
                curr.setRight(removeSuccesor(curr.getRight()));
                curr.setData(succesor.getData());
            }
        }
        return curr;
    }

    
    /** 
     * @param curr
     * @return BSTNode<T>
     * helper method
     */
    private BSTNode<T> removeSuccesor(BSTNode<T> curr){
        if(curr.getLeft() == null){
            succesor = curr;
            return curr.getRight();
        }
        else{
            curr.setLeft(removeSuccesor(curr.getLeft()));
            return curr;
        }
    }

    
    /** 
     * @param data
     * @return T
     * find in function of data
     */
    public T find(T data){
        return findH(data, root);
    }

    
    /** 
     * @param data
     * @param curr
     * @return T
     */
    private T findH(T data, BSTNode<T> curr){
        if(curr == null){
            return null;
        }
        else if(data.compareTo(curr.getData())<0){
            return findH(data, curr.getLeft());
        }
        else if(data.compareTo(curr.getData())>0){
            return findH(data, curr.getRight());
        }
        else {
            return curr.getData();
        }
    }

    /**
     * TRAVERSE
     */
    public void preOrder(){
        preOrderH(root);
    }

    
    /** 
     * @param curr
     */
    private void preOrderH(BSTNode<T> curr){
        if(curr != null){
            System.out.print(curr.getData() + " ");
            preOrderH(curr.getLeft());
            preOrderH(curr.getRight());
        }
    }

    public void postOrder(){
        postOrderH(root);
    }

    
    /** 
     * @param curr
     */
    private void postOrderH(BSTNode<T> curr){
        if(curr != null){
            postOrderH(curr.getLeft());
            postOrderH(curr.getRight());
            System.out.print(curr.getData() + " ");
        }
    }

    public void inOrder(){
        inOrderH(root);
    }

    
    /** 
     * @param curr
     */
    private void inOrderH(BSTNode<T> curr){
        if(curr != null){
            inOrderH(curr.getLeft());
            System.out.print(curr.getData() + " ");
            inOrderH(curr.getRight());
        }
    }

    public void clear(){
        root = null;
        size = 0;
    }

    
    /** 
     * @return int
     */
    public int getSize(){
        return size;
    }
    
    
    /** 
     * @return int
     */
    public int heigh(){
        return heighH(root);
    }

    
    /** 
     * @param curr
     * @return int
     */
    private int heighH(BSTNode<T> curr){
        if(curr == null){
            return 0;
        }
        int leftHeight = heighH(curr.getLeft());
        int rightHeigh = heighH(curr.getRight());
        return Math.max(leftHeight, rightHeigh) + 1;
    }

    public void contain(){
        containH(root);
    }

    
    /** 
     * @param curr
     */
    private void containH(BSTNode<T> curr){
        if(curr != null){
            System.out.print(curr.toString() + " ");
            preOrderH(curr.getLeft());
            preOrderH(curr.getRight());
        }
    }


}
