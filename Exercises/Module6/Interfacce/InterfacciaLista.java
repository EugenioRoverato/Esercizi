package Iterabile;

public interface InterfacciaLista
{
    Object get(int i); // restituisce l'elemento alla posizione i della sequenza
    boolean contains(Object o); // restituisce true se l'elemento o è presente nella sequenza
    int size(); // restituisce quanti elementi sono presenti all'interno della sequenza
    void add(Object o); // aggiunge un elemento alla sequenza
    boolean remove(int i); // rimuove l'elemento alla posizione i della sequenza, torna true se l'elemento è stato rimosso, false se non l'ha trovato
    void clear(); // rimuove tutti gli elementi dalla sequenza

}
