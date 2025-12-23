#include <iostream>
#include <string>
#include <vector>
#include <cmath>
#include <iomanip> // สำหรับ setprecision

using namespace std;

// ========================
// ส่วนที่ 1: Shape Hierarchy
// ========================

class Shape {
protected:
    string name;

public:
    Shape(string n) : name(n) {}
    
    virtual double area() {
        return 0.0;
    }

    virtual void printinfo() {
        cout << "Shape: " << name << " | Area: " << fixed << setprecision(2) << area() << endl;
    }
};

class Circle : public Shape {
protected:
    double radius;

public:
    Circle(string n, double r) : Shape(n), radius(r) {}

    double area() override {
        return M_PI * radius * radius;
    }
};

class Rectangle : public Shape {
protected:
    double width, height;

public:
    Rectangle(string n, double w, double h) : Shape(n), width(w), height(h) {}

    double area() override {
        return width * height;
    }
};

class Cylinder : public Circle {
protected:
    double length;

public:
    Cylinder(string n, double r, double l) : Circle(n, r), length(l) {}

    double volume() {
        return Circle::area() * length;
    }

    void printinfo() override {
        cout << "Cylinder: " << name << " | Volume: " << fixed << setprecision(2) << volume() << endl;
    }
};

class Polygon : public Rectangle {
protected:
    int n;

public:
    Polygon(string name, double w, double h, int n_val) : Rectangle(name, w, h), n(n_val) {}

    double volume() {
        return Rectangle::area() * n;
    }

    void printinfo() override {
        cout << "Polygon: " << name << " | Volume: " << fixed << setprecision(2) << volume() << endl;
    }
};

// ========================
// ส่วนที่ 2: Stack & List
// ========================

class MyStack {
protected:
    vector<string> data; // ใช้ string แทน Object เพื่อความง่ายใน C++

public:
    void push(string obj) {
        data.push_back(obj);
    }

    string pop() {
        if (!empty()) {
            string val = data.back();
            data.pop_back();
            return val;
        }
        return "null";
    }

    string peek() {
        if (!empty()) {
            return data.back();
        }
        return "null";
    }

    int size() {
        return data.size();
    }

    bool empty() {
        return data.empty();
    }
};

class MyList : public MyStack {
public:
    void insert(int index, string obj) {
        if (index >= 0 && index <= size()) {
            data.insert(data.begin() + index, obj);
        }
    }

    void insertFront(string obj) {
        insert(0, obj);
    }

    void insertBack(string obj) {
        push(obj);
    }

    string remove(int index) {
        if (index >= 0 && index < size()) {
            string val = data[index];
            data.erase(data.begin() + index);
            return val;
        }
        return "null";
    }

    string removeBack() {
        return pop();
    }
};

// ========================
// Main Execution
// ========================

int main() {
    cout << "=== 1. Testing Shapes ===" << endl;

    Circle c("MyCircle", 5.0);
    c.printinfo();

    Rectangle r("MyRect", 4.0, 5.0);
    r.printinfo();

    Cylinder cyl("MyCylinder", 5.0, 10.0);
    cyl.printinfo();

    Polygon poly("MyPoly", 4.0, 5.0, 3);
    poly.printinfo();

    cout << "\n=== 2. Testing Stack & List ===" << endl;

    MyList list;
    list.insertBack("Jack");
    list.insertBack("John");
    list.insert(2, "Joe");
    list.insertBack("Jane");
    list.push("Jim");

    cout << "Size: " << list.size() << endl;
    cout << "Peek (Top): " << list.peek() << endl;

    cout << "Pop: " << list.pop() << endl;
    cout << "Peek after pop: " << list.peek() << endl;

    return 0;
}