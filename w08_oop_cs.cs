using System;

class Shape {
    protected string name;

    public Shape(string name) {
        this.name = name;
    }

    // Getter / Setter (C# Style Properties)
    public string Name {
        get { return name; }
        set { name = value; }
    }

    public virtual double Area() {
        return 0.0;
    }

    public virtual void PrintInfo() {
        // ใช้ {0:F2} เพื่อกำหนดทศนิยม 2 ตำแหน่ง
        Console.WriteLine("Shape: {0} | Area: {1:F2}", name, Area());
    }
}

class Circle : Shape {
    protected double radius;

    public Circle(string name, double radius) : base(name) {
        this.radius = radius;
    }

    public double Radius {
        get { return radius; }
        set { radius = value; }
    }

    public override double Area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle : Shape {
    protected double width, height;

    public Rectangle(string name, double width, double height) : base(name) {
        this.width = width;
        this.height = height;
    }

    public double Width { get { return width; } set { width = value; } }
    public double Height { get { return height; } set { height = value; } }

    public override double Area() {
        return width * height;
    }
}

class Cylinder : Circle {
    protected double length;

    public Cylinder(string name, double radius, double length) : base(name, radius) {
        this.length = length;
    }

    public double Length { get { return length; } set { length = value; } }

    public double Volume() {
        return base.Area() * length;
    }

    public override void PrintInfo() {
        Console.WriteLine("Cylinder: {0} | Volume: {1:F2}", name, Volume());
    }
}

class Polygon : Rectangle {
    protected int n;

    public Polygon(string name, double width, double height, int n) : base(name, width, height) {
        this.n = n;
    }

    public int N { get { return n; } set { n = value; } }

    public double Volume() {
        return base.Area() * n;
    }

    public override void PrintInfo() {
        Console.WriteLine("Polygon: {0} | Volume: {1:F2}", name, Volume());
    }
}

class Program {
    static void Main(string[] args) {
        Circle c = new Circle("MyCircle", 5.0);
        c.PrintInfo();

        Rectangle r = new Rectangle("MyRect", 4.0, 5.0);
        r.PrintInfo();

        Cylinder cyl = new Cylinder("MyCylinder", 5.0, 10.0);
        cyl.PrintInfo();

        Polygon poly = new Polygon("MyPoly", 4.0, 5.0, 3);
        poly.PrintInfo();
    }
}
