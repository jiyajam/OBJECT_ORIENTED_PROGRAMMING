public class Bus extends Car {

    private int passengers;

    public Bus(String typeName, double speed, double gasolineLevel) {
        super(typeName, speed, gasolineLevel);
        this.passengers = 0;
    }

    public void passengerEnter() {
        passengers++;
    }

    public void passengerExit() {
        if (passengers > 0) {
            passengers--;
        }
    }

    public int getPassengerCount() {
        return passengers;
    }
}
