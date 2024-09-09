//Sandwhich.java
//9/9/2024
//AlexanderCox


public class Sandwhich{
    private String ingredientType;
    private String breadType;
    private double price;
    public void setBreadType(String bread) {
        breadType = bread;
    }
    public void setIngredient(String ingredient) {
        ingredientType = ingredient;
    }
    public void setPrice(double sandwhichPrice){
        price = sandwhichPrice;
    }
    public String getIngredientType(){
        return ingredientType;
    }
    public String getBreadType(){
        return breadType;
    }
    public double getPrice(){
        return price;
    }
}   