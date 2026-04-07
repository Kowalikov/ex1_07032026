/*
Zadanie 4:
Zaimplementuj klasę Clock. Klasa zawierać będzie pola: hours, minutes, seconds.
Zmienna hours przyjmuje wartości z zakresu 0-23, minutes z zakresu 0-59, seconds 0-59.
Dodaj trzy konstruktor:

- domyślny - inicjalizuje godzinę 12:00:00;
- konstruktor zawierający trzy parametry: hours, minutes, seconds,
- konstruktor z jednym parametrem - czas w sekundach licząc od północy jest konwertowany do pól: hours, minutes, seconds.

Dodaj metody:
- getHours(), getMinutes(), getSeconds(), bez parametrów, które zwracają odpowiednie wartości;
- setHours(), setMinutes(), setSeconds(), z jednym parametrem, który ustawia odpowiednie wartości;
- tick(), bez parametrów, która inkrementuje wartość second o jeden. Przykład:
  wartość 00:00:01 zamieni się na 00:00:02; wartość 00:59:59 zmieni się na 01:00:00;
- tickDown(), zmniejsza wartość sekund o jedno; analogiczna do tick();
- toString(), bez parametrów, zwraca reprezentację obiektu w postaci "[hh-mm-ss]",
  uzupełnioną o nieznaczące zera, na przykład: "[03:12:56]".

Przetestuj zaimplementowany program.
Autor rozwiązania: Marek Kowalik
*/
package lab2;


public class Zad04Lab2 {
    public static class Clock {
        private int hours;
        private int minutes;
        private int seconds;

        public Clock() {
            this.hours = 12;
            this.minutes = 0;
            this.seconds = 0;
        }

        public Clock(int hours, int minutes, int seconds) {
            if ( hours < 0 || hours > 23) {
                throw new IllegalArgumentException("Invalid hours: " + hours);
            }
            if ( minutes < 0 || minutes > 59) {
                throw new IllegalArgumentException("Invalid minutes: " + minutes);
            }
            if ( seconds < 0 || seconds > 59 ) {
                throw new IllegalArgumentException("Invalid seconds: " + seconds);
            }
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        }

        public Clock(int seconds) {
            if ( seconds < 0 ) {
                throw new IllegalArgumentException("Invalid seconds: " + seconds);
            }
            this.hours = (seconds / 3600) % 24;
            this.minutes = ((seconds % 3600) / 60);
            this.seconds = seconds % 60;
        }

        public void setHours(int hours) {
            if ( hours < 0 || hours > 23) {
                throw new IllegalArgumentException("Invalid hours: " + hours);
            }
            this.hours = hours;
        }
        public void setMinutes(int minutes) {
            if ( minutes < 0 || minutes > 59) {
                throw new IllegalArgumentException("Invalid minutes: " + minutes);
            }
            this.minutes = minutes;
        }
        public void setSeconds(int seconds) {
            if ( seconds < 0 || seconds > 59 ) {
                throw new IllegalArgumentException("Invalid seconds: " + seconds);
            }
            this.seconds = seconds;
        }

        public int getHours() {
            return this.hours;
        }
        public int getMinutes() {
            return this.minutes;
        }
        public int getSeconds() {
            return this.seconds;
        }

        public void tick() {
            int minutes_to_increase = (this.seconds + 1) / 60;
            int hours_to_increase = (this.minutes + minutes_to_increase) / 60;

            this.seconds = (this.seconds + 1) % 60;
            this.minutes = (this.minutes + minutes_to_increase) % 60;
            this.hours = (this.hours + hours_to_increase) % 24;
        }

        public void tickDown() {
            int minutes_to_decrease = 0;
            if ((this.seconds - 1) < 0) {
                minutes_to_decrease = 1;
            }
            int hours_to_decrease = 0;
            if ((this.minutes - minutes_to_decrease) < 0) {
                hours_to_decrease = 1;
            }
            this.minutes = (this.minutes + 60 - minutes_to_decrease) % 60;
            this.seconds = (this.seconds + 60 - 1) % 60;
            this.hours = (this.hours + 24 - hours_to_decrease) % 24;
        }

        public String toString() {
            return String.format("[%02d:%02d:%02d]", hours, minutes, seconds);
        }
    }

    public static void main(String[] args) {
        Clock clock1 = new Clock(23, 59, 59);
        IO.print(clock1);
        clock1.tick();
        IO.println(" - after one tick -> " + clock1);

        Clock clock2 = new Clock(36000);
        IO.print(clock2);
        clock2.setHours(3);
        clock2.setMinutes(31);
        clock2.setSeconds(50);
        IO.println(" - with new setup -> " + clock2);

        Clock clock3 = new Clock();
        IO.print(clock3);
        clock3.tickDown();
        IO.println(" - after tickDown -> " + clock3);
    }
}
