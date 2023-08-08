/**
 * The greatest common divisor (GCD) of two or more integers, 
 * x and y, where x and y are not both zero, is the LARGEST integer 
 * dividing both x and y with no reminder (r)
 */
public class Recursive{
    // x > y and y > r
    public static int gcd(int x, int y){
        if(y == 0){
            return x;
        } else {
            int remainder = x % y;
            return gcd(y, remainder);
        }
    }

    public static void main(String[] args) {
        System.out.println(gcd(567, 12));
        System.out.println(gcd(1482, 819));
        System.out.println(gcd(1240, 124));
    }

}