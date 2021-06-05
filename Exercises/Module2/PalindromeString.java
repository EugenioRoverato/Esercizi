package Exercises;
import java.util.Scanner;

public class PalindromeString
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String string = sc.nextLine();

        if (palindromeString(string))
            System.out.println(string + " is palindrome");
        else
            System.out.println(string + " is not palindrome");
    }

    private static boolean palindromeString(String string)
    {
        string = string.replace(" ", "");

        int max = string.length() - 1;

        for (int i = 0 ; i < string.length()/2 ; i++)
        {
            if (string.charAt(i) != string.charAt(max-i))
            {
                return false;
            }
        }
        return true;
    }
}