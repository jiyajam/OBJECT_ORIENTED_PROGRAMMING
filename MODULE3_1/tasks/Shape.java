public abstract class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    public abstract double calculateArea();

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Color: " + color;
    }
}
