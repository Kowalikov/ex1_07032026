/*
Zadanie 5 (4 punkty)
Z klasy Pojazd dziedziczą Samochod (dodatkowe atrybuty segment
i VIN) oraz Jednoslad (dodatkowy atrybut typ). Obie wspomniane
klasy wykorzystują autorskie enumeracje i zostają wyposażone w
konstruktory oraz metody wyswietl, nadpisujące metody o tej
samej nazwie w klasach nadrzędnych. Konstruktory mają wywoływać
konstruktory klasy nadrzędnej i wpisywać się w logikę
autonumerowania i wyświetlania informacji o numeracji.
W szczególności, klasy te powinny mieć konstruktory pobierające
odpowiednio 8 i 7 atrybutów - a jednoślad dodatkowo konstruktor,
który nie pobiera wszystkich atrybutów (z uwagi na specyficzną
logikę opisu rowerów i hulajnóg tradycyjnych). Metoda
wyświetlająca klasy Jednoślad ma pomijać wartości niewprowadzone.
Autor rozwiązania: Marek Kowalik
*/
package lab3;


public class Zad05Lab3 {
    protected static enum Segment {
        A,
        B,
        C,
        D,
        E,
        F,
        J,
        M,
        S
    }

    static class Samochod extends Zad04Lab3.Pojazd {
        protected String VIN;
        protected Segment segment;

        Samochod(
                String marka,
                String nazwa,
                double pojemnoscSilnika,
                Zad01Lab3.RodzajSilnika rodzajSilnika,
                double moc,
                double momentObrotowy,
                String VIN,
                Segment segment
        ) {
            super(
                    marka,
                    nazwa,
                    pojemnoscSilnika,
                    rodzajSilnika,
                    moc,
                    momentObrotowy
            );
            this.VIN = VIN;
            this.segment = segment;
        }

        @Override
        void wyswietl() {
            System.out.println("Informacje o pojeździe:");
            System.out.println("Marka: %s".formatted(this.marka));
            System.out.println("Nazwa: %s".formatted(this.nazwa));
            System.out.println("Pojemność silnika: %.1f cc".formatted(this.pojemnoscSilnika));
            System.out.println("Rodzaj silnika: %s".formatted(this.rodzajSilnika));
            System.out.println("Moc: %.1f kW".formatted(this.moc));
            System.out.println("Moment obrotowy: %.1f Nm".formatted(this.momentObrotowy));
            System.out.println("VIN: %s".formatted(this.VIN));
            System.out.println("Segment: %s".formatted(this.segment));
            System.out.println("Pojazd %d z %d".formatted(this.nrPojazdu, maxLiczbaPojazdow));
        }
    }

    protected static enum Typ {
        hulajnoga,
        rower,
        motocykl,
        motorower
    }

    static class Jednoslad extends Zad04Lab3.Pojazd {
        protected Typ typ;

        Jednoslad(
                String marka,
                String nazwa,
                double pojemnoscSilnika,
                Zad01Lab3.RodzajSilnika rodzajSilnika,
                double moc,
                double momentObrotowy,
                Typ typ
        ) {
            super(
                    marka,
                    nazwa,
                    pojemnoscSilnika,
                    rodzajSilnika,
                    moc,
                    momentObrotowy
            );
            this.typ = typ;
        }

        Jednoslad(
                String marka,
                String nazwa,
                Typ typ
        ) {
            super();
            this.marka = marka;
            this.nazwa = nazwa;
            this.typ = typ;
        }

        @Override
        void wyswietl() {
            System.out.println("Informacje o pojeździe:");
            System.out.println("Marka: %s".formatted(this.marka));
            System.out.println("Nazwa: %s".formatted(this.nazwa));

            if (pojemnoscSilnika > 0.0) {
                System.out.println("Pojemność silnika: %.1f cc".formatted(this.pojemnoscSilnika));
            }
            if (rodzajSilnika != null) {
                System.out.println("Rodzaj silnika: %s".formatted(this.rodzajSilnika));
            }
            if (moc > 0) {
                System.out.println("Moc: %.1f kW".formatted(this.moc));
            }
            if (momentObrotowy > 0) {
                System.out.println("Moment obrotowy: %.1f Nm".formatted(this.momentObrotowy));
            }

            System.out.println("Typ: %s".formatted(this.typ));
            System.out.println("Pojazd %d z %d".formatted(this.nrPojazdu, maxLiczbaPojazdow));
        }
    }

    public static void main(String[] args) {
        Samochod s = new Samochod(
                "Honda",
                "City",
                1500f,
                Zad01Lab3.RodzajSilnika.BENZYNA,
                109*0.73549875,
                143,
                "1M8GDM9A0KP042788",
                Segment.C
        );
        Jednoslad j1 = new Jednoslad(
                "Kawasaki",
                "Ninja",
                998f,
                Zad01Lab3.RodzajSilnika.BENZYNA,
                146,
                131.0,
                Typ.motocykl
        );
        Jednoslad j2 = new Jednoslad(
                "Romet",
                "Finale",
                Typ.rower
        );


        s.wyswietl();
        System.out.println();
        j1.wyswietl();
        System.out.println();
        j2.wyswietl();
    }
}
