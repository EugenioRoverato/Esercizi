package Old.Prenotazioni;

public class Prenotazione
{
    int codice;
    int nPosti;

    public Prenotazione(int codice, int nPosti)
    {
        this.codice = codice;
        this.nPosti = nPosti;
    }

    public int getCodice() {
        return codice;
    }

    public int getnPosti() {
        return nPosti;
    }
}
