public class RideSharingApplication{

    public static void main(String[] args){

        System.out.println("Ride sharing system started......");

        DriverPool driverPool = new DriverPool(3);

        for(int i = 0; i <= 8; i++){

            PassengerRequest request = new PassengerRequest("Passenger-  " + i , driverPool);

            Thread passangerThread = new Thread(request);

            passangerThread.start();
        }
    }
}
