public class Cat_task_4 {
    private String name;

    public Cat_task_4(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println("The cat named " + name + " says: Meow!");
    }

    public static void main(String[] args) {
        // Create an instance of the Cat class with a name
        Cat_task_4 cat1 = new Cat_task_4("Whiskers");
        Cat_task_4 cat2 = new Cat_task_4("Rex");



        // Call the meow method on the cat instance
        cat1.meow();
        cat1.meow();
        cat2.meow();
        cat1.meow();
    }

}
