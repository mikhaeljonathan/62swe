public class Rectangle extends Polygon {

    private double length;
    private double sides;

    Rectangle(double centerX, double centerY, double length, double sides) {
        super(centerX, centerY, 4);
        this.length = length;
        this.sides = sides;
    }

    public double getArea() {
        return this.length * this.sides;
    }

}
