package ToDo;
import java.util.ArrayList;
import java.util.List;

public class PerfectNumbers1000
{
    public static void main (String[] args)
    {
        System.out.println(findPerfectNumbers(1000000));
    }

    static List<Integer> findPerfectNumbers(int maxNum)
    {
        int[] primes = findPrimeNum(maxNum);
        List<Integer> perfects = new ArrayList<>();

        for (int prime : primes) {
            if ((int) (Math.pow(2, prime - 1) * (Math.pow(2, prime) - 1)) > maxNum)
                return perfects;
            perfects.add((int) (Math.pow(2, prime - 1) * (Math.pow(2, prime) - 1)));
        }
        return perfects;
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
