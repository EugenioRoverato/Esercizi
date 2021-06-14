package Iterabile;

public class ListaDiInteri implements InterfacciaIterabile, InterfacciaLista
{
    int[] arrayFI = new int[]{1,2};
    int i = 0;

    int[] array = new int[0];

    //////////////////////// FIRST INTERFACE

    public void setI(int i) { this.i = i+1; }

    @Override
    public Object next()
    {
        int temp = arrayFI[i];
        setI(i);
        return temp;
    }

    @Override
    public boolean hasNext() { return i <= arrayFI.length - 1; }

    @Override
    public void reset() { i = -1; }

    //////////////////////// SECOND INTERFACE

    @Override
    public Object get(int i)
    {
        return array[i];
    }

    @Override
    public boolean contains(Object o)
    {
        for (int element : array)
            if (element == (int) o)
                return true;

        return false;
    }

    @Override
    public int size()
    {
        return array.length;
    }

    @Override
    public void add(Object o)
    {
        int[] newArray = new int[array.length+1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[newArray.length-1] = (int) o;
        this.array = newArray;
    }

    @Override
    public boolean remove(int index)
    {
        for (int i = 0 ; i < array.length ; i++)
        {
            if (index == i)
            {
                int[] newArray = new int[array.length];
                for (int j = 0 ; j < array.length ; j++)
                {
                    if (j != index)
                    {
                        newArray[j] = array[j];
                    }
                }
                this.array = newArray;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear()
    {
        this.array = new int[0];
    }
}
