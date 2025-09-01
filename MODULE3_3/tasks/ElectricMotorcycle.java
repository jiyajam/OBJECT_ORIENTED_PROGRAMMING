// ElectricMotorcycle.java
public class ElectricMotorcycle extends AbstractVehicle implements ElectricVehicle {
    public ElectricMotorcycle() {
        super("Electric Motorcycle", "Electricity", "Green");
        this.fuelEfficiency = 3.2;
    }

    @Override
    public void charge() {
        System.out.println("Electric Motorcycle is charging...");
    }

    @Override
    public String getInfo() {
        return "Electric Motorcycle Information:\nType: " + type + "\nFuel: " + fuel + "\nColor: " + color;
    }
}

