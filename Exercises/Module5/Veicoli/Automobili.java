package Old.Veicoli;

public class Automobili extends Veicoli
{
    int numPorte;

    public Automobili(String targa, String marca, String modello, int numPosti, int numPorte)
    {
        super(targa, marca, modello, numPosti, numPorte);
        this.numPorte = numPorte;
    }

    public int getNumPorte() { return numPorte; }
    @Override public String toString() { return super.toString(targa, getNumPorte()); }
}
