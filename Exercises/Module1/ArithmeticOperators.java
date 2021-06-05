package Exercises;
import java.util.Scanner;

public class ArithmeticOperators {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number:");
        int a = sc.nextInt();
        System.out.print("Enter second number:");
        int b = sc.nextInt();

        computeValues(a, b);
    }

    private static void computeValues(int a, int b)
    {
        System.out.print("Sum: ");
        System.out.println(a+b);
        System.out.print("Subtraction: ");
        System.out.println(a-b);
        System.out.print("Multiplication: ");
        System.out.println(a*b);
        System.out.print("Division: ");
        if (b != 0)
            System.out.println(a/b);
        else
            System.out.println("Impossible");
    }
}

