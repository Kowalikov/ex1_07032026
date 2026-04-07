/*
Zadanie 1:
Zaimplementuj klasę Card reprezentującą pojedynczą kartę do gry z talii kart.
Klasa powinna przechowywać wartość i kolor: kier, karo, pik, trefl.
W zadaniu użyj typu wyliczeniowego. Napisz program testujący, który
stworzy trzy różne obiekty klasy Card.
Autor rozwiązania: Marek Kowalik
*/
package lab2;


public class Zad01Lab2 {
    public enum Kolor {
        kier,
        karo,
        pik,
        trefl
    }

    public enum Wartosc {
        dwojka,
        trojka,
        czworka,
        piatka,
        szostka,
        siodemka,
        osemka,
        dziewiatka,
        dziesiatka,
        walet,
        dama,
        krol,
        as
    }

    public static class Card {
        private final Wartosc wartosc;
        private final Kolor kolor;

        public Card(Wartosc wartosc, Kolor kolor) {
            this.wartosc = wartosc;
            this.kolor = kolor;
        }

        @Override
        public String toString() {
            return wartosc + " " + kolor;
        }
    }

    public static void main(String[] args) {
        Card karta1 = new Card(Wartosc.siodemka, Kolor.karo);
        Card karta2 = new Card(Wartosc.dwojka, Kolor.trefl);
        Card karta3 = new Card(Wartosc.as, Kolor.kier);

        IO.println(String.format("Karta 1: %s", karta1.toString()));
        IO.println(String.format("Karta 2: %s", karta2.toString()));
        IO.println(String.format("Karta 3: %s", karta3.toString()));
    }
}
