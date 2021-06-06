package Exercises;
import java.util.Scanner;

public class PrimeNumBeforeN
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int num;
        do
        {
            System.out.print("Enter a number greater than 1: ");
            num = sc.nextInt();
        }while (num < 2);

        for (int n : findPrimeNum(num))
            if (n != 0)
                System.out.print(n + " ");
    }

   static int[] findPrimeNum(int num)
   {
       if (num == 2) return new int[]{2};
       if (num == 3) return new int[]{3};

       int[] allNum = new int[num];

       for (int i = 2 ; i < allNum.length ; i++)
       {
           allNum[i] = i;
       }

       for (int j = 2 ; allNum[j]*allNum[j] < allNum.length ; j++)
       {
           if (allNum[j] != 0)
           {
               for (int k = 4 ; k < allNum.length ; k++)
               {
                   if (allNum[k] % j == 0)
                   {
                       allNum[k] = 0;
                   }
               }
           }
       }
       return allNum;
   }
}
