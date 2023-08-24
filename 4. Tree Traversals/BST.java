public class BST<T extends Comparable<? super T>> {
    private BSTNode<T> root;
    private int size;
    private BSTNode<T> succesor;

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

    public T find(T data){
        return findH(data, root);
    }

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

    public void preOrder(BSTNode<T> root){
        preOrderH(root);
    }

    private void preOrderH(BSTNode<T> curr){
        if(curr != null){
            System.out.print(curr.getData());
            preOrderH(curr.getLeft());
            preOrderH(curr.getRight());
        }
    }

    

}
