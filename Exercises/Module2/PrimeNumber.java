package Exercises;
import java.util.Scanner;

public class PrimeNumber
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int a = sc.nextInt();

        System.out.println(a + isPrimeNumber(a) + "a prime number");
    }

    private static String isPrimeNumber(int num)
    {
        if (num <= 1) return " is not ";
        int divider = 2;
        while (divider < num/2)
        {
            if (num % divider == 0)
            {
                return " is not ";
            }
            divider++;
        }
        return " is ";
    }
}
