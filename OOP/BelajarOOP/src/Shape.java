public class Shape {
    protected double centerX;
    protected double centerY;

    Shape(double centerX, double centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
    }

    protected void render() {
        System.out.println("Rendering...");
    }

    @Override
    public String toString() {
        return "This is a shape with center x = " + this.centerX + " and center y = " + this.centerY;
    }
}
