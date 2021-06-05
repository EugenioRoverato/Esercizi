package Exercises;
import java.util.Arrays;
import java.util.Scanner;

public class MinMax
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Write numbers (separated by commas): ");
        String inputNum = sc.nextLine();

        int[] values = parseNumbers(inputNum);
        computeMinAndMax(values);
    }

    static int[] parseNumbers(String inputNum)
    {
        String[] splittedInputString = inputNum.split(",");

        int[] convertedValues = new int[splittedInputString.length];

        for (int i = 0 ; i < splittedInputString.length ; i++)
        {
            convertedValues[i] = Integer.parseInt(splittedInputString[i].trim());
        }

        return convertedValues;
    }

    static void computeMinAndMax(int[] values)
    {
        Arrays.sort(values);
        System.out.print("Min: " + values[0] + ", Max: " + values[values.length-1]);
    }

}
