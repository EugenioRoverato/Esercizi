package Exercises;
import java.util.Scanner;

public class Factorial
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number:");
        int inputNum = sc.nextInt();
        System.out.println(inputNum + "! = " + calculateFactorial(inputNum));
    }

    private static int calculateFactorial(int num)
    {
       int max = num;

       if (num == 0) return 1;

       for (int i = max-1 ; i > 0 ; i--)
       {
           num *= i;
       }

       return num;
    }
}
