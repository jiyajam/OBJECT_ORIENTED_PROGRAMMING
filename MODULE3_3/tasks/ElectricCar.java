// ElectricCar.java
// ElectricCar.java (Updated)
public class ElectricCar extends AbstractVehicle implements ElectricVehicle {
    public ElectricCar() {
        super("Electric Car", "Electricity", "White");
        this.fuelEfficiency = 5.5;
    }

    @Override
    public void charge() {
        System.out.println("Electric Car is charging...");
    }

    @Override
    public String getInfo() {
        return "Electric Car Information:\nType: " + type + "\nFuel: " + fuel + "\nColor: " + color;
    }
}
