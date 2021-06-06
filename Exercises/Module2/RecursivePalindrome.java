package Exercises;
import java.util.Scanner;

public class RecursivePalindrome
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String inputString = sc.nextLine();
        String myString = inputString.replace(" ", "");

        int index = 0;
        if (palindromeString(myString, index))
            System.out.println(inputString + " is palindrome");
        else
            System.out.println(inputString + " is not palindrome");
    }

    static boolean palindromeString(String string, int index)
    {
        int max = string.length() - index - 1;

        if (string.charAt(index) != string.charAt(max))
        {
            return false;
        }

        if (string.length()/2 == index)
        {
            return true;
        }

        return palindromeString(string, index+1);
    }
}