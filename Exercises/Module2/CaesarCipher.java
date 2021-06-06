package Exercises;
import java.util.Scanner;

public class CaesarCipher
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Scanner choiceSc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        char[] inputSentece = sc.nextLine().toLowerCase().replaceAll(" ", "").toCharArray(); // Ascii: 97 - 122

        System.out.print("Enter a key: ");
        int key = sc.nextInt();

        System.out.print("Do you want to encrypt (C) or decrypt (D) ? ");
        char choice = choiceSc.nextLine().toUpperCase().charAt(0);

        int oldValue = 0;
        if (choice == 'C')
        {
            inputSentece = crypt(inputSentece, key, oldValue);
        }else if (choice == 'D')
        {
            inputSentece = decrypt(inputSentece, key, oldValue);
        }else return;

        for (char x : inputSentece)
            System.out.print(x);
    }

    static char[] crypt(char[] sentence, int key, int oldValue)
    {
        if (oldValue == sentence.length)
        {
            return sentence;
        }

        int oldKey = key;

        int reduce = 1;
        while (oldKey > 0)
        {
            sentence[oldValue] += reduce;
            oldKey -= reduce;

            if (sentence[oldValue] == 123)
                sentence[oldValue] = 97;
        }

        return crypt(sentence, key ,oldValue+1);
    }

    static char[] decrypt(char[] sentence, int key, int oldValue)
    {
        if (oldValue == sentence.length)
        {
            return sentence;
        }

        int oldKey = key;
        int reduce = 1;
        while (oldKey > 0)
        {
            sentence[oldValue] -= reduce;
            oldKey -= reduce;

            if (sentence[oldValue] == 96)
                sentence[oldValue] = 122;
        }

        return decrypt(sentence, key ,oldValue + 1);
    }
}
