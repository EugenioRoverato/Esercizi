package Shop;

import java.util.Calendar;
import java.util.Scanner;

public class ShopSimulator
{
    private Product[] products;
    private int productsNum;
    private float discount = 0.2f;

    private Product[] shoppingList;

    public ShopSimulator()
    {
         products = new Product[100];
         productsNum = 0;
         shoppingList = new Product[100];
    }

    public void addProduct(boolean foodstuff, String name, int price, int quantity)
    {
        productsNum++;

        if (products[productsNum-1] == null)
        {
            products[productsNum-1] = new Product(foodstuff, name, price, quantity); // aggiunge prodotto ex novo
            return;
        }

        for (int i = 0 ; i < productsNum ; i++)
        {
            if (products[i].getName().equals(name))
            {
                products[i].setQuantity(products[i].getQuantity() + quantity); // aggiunge prodotto come quantità di uno preesistente
                return;
            }
        }
    }

    public void removeProduct(String name) // Serve concatenare le due estremità di array per far funzionare il productsNum, dopodichè si potranno togliere tutti i !=null
    {
        for (int i = 0 ; i < productsNum ; i++)
        {
            if (products[i].getName().equals(name) && products[i].getQuantity() > 0)
            {
                products[i].setQuantity(0);
                return;
            }
        }
    }

    public Product[] remaningAmount()
    {
        Product[] remaningProducts = new Product[100];
        for (int i = 0 ; i < productsNum ; i++)
        {
            if (products[i].getQuantity() > 0)
            {
                remaningProducts[i] = products[i];
            }
        }

        return remaningProducts;
    }

    public void addProductToShoppingList(String name, int quantity)
    {
        for (int j = 0 ; j < productsNum ; j++)
        {
            if (shoppingList[j] == null)
            {
                for (Product prod : products)
                {
                    if (prod.getName().equals(name) && prod.getQuantity() >= quantity)
                    {
                        shoppingList[j] = new Product(prod.isFoodstuff(), prod.getName(), (int) prod.getPrice(), quantity);
                        return;
                    }
                }
            }
        }

        for (int i = 0 ; i < productsNum ; i++)
        {
            assert shoppingList[i] != null;
            if (shoppingList[i].getName().equals(name) && products[i].getQuantity() >= quantity)
            {
                shoppingList[i].setQuantity(shoppingList[i].getQuantity() + quantity);
                return;
            }
        }
    }

    public void shopProducts()
    {
        double totalPrice = 0.0;

        for (int j = 0 ; j < productsNum ; j++)
            if (shoppingList[j] != null)
                totalPrice += shoppingList[j].getQuantity() * shoppingList[j].getPrice();

        System.out.println("The total to be paid for ");
        for (int i = 0 ; i < productsNum ; i++)
            if (receiptName()[i] != null)
                System.out.println("| " + receiptName()[i] + "  x" + receiptAmount()[i] + " (" + receiptPrice()[i] +  ") |");
        System.out.println("_______________________________");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your age for a discount: ");
        int temp = sc.nextInt();
        System.out.println("_______________________________");
        System.out.println("Total: " + addDiscount(temp, totalPrice) + "$");

        for (int k = 0 ; k < productsNum ; k++)
            for (int l = 0 ; l < productsNum ; l++)
            {
                if (shoppingList[k] != null)
                {
                    if (products[l].getName().equals(shoppingList[k].getName()))
                    {
                        products[l].setQuantity(products[l].getQuantity() - shoppingList[k].getQuantity());
                        break;
                    }
                }
            }
    }

    public String[] receiptName()
    {
        String[] productNames = new String[productsNum];
        for (int i = 0 ; i < productsNum ; i++)
            if (shoppingList[i] != null)
                productNames[i] = shoppingList[i].getName();

        return productNames;
    }

    public int[] receiptAmount()
    {
        int[] productNumbers = new int[productsNum];
        for (int i = 0 ; i < productsNum ; i++)
            if (shoppingList[i] != null)
                productNumbers[i] = shoppingList[i].getQuantity();

        return productNumbers;
    }

    public double[] receiptPrice()
    {
        double[] productPrices = new double[productsNum];
        for (int i = 0 ; i < productsNum ; i++)
            if (shoppingList[i] != null)
                productPrices[i] = shoppingList[i].getPrice() * shoppingList[i].getQuantity();

        return productPrices;
    }

    public double addDiscount(int age, double price)
    {
        if (age >= 60 && Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY || Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY)
        {
            System.out.println("Today is " + Calendar.getInstance().get(Calendar.DAY_OF_WEEK) + " so you will be given a 20% discount!");
            price -= (price * discount);
        }

        return Math.floor(price * Math.pow(10, 2)) / Math.pow(10, 2);
    }

    public void print(Product[] prod)
    {
        for (int i = 0 ; i < productsNum ; i++)
            if (prod[i] != null)
                System.out.println(prod[i].getName() + " " + prod[i].getQuantity());
    }

    public static void main(String[] args)
    {
        ShopSimulator ss = new ShopSimulator();

        ss.addProduct(true, "Formaggio di capra", 2 , 10);
        ss.addProduct(true, "Formaggio di mucca", 3, 10);
        ss.addProduct(true, "Formaggio di umana", 1, 10);
        ss.addProduct(true, "Formaggio di sogliola", 10, 10);
        ss.addProduct(true, "Formaggio di proboscide", 5, 10);
        ss.addProduct(true, "Formaggio di pokemon", 4, 10);

        ss.addProductToShoppingList("Formaggio di mucca", 1);
        ss.addProductToShoppingList("Formaggio di sogliola", 1);
        ss.addProductToShoppingList("Formaggio di pokemon", 1);

        for(int i = 0 ; i < ss.productsNum ; i++)
        {
            System.out.println(ss.products[i].getName() + " " + ss.products[i].getQuantity());
        }

        ss.shopProducts();

        ss.removeProduct("Formaggio di proboscide"); // toglie l'elemento se non è gia out of stock

        ss.print(ss.remaningAmount());
    }
}
