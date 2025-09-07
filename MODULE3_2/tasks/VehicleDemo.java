public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration\n");

        Vehicle car = new Car();
        car.start();
        car.stop();
        System.out.println(car.getInfo());
        System.out.println("Efficiency: " + car.calculateFuelEfficiency() + "\n");

        Vehicle motorcycle = new Motorcycle();
        motorcycle.start();
        motorcycle.stop();
        System.out.println(motorcycle.getInfo());
        System.out.println("Efficiency: " + motorcycle.calculateFuelEfficiency() + "\n");

        Vehicle bus = new Bus();
        bus.start();
        bus.stop();
        System.out.println(bus.getInfo());
        System.out.println("Efficiency: " + bus.calculateFuelEfficiency() + "\n");

        ElectricVehicle eCar = new ElectricCar();
        eCar.charge();
        System.out.println(((Vehicle) eCar).getInfo());
        System.out.println("Efficiency: " + ((Vehicle) eCar).calculateFuelEfficiency() + "\n");

        ElectricVehicle eMoto = new ElectricMotorcycle();
        eMoto.charge();
        System.out.println(((Vehicle) eMoto).getInfo());
        System.out.println("Efficiency: " + ((Vehicle) eMoto).calculateFuelEfficiency() + "\n");
    }
}
