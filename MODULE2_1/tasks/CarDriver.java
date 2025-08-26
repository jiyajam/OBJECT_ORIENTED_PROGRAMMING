public class CarDriver {
    public static void main(String[] args) {
        Car_task_2 myCar = new Car_task_2("Porche Cayan", 0.0, 0.0);
        myCar.fillTank();


        for (int i = 0; i < 3; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        myCar.setCruiseSpeed(60);

  boolean cruiseStarted = myCar.turnCruiseOn();

        if (cruiseStarted) {
            System.out.println("Cruise control is ON");
            System.out.println("Target speed: " + myCar.getCruiseSpeed() + " km/h");


            while (myCar.getSpeed() != myCar.getCruiseSpeed()) {
                myCar.updateCruise();
                System.out.println("Adjusting speed: " + myCar.getSpeed() + " km/h");
            }

            System.out.println("Target speed reached.");
            myCar.turnCruiseOff();
            System.out.println("Cruise control is OFF");
        } else {
            System.out.println("Cruise control could not be turned on");
        }
    }
}
//I modified the CarDriver first to see how the cruise control will work.
//It helps to build structure and test the code before adding it to Car_task_2.
