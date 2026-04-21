/*
Zadanie 2 (2 punkty)
Zaimplementuj klasę `Lokomotywa` dziedziczącą po maszynie.
Klasa ta ma dodawać dwa prywatne atrybuty charakterystyczne
dla lokomotyw i nieuwzględnione wcześniej w maszynie.
Klasa ta ma mieć konstruktor, przyjmujący komplet 6 parametrów
oraz metodę `wyswietl`, wyrzucającą w zamyśle na ekran
wyczerpujący opis danej lokomotywy.
Autor rozwiązania: Marek Kowalik
*/
package lab3;


public class Zad02Lab3 {
    static class Lokomotywa extends Zad01Lab3.Maszyna {
        private double moc;
        private int iloscOsi;

        Lokomotywa(
                String marka,
                String nazwa,
                double pojemnoscSilnika,
                Zad01Lab3.RodzajSilnika rodzajSilnika,
                double moc,
                int iloscOsi
        ) {
            this.marka = marka;
            this.nazwa = nazwa;
            this.pojemnoscSilnika = pojemnoscSilnika;
            this.rodzajSilnika = rodzajSilnika;
            this.moc = moc;
            this.iloscOsi = iloscOsi;
        }

        void wyswietl() {
            System.out.println("Informacje o lokomotywie:");
            System.out.println("Marka: %s".formatted(this.marka));
            System.out.println("Nazwa: %s".formatted(this.nazwa));
            System.out.println("Pojemność silnika: %.1f cc".formatted(this.pojemnoscSilnika));
            System.out.println("Rodzaj silnika: %s".formatted(this.rodzajSilnika));
            System.out.println("Moc: %.1f kW".formatted(this.moc));
            System.out.println("Ilość osi: %d".formatted(this.iloscOsi));
        }
    }

    public static void main(String[] args) {
        Lokomotywa l = new Lokomotywa(
                "PKP",
                "EP02",
                0f,
                Zad01Lab3.RodzajSilnika.ELEKTRYCZNY,
                1_360f,
                4
        );

        l.wyswietl();
    }
}
