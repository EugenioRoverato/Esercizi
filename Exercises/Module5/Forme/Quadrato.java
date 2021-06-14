package Old.Forme;

public class Quadrato extends FormeGeometriche
{
    public Quadrato(int lato1)
    {
        super(lato1);
    }
    public int getArea() { return getLato1()*getLato1(); }
    public int getPerimeter() { return getLato1()*4; }

    @Override public String toString() { return getClass().getName(); }
}
