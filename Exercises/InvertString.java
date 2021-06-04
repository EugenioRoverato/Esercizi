package Exercises;
import java.util.*;

public class InvertString {
    public static void main(String[] args) {
        System.out.println("Insert string to invert: ");
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();

        String[] phrase = string.split(" ");

        int i = phrase.length - 1;

        while (i >= 0)
        {
            System.out.print(phrase[i] + " " );
            i -= 1;
        }
    }
}
