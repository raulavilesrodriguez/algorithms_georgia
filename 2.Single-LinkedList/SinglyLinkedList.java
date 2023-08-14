
public class SinglyLinkedList<T> {
    private LinkedNode<T> head;
    private LinkedNode<T> tail;
    private int size;
     
    /*Constructor methods*/
    public SinglyLinkedList(){
        head = null;
        tail = null;
    }

    /*Methods*/
    public boolean isEmpty(){
        return (head == null);
    }

    public void addToFront(T data){
        if(data == null){
            throw new IllegalArgumentException("Error: You cannot add null data to the list");
        }
        LinkedNode<T> node = new LinkedNode<T>(data);
        if(isEmpty()){
            tail = node;
        }
        LinkedNode<T> temp = head;
        head = node;
        head.setNext(temp);
        size++;
    }

    public void addToBack(T data){
        if(data == null){
            throw new IllegalArgumentException("Error: You cannot add null data to the list");
        }
        LinkedNode<T> node = new LinkedNode<T>(data);
        if(isEmpty()){
            head = node;
            tail = node;
        } else{
            tail.setNext(node);
        }
        tail = node;
        size++;
    }

    public T removeFromFront(){
        if(isEmpty()){
            size = 0;
            return null;
        }
        T removedData = head.getData();
        head = head.getNext();
        size--;
        return removedData;
    }

    public T removeFromBack(){
        T removedData;
        if(isEmpty()){
            size = 0;
            removedData = null;
        }
        else if (head.getNext() == null){
            removedData = head.getData();
            head = null;
            tail = null;
            size = 0;
        }
        else {
            LinkedNode<T> current = head;
            while(current.getNext().getNext() != null){
                current = current.getNext();
            }
            removedData = current.getNext().getData();
            current.setNext(null);
            tail = current;
            size--;
        }
        return removedData;
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    public LinkedNode<T> getHead(){
        return head;
    }
    public LinkedNode<T> getTail(){
        return tail;   
    }

    public int getSize(){
        return size;
    }

    public String toString(){
        LinkedNode<T> current = head;
        String result = "";

        while(current != null){
            result = result + current.getData().toString() + ", ";
            current = current.getNext();
        }
        result = "[" + result.replaceAll(", $", "") + "]";
        return  result;
    }

}
