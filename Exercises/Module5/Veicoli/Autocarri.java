package Old.Veicoli;

public class Autocarri extends Veicoli
{
    int maxCapacity; // in quintali

    public Autocarri(String targa, String marca, String modello, int numPosti, int maxCapacity)
    {
        super(targa, marca, modello, numPosti, maxCapacity);
        this.maxCapacity = maxCapacity;
    }

    public int getMaxCapacity() { return maxCapacity; }
    @Override public String toString() { return super.toString(targa, getMaxCapacity()); }
}
