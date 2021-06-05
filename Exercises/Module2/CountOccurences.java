package Exercises;
import java.util.Scanner;

public class CountOccurences
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter character to count:");
        String a = sc.nextLine();
        System.out.print("Enter string:");
        String b = sc.nextLine();

        System.out.println(countOccurrences(a.charAt(0), b));
    }

    static int countOccurrences(char a, String b)
    {
        int count = 0;
        for (int i = 0; i < b.length(); i++)
        {
            if (b.charAt(i) == a)
                count++;
        }

        return count;
    }
}
