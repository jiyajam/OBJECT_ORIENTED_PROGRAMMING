public class CoffeeMakerDriver_task_3 {
    public static void main(String[] args) {
        CoffeeMaker_task_3 cm = new CoffeeMaker_task_3();

        cm.switchOn();
        System.out.println("Coffee maker is on");

        cm.setCoffeeType("espresso");
        cm.setCoffeeAmount(50);

        System.out.println("Coffee type is " + cm.coffeeType);
        System.out.println("Coffee amount is " + cm.coffeeAmount + " ml");

        cm.switchOff();
        System.out.println("Coffee maker is off");
    }
}

