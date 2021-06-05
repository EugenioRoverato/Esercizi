package Exercises;
import java.util.Scanner;

public class HarmonicSum
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int inputNum = sc.nextInt();

        System.out.println("The harmonic sum of " + inputNum + " is: " + harmonicSum(inputNum));
    }

    private static double harmonicSum(int num)
    {
        double sum = 0;
        double i;

        for (i = 1 ; i <= num ; i++)
        {
            sum += 1/i;
        }

        return sum;
    }
}