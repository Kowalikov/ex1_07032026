/*
Zadanie 3:
Zaimplementuj klasę MyDate, która przechowuje informację: month (typu int),
day(typu int) i year (type int). Klasa powinna zawierać konstruktor, który
inicjalizuje zmienne, sprawdzając poprawność zakresów (day 0-31, month 0-12,
year 1990-2050). Zaimplementuj methody set i get dla wszystkich pól.
Dodaj metodę displayDate, która wyświetli pola z uwzględnieniem zer nieznaczących
oddzielone znakiem "/", np 21/03/2051. Przetestuj zaimplementowaną klasę.
Autor rozwiązania: Marek Kowalik
*/
package lab2;


public class Zad03Lab2 {
    public static class MyDate {
        private int month;
        private int day;
        private int year;

        public MyDate(int month, int day, int year) {
            if ( month < 0 || month > 12) {
                throw new IllegalArgumentException("Invalid month: " + month);
            }
            if ( day < 0 || day > 31) {
                throw new IllegalArgumentException("Invalid day: " + day);
            }
            if ( year < 1990 || year > 2050 ) {
                throw new IllegalArgumentException("Invalid year: " + year);
            }
            this.month = month;
            this.day = day;
            this.year = year;
        }

        public void setMonth(int month) {
            if ( month < 0 || month > 12) {
                throw new IllegalArgumentException("Invalid month: " + month);
            }
            this.month = month;
        }
        public void setDay(int day) {
            if ( day < 0 || day > 31) {
                throw new IllegalArgumentException("Invalid day: " + day);
            }
            this.day = day;
        }
        public void setYear(int year) {
            if ( year < 1990 || year > 2050 ) {
                throw new IllegalArgumentException("Invalid year: " + year);
            }
            this.year = year;
        }

        public int getMonth() {
            return this.month;
        }
        public int getDay() {
            return this.day;
        }
        public int getYear() {
            return this.year;
        }

        public void displayDate() {
            IO.println(String.format("%02d/%02d/%04d", month, day, year));
        }
    }

    public static void main(String[] args) {
        MyDate date1 = new MyDate(1, 1, 2001);
        MyDate date2 = new MyDate(4, 10, 2026);

        date1.displayDate();
        date2.displayDate();

        IO.println("\nZmiana daty 1 setterami na 03/31/2050:");

        date1.setDay(31);
        date1.setMonth(3);
        date1.setYear(2050);

        date1.displayDate();
    }
}
