/*
Zadanie 1
Zaimplementuj klasę Safe wraz z wymaganymi klasami Alarm i PinEvent, bez systemu rejestracji zdarzeń.
Autor rozwiązania: Marek Kowalik
*/
package lab4;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import static java.lang.Thread.sleep;


public class Zad01Lab4 {
    interface Logger {} //placeholder

    class PinEvent {
        private final Safe safe;
        public Date eventDate;

        PinEvent(Safe safe, Date eventDate) {
            this.safe = safe;
            this.eventDate = eventDate;
        }

        public Safe getSafe() {
            return this.safe;
        }
    }

    interface Alarm {
        public Logger logger = null;

        public void alarmTurnOn(PinEvent pinEvent) throws InterruptedException;
        public void alarmTurnOff(PinEvent pinEvent);
    }

    class SoundAlarm implements Alarm {
        public Logger logger;

        SoundAlarm(Logger logger) {
            this.logger = logger;
        }

        @Override
        public void alarmTurnOn(PinEvent pinEvent) {
            System.out.println("Rising alarm! WEEE-WOOO, WEEE-WOOO, WEEE-WOOO!");
        }

        @Override
        public void alarmTurnOff(PinEvent pinEvent) {
            System.out.println("Alarm off.");
        }
    }

    class BarsAlarm implements Alarm {
        public Logger logger;

        BarsAlarm(Logger logger) {
            this.logger = logger;
        }

        @Override
        public void alarmTurnOn(PinEvent pinEvent) {
            System.out.println("Dropping bars! ↓↓↓ ↓↓↓ ↓↓↓");
        }

        @Override
        public void alarmTurnOff(PinEvent pinEvent) {
            System.out.println("Alarm off. Rising bars: ↑↑↑ ↑↑↑ ↑↑↑");
        }
    }

    class DogsAlarm implements Alarm {
        public Logger logger;

        DogsAlarm(Logger logger) {
            this.logger = logger;
        }

        @Override
        public void alarmTurnOn(PinEvent pinEvent) {
            System.out.println("Releasing dogs! *woof, woof, woof*");
        }

        @Override
        public void alarmTurnOff(PinEvent pinEvent) {
            System.out.println("Hiding dogs. <aggresively shaking doggy treats> *Come here!*");
        }
    }

    class PoliceAlarm implements Alarm {
        public Logger logger;

        PoliceAlarm(Logger logger) {
            this.logger = logger;
        }

        @Override
        public void alarmTurnOn(PinEvent pinEvent) {
            System.out.println("Calling 911 in 5s.");
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Calling 911 now.");
        }

        @Override
        public void alarmTurnOff(PinEvent pinEvent) {
            System.out.println("Calling 911 to cancel previous call.");
        }
    }


    class Safe {
        public ArrayList<Alarm> alarms;
        private String pin;

        Safe(ArrayList<Alarm> alarms, String pin) {
            this.alarms = alarms;
            this.pin = pin;
        }

        Safe(String pin) {
            this.pin = pin;
            this.alarms = new ArrayList<>();
        }

        public void addAlarm(Alarm alarm) {
            this.alarms.add(alarm);
        }

        public void removeAlarm(Alarm alarm) {
            this.alarms.remove(alarm);
        }

        public void enterPin(String pin) {
            if (this.pin.equals(pin)) {
                this.correctPin();
            } else {
                this.wrongPin();
            }
        }
        private void wrongPin() {
            for (Alarm a: alarms) {
                Date date = new Date();
                PinEvent event = new PinEvent(this, date);
                try {
                    a.alarmTurnOn(event);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        private void correctPin() {
            for (Alarm a: alarms) {
                Date date = new Date();
                PinEvent event = new PinEvent(this, date);
                a.alarmTurnOff(event);
            }
        }
    }
}
