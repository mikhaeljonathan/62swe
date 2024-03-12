public class Square extends Shape{
    private double length;

    Square(double centerX, double centerY, double length) {
        super(centerX, centerY);
        this.length = length;
    }

    public double getArea() {
        return length * length;
    }
}
