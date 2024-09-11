//DemoIncrement.java
//9/11/2024
//Alexander Cox
public class DemoIncrement {
    public static void main(String[] args) {
        int v = 4;
        int plusPlusV = ++v;
        v=4;
        int vPlusPlus = v++;

        System.out.println("v is " + v);
        System.out.println("++v is " + plusPlusV);
        System.out.println("v++ is " + vPlusPlus);
    }
}