public class MyObject {
    private String strVal;
    private int val;
    private char c;
    private boolean b;

    public MyObject(int val){
        this.val = val;
    }

    public String getStrVal() {
        return strVal;
    }

    public int getValue() {
        return val;
    }

    public char getC(){
        return c;
    }

    public boolean getB() {
        return b;
    }

    public void setStrVal(String s) {
        strVal = s;
    }

    public void setValue(int i) {
        val = i;
    }
}
