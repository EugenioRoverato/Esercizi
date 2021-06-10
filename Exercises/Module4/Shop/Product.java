package Shop;

public class Product
{
    private boolean foodstuff;
    private String name;
    private float price;
    private int quantity;

    public Product(boolean foodstuff, String name, int price, int quantity)
    {
        this.foodstuff = foodstuff;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public boolean isFoodstuff() {
        return foodstuff;
    }

    public void setFoodstuff(boolean foodstuff) {
        this.foodstuff = foodstuff;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
}
