package Exercises;
import java.util.Scanner;

public class DaysHoursMinutesSeconds
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter seconds: ");
        int seconds = sc.nextInt();

        convertSeconds(seconds);
    }

    public static void convertSeconds(int seconds)
    {
        int mySeconds = seconds % 60;
        int myMinutes = seconds / 60;
        int myHours = myMinutes / 60;
        int myDays = myHours / 24;

        System.out.print("Days: " + myDays % 24 + " Hours: " + myHours % 60 + " Minutes: " + myMinutes % 60 + " Seconds: " + mySeconds);
    }
}
