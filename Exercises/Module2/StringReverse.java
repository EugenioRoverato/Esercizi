package Exercises;
import java.util.Scanner;

public class StringReverse
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string:");
        String myString = sc.nextLine();

        System.out.println("Reverse of the string: " + stringReverse(myString));
    }

    static String stringReverse(String myString)
    {
        String newString = "";
        for (int i = myString.length()-1 ; i >= 0 ; i--)
        {
            newString += myString.charAt(i);
        }

        return newString;
    }
}
