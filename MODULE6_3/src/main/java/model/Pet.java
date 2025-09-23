package model;

public class Pet {
    private double x;
    private double y;
    private static final double SPEED = 1.5;

    public Pet(double startX, double startY) {
        this.x = startX;
        this.y = startY;
    }

    public void moveTowards(double targetX, double targetY) {
        // Calculate direction using trigonometry
        double deltaX = targetX - x;
        double deltaY = targetY - y;
        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        if (distance > SPEED) {
            // Normalize the direction and multiply by speed
            x += (deltaX / distance) * SPEED;
            y += (deltaY / distance) * SPEED;
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean hasReached(double targetX, double targetY) {
        double deltaX = targetX - x;
        double deltaY = targetY - y;
        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        return distance < 5;
    }
}
