package Old.Forme;

public class FormeGeometriche
{
    public int lato1;
    public int lato2;

    public FormeGeometriche(int lato1, int lato2)
    {
        this.lato1 = lato1;
        this.lato2 = lato2;
    }

    public FormeGeometriche(int lato1)
    {
        this.lato1 = lato1;
    }

    public int getLato1()
    {
        return lato1;
    }

    public int getLato2() {
        return lato2;
    }

    public String toString()
    {
        return "";
    }

    public static void main(String[] args)
    {
        Quadrato quadrato = new Quadrato(5);
        Rettangolo rettangolo = new Rettangolo(5,6);

        System.out.println(quadrato);
        System.out.println("Perimetro: " + quadrato.getPerimeter() + " Area: " + quadrato.getArea());
        System.out.println(rettangolo);
        System.out.println("Perimetro: " + rettangolo.getPerimeter() + " Area: " + rettangolo.getArea());
    }
}
