package view;

import controller.PetController;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PetView extends Application {

    private Canvas canvas;
    private GraphicsContext gc;
    private PetController controller;
    private Image catImage;
    private Image backgroundImage;
    private AnimationTimer timer;

    public void start(Stage stage) {

        canvas = new Canvas(400, 300);
        gc = canvas.getGraphicsContext2D();


        catImage = new Image("sheep.png");
        backgroundImage=new Image("background.png");

        canvas.setOnMouseMoved(event -> {
            controller.handleMouseMove(event.getX(), event.getY());
        });

        canvas.setOnMouseExited(event -> {
            controller.handleMouseExit();
        });

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, 400, 300);

        stage.setTitle("My Virtual Pet");
        stage.setScene(scene);
        stage.show();

        updateCanvas();

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                controller.updatePet();
            }
        };
        timer.start();
    }

    public void init() {
        controller = new PetController(this);
    }

    public void updateCanvas() {
        gc.drawImage(backgroundImage,0,0,400,300);



        double x = controller.getPet().getX();
        double y = controller.getPet().getY();

        gc.drawImage(catImage, x - 15, y - 15, 60, 60);
    }

    @Override
    public void stop() {
        if (timer != null) {
            timer.stop();
        }
    }
}
