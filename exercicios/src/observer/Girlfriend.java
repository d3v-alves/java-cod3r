package observer;

public class Girlfriend implements ArrivalBirthdayObserver {

    @Override
    public void arrival(ArrivalBirthdayEvent event) {
        System.out.println("turn off the lights");
        System.out.println("to be silent");
        System.out.println("surprise");

    }
}
