import java.util.Arrays;
import java.util.Scanner;

public class TriangoloTartaglia
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a line number: ");

        int value = scanner.nextInt();

        int[][] numbers = new int[value+1][value+1];

        if (value >= 0)
            numbers[0][0] = 1;
        if (value >= 1)
        {
            numbers[1][0] = 1;
            numbers[1][1] = 1;
        }
        int index = 2;

        int[][] result = elementiRiga(value, numbers, index);

        System.out.println("Result line: " + Arrays.toString(result[value]));
    }

    public static int[][] elementiRiga(int n, int[][] num, int i)
    {
        if (n < 2 || i > n) return num;

        num[i][0] = 1;
        num[i][i] = 1;

        for (int k = 1 ; k < i ; k++)
            num[i][k] = num[i-1][k-1] + num[i-1][k];

        return elementiRiga(n, num, i+1);
    }
}
