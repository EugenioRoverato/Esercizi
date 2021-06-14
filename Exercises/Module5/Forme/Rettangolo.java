package Old.Forme;

public class Rettangolo extends FormeGeometriche
{
    public Rettangolo(int lato1, int lato2) { super(lato1, lato2); }
    public int getArea() { return getLato1()*getLato2(); }
    public int getPerimeter() { return getLato1() * 2 + getLato2() * 2; }

    @Override public String toString() { return "Rettangolo"; }
}
