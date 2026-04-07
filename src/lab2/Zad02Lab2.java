/*
Zadanie 2:
Zaimplementuj klasę Student, do przechowywania imienia, nazwiska,
numer indeksu i obecność (wyrażonej w procentach) oceny z POJ (typu int).
Jeżeli podczas tworzenia obiektu nie zostało przekazane imię i nazwisko,
pola powinny być ustawione wartością "Unknown". Dodaj odpowiednie metody
set i get do wszystkich pól klasy. Jeżeli obecnocność jest mniejsza niż 50%,
student powinien otrzymać ocenę 2. Przetestuj program,
tworząc trzy różne obiekty klasy Student.
Autor rozwiązania: Marek Kowalik
*/
package lab2;


public class Zad02Lab2 {
    public static class Student {
        private String imie;
        private String nazwisko;
        private int numer_indeksu;
        private double obecnosc_z_POJ;
        private int ocena_z_POJ = 2;

        public Student(String imie, String nazwisko, int numer_indeksu, double obecnosc_z_POJ, int ocena_z_POJ) {
            this.imie = imie;
            this.nazwisko = nazwisko;
            this.numer_indeksu = numer_indeksu;
            this.obecnosc_z_POJ = obecnosc_z_POJ;
            this.ocena_z_POJ = ocena_z_POJ;
        }

        public Student(String imie, String nazwisko) {
            this.imie = imie;
            this.nazwisko = nazwisko;
        }

        public Student() {
            this.imie = "Unknown";
            this.nazwisko = "Unknown";
        }

        public void setImie(String imie) {
            this.imie = imie;
        }
        public void setNazwisko(String nazwisko) {
            this.nazwisko = nazwisko;
        }
        public void setNumer_indeksu(int numer_indeksu) {
            this.numer_indeksu = numer_indeksu;
        }
        public void setObecnosc_z_POJ(double obecnosc_z_POJ) {
            this.obecnosc_z_POJ = obecnosc_z_POJ;
            if ( obecnosc_z_POJ < 50.0 ) {
                this.ocena_z_POJ = 2;
            }
        }
        public void setOcena_z_POJ(int ocena_z_POJ) {
            if ( obecnosc_z_POJ < 50.0 ) {
                this.ocena_z_POJ = 2;
            } else {
                this.ocena_z_POJ = ocena_z_POJ;
            }
        }

        public String getImie() {
            return imie;
        }
        public String getNazwisko() {
            return nazwisko;
        }
        public int getNumer_indeksu() {
            return numer_indeksu;
        }
        public double getObecnosc_z_POJ() {
            return obecnosc_z_POJ;
        }
        public int getOcena_z_POJ() {
            return ocena_z_POJ;
        }

        @Override
        public String toString() {
            return "\tImię: %s\n".formatted(imie) +
                    "\tNazwisko: %s\n".formatted(nazwisko) +
                    "\tNr. indeksu: %d\n".formatted(numer_indeksu) +
                    "\tObecność z POJ: %.2f%%\n".formatted(obecnosc_z_POJ) +
                    "\tOcena z POJ: %d\n".formatted(ocena_z_POJ);
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student(
                "Marek",
                "Kowalik",
                35501,
                80.0,
                4);
        Student student2 = new Student("Jan", "Kowalski");
        Student student3 = new Student();

        IO.println(String.format("Student 1:\n %s", student1));
        IO.println(String.format("Student 2:\n %s", student2));
        IO.println(String.format("Student 3:\n %s", student3));

        student1.setObecnosc_z_POJ(40.0);

        student2.setImie("Michał");
        student2.setNazwisko("Nowak");
        student2.setOcena_z_POJ(5);

        student3.setImie("Robert");
        student3.setNazwisko("Lewandowski");
        student3.setNumer_indeksu(9);
        student3.setObecnosc_z_POJ(100);
        student3.setOcena_z_POJ(5);

        IO.println(String.format("Student 1:\n %s", student1));
        IO.println(String.format("Student 2:\n %s", student2));
        IO.println(String.format("Student 3:\n %s", student3));
    }
}
