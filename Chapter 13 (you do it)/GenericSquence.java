public class GenericSquence{
    public static void main(String[] args){
        Character grade = 'A';
        Integer Score = 0;
        Double pay = 21.34;
        String word = "hello";
        duplicate(grade, 5);
        duplicate(Score, 10);
        duplicate(pay,3);
        duplicate(word,7);
    }
    public static <T> void duplicate (T obj, int num) {
        int x;
        for(x = 0; x < num; ++x){
            System.out.print(obj + " ");
        }
        System.out.println();
    }
}
