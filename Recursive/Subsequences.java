//import java.lang.Math;

public class Subsequences {
    private int [] ar;
    int i = 0;
    int count = 0;

    public Subsequences( int [] ar){
        this.ar = ar;
    }

    public int recA(int i){
        if((ar.length) == i){
            return count + ar.length;
        }
        int j = ar.length-1;
        boolean flag = false;
        int size = 0;
        while(!flag){
            if(j > 0 && j>i){
                System.out.println("VARIABLE " + i + j);
                 if(ar[i]<ar[j] ){
                    size++;
                }              
            } else{
                System.out.println("SIZE: " + size);
                flag = true;
            }

            int sizeI = 0;
            if (j-i > 1){
                for(int w=j; w>i; w--){
                    if(ar[w-1]<ar[w]){
                        sizeI++;
                    }
                }
                if(j-i==2 && sizeI==(j-i)){
                    count = count + 1;
                }
                else if(sizeI==(j-i)){
                    count = count + (j-i);
                }
            }

            j--; 
        }

        count = count + size;
        
        return recA(++i);
    }
    public static void main(String[] args){
        int [] ar = {3, 2, 4, 5, 4};
        System.out.println("Array: " + ar[0]);
        Subsequences veamos = new Subsequences(ar);
        System.out.println(veamos.recA(0));
    }
}
