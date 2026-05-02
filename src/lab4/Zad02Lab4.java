/*
Zadanie 2
Do implementacji z zadania 1 dodaj opisany system rejestracji zdarzeń wraz z przykładowymi implementacjami klas FileLogger oraz ConsoleLogger.
Autor rozwiązania: Marek Kowalik
*/
package lab4;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import java.io.FileWriter;
import java.io.IOException;

import static java.lang.Thread.sleep;


public class Zad02Lab4 {
    public enum Severity {
        none,
        trace,
        mild,
        severe,
        fatal
    }

    interface Logger {
        public Severity logLevel = null;

        public void LogMessage(
                Severity severity,
                EventSource eventSource,
                String string
        );
    }

    public static class FileLogger implements Logger {
        public Severity logLevel;

        FileLogger() {}

        @Override
        public void LogMessage(Severity severity, EventSource eventSource, String message) {
            Date date = new Date();
            this.logLevel = severity;

            try (FileWriter writer = new FileWriter("logger_output.txt", true)) {
                writer.write(
                        "[%s] Event (Severity - %s) at %s: %s".formatted(date, severity, eventSource.eventDate, message)
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static void main(String[] argv) throws IOException {
            FileLogger logger = new FileLogger();
            PinEvent pinEvent = new PinEvent(null, null);

            logger.LogMessage(Severity.fatal, pinEvent, "This is the message.");
        }
    }

    public static class ConsoleLogger implements Logger {
        public Severity logLevel;

        ConsoleLogger() {}

        @Override
        public void LogMessage(Severity severity, EventSource eventSource, String message) {
            Date date = new Date();
            this.logLevel = severity;
            System.out.printf("[%s] Event (Severe - %s) at %s: %s%n", date, severity, eventSource.eventDate, message);
        }

        public static void main(String[] argv) {
            ConsoleLogger logger = new ConsoleLogger();
            PinEvent pinEvent = new PinEvent(null, null);

            logger.LogMessage(Severity.fatal, pinEvent, "This is the message.");
        }

    }

    abstract static class EventSource {
        public Date eventDate;
    }

    static class PinEvent extends EventSource {
        private final Safe safe;

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
            logger.LogMessage(Severity.fatal, pinEvent, "Rising alarm! WEEE-WOOO, WEEE-WOOO, WEEE-WOOO!");
        }

        @Override
        public void alarmTurnOff(PinEvent pinEvent) {
            logger.LogMessage(Severity.fatal, pinEvent, "Alarm off.");
        }
    }

    class BarsAlarm implements Alarm {
        public Logger logger;

        BarsAlarm(Logger logger) {
            this.logger = logger;
        }

        @Override
        public void alarmTurnOn(PinEvent pinEvent) {
            logger.LogMessage(Severity.fatal, pinEvent, "Dropping bars! ↓↓↓ ↓↓↓ ↓↓↓");
        }

        @Override
        public void alarmTurnOff(PinEvent pinEvent) {
            logger.LogMessage(Severity.fatal, pinEvent, "Alarm off. Rising bars: ↑↑↑ ↑↑↑ ↑↑↑");
        }
    }

    class DogsAlarm implements Alarm {
        public Logger logger;

        DogsAlarm(Logger logger) {
            this.logger = logger;
        }

        @Override
        public void alarmTurnOn(PinEvent pinEvent) {
            logger.LogMessage(Severity.fatal, pinEvent, "Releasing dogs! *woof, woof, woof*");
        }

        @Override
        public void alarmTurnOff(PinEvent pinEvent) {
            logger.LogMessage(Severity.fatal, pinEvent, "Hiding dogs. <aggresively shaking doggy treats> *Come here!*");
        }
    }

    class PoliceAlarm implements Alarm {
        public Logger logger;

        PoliceAlarm(Logger logger) {
            this.logger = logger;
        }

        @Override
        public void alarmTurnOn(PinEvent pinEvent) {
            logger.LogMessage(Severity.fatal, pinEvent, "Calling 911 in 5s.");
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            logger.LogMessage(Severity.fatal, pinEvent, "Calling 911 now.");
        }

        @Override
        public void alarmTurnOff(PinEvent pinEvent) {
            logger.LogMessage(Severity.fatal, pinEvent, "Calling 911 to cancel previous call.");
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
            for (Alarm a : alarms) {
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
            for (Alarm a : alarms) {
                Date date = new Date();
                PinEvent event = new PinEvent(this, date);
                a.alarmTurnOff(event);
            }
        }
    }

    public static void main(String[] args) {

        }
}
