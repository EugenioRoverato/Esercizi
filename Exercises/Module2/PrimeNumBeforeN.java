package Old.Exercises;
import java.util.Arrays;
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

        System.out.println(Arrays.toString(findPrimeNum(num)));
    }

   static int[] findPrimeNum(int num)
   {
       int[] allNum = new int[num/2];
       if (num <= 1) return new int[]{0};

       int index = 0;
       for (int i = 2 ; i < num ; i ++)
       {
           boolean hasDividers = false;
           int divider = 2;
           while (divider <= i/2)
           {
               if (i % divider == 0)
               {
                   hasDividers = true;
                   break;
               }
               divider++;
           }
           if (!hasDividers)
           {
               allNum[index] = i; // non deve essere eseguito sempre dopo il while
               index++;
           }
       }

       int[] noZeros = new int[index];
       System.arraycopy(allNum, 0, noZeros, 0, index);

       return noZeros;
   }
}
