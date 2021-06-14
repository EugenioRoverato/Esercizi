package Iterabile;

public class MiaStringa implements InterfacciaIterabile, InterfacciaLista
{
    String stringFI = "ab";
    int i = 0;

    String string = "";

    //////////////////////// FIRST INTERFACE

    public void setI(int i) { this.i = i+1; }

    @Override
    public Object next()
    {
        char temp = stringFI.charAt(i);
        setI(i);
        return temp;
    }

    @Override
    public boolean hasNext() { return i < stringFI.toCharArray().length; }

    @Override
    public void reset()
    {
        i = -1;
    }

    //////////////////////// SECOND INTERFACE

    @Override
    public Object get(int i)
    {
        return string.toCharArray()[i];
    }

    @Override
    public boolean contains(Object o)
    {
        for (char element : string.toCharArray())
            if (element == (char) o)
                return true;
        return false;
    }

    @Override
    public int size()
    {
        return string.toCharArray().length;
    }

    @Override
    public void add(Object o)
    {
        string += (char) o;
    }

    @Override
    public boolean remove(int index)
    {
        String newString = "";
        for (int i = 0 ; i < string.toCharArray().length ; i++)
        {
            if (i != index)
            {
                newString += string;
            }
        }
        if (!newString.equals(string))
        {
            this.string = newString;
            return true;
        }
        return false;
    }

    @Override
    public void clear()
    {
        this.string = "";
    }
}
