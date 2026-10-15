package observer;

public class SurpriseBirthdayParty {

    public static void main(String[] args) {
        Girlfriend girlfriend = new Girlfriend();
        Doorman doorman =   new Doorman();

        doorman.addArrivalBirthdayObserver(girlfriend);

        doorman.start();
    }
}
