package Old.SerieACalcio;

public class Classifica
{
    final int nSquadre = 20;
    Squadra[] listaSquadre;
    int currentIndex;
    int maxGoal;

    public Classifica()
    {
        listaSquadre = new Squadra[nSquadre];
        currentIndex = 0;
        maxGoal = 0;
    }

    public void esitoPartita(String squadraCasa, int goalCasa, String squadraOspite, int goalOspite)
    {
        Squadra casa = new Squadra(squadraCasa, goalCasa);
        Squadra ospite = new Squadra(squadraOspite, goalOspite);

        if(!confrontaInLista(goalCasa, goalOspite, casa)) // se non é in lista
            aggiungiInLista(goalCasa, goalOspite, casa); // aggiungilo

        if(!confrontaInLista(goalOspite, goalCasa, ospite))
            aggiungiInLista(goalOspite, goalCasa, ospite);

        if (listaSquadre[nSquadre-1] != null) // se ci sono tutte e 20 le squadre, fai il sort <-- Si puo svolgere anche ad ogni match, ma cosi forse é meno pesante
            sort();
    }

    public void aggiungiInLista(int goalCasa, int goalOspite, Squadra squadra) // se la squadra non é in lista la aggiunge e poi modifica il suo punteggio
    {
        if (goalCasa > goalOspite)
            squadra.setPunti(squadra.getPunti() + 3);
        else if (goalOspite == goalCasa)
                squadra.setPunti(squadra.getPunti() + 1);
        squadra.setGoalFatti(squadra.getGoalFatti() + goalCasa);
        squadra.setGoalSubiti(squadra.getGoalSubiti() + goalOspite);
        assegnaAdArray(squadra);
    }

    public boolean confrontaInLista(int goalCasa, int goalOspite, Squadra squadra) // se la squadra é giá in lista, modifica il suo punteggio
    {
        for (Squadra squad : listaSquadre)
        {
            if (squad != null && squad.getId().equals(squadra.getId()))
            {
                if (goalCasa > goalOspite)
                    squad.setPunti(squad.getPunti() + 3);
                else if (goalCasa == goalOspite)
                    squad.setPunti(squad.getPunti() + 1);

                squad.setGoalFatti(squad.getGoalFatti() + goalCasa);
                squad.setGoalSubiti(squad.getGoalSubiti() + goalOspite);

                return true;
            }
        }
        return false;
    }

    public void assegnaAdArray(Squadra squadra)
    {
        listaSquadre[currentIndex] = squadra;
        currentIndex++;
    }

    public void sort() // fa un insertion sort in base al punteggio (si potevano usare altri algoritmi di ordinamento)
    {
        Squadra temp;
        for (int i = 1; i < nSquadre; i++)
        {
            for (int j = i; j > 0; j--)
            {
                if (listaSquadre[j]!=null && listaSquadre[j-1]!=null)
                    if (listaSquadre[j].getPunti() > listaSquadre[j-1].getPunti())
                    {
                        temp = listaSquadre[j];
                        listaSquadre[j] = listaSquadre[j-1];
                        listaSquadre[j-1] = temp;
                    }
            }
        }
    }

    public String[] getMigliorAttacco() // Si puo ottenere un solo valore di ritorno facendo una scrematura sulla posizione in classifica punti
    {
        int max = 0;
        String[] migliorAttacco = new String[nSquadre];
        for (int i = 0 ; i < nSquadre ; i++)
        {
            if (listaSquadre[i].getGoalFatti() > max)
            {
                max = listaSquadre[i].getGoalFatti();
                migliorAttacco[i] = listaSquadre[i].getId();
            }
        }

        int index = 1;

        for (Squadra squad : listaSquadre)
        {
            if (squad.getGoalFatti() == max)
            {
                migliorAttacco[index] = squad.getId();
                index++;
            }
        }

        setMaxGoal(max);
        return migliorAttacco;
    }

    public String[] getPeggiorDifesa() // Si puo ottenere un solo valore di ritorno facendo una scrematura sulla posizione in classifica punti
    {
        int max = 0;
        String[] peggiorDifesa = new String[nSquadre];
        for (int i = 0 ; i < nSquadre ; i++)
        {
            if (listaSquadre[i].getGoalSubiti() > max)
            {
                max = listaSquadre[i].getGoalSubiti();
                peggiorDifesa[i] = listaSquadre[i].getId();
            }
        }

        int index = 1;

        for (Squadra squad : listaSquadre)
        {
            if (squad.getGoalSubiti() == max)
            {
                peggiorDifesa[index] = squad.getId();
                index++;
            }
        }

        setMaxGoal(max);
        return peggiorDifesa;
    }

    public void setMaxGoal(int maxGoal) { this.maxGoal = maxGoal; }
    public int getMaxGoal() { return maxGoal; }

    public static void main(String[] args)
    {
        Classifica ranking = new Classifica();
        ranking.esitoPartita("001", 5, "002", 3 );
        ranking.esitoPartita("003", 6, "004", 2 );
        ranking.esitoPartita("005", 4, "006", 0 );
        ranking.esitoPartita("007", 1, "008", 2 );
        ranking.esitoPartita("009", 3, "010", 4 );
        ranking.esitoPartita("011", 0, "012", 1 );
        ranking.esitoPartita("013", 0, "014", 0 );
        ranking.esitoPartita("015", 3, "016", 1 );
        ranking.esitoPartita("017", 7, "018", 0 );
        ranking.esitoPartita("019", 2, "020", 6 );

        ranking.esitoPartita("001", 5, "020", 3 );
        ranking.esitoPartita("002", 6, "019", 2 );
        ranking.esitoPartita("003", 4, "018", 0 );
        ranking.esitoPartita("004", 1, "017", 2 );
        ranking.esitoPartita("005", 3, "016", 4 );
        ranking.esitoPartita("006", 0, "015", 1 );
        ranking.esitoPartita("007", 0, "014", 0 );
        ranking.esitoPartita("008", 3, "013", 1 );
        ranking.esitoPartita("009", 7, "012", 0 );
        ranking.esitoPartita("010", 2, "011", 6 );

        for (int i = 0 ; i < ranking.nSquadre ; i++)
        {
            if (ranking.listaSquadre[i]!=null)
                System.out.println("Id squadra: " + ranking.listaSquadre[i].getId() + " | Punti: " + ranking.listaSquadre[i].getPunti()); // METODO GET CLASSIFICA
        }

        for (int i = 0 ; i < ranking.nSquadre ; i++)
        {
            if (ranking.getMigliorAttacco()[i] != null)
                System.out.println("[ Miglior Attaccante: " + ranking.getMigliorAttacco()[i] + " con " + ranking.getMaxGoal() + " goal fatti ]");
        }

        for (int i = 0 ; i < ranking.nSquadre ; i++)
        {
            if (ranking.getPeggiorDifesa()[i] != null)
                System.out.println("[ Peggior Difensore: " + ranking.getPeggiorDifesa()[i] + " con " + ranking.getMaxGoal() + " goal subiti ]");
        }
    }
}
