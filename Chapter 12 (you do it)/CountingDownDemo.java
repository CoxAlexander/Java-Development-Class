public class CountingDownDemo {
    public static void main(String[] args) {
        countingDown(10);
        System.out.println("Blast Off!");
    }
    public static void countingDown(int count){
        if(count>0){
            System.out.println(count);
            countingDown(count-1);
        }
    }
}