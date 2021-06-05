package Exercises;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int number;

        do {
            System.out.print("Enter a positive number: ");
            number = sc.nextInt();
            }
        while (number < 0);

        System.out.println("In the Fibonacci sequence, at index " + number + " there is " + fibonacci(number));
    }
    public static int fibonacci(int num)
    {
        if (num == 0) return 0;
        if (num == 1) return 1;

        int[] fibonacci = new int[num+1];

        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2 ; i <= num ; i++)
        {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
        return fibonacci[num];
    }
}
