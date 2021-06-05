package Exercises;

public class CompareStrings
{
    public static void main(String[] args)
    {
        String a = "heLLo My fRiend";
        String b = "Hello my friend";
        String c = "heLLo My fRiend";

        System.out.println("There are " + compareStrings(a,b,c) + " identical strings");
    }

    private static int compareStrings(String a, String b, String c)
    {
        int equalStrings;

        if (a.toUpperCase().equals(b) && (a.toUpperCase().equals(c) || b.toUpperCase().equals(c)))
        {
            equalStrings = 3;
        }else if (a.toUpperCase().equals(b) || a.toUpperCase().equals(c) || b.toUpperCase().equals(c))
        {
            equalStrings = 2;
        } else
        {
            equalStrings = 0;
        }

        return equalStrings;
    }
}
