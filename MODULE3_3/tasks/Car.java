//// Car.java
//public class Car implements Vehicle {
//    @Override
//    public void start() {
//        System.out.println("Car is starting...");
//    }
//
//    @Override
//    public void stop() {
//        System.out.println("Car is stopping...");
//    }
//
//    @Override
//    public String getInfo() {
//        return "Car Information:\nType: Car\nFuel: Petrol\nColor: Red";
//    }
//}


public class Car extends AbstractVehicle {
    public Car() {
        super("Car", "Petrol", "Red");
        this.fuelEfficiency = 25.0;
    }

    @Override
    public String getInfo() {
        return "Car Information:\nType: " + type + "\nFuel: " + fuel + "\nColor: " + color;
    }
}

