package ped1;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ArgumentsReader arguments = new ArgumentsReader(args);
        Scheduler scheduler = new Scheduler(arguments);
        scheduler.printSchedule(arguments.withTrace());
    }

}
