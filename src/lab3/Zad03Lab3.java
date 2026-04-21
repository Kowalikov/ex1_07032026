/*
Zadanie 3 (3 punkty)
Uzupełnij repozytorium o klasę Kosiarka, która:
- dziedziczy z maszyny;
- wprowadza prywatne atrybuty czyMelekser (typu boolean),
  czyNaped(j.w.) i liczbaOstrzy (typu int);
- posiada, analogicznie jak klasa Kosiarka, jeden konstruktor
  i metodę wyswietl, która wyświetla komplet 7 atrybutów w
  zorganizowanej formie;
- dodatkowo, klasa ma zawierać metody set dla wszystkich trzech
  nowowprowadzanych atrybutów.
Autor rozwiązania: Marek Kowalik
*/
package lab3;


public class Zad03Lab3 {
    static class Kosiarka extends Zad01Lab3.Maszyna {
        private boolean czyMelekser;
        private boolean czyNaped;
        private int liczbaOstrzy;
        Kosiarka(
                String marka,
                String nazwa,
                double pojemnoscSilnika,
                Zad01Lab3.RodzajSilnika rodzajSilnika,
                boolean czyMelekser,
                boolean czyNaped,
                int liczbaOstrzy
        ) {
            this.marka = marka;
            this.nazwa = nazwa;
            this.pojemnoscSilnika = pojemnoscSilnika;
            this.rodzajSilnika = rodzajSilnika;
            this.czyMelekser = czyMelekser;
            this.czyNaped = czyNaped;
            this.liczbaOstrzy = liczbaOstrzy;
        }

        void wyswietl() {
            System.out.println("Informacje o kosiarce:");
            System.out.println("Marka: %s".formatted(this.marka));
            System.out.println("Nazwa: %s".formatted(this.nazwa));
            System.out.println("Pojemność silnika: %.1f cc".formatted(this.pojemnoscSilnika));
            System.out.println("Rodzaj silnika: %s".formatted(this.rodzajSilnika));
            System.out.println("Czy jest melekserem: %b".formatted(this.czyMelekser));
            System.out.println("Czy ma napęd: %b".formatted(this.czyNaped));
            System.out.println("Liczba ostrzy: %d".formatted(this.liczbaOstrzy));
        }

        public void setLiczbaOstrzy(int liczbaOstrzy) {
            this.liczbaOstrzy = liczbaOstrzy;
        }
    }

    public static void main(String[] args) {
        Zad03Lab3.Kosiarka k = new Zad03Lab3.Kosiarka(
                "Husqvarna",
                "308V",
                0f,
                Zad01Lab3.RodzajSilnika.ELEKTRYCZNY,
                false,
                true,
                4
        );

        k.wyswietl();
    }
}
