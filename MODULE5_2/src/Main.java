import java.util.Random;

class Theater {
    private int availableSeats;

    public Theater(int totalSeats) {
        this.availableSeats = totalSeats;
    }

    public synchronized boolean reserveSeats(int customerId, int requestedSeats) {
        if (availableSeats >= requestedSeats) {
            availableSeats -= requestedSeats;
            System.out.println("Customer " + customerId + " reserved " + requestedSeats + " tickets.");
            return true;
        } else {
            System.out.println("Customer " + customerId + " couldn't reserve " + requestedSeats + " tickets.");
            return false;
        }
    }

    public synchronized int getAvailableSeats() {
        return availableSeats;
    }
}

class Customer implements Runnable {
    private Theater theater;
    private int customerId;
    private int requestedSeats;

    public Customer(Theater theater, int customerId, int requestedSeats) {
        this.theater = theater;
        this.customerId = customerId;
        this.requestedSeats = requestedSeats;
    }

    public void run() {
        theater.reserveSeats(customerId, requestedSeats);
    }
}

public class Main {
    public static void main(String[] args) {
        Theater theater = new Theater(10); // Theater with 10 seats
        Random random = new Random();

        // 15 customers with random seat requests
        Thread[] customers = new Thread[15];
        for (int i = 0; i < 15; i++) {
            int requestedSeats = random.nextInt(4) + 1; // 1-4 seats
            customers[i] = new Thread(new Customer(theater, i + 1, requestedSeats));
        }

        // Start threads
        for (Thread customer : customers) {
            customer.start();
        }


        try {
            for (Thread customer : customers) {
                customer.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Remaining seats: " + theater.getAvailableSeats());
    }
}
