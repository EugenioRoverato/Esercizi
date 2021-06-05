package Exercises;
import java.util.Scanner;

public class Anagrams
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String string1 = sc.nextLine();
        System.out.print("Enter another string: ");
        String string2 = sc.nextLine();

        anagrams(string1, string2);
    }

    static void anagrams(String string1, String string2)
    {
        if (string1.length() != string2.length())
        {
            System.out.print("No anagram found");
            return;
        }

        int countMatches = 0;

        char[] string1Array = string1.toUpperCase().toCharArray();
        char[] string2Array = string2.toUpperCase().toCharArray();

        for (int i = 0 ; i < string1.length() ; i++)
        {
            for (int j = 0 ; j < string2.length() ; j++)
            {
                if (string1Array[i] == string2Array[j])
                {
                    countMatches++;
                    break;
                }
            }
        }

        if (countMatches == string1.length())
        {
            System.out.print("They are anagrams");
        }else
            System.out.print("They are not anagrams");
    }
}
