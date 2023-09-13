import java.util.NoSuchElementException;

/**
 * Your implementation of a BST.
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Returns whether or not data matching the given parameter is contained
     * within the tree.
     *
     * This should be done recursively.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to search for. You may assume data is never null.
     * @return true if the parameter is contained within the tree, false otherwise.
     */
    public boolean contains(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        return containsH(data, root);
    }
    
    private boolean containsH(T data, BSTNode<T> curr){
        if(curr == null){
            return false;
        }
        else if(data.compareTo(curr.getData())<0){
            return containsH(data, curr.getLeft());
        }
        else if(data.compareTo(curr.getData())>0){
            return containsH(data, curr.getRight());
        }
        else{
            return true;
        }
    
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the SUCCESSOR to
     * replace the data. You should use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove. You may assume that data is never null.
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the data is not in the tree.
     */
    public T remove(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        BSTNode<T> dummy = new BSTNode<T>(null);
        root = removeH(data, root, dummy);
        
        return dummy.getData();
    }

    private BSTNode<T> removeH(T data, BSTNode<T> curr, BSTNode<T> dummy){
        if(curr == null){
            throw new NoSuchElementException("DATA is not in the tree");
        }
        else if(data.compareTo(curr.getData())<0){
            curr.setLeft(removeH(data, curr.getLeft(), dummy));
        }
        else if(data.compareTo(curr.getData())>0){
            curr.setRight(removeH(data, curr.getRight(), dummy));
        }
        else{
            dummy.setData(curr.getData());
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
                BSTNode<T> dummy2 = new BSTNode<T>(null);
                curr.setRight(removeSuccesor(curr.getRight(), dummy2));
                curr.setData(dummy2.getData());
            }
        }
        return curr;
    }

    private BSTNode<T> removeSuccesor(BSTNode<T> curr, BSTNode<T> dummy2){
        if(curr.getLeft() == null){
            dummy2.setData(curr.getData());;
            return curr.getRight();
        }
        else{
            curr.setLeft(removeSuccesor(curr.getLeft(), dummy2));
            return curr;
        }
    }

    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}