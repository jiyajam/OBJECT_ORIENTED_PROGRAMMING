//// Motorcycle.java
//public class Motorcycle implements Vehicle {
//    @Override
//    public void start() {
//        System.out.println("Motorcycle is starting...");
//    }
//
//    @Override
//    public void stop() {
//        System.out.println("Motorcycle is stopping...");
//    }
//
//    @Override
//    public String getInfo() {
//        return "Motorcycle Information:\nType: Motorcycle\nFuel: Gasoline\nColor: Black";
//    }
//}

public class Motorcycle extends AbstractVehicle {
    public Motorcycle() {
        super("Motorcycle", "Gasoline", "Black");
        this.fuelEfficiency = 55.0;
    }

    @Override
    public String getInfo() {
        return "Motorcycle Information:\nType: " + type + "\nFuel: " + fuel + "\nColor: " + color;
    }
}
