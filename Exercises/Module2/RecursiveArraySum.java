package Exercises;
import java.util.Scanner;

public class RecursiveArraySum
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String inputNum;

        do {
            System.out.print("Write numbers (separated by commas): ");
            inputNum = sc.nextLine();
            }while (inputNum.length() < 3);

        int index = 1;
        System.out.print("Sum: " + recursiveSum(convertToInt(inputNum.split(",")), index));
    }

    static int recursiveSum(int[] array, int index)
    {
        if (index > array.length - 1)
            return array[0];

        array[0] += array[index];

        return recursiveSum(array, index+1);
    }

    static int[] convertToInt(String[] arrayStr)
    {
        int[] arrayInt = new int[arrayStr.length];
        for (int i = 0 ; i < arrayStr.length ; i++)
        {
            arrayInt[i] = Integer.parseInt(arrayStr[i]);
        }
        return arrayInt;
    }
}
