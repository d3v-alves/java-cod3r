package observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Doorman extends Thread {

    private List<ArrivalBirthdayObserver> observers = new ArrayList<ArrivalBirthdayObserver>();

    public void addArrivalBirthdayObserver(ArrivalBirthdayObserver observer){
        this.observers.add(observer);
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            int value = scanner.nextInt();

            if(value == 1) {
                ArrivalBirthdayEvent event = new ArrivalBirthdayEvent(new Date());

                for(ArrivalBirthdayObserver observer: this.observers){
                    observer.arrival(event);
                }
            } else {
                System.out.println("false alarm");
            }
        }

    }
}
