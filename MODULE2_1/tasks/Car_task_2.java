public class Car_task_2 {

    private double speed;
    private double gasolineLevel;
    private String typeName;


    private double cruiseSpeed;
    private boolean cruiseOn;


    private final double MIN_CRUISE_SPEED = 10;
    private final double MAX_CRUISE_SPEED = 80;

    public Car_task_2(String typeName, double speed, double gasolineLevel) {
        this.typeName = typeName;
        this.speed = speed;
        this.gasolineLevel = gasolineLevel;
        this.cruiseOn = false;
        this.cruiseSpeed = 0;
    }

    public void accelerate() {
        if (gasolineLevel > 0) {
            speed += 10;
        } else {
            speed = 0;
        }
    }

    public void decelerate(int amount) {
        if (gasolineLevel > 0 && amount > 0) {
            speed -= amount;
            if (speed < 0) speed = 0;
        } else {
            speed = 0;
        }
    }

    public double getSpeed() {
        return speed;
    }

    public String getTypeName() {
        return typeName;
    }

    public void fillTank() {
        gasolineLevel = 100;
    }

    public double getGasolineLevel() {
        return gasolineLevel;
    }



    public void setCruiseSpeed(double speed) {
        this.cruiseSpeed = speed;
    }

    public double getCruiseSpeed() {
        return cruiseSpeed;
    }

    public boolean turnCruiseOn() {
        if (cruiseSpeed >= MIN_CRUISE_SPEED && cruiseSpeed <= MAX_CRUISE_SPEED) {
            cruiseOn = true;
            return true;
        } else {
            cruiseOn = false;
            return false;
        }
    }

    public void turnCruiseOff() {
        cruiseOn = false;
    }

    public void updateCruise() {
        if (!cruiseOn) return;

        if (speed < cruiseSpeed) {
            accelerate();
        } else if (speed > cruiseSpeed) {
            decelerate(10);
        }


        if (speed < MIN_CRUISE_SPEED || speed > MAX_CRUISE_SPEED) {
            cruiseOn = false;
        }
    }
}


