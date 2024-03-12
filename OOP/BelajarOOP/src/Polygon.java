public class Polygon extends Shape {
    private int numOfSides;

    Polygon(double centerX, double centerY, int numOfSides) {
        super(centerX, centerY);
        this.numOfSides = numOfSides;
    }
}
