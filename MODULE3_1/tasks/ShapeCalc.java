public class ShapeCalc {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(3.0, "Red"),
            new Rectangle(9.0, 6.0, "Blue"),
            new Triangle(6.0, 8.0, "Green")
        };

        System.out.println("Shape Calculator\n");

        for (Shape shape : shapes) {
            System.out.println(shape);
            System.out.println("Area: " + shape.calculateArea());
            System.out.println();
        }
    }
}

