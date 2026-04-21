/*
Zadanie 6 (3 punkty)
W metodzie głównej klasy ParkMaszynowy zadeklarować po 2 obiekty
każdej klasy, w stosunku do której jest to możliwe. Wszystkie
obiekty trafiają do pojedynczej kolekcji i są wyświetlane pętlą
for each. Jakiej modyfikacji należy dokonać w klasie Maszyna,
aby było to możliwe? Wykorzystaj dodolną metodę set obiektu
klasy Kosiarka i wyświetl ten obiekt ponownie.
Autor rozwiązania: Marek Kowalik
*/
package lab3;


import java.util.ArrayList;
import java.util.List;

public class Zad06Lab3 {
    static class ParkMaszynowy {
        private List<Zad01Lab3.Maszyna> maszyny = new ArrayList<>();

        public void dodajMaszyne(Zad01Lab3.Maszyna m) {
            maszyny.add(m);
        }

        public void usunMaszyne(Zad01Lab3.Maszyna m) {
            maszyny.remove(m);
        }

        public static void main(String[] args) {
            ParkMaszynowy pm = new ParkMaszynowy();

            Zad02Lab3.Lokomotywa l1 = new Zad02Lab3.Lokomotywa(
                    "PKP",
                    "EP02",
                    0f,
                    Zad01Lab3.RodzajSilnika.ELEKTRYCZNY,
                    1_360f,
                    4
            );
            pm.dodajMaszyne(l1);

            Zad02Lab3.Lokomotywa l2 = new Zad02Lab3.Lokomotywa(
                    "Fablok",
                    "Ls800E-6D",
                    81600f,
                    Zad01Lab3.RodzajSilnika.DIESEL,
                    590f,
                    4
            );
            pm.dodajMaszyne(l2);

            Zad03Lab3.Kosiarka k1 = new Zad03Lab3.Kosiarka(
                    "Husqvarna",
                    "308V",
                    0f,
                    Zad01Lab3.RodzajSilnika.ELEKTRYCZNY,
                    false,
                    true,
                    4
            );
            pm.dodajMaszyne(k1);

            Zad03Lab3.Kosiarka k2 = new Zad03Lab3.Kosiarka(
                    "Honda",
                    "Wuber",
                    201f,
                    Zad01Lab3.RodzajSilnika.BENZYNA,
                    false,
                    true,
                    4
            );
            pm.dodajMaszyne(k2);

            Zad04Lab3.Pojazd p1 = new Zad04Lab3.Pojazd(
                    "Fiat",
                    "Panda",
                    1368f,
                    Zad01Lab3.RodzajSilnika.BENZYNA,
                    73.549875,
                    131.0
            );
            pm.dodajMaszyne(p1);

            Zad04Lab3.Pojazd p2 = new Zad04Lab3.Pojazd(
                    "Honda",
                    "City",
                    1500f,
                    Zad01Lab3.RodzajSilnika.BENZYNA,
                    109*0.73549875,
                    143
            );
            pm.dodajMaszyne(p2);

            Zad05Lab3.Jednoslad j1 = new Zad05Lab3.Jednoslad(
                    "Kawasaki",
                    "Ninja",
                    998f,
                    Zad01Lab3.RodzajSilnika.BENZYNA,
                    146,
                    131.0,
                    Zad05Lab3.Typ.motocykl
            );
            pm.dodajMaszyne(j1);

            Zad05Lab3.Jednoslad j2 = new Zad05Lab3.Jednoslad(
                    "Romet",
                    "Finale",
                    Zad05Lab3.Typ.rower
            );
            pm.dodajMaszyne(j2);

            Zad05Lab3.Samochod s1 = new Zad05Lab3.Samochod(
                    "Honda",
                    "City",
                    1500f,
                    Zad01Lab3.RodzajSilnika.BENZYNA,
                    109*0.73549875,
                    143,
                    "1M8GDM9A0KP042788",
                    Zad05Lab3.Segment.C
            );
            pm.dodajMaszyne(s1);

            Zad05Lab3.Samochod s2 = new Zad05Lab3.Samochod(
                    "Renault",
                    "Clio",
                    1461f,
                    Zad01Lab3.RodzajSilnika.DIESEL,
                    90*0.73549875,
                    220,
                    "YV4902DZ3E2538289",
                    Zad05Lab3.Segment.B
            );
            pm.dodajMaszyne(s2);

            for (Zad01Lab3.Maszyna m : pm.maszyny) {
                m.wyswietl();
                System.out.println();
            }

            k2.setLiczbaOstrzy(32);
            k2.wyswietl();
        }
    }

    public static void main(String[] args) {
    }
}
