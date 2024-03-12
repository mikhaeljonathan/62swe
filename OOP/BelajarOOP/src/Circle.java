public class Circle extends Shape{
    private double radius;

    Circle(double centerX, double centerY, double radius) {
        super(centerX, centerY);
        this.radius = radius;
    }
    public double getDiameter() {
        return 2 * this.radius;
    }

    @Override
    public void render() {
        System.out.println("Rendering circle...");
    }

    @Override
    public String toString() {
        return "This is a circle with center x = " + this.centerX + " and center y = " + this.centerY +
                " and radius = " + this.radius;
    }
}
