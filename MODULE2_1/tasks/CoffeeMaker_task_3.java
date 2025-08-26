public class CoffeeMaker_task_3 {
    boolean isOn = false;
    String coffeeType = "normal";
    int coffeeAmount = 10;

    void switchOn() {
        isOn = true;
    }
    void switchOff() {
    isOn = false;
    }

    void setCoffeeType(String type) {
        if (isOn) {
            coffeeType = type;
        }
    }

    void setCoffeeAmount(int amount) {
        if (isOn) {
            coffeeAmount = amount;
        }
    }
}


