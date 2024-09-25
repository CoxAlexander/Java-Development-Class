public class UseAnimals {
    public static void main(String[] args){
        Dog myDog = new Dog();
        Cow myCow = new Cow();
        Snake mySnake = new Snake();
        myDog.setName("My dog murphy");
        myCow.setName("Dinner");
        mySnake.setName("Sammy");
        System.out.print(myDog.getName() + " says ");
        myDog.speak();
        System.out.print(myCow.getName() + " says ");
        myCow.speak();
        System.out.print(mySnake.getName() + " says ");
        mySnake.speak();
    }

}