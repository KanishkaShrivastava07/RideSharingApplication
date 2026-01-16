import java.util.LinkedList;
import java.util.Queue;

public class DriverPool{

    private Queue<Driver> availableDrivers = new LinkedList<>();

    public DriverPool(int totalDrivers){

        for(int i = 0; i < totalDrivers; i++){
            availableDrivers.add(new Driver(i));
        }
    }

    public synchronized Driver assignDriver(String passengerName){

        while(availableDrivers.isEmpty()){
            try {
                System.out.println(passengerName + " is waiting for a driver");

                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        Driver driver = availableDrivers.poll();

        System.out.println("Driver " + driver.getDriverId() + " assigned to " + passengerName);

        return driver;
    }

    public synchronized void releaseDriver(Driver driver){

        availableDrivers.add(driver);

        System.out.println("Driver " + driver.getDriverId() + " is now available");

        notify();
    }
}
