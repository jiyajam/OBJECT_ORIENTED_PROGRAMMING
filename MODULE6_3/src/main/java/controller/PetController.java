package controller;

import model.Pet;
import view.PetView;

public class PetController {
    private Pet pet;
    private PetView view;
    private double targetX;
    private double targetY;
    private boolean isMoving;

    public PetController(PetView view) {
        this.view = view;
        this.pet = new Pet(200, 150);
        this.isMoving = false;
    }

    public void handleMouseMove(double mouseX, double mouseY) {
        this.targetX = mouseX;
        this.targetY = mouseY;
        this.isMoving = true;
    }

    public void handleMouseExit() {
        this.isMoving = false;
    }

    public void updatePet() {
        if (isMoving) {
            if (!pet.hasReached(targetX, targetY)) {
                pet.moveTowards(targetX, targetY);
                view.updateCanvas();
            } else {
                isMoving = false;
            }
        }
    }

    public Pet getPet() {
        return pet;
    }
}

