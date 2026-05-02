/*
Zadanie 3
Przeprowadź testy poprawności działania sejfu uwzględniając różne konfiguracje alarmów i urządzeń rejestrujących.
Autor rozwiązania: Marek Kowalik
*/
package lab4;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.Thread.sleep;


public class Zad03Lab4 {
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
                        "[%s] Event (Severity - %s) at [%s]: %s%n".formatted(date, severity, eventSource.eventDate, message)
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static void main(String[] argv) throws IOException {
            FileLogger logger = new FileLogger();
            PinEvent pinEvent = new PinEvent(null, null);

            logger.LogMessage(Severity.mild, pinEvent, "This is the message.");
        }
    }

    public static class ConsoleLogger implements Logger {
        public Severity logLevel;

        ConsoleLogger() {}

        @Override
        public void LogMessage(Severity severity, EventSource eventSource, String message) {
            Date date = new Date();
            this.logLevel = severity;
            System.out.printf("[%s] Event (Severe - %s) at [%s]: %s%n", date, severity, eventSource.eventDate, message);
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
        private boolean onFlag = false;

        SoundAlarm(Logger logger) {
            this.logger = logger;
        }

        @Override
        public void alarmTurnOn(PinEvent pinEvent) {
            this.onFlag = true;
            logger.LogMessage(Severity.mild, pinEvent, "[Sound alarm] Rising alarm! WEEE-WOOO, WEEE-WOOO, WEEE-WOOO!");
        }

        @Override
        public void alarmTurnOff(PinEvent pinEvent) {
            if (this.onFlag) {
                logger.LogMessage(Severity.none, pinEvent, "[Sound alarm] Alarm off.");
                this.onFlag = false;
            }
            logger.LogMessage(Severity.none, pinEvent, "[Sound alarm] Alarm off confirmed.");
        }
    }

    class BarsAlarm implements Alarm {
        public Logger logger;
        private boolean onFlag = false;

        BarsAlarm(Logger logger) {
            this.logger = logger;
        }

        @Override
        public void alarmTurnOn(PinEvent pinEvent) {
            this.onFlag = true;
            logger.LogMessage(Severity.trace, pinEvent, "[Bars alarm] Dropping bars! ↓↓↓ ↓↓↓ ↓↓↓");
        }

        @Override
        public void alarmTurnOff(PinEvent pinEvent) {
            if (this.onFlag) {
                logger.LogMessage(Severity.none, pinEvent, "[Bars alarm] Rising bars: ↑↑↑ ↑↑↑ ↑↑↑");
                this.onFlag = false;
            }
            logger.LogMessage(Severity.none, pinEvent, "[Bars alarm] Alarm off confirmed.");
        }
    }

    class DogsAlarm implements Alarm {
        public Logger logger;
        private boolean onFlag = false;

        DogsAlarm(Logger logger) {
            this.logger = logger;
        }

        @Override
        public void alarmTurnOn(PinEvent pinEvent) {
            this.onFlag = true;
            logger.LogMessage(Severity.fatal, pinEvent, "[Dogs alarm] Releasing dogs! *woof, woof, woof*");
        }

        @Override
        public void alarmTurnOff(PinEvent pinEvent) {
            if (this.onFlag) {
                logger.LogMessage(Severity.none, pinEvent, "[Dogs alarm] Hiding dogs. <aggresively shaking doggy treats> *Come here!*");
                this.onFlag = false;
            }
            logger.LogMessage(Severity.none, pinEvent, "[Dogs alarm] Alarm off confirmed.");
        }
    }

    class PoliceAlarm implements Alarm {
        public Logger logger;
        private boolean calledFlag = false;
        private boolean policeArrivedFlag = false;


        PoliceAlarm(Logger logger) {
            this.logger = logger;
        }

        @Override
        public void alarmTurnOn(PinEvent pinEvent) {
            logger.LogMessage(Severity.severe, pinEvent, "[Police alarm] Calling 911 in 3s.");
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            logger.LogMessage(Severity.severe, pinEvent, "[Police alarm] Calling 911 now.");
            this.calledFlag = true;
        }

        @Override
        public void alarmTurnOff(PinEvent pinEvent) {
            if (this.calledFlag) {
                if (this.policeArrivedFlag) {
                    this.policeArrivedFlag = false;
                    logger.LogMessage(Severity.none, pinEvent, "[Police alarm] Alarm off.");
                } else {
                    logger.LogMessage(Severity.none, pinEvent, "[Police alarm] Calling 911 to cancel previous call.");
                }
                this.calledFlag = false;
            }
            logger.LogMessage(Severity.none, pinEvent, "[Police alarm] Alarm off confirmed.");
        }

        public void notePoliceArrival() {
            this.policeArrivedFlag = true;
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

    public void main(String[] args) throws IOException {
        // --------------------------------------------------------------------------------
        System.out.println("============================");
        System.out.println("Test 1: file logger test");
        System.out.println("============================");

        System.out.println("1/4 Creating the setup.");
        Safe s1 = new Safe("4321");

        // Clearing log file
        try (FileWriter writer = new FileWriter("logger_output.txt", false)) {}

        FileLogger fl1 = new FileLogger();

        // create alarms
        SoundAlarm a1 = new SoundAlarm(fl1);
        BarsAlarm a2 = new BarsAlarm(fl1);
        DogsAlarm a3 = new DogsAlarm(fl1);
        PoliceAlarm a4 = new PoliceAlarm(fl1);
        BarsAlarm a5 = new BarsAlarm(fl1);

        s1.addAlarm(a1);
        s1.addAlarm(a2);
        s1.addAlarm(a3);
        s1.addAlarm(a4);
        s1.addAlarm(a5);

        s1.removeAlarm(a2);

        System.out.println("2/4 Correct pin input.");
        s1.enterPin("4321");
        System.out.println("Content of the log file:");
        System.out.println("------------------------------------------------------------");
        String file_content = Files.readString(Path.of("logger_output.txt"));
        System.out.print(file_content);
        System.out.println("------------------------------------------------------------");

        System.out.println("3/4 Incorrect pin input.");
        s1.enterPin("1234");
        System.out.println("Content of the log file:");
        System.out.println("------------------------------------------------------------");
        file_content = Files.readString(Path.of("logger_output.txt"));
        System.out.print(file_content);
        System.out.println("------------------------------------------------------------");

        System.out.println("4/4 Correct pin input.");
        s1.enterPin("4321");
        System.out.println("Content of the log file:");
        System.out.println("------------------------------------------------------------");
        file_content = Files.readString(Path.of("logger_output.txt"));
        System.out.print(file_content);
        System.out.println("------------------------------------------------------------");

        // --------------------------------------------------------------------------------
        System.out.println("============================");
        System.out.println("Test 2: console logger test");
        System.out.println("============================");

        System.out.println("1/4 Creating the setup.");
        ConsoleLogger cl1 = new ConsoleLogger();

        SoundAlarm a6 = new SoundAlarm(cl1);
        BarsAlarm a7 = new BarsAlarm(cl1);
        DogsAlarm a8 = new DogsAlarm(cl1);
        PoliceAlarm a9 = new PoliceAlarm(cl1);

        ArrayList<Alarm> a_list = new ArrayList<Alarm>();
        a_list.add(a6);
        a_list.add(a7);
        a_list.add(a8);
        a_list.add(a9);

        a_list.add(a7);

        Safe s2 = new Safe(a_list, "4321");

        System.out.println("2/4 Correct pin input.");
        s2.enterPin("4321");

        System.out.println("3/4 Incorrect pin input.");
        s2.enterPin("1234");

        a9.notePoliceArrival();

        System.out.println("4/4 Correct pin input.");
        s2.enterPin("4321");
        }
}
