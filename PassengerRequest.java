public class PassengerRequest implements Runnable{

    private String passengerName;
    private DriverPool driverPool;

    public PassengerRequest(String passengerName, DriverPool driverPool){
        this.passengerName = passengerName;
        this.driverPool = driverPool;
    }

    @Override
    public void run(){
        Driver driver = driverPool.assignDriver(passengerName);

        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        driverPool.releaseDriver(driver);

    }
}
