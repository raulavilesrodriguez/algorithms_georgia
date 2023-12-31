//import java.util.ArrayList;
import java.util.Collection;
//import java.util.List;
import java.util.NoSuchElementException;
import java.util.HashSet;
import java.util.Set;

/**
 * Your implementation of an AVL.
 *
 * @author Raúl Avilés
 * @version 1.0
 * @userid br (i.e. gburdell3)
 * @GTID 903437907 (i.e. 900000000)
 *
 * Collaborators: NONE
 *
 * Resources: NONE
 */

public class AVL<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private AVLNode<T> root;
    private int size;

    /**
     * Constructs a new AVL.
     *
     * This constructor should initialize an empty AVL.
     *
     * Since instance variables are initialized to their default values, there
     * is no need to do anything for this constructor.
     */
    public AVL() {
        // DO NOT IMPLEMENT THIS CONSTRUCTOR!
    }

    /**
     * Constructs a new AVL.
     *
     * This constructor should initialize the AVL with the data in the
     * Collection. The data should be added in the same order it is in the
     * Collection.
     *
     * @param data the data to add to the tree
     * @throws java.lang.IllegalArgumentException if data or any element in data
     *                                            is null
     */
    public AVL(Collection<T> data) {
        if(data == null){
            throw new IllegalArgumentException("Error: You cannot add null data to the AVL structure");
        }
        for (T d: data) {
            if (d == null) {
                throw new IllegalArgumentException("Cannot initialize null data.");
            }
            this.add(d);
            size = 0;
        }
    }

    /**
     * Helper method to update the node's height and balance factor
     * @param node node to update height and balance factor of
     */
    private void updateHeightAndBF(AVLNode<T> node) {
        int leftChildHeight = getValueH(node.getLeft());
        int rightChildHeight = getValueH(node.getRight());
        int height = Math.max(leftChildHeight, rightChildHeight) + 1;
        int BF = leftChildHeight - rightChildHeight;
        node.setHeight(height);
        node.setBalanceFactor(BF);
    }

    private int getValueH(AVLNode<T> node){
        if(node == null){
            return -1;
        } 
        else {
            return node.getHeight();
        }
    }

    /**
     * Adds the element to the tree.
     *
     * Start by adding it as a leaf like in a regular BST and then rotate the
     * tree as necessary.
     *
     * If the data is already in the tree, then nothing should be done (the
     * duplicate shouldn't get added, and size should not be incremented).
     *
     * Remember to recalculate heights and balance factors while going back
     * up the tree after adding the element, making sure to rebalance if
     * necessary.
     *
     * @param data the data to add
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void add(T data) {
        root = addH(data, root);
    }

    private AVLNode<T> addH(T data, AVLNode<T> curr){
        if(data == null){
            throw new IllegalArgumentException("Error: You cannot add null data to the tree");
        }
        if(curr == null){
            size++;
            AVLNode<T> node = new AVLNode<T>(data);
            updateHeightAndBF(node);
            return node;
        }
        else if(data.compareTo(curr.getData())<0){
            curr.setLeft(addH(data, curr.getLeft()));
        }
        else if(data.compareTo(curr.getData())>0){
            curr.setRight(addH(data, curr.getRight()));
        }
        updateHeightAndBF(curr);
        curr = balance(curr);
        return curr;
    }

    /**
     * Helper method to balance AVL Tree
     * @param node unbalanced node to be rebalanced
     * @return balanced subtree for given node
     */
    private AVLNode<T> balance(AVLNode<T> node) {
        // Right Rotation
        if(node.getBalanceFactor()==2 && node.getLeft().getBalanceFactor()==0 ||
            node.getBalanceFactor()==2 && node.getLeft().getBalanceFactor()==1
        ){
            return rotateRight(node);
        }
        // Left-Right Rotation
        else if(node.getBalanceFactor()==2 && node.getLeft().getBalanceFactor()==-1){
            AVLNode<T> B = rotateLeft(node.getLeft());
            node.setLeft(B);
            return rotateRight(node);
        }
        // Left Rotation
        else if(node.getBalanceFactor()==-2 && node.getRight().getBalanceFactor()==-1 ||
                node.getBalanceFactor()==-2 && node.getRight().getBalanceFactor()==0
        ){
            return rotateLeft(node);
        }
        // Right-Left Rotation
        else if(node.getBalanceFactor()==-2 && node.getRight().getBalanceFactor()==1){
            AVLNode<T> B = rotateRight(node.getRight());
            node.setRight(B);
            return rotateLeft(node);
        }
        return node;
    }

    /**
     * Helper method to make a right rotation
     * @param node node to make right rotation on
     * @return rotated subtree
     */
    private AVLNode<T> rotateRight(AVLNode<T> node) {
        AVLNode<T> B = node.getLeft();
        node.setLeft(B.getRight());
        B.setRight(node);
        updateHeightAndBF(node); // first update node, the order is crucial
        updateHeightAndBF(B);
        return B;
    }

    /**
     * Helper method to make a left rotation
     * @param node node to make left rotation on
     * @return rotated subtree
     */
    private AVLNode<T> rotateLeft(AVLNode<T> node) {
        AVLNode<T> B = node.getRight();
        node.setRight(B.getLeft());
        B.setLeft(node);
        updateHeightAndBF(node); // first update node, the order is crucial
        updateHeightAndBF(B);
        return B;
    }
    /**
     * Removes and returns the element from the tree matching the given
     * parameter.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the predecessor to
     * replace the data, NOT successor. As a reminder, rotations can occur
     * after removing the predecessor node.
     *
     * Remember to recalculate heights and balance factors while going back
     * up the tree after removing the element, making sure to rebalance if
     * necessary.
     *
     * Do not return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * @param data the data to remove
     * @return the data that was removed
     * @throws java.lang.IllegalArgumentException if the data is null
     * @throws java.util.NoSuchElementException   if the data is not found
     */
    public T remove(T data) {
        if(data == null){
            throw new IllegalArgumentException("Error: You cannot remove null data to the tree");
        }
        AVLNode<T> dummy = new AVLNode<T>(null);
        root = removeH(data, root, dummy);
        return dummy.getData();
    }

    /***
     * Helper method for remove.
     * Traverses the BST in search for node matching the given data and removes it from the tree.
     * @param data the data to remove
     * @param curr the current node being traversed in the BST
     * @return the modified BST with removed data (if found)
     */
    private AVLNode<T> removeH(T data, AVLNode<T> curr, AVLNode<T> dummy) {
        if(curr == null){
            throw new NoSuchElementException("DATA is not in the AVL tree");
        }
        else if(data.compareTo(curr.getData())<0){
            curr.setLeft(removeH(data, curr.getLeft(), dummy));
        }
        else if(data.compareTo(curr.getData())>0){
            curr.setRight(removeH(data, curr.getRight(), dummy));
        }
        else {
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
                AVLNode<T> dummy2 = new AVLNode<T>(null);
                curr.setRight(removeSuccesor(curr.getRight(), dummy2));
                curr.setData(dummy2.getData());
            }
        }
        updateHeightAndBF(curr);
        curr = balance(curr);
        return curr;
    }

    /***
     * Finds the successor for the node that is being called on.
     * @param node the child node of the parent node that we are finding the successor for
     * @return successor for parent node
     */
    private AVLNode<T> removeSuccesor(AVLNode<T> curr, AVLNode<T> dummy2) {
        if(curr.getLeft() == null){
            dummy2.setData(curr.getData());
            return curr.getRight();
        }
        else{
            curr.setLeft(removeSuccesor(curr.getLeft(), dummy2));
            updateHeightAndBF(curr);
            curr = balance(curr);
            return curr;
        }
    }


    /**
     * Returns the element from the tree matching the given parameter.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Do not return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * @param data the data to search for in the tree
     * @return the data in the tree equal to the parameter
     * @throws java.lang.IllegalArgumentException if data is null
     * @throws java.util.NoSuchElementException   if the data is not in the tree
     */
    public T get(T data) {
        if(data == null){
            throw new IllegalArgumentException("Error: You cannot remove null data to the tree PARCE");
        }
        return getT(data, root);
    }

    /***
     * Traverses the BST in search for node that matches the given data
     * @param data the data to search for
     * @param current current node being accessed in tree traversal
     * @return if data is in the tree, returns the node that contains it. Else, returns 'null'.
     */
    private T getT(T data, AVLNode<T> curr) {
        if(curr == null){
            throw new NoSuchElementException("DATA is not in the AVL tree BROO");
        }
        else if(data.compareTo(curr.getData())<0){
            return getT(data, curr.getLeft());
        }
        else if(data.compareTo(curr.getData())>0){
            return getT(data, curr.getRight());
        }
        else{
            return curr.getData();
        }
    }

    /**
     * Returns whether or not data matching the given parameter is contained
     * within the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * @param data the data to search for in the tree
     * @return true if the parameter is contained within the tree, false
     * otherwise
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public boolean contains(T data) {
        if(data == null){
            throw new IllegalArgumentException("Error: You cannot remove null data to the tree AMI");
        }
        return containsH(data, root);
    }

    private boolean containsH(T data, AVLNode<T> curr){
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
     * Returns the height of the root of the tree.
     *
     * @return the height of the root of the tree, -1 if the tree is empty
     */
    public int height() {
        if(root == null){
            return -1;
        }
        else{
            return root.getHeight();
        }
    }

    
    /**
     * Clears the tree.
     *
     * Clears all data and resets the size.
     */
    public void clear() {
        root = null;
        size = 0;    
    }

    /**
     * Find all elements within a certain distance from the given data.
     * "Distance" means the number of edges between two nodes in the tree.
     *
     * To do this, first find the data in the tree. Keep track of the distance
     * of the current node on the path to the data (you can use the return
     * value of a helper method to denote the current distance to the target
     * data - but note that you must find the data first before you can
     * calculate this information). After you have found the data, you should
     * know the distance of each node on the path to the data. With that
     * information, you can determine how much farther away you can traverse
     * from the main path while remaining within distance of the target data.
     *
     * Use a HashSet as the Set you return. Keep in mind that since it is a
     * Set, you do not have to worry about any specific order in the Set.
     *
     * Note: We recommend 2 helper methods:
     * 1. One helper method should be for adding the nodes on the path (from
     * the root to the node containing the data) to the Set (if they are within
     * the distance). This helper method will also need to find the distance
     * between each node on the path and the target data node.
     * 2. One helper method should be for adding the children of the nodes
     * along the path to the Set (if they are within the distance). The
     * private method stub called elementsWithinDistanceBelow is intended to
     * be the second helper method. You do NOT have to implement
     * elementsWithinDistanceBelow. However, we recommend you use this method
     * to help implement elementsWithinDistance.
     *
     * Ex:
     * Given the following AVL composed of Integers
     *              50
     *            /    \
     *         25      75
     *        /  \     / \
     *      13   37  70  80
     *    /  \    \      \
     *   12  15    40    85
     *  /
     * 10
     * elementsWithinDistance(37, 3) should return the set {12, 13, 15, 25,
     * 37, 40, 50, 75}
     * elementsWithinDistance(85, 2) should return the set {75, 80, 85}
     * elementsWithinDistance(13, 1) should return the set {12, 13, 15, 25}
     *
     * @param data     the data to begin calculating distance from
     * @param distance the maximum distance allowed
     * @return the set of all data within a certain distance from the given data
     * @throws java.lang.IllegalArgumentException if data is null
     * @throws java.util.NoSuchElementException   is the data is not in the tree
     * @throws java.lang.IllegalArgumentException if distance is negative
     */
    public Set<T> elementsWithinDistance(T data, int distance) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot search with null data value.");
        }
        if (!contains(data)) {
            throw new NoSuchElementException("Data does not exist in tree.");
        }
        if (distance < 0) {
            throw new IllegalArgumentException("Distance cannot be a negative integer.");
        }
        HashSet<T> set = new HashSet<>();
        ewdp(data, distance, root, set);
        return set;

    }

    /**
     * Helper method for elementWithinDistance() to add all nodes along path of given data
     * @param data the data to begin calculating distance from
     * @param maxDist maximum distance allowed
     * @param curr current node being traversed
     * @param set Hash Set of all elements within given distance
     * @return current distance away from data
     */
    private int ewdp(T data, int maxDist, AVLNode<T> curr, Set<T> set) {
        int compare = data.compareTo(curr.getData());
        int childDist = -1;
        if (compare > 0) {
            childDist = ewdp(data, maxDist, curr.getRight(), set);
        } else if (compare < 0) {
            childDist = ewdp(data, maxDist, curr.getLeft(), set);
        }
        int currDist = childDist + 1;
        if (currDist <= maxDist) {
            set.add(curr.getData());
        }
        if (currDist < maxDist) {
            if (curr.getLeft() != null) {
                elementsWithinDistanceBelow(curr.getLeft(), maxDist, currDist + 1, set);
            }
            if (curr.getRight() != null) {
                elementsWithinDistanceBelow(curr.getRight(), maxDist, currDist + 1, set);
            }
        }
        return currDist;
    }


    /**
     * You do NOT have to implement this method if you choose not to.
     * However, this will help with the elementsWithinDistance method.
     *
     * Adds data to the Set if the current node is within the maximum distance
     * from the target node. Recursively call on the current node's children to
     * add their data too if the children's data are also within the maximum
     * distance from the target node.
     *
     * @param curNode         the current node
     * @param maximumDistance the maximum distance allowed
     * @param currentDistance the distance between the current node and the
     *                        target node
     * @param currentResult   the current set of data within the maximum
     *                        distance
     */
    private void elementsWithinDistanceBelow(AVLNode<T> curNode,
                                             int maximumDistance,
                                             int currentDistance,
                                             Set<T> currentResult) {

        if (currentDistance <= maximumDistance) {
            currentResult.add(curNode.getData());
        }
        if (currentDistance < maximumDistance) {
            if (curNode.getLeft() != null) {
                elementsWithinDistanceBelow(curNode.getLeft(), maximumDistance, currentDistance + 1, currentResult);
            }
            if (curNode.getRight() != null) {
                elementsWithinDistanceBelow(curNode.getRight(), maximumDistance, currentDistance + 1, currentResult);
            }
        }
    }

    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the root of the tree
     */
    public AVLNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    public void preOrder(){
        preOrderH(root);
    }

    
    /** 
     * @param curr
     */
    private void preOrderH(AVLNode<T> curr){
        if(curr != null){
            System.out.println(curr.getData() + " " + "Height:" + curr.getHeight() + " BF:" + curr.getBalanceFactor());
            preOrderH(curr.getLeft());
            preOrderH(curr.getRight());
        }
    }
}


