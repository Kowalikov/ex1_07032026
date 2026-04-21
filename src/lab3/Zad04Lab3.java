/*
Zadanie 4 (2 punkty)
Ostatnią klasą dziedziczącą bezpośrednio z maszyny jest klasa
Pojazd. Klasa zawierać będzie pojedynczy konstruktor, standardową
metodę wyświetlającą oraz chronione atrybuty typu double moc
oraz momentObrotowy. Konstruktor ma realizować autonumerowanie
pojazdów. W tym celu należy posłużyć się parą klasowych atrybutów
typu int: nrPojazdu oraz maxLiczbaPojazdow (ten ostatni statyczny).
Metoda wyświetlająca ma uwzględniać obie wskazane informacje,
np. Pojazd 7 z 12....
Autor rozwiązania: Marek Kowalik
*/
package lab3;


public class Zad04Lab3 {
    static class Pojazd extends Zad01Lab3.Maszyna {
        protected double moc;
        protected double momentObrotowy;
        int nrPojazdu;
        static int maxLiczbaPojazdow;

        Pojazd() {
            maxLiczbaPojazdow += 1;
            this.nrPojazdu = maxLiczbaPojazdow;
        }

        Pojazd(
                String marka,
                String nazwa,
                double pojemnoscSilnika,
                Zad01Lab3.RodzajSilnika rodzajSilnika,
                double moc,
                double momentObrotowy
        ) {
            this.marka = marka;
            this.nazwa = nazwa;
            this.pojemnoscSilnika = pojemnoscSilnika;
            this.rodzajSilnika = rodzajSilnika;
            this.moc = moc;
            this.momentObrotowy = momentObrotowy;

            maxLiczbaPojazdow += 1;
            this.nrPojazdu = maxLiczbaPojazdow;
        }

        void wyswietl() {
            System.out.println("Informacje o pojeździe:");
            System.out.println("Marka: %s".formatted(this.marka));
            System.out.println("Nazwa: %s".formatted(this.nazwa));
            System.out.println("Pojemność silnika: %.1f cc".formatted(this.pojemnoscSilnika));
            System.out.println("Rodzaj silnika: %s".formatted(this.rodzajSilnika));
            System.out.println("Moc: %.1f kW".formatted(this.moc));
            System.out.println("Moment obrotowy: %.1f Nm".formatted(this.momentObrotowy));
            System.out.println("Pojazd %d z %d".formatted(this.nrPojazdu, maxLiczbaPojazdow));
        }
    }

    public static void main(String[] args) {
        Zad04Lab3.Pojazd p1 = new Zad04Lab3.Pojazd(
                "Fiat",
                "Panda",
                1368f,
                Zad01Lab3.RodzajSilnika.BENZYNA,
                73.549875,
                131.0
        );


        Zad04Lab3.Pojazd p2 = new Zad04Lab3.Pojazd(
                "Honda",
                "City",
                1500f,
                Zad01Lab3.RodzajSilnika.BENZYNA,
                109*0.73549875,
                143
        );

        p1.wyswietl();
        System.out.println();
        p2.wyswietl();
    }
}
