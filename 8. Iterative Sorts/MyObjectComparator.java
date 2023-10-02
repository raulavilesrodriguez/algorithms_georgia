import java.util.Comparator;

public class MyObjectComparator implements Comparator<MyObject> {
    @Override
    public int compare(MyObject o1, MyObject o2) {        
        if(o1.getValue() > o2.getValue()){
            return 1;
        } else if(o1.getValue() < o2.getValue()){
            return -1;
        }
        return 0;
        
    }
}


