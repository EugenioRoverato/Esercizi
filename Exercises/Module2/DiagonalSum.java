package Exercises;
import java.util.Scanner;

public class DiagonalSum
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String inputNum;
        boolean choiceDone = false;

        do {
            System.out.print("Write 9/16/25 numbers (separated by commas): ");
            inputNum = sc.nextLine();
        }while (inputNum.length() < 17); // at least 9 numbers

        String[] splittedString = inputNum.split(",");

        int dimension = (int) Math.sqrt(splittedString.length);

        int[][] mat = parseNumbers(splittedString, dimension);

        char choice;

        do{
            System.out.print("Do I count from left to right? (Y/N) ");
            choice = sc.nextLine().toUpperCase().charAt(0);
            if (choice == 'Y')
            {
                choiceDone = true;
            }else if (choice == 'N')
            {
                System.out.print("So I'm going to count from right to left..");
                choiceDone = true;
            }
        }while (!choiceDone);

        System.out.print("Diagonal sum: " + diagonalSum(mat, choice, dimension));
    }

    public static int diagonalSum(int[][] mat, char choice, int dim)
    {
        int res = 0;

        if (choice == 'Y')
        {
            for (int i = 0 ; i < dim ; i++)
            {
                res += mat[i][i];
            }
        }
        else {
            for (int i = 0 ; i < dim ; i++)
            {
                res += mat[i][dim-1-i];
            }
        }
        return res;
    }

    static int[][] parseNumbers(String[] r, double dim)
    {
        int[][] array = new int[(int) dim][(int) dim];

        int k = 0;
        for (int i = 0 ; i < (int) dim; i++)
        {
            for (int j = 0 ; j < (int) dim ; j++)
            {
                array[i][j] = Integer.parseInt(r[k]);
                k++;
            }
        }
        return array;
    }
}
