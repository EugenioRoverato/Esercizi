package Exercises;
import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number:");
        int num = sc.nextInt();
        calc(num);
    }

    private static void calc(int num)
    {
        if (num%2 == 0)
            System.out.println(num + " is even");
        else
            System.out.println(num + " is odd");
    }
}

