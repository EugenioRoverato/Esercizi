package Esercizi;

public class AndreaGit
{
    public static void main (String[] args)
    {
        int orario = 9;
        String warning = "Fate attenzione al Git!";
        System.out.print(andreaRaccomanda(orario, warning));
    }

    static String andreaRaccomanda(int orario, String warning)
    {
        if (orario == 16)
            return "USATE GITHUB";

        System.out.println(warning);
        return andreaRaccomanda(orario+1, warning);
    }
}