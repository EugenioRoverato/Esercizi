package Old.Veicoli;

public class Veicoli
{
    String targa;
    String marca;
    String modello;
    int numPosti;
    int element;

    public Veicoli(String targa, String marca, String modello, int numPosti, int element)
    {
        this.targa = targa;
        this.marca = marca;
        this.modello = modello;
        this.numPosti = numPosti;
        this.element = element;
    }

    public String toString(String targa, int element) { return targa + " «:» " + element; }

    public static void main(String[] args)
    {
        Automobili auto = new Automobili("4UT1N4", "Audi", "RX", 4, 4);
        Autocarri carro = new Autocarri("P1PP0N3", "Mini", "Cooper Carro", 4, 500);

        System.out.println(auto); // toString viene richiamato in automatico
        System.out.println(carro);
    }
}
