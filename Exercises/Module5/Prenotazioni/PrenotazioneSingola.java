package Old.Prenotazioni;

public class PrenotazioneSingola extends Prenotazione
{
    Preferenza preferenza;

    public PrenotazioneSingola(int codice, Preferenza preferenza)
    {
        super(codice, 1);
        this.preferenza = preferenza;
    }

    public Preferenza getPreferenza() {
        return preferenza;
    }
}
enum Preferenza{
    INTERNO, ESTERNO
}
