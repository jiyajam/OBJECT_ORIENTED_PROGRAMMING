// Bus.java
//public class Bus implements Vehicle {
//    @Override
//    public void start() {
//        System.out.println("Bus is starting...");
//    }
//
//    @Override
//    public void stop() {
//        System.out.println("Bus is stopping...");
//    }
//
//    @Override
//    public String getInfo() {
//        return "Bus Information:\nType: Bus\nFuel: Diesel\nCapacity: 40 passengers";
//    }
//}
// Bus.java (Updated)
public class Bus extends AbstractVehicle {
    public Bus() {
        super("Bus", "Diesel", "Blue");
        this.fuelEfficiency = 8.0;
    }

    @Override
    public String getInfo() {
        return "Bus Information:\nType: " + type + "\nFuel: " + fuel + "\nCapacity: 40 passengers";
    }
}
