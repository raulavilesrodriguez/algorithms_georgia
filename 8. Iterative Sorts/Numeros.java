//import java.util.Comparator;

public class Numeros<T extends Comparable<? super T>> {
    private T num;

    public Numeros(T num){
        this.num = num;
    }

    public T getValue(){
        return num;
    }
    @Override
    public String toString() {
        return "Name: " + num;
    }

    

}
