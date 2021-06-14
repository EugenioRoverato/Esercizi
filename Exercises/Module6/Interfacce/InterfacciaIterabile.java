package Iterabile;

public interface InterfacciaIterabile
{
    Object next(); // permette di ottenere il prossimo elemento
    boolean hasNext(); // indica se è presente un prossimo elemento nella sequenza
    void reset(); // resetta l'iterazione (indice interno)
}
