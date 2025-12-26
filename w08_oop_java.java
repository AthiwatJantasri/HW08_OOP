class Shape {
    protected String name;

    // 1.1 Constructor
    public Shape(String name) {
        this.name = name;
    }

    // 1.1 Getter / Setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // 1.2 & 1.3 Methods
    public double area() {
        return 0.0;
    }

    public void printinfo() {
        System.out.printf("Shape: %s | Area: %.2f%n", name, area());
    }
}

class Circle extends Shape {
    protected double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    // Getter / Setter
    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    protected double width, height;

    public Rectangle(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    // Getter / Setter
    public double getWidth() { return width; }
    public void setWidth(double width) { this.width = width; }
    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    @Override
    public double area() {
        return width * height;
    }
}

class Cylinder extends Circle {
    protected double length;

    public Cylinder(String name, double radius, double length) {
        super(name, radius);
        this.length = length;
    }

    // Getter / Setter
    public double getLength() { return length; }
    public void setLength(double length) { this.length = length; }

    public double volume() {
        return super.area() * length;
    }

    @Override
    public void printinfo() {
        System.out.printf("Cylinder: %s | Volume: %.2f%n", name, volume());
    }
}

class Polygon extends Rectangle {
    protected int n;

    public Polygon(String name, double width, double height, int n) {
        super(name, width, height);
        this.n = n;
    }

    // Getter / Setter
    public int getN() { return n; }
    public void setN(int n) { this.n = n; }

    public double volume() {
        return super.area() * n;
    }

    @Override
    public void printinfo() {
        System.out.printf("Polygon: %s | Volume: %.2f%n", name, volume());
    }
}

// Main Class สำหรับรัน
public class Main {
    public static void main(String[] args) {
        Circle c = new Circle("MyCircle", 5.0);
        c.printinfo();

        Rectangle r = new Rectangle("MyRect", 4.0, 5.0);
        r.printinfo();

        Cylinder cyl = new Cylinder("MyCylinder", 5.0, 10.0);
        cyl.printinfo();

        Polygon poly = new Polygon("MyPoly", 4.0, 5.0, 3);
        poly.printinfo();
    }
}
