/*
Zadanie 1 (1 punkt)
Zaimplementuj abstrakcyjną klasę `Maszyna` z chronionymi
atrybutami `marka`, `nazwa`, `pojemnoscSilnika` i `rodzajSilnika`.
Ten ostatni ma być enumeracją.
Autor rozwiązania: Marek Kowalik
*/
package lab3;


public class Zad01Lab3 {
    protected static enum RodzajSilnika {
        DIESEL,
        BENZYNA,
        ELEKTRYCZNY
    }

    abstract static class Maszyna{
        protected String marka;
        protected String nazwa;
        protected double pojemnoscSilnika;
        protected RodzajSilnika rodzajSilnika;

        abstract void wyswietl();
    }


    public static void main(String[] args) {}
}
