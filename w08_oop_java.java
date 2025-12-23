import java.util.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
      System.out.println("=== 1. Testing Shapes ===");
        
        // 1.1 สร้าง Circle
        Circle c = new Circle("MyCircle", 5.0);
        c.printinfo();

        // 1.2 สร้าง Rectangle
        Rectangle r = new Rectangle("MyRect", 4.0, 5.0);
        r.printinfo();

        // 1.3 สร้าง Cylinder (มี volume)
        Cylinder cyl = new Cylinder("MyCylinder", 5.0, 10.0);
        cyl.printinfo();

        // 1.4 สร้าง Polygon (มี volume)
        Polygon poly = new Polygon("MyPoly", 4.0, 5.0, 3);
        poly.printinfo();

        System.out.println("\n=== 2. Testing Stack & List ===");
        
        // 2.1 Testing List (ซึ่งทำงานเป็น Stack ได้ด้วย)
        MyList list = new MyList();
        
        // จำลองข้อมูลตามโจทย์ Jack, John, Joe, Jane, Jim
        list.insertBack("Jack");
        list.insertBack("John");
        list.insert(2, "Joe"); // แทรก Joe ตรงกลาง
        list.insertBack("Jane");
        list.push("Jim");      // ใช้คำสั่ง push แบบ Stack

        System.out.println("Size: " + list.size()); // ควรได้ 5
        System.out.println("Peek (Top): " + list.peek()); // ควรได้ Jim
        
        System.out.println("Pop: " + list.pop()); // เอา Jim ออก
        System.out.println("Peek after pop: " + list.peek()); // ควรเหลือ Jane
  }
}

// ========================
// ส่วนที่ 1: Shape Hierarchy
// ========================

// 1. Class แม่: Shape
class Shape {
    protected String name; // #name: string

    public Shape(String name) {
        this.name = name;
    }

    public double area() {
        return 0.0; // ค่าเริ่มต้น
    }

    public void printinfo() {
        System.out.println("Shape: " + name + " | Area: " + String.format("%.2f", area()));
    }
}

// 2. Class Circle (สืบทอดจาก Shape)
class Circle extends Shape {
    protected double radius; // #radius: double

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

// 3. Class Rectangle (สืบทอดจาก Shape)
class Rectangle extends Shape {
    protected double width;
    protected double height;

    public Rectangle(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

// 4. Class Cylinder (สืบทอดจาก Circle)
class Cylinder extends Circle {
    protected double length;

    public Cylinder(String name, double radius, double length) {
        super(name, radius);
        this.length = length;
    }

    // volume = พื้นที่ฐาน (จาก Circle) * ความยาว
    public double volume() {
        return super.area() * length;
    }

    @Override
    public void printinfo() {
        System.out.println("Cylinder: " + name + " | Volume: " + String.format("%.2f", volume()));
    }
}

// 5. Class Polygon (สืบทอดจาก Rectangle ตามโจทย์)
class Polygon extends Rectangle {
    protected int n;

    public Polygon(String name, double width, double height, int n) {
        super(name, width, height);
        this.n = n;
    }

    // สมมติสูตร volume = พื้นที่ * n (ตามบริบทที่สืบทอดมา)
    public double volume() {
        return super.area() * n;
    }

    @Override
    public void printinfo() {
        System.out.println("Polygon: " + name + " | Volume: " + String.format("%.2f", volume()));
    }
}

// ========================
// ส่วนที่ 2: Stack & List
// ========================

// Class Stack
class MyStack {
    protected ArrayList<Object> data;

    public MyStack() {
        data = new ArrayList<>();
    }

    public void push(Object obj) {
        data.add(obj);
    }

    public Object pop() {
        if (!empty()) {
            return data.remove(data.size() - 1);
        }
        return null;
    }

    public Object peek() {
        if (!empty()) {
            return data.get(data.size() - 1);
        }
        return null;
    }

    public int size() {
        return data.size();
    }

    public boolean empty() {
        return data.isEmpty();
    }
}

// Class List (สืบทอดจาก Stack ตามโจทย์ข้อ 2.1)
class MyList extends MyStack {
    
    // insert ที่ตำแหน่ง index
    public void insert(int index, Object obj) {
        if (index >= 0 && index <= size()) {
            data.add(index, obj);
        }
    }

    public void insertFront(Object obj) {
        insert(0, obj);
    }

    public void insertBack(Object obj) {
        push(obj); // ใช้ push ของ Stack ได้เลย
    }

    // remove ที่ตำแหน่ง index
    public Object remove(int index) {
        if (index >= 0 && index < size()) {
            return data.remove(index);
        }
        return null;
    }
    
    public Object removeBack() {
        return pop(); // ใช้ pop ของ Stack
    }
}