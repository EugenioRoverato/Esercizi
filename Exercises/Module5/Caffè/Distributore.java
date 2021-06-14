package Old.Caffè;
import java.util.ArrayList;

public class Distributore
{
    ArrayList<Distributore> prodotti = new ArrayList<>();
    int numProdotti;

    double saldo;
    double resto;

    public Distributore(int numProdotti)
    {
        this.numProdotti = numProdotti;
        saldo = 0;
        resto = 0;
    }

    public Distributore() {
    }

    public int getNumProdotti() { return numProdotti; }
    public void setNumProdotti(int numProdotti) { this.numProdotti = numProdotti; }

    public void caricaProdotto(Distributore prod)
    {
        if (numProdotti > 0)
        {
            prodotti.add(prod);
            numProdotti--;
        }
    }

    public void inserisciImporto(double importo) { this.saldo += importo; }

    public void scegliProdotto(double num)
    {
        double temp = getSaldo();

        for (Distributore prod : prodotti)
        {
            if (prod instanceof Caffe)
            {
                Caffe caffe = (Caffe) prod;

                if (num == caffe.getIdCaffe() && getSaldo() >= caffe.getCostoCaf())
                    setSaldo(getSaldo() - caffe.getCostoCaf());
            }
            else if (prod instanceof Cappuccino)
                {
                    Cappuccino capp = (Cappuccino) prod;

                    if (num == capp.getIdCappuccino() && getSaldo() >= capp.getCostoCap())
                        setSaldo(getSaldo() - capp.getCostoCap());
                }
        }

        if (temp == getSaldo())
            System.out.println("Non hai abbastanza soldi");
    }

    public double getResto()
    {
        setResto(saldo);
        saldo = 0;
        return resto;
    }

    public void setResto(double resto) {
        this.resto = resto;
    }

    public void setSaldo(double saldo) {
        this.saldo = Math.ceil(saldo * Math.pow(10, 2)) / Math.pow(10, 2);;
    }

    public double getSaldo() {
        return saldo;
    }

    public static void main(String[] args)
    {
        Distributore caffe = new Caffe();
        Distributore cappuccino = new Cappuccino();

        Distributore macchinetta = new Distributore(10);

        macchinetta.caricaProdotto(caffe);
        macchinetta.caricaProdotto(cappuccino);
        macchinetta.caricaProdotto(caffe);
        macchinetta.caricaProdotto(cappuccino);
        macchinetta.caricaProdotto(caffe);
        macchinetta.caricaProdotto(cappuccino);
        macchinetta.caricaProdotto(caffe); // 4 caffe 3 capp

        macchinetta.inserisciImporto(2.5);
        macchinetta.scegliProdotto(1);
        macchinetta.scegliProdotto(0);

        System.out.println("Saldo: " + macchinetta.getSaldo());
        //System.out.println("Resto: " + macchinetta.getResto());
    }
}
