public abstract class AbstractVehicle implements Vehicle {
    protected String type;
    protected String fuel;
    protected String color;
    protected double fuelEfficiency;

    public AbstractVehicle(String type, String fuel, String color) {
        this.type = type;
        this.fuel = fuel;
        this.color = color;
    }

    @Override
    public void start() {
        System.out.println(type + " is starting...");
    }

    @Override
    public void stop() {
        System.out.println(type + " is stopping...");
    }

    @Override
    public double calculateFuelEfficiency() {
        return fuelEfficiency;
    }
}
