package Exercises;
import java.util.Random;
import java.util.Scanner;

public class Bingo
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int[][] folder = new int[3][5];
        fillFolder(sc, folder);

        int[] randomNumbers = drawNumbers();
        winCheck(folder, randomNumbers);
    }

    static void fillFolder(Scanner sc, int[][] folder)
    {
        int[] takenNumbers = new int[15];

        int count = 15;
        int maxCount = count;

        int j = 0;
        for (int i = 0 ; i < 5 ; i++)
        {
            System.out.print("Write " + count + " numbers from 1 to 90: ");

            folder[j][i] = sc.nextInt();

            if ((noDuplicates(takenNumbers, folder, j , i , maxCount) && count != 15) || folder[j][i] > 90 || folder[j][i] < 1)
            {
                System.out.println("Invalid number");
                i--;
                continue;
            }

            takenNumbers[count-1] = folder[j][i];
            count--;

            if (i == 4)
            {
                if (j == 2)
                {
                    break;
                }
                i = -1;
                j++;
            }
        }
    }

    static int[] drawNumbers()
    {
        Random rand = new Random();
        int[] randomNum = new int[30];
        int[] givenNum = new int[30];

        for (int j = 0 ; j < 30 ; j ++)
        {
            randomNum[j] = 1 + rand.nextInt(90);

            if (j > 0)
            {
                while (randomNum[j] == givenNum[j-1])
                {
                    randomNum[j] = 1 + rand.nextInt(90);
                }
                givenNum[j] = randomNum[j];
            }
        }
        return randomNum;
    }

    static boolean noDuplicates(int[] alreadyTakenNumbers, int[][] folder, int colIndex, int rigIndex, int max)
    {
        for (int i = max - 1 ; i >= 0 ; i--)
        {
            if (folder[colIndex][rigIndex] == alreadyTakenNumbers[i])
            {
                return true;
            }
        }
        return false;
    }

    static void winCheck(int[][] folder, int[] randomNum)
    {
        int ambo = 0;
        int terna = 0;
        int quaterna = 0;
        int cinquina = 0;

        int countEqualNums = 0;

        int col = 0;
        for (int rig = 0 ; rig < 5 ; rig++)
        {
            for (int j = 0 ; j < 30 ; j ++)
            {
                if (folder[col][rig] == randomNum[j])
                {
                    countEqualNums++;
                }
            }

            if (rig == 4)
            {
                switch (countEqualNums)
                {
                    case 2:
                        ambo++;
                        break;
                    case 3:
                        ambo++;
                        terna++;
                        break;
                    case 4:
                        ambo++;
                        terna++;
                        quaterna++;
                        break;
                    case 5:
                        ambo++;
                        terna++;
                        quaterna++;
                        cinquina++;
                        break;
                }

                rig = -1;
                col++;
            }

            if (col == 3)
            {
                if (cinquina == 3)
                {
                    System.out.println("BINGO!");
                    return;
                }

                System.out.println("Ambi: " + ambo + ", Terne: " + terna + ", Quaterne: " + quaterna + ", Cinquine: " + cinquina);
                return;
            }
        }

    }
}
