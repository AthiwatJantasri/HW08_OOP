#include <iostream>
#include <string>
#include <cmath>
#include <cstdio> // สำหรับ printf

using namespace std;

// ================= Shape =================
class Shape {
protected:
    string name;

public:
    Shape(string n) : name(n) {}

    // Getter / Setter
    string getName() { return name; }
    void setName(string n) { name = n; }

    virtual double area() {
        return 0.0;
    }

    virtual void printinfo() {
        printf("Shape: %s | Area: %.2f\n", name.c_str(), area());
    }
};

// ================= Circle =================
class Circle : public Shape {
protected:
    double radius;

public:
    Circle(string n, double r) : Shape(n), radius(r) {}

    // Getter / Setter
    double getRadius() { return radius; }
    void setRadius(double r) { radius = r; }

    double area() override {
        return M_PI * radius * radius;
    }
};

// ================= Rectangle =================
class Rectangle : public Shape {
protected:
    double width, height;

public:
    Rectangle(string n, double w, double h) : Shape(n), width(w), height(h) {}

    // Getter / Setter
    double getWidth() { return width; }
    void setWidth(double w) { width = w; }
    double getHeight() { return height; }
    void setHeight(double h) { height = h; }

    double area() override {
        return width * height;
    }
};

// ================= Cylinder =================
class Cylinder : public Circle {
protected:
    double length;

public:
    Cylinder(string n, double r, double l) : Circle(n, r), length(l) {}

    // Getter / Setter
    double getLength() { return length; }
    void setLength(double l) { length = l; }

    double volume() {
        return Circle::area() * length;
    }

    void printinfo() override {
        printf("Cylinder: %s | Volume: %.2f\n", name.c_str(), volume());
    }
};

// ================= Polygon =================
class Polygon : public Rectangle {
protected:
    int n;

public:
    Polygon(string name, double w, double h, int n_val) : Rectangle(name, w, h), n(n_val) {}

    // Getter / Setter
    int getN() { return n; }
    void setN(int n_val) { n = n_val; }

    double volume() {
        return Rectangle::area() * n;
    }

    void printinfo() override {
        printf("Polygon: %s | Volume: %.2f\n", name.c_str(), volume());
    }
};

// ================= Main =================
int main() {
    Circle c("MyCircle", 5.0);
    c.printinfo();

    Rectangle r("MyRect", 4.0, 5.0);
    r.printinfo();

    Cylinder cyl("MyCylinder", 5.0, 10.0);
    cyl.printinfo();

    Polygon poly("MyPoly", 4.0, 5.0, 3);
    poly.printinfo();

    return 0;
}
