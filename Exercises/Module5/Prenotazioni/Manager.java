package Old.Prenotazioni;
import java.util.ArrayList;

public class Manager
{
    ArrayList<Prenotazione> listaPrenotazioniInterne = new ArrayList<>();
    ArrayList<Prenotazione> listaPrenotazioniEsterne = new ArrayList<>();
    ArrayList<Prenotazione> listaPrenotazioniInAttesa = new ArrayList<>();

    int prenotazioniInt, prenotazioniExt;
    int pInt, pExt; // numero di posti disponibili all’interno e all’esterno nel ristorante

    public Manager(int pInt, int pExt)
    {
        this.pInt = pInt;
        this.pExt = pExt;
    }

    public boolean prenota(Prenotazione p) // data una Prenotazione p in input
    {
        if (pInt+pExt < p.getnPosti()) return false; // se non ci sono posti, esce

        if (p instanceof PrenotazioneSingola)
        {
            PrenotazioneSingola pS = (PrenotazioneSingola) p;
            int tempI = pInt;

            if (pInt >= p.getnPosti() && pS.preferenza == Preferenza.INTERNO) { pInt--; } // se c'é posto e segue la preferenza
            else if (pExt >= p.getnPosti() && pS.preferenza == Preferenza.INTERNO) { pExt--; } // se c'é posto ma non per la preferenza

            if (pExt >= p.getnPosti() && pS.preferenza == Preferenza.ESTERNO) { pExt--; }
            else if (pInt >= p.getnPosti() && pS.preferenza == Preferenza.ESTERNO) { pInt--; }

            if (pInt < tempI)
            {
                prenotazioniInt++;
                listaPrenotazioniInterne.add(p);
                return true; // viene accettata restituendo true
            } else {
                prenotazioniExt++;
                listaPrenotazioniEsterne.add(p);
                return true;
            }
        }
        else
        {
            int tempI = pInt;
            int tempE = pExt;

            if (pInt >= p.getnPosti()) { pInt-=p.getnPosti(); }
            else if (pExt >= p.getnPosti()) { pExt-=p.getnPosti(); }

            if (pInt < tempI)
            {
                prenotazioniInt++;
                listaPrenotazioniInterne.add(p);
                return true; // viene accettata restituendo true
            } else if (pExt < tempE){
                prenotazioniExt++;
                listaPrenotazioniEsterne.add(p);
                return true;
            }

            listaPrenotazioniInAttesa.add(p);
            return false;
        }
    }

    public void cancellaPrenotazione(Prenotazione p)
    {
        if (p instanceof PrenotazioneSingola)
        {
            PrenotazioneSingola pS = (PrenotazioneSingola) p;
            for (Prenotazione interna : listaPrenotazioniInterne)
            {
                if (pS.getCodice() == interna.getCodice())
                {
                    pInt++;
                    prenotazioniInt--;
                    listaPrenotazioniInterne.remove(p);
                    break;
                }
            }
            for (Prenotazione esterna : listaPrenotazioniEsterne)
            {
                if (pS.getCodice() == esterna.getCodice())
                {
                    pExt++;
                    prenotazioniExt--;
                    listaPrenotazioniEsterne.remove(p);
                    break;
                }
            }
        }
        else if (p instanceof PrenotazioneGruppo)
        {
            PrenotazioneGruppo pG = (PrenotazioneGruppo) p;
            for (Prenotazione interna : listaPrenotazioniInterne)
            {
                if (pG.getCodice() == interna.getCodice())
                {
                    pInt += pG.getnPosti();
                    prenotazioniInt--;
                    listaPrenotazioniInterne.remove(p);
                    break;
                }
            }
            for (Prenotazione esterna : listaPrenotazioniEsterne)
            {
                if (pG.getCodice() == esterna.getCodice())
                {
                    pExt += pG.getnPosti();
                    prenotazioniExt--;
                    listaPrenotazioniEsterne.remove(p);
                    break;
                }
            }
        }

        riassegnaPrenotazioni();
    }

    public void riassegnaPrenotazioni()
    {
        if (listaPrenotazioniInAttesa == null) return;

        for (Prenotazione pInAttesa : listaPrenotazioniInAttesa)
        {
            if (pInAttesa instanceof PrenotazioneSingola && pInt+pExt > 0)
            {
                System.out.println("Prenotazione n." + pInAttesa.getCodice() + " = " + prenota(pInAttesa));
            }
            if (pInAttesa instanceof PrenotazioneGruppo)
            {
                if (pInt >= pInAttesa.getnPosti() || pExt >= pInAttesa.getnPosti())
                {
                    System.out.println("Prenotazione n." + pInAttesa.getCodice() + " = " + prenota(pInAttesa));
                }
            }
        }
    }

    public ArrayList<Prenotazione> getListaPrenotazioniInAttesa() {
        return listaPrenotazioniInAttesa;
    }

    public int getPostiRimanenti() {
        return pInt+pExt;
    }

    public int getPrenotazioniInt() {
        return prenotazioniInt;
    }

    public int getPrenotazioniExt() {
        return prenotazioniExt;
    }

    public static void main(String[] args)
    {
        Manager manager = new Manager(4, 4);
        Prenotazione prenotazione1 = new PrenotazioneSingola(1, Preferenza.INTERNO);
        Prenotazione prenotazione2 = new PrenotazioneSingola(2, Preferenza.ESTERNO);
        Prenotazione prenotazione3 = new PrenotazioneSingola(3, Preferenza.ESTERNO);
        Prenotazione prenotazione4 = new PrenotazioneSingola(4, Preferenza.INTERNO);

        System.out.println("Prenotazione n." + prenotazione1.getCodice() + " = " + manager.prenota(prenotazione1));
        System.out.println("Prenotazione n." + prenotazione2.getCodice() + " = " + manager.prenota(prenotazione2));
        System.out.println("Prenotazione n." + prenotazione3.getCodice() + " = " + manager.prenota(prenotazione3));
        System.out.println("Prenotazione n." + prenotazione4.getCodice() + " = " + manager.prenota(prenotazione4));

        Prenotazione prenotazione5 = new PrenotazioneGruppo(5, 3);
        System.out.println("Prenotazione n." + prenotazione5.getCodice() + " = " + manager.prenota(prenotazione5));

        manager.cancellaPrenotazione(prenotazione2);

        System.out.println("Prenotazioni interne: " + manager.getPrenotazioniInt());
        System.out.println("Prenotazioni esterne: " + manager.getPrenotazioniExt());
        System.out.println("Numero posti rimaneneti: " + manager.getPostiRimanenti());
    }
}





