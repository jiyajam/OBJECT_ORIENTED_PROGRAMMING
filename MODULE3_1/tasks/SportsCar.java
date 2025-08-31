public class SportsCar extends Car {

    public SportsCar(String typeName, double speed, double gasolineLevel) {
        super(typeName, speed, gasolineLevel);
    }

    @Override
    public void accelerate() {
        if (getGasolineLevel() >= 2) {

            super.decelerate(-20);  // decelerating  w negative number = accelerate by 20
            reduceFuel(2);
        }
    }

    @Override
    public void decelerate(int amount) {
        if (amount > 0) {
            super.decelerate(amount * 2);
        }
    }

}
