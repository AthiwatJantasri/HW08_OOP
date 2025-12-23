using System;
using System.Collections.Generic;

namespace OOP_Homework
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("=== 1. Testing Shapes ===");

            Circle c = new Circle("MyCircle", 5.0);
            c.PrintInfo();

            Rectangle r = new Rectangle("MyRect", 4.0, 5.0);
            r.PrintInfo();

            Cylinder cyl = new Cylinder("MyCylinder", 5.0, 10.0);
            cyl.PrintInfo();

            Polygon poly = new Polygon("MyPoly", 4.0, 5.0, 3);
            poly.PrintInfo();

            Console.WriteLine("\n=== 2. Testing Stack & List ===");

            MyList list = new MyList();
            list.InsertBack("Jack");
            list.InsertBack("John");
            list.Insert(2, "Joe");
            list.InsertBack("Jane");
            list.Push("Jim");

            Console.WriteLine("Size: " + list.Size());
            Console.WriteLine("Peek (Top): " + list.Peek());

            Console.WriteLine("Pop: " + list.Pop());
            Console.WriteLine("Peek after pop: " + list.Peek());
        }
    }

    // ========================
    // ส่วนที่ 1: Shape Hierarchy
    // ========================

    class Shape
    {
        protected string name;

        public Shape(string name)
        {
            this.name = name;
        }

        public virtual double Area()
        {
            return 0.0;
        }

        public virtual void PrintInfo()
        {
            Console.WriteLine($"Shape: {name} | Area: {Area():F2}");
        }
    }

    class Circle : Shape
    {
        protected double radius;

        public Circle(string name, double radius) : base(name)
        {
            this.radius = radius;
        }

        public override double Area()
        {
            return Math.PI * radius * radius;
        }
    }

    class Rectangle : Shape
    {
        protected double width;
        protected double height;

        public Rectangle(string name, double width, double height) : base(name)
        {
            this.width = width;
            this.height = height;
        }

        public override double Area()
        {
            return width * height;
        }
    }

    class Cylinder : Circle
    {
        protected double length;

        public Cylinder(string name, double radius, double length) : base(name, radius)
        {
            this.length = length;
        }

        public double Volume()
        {
            return base.Area() * length;
        }

        public override void PrintInfo()
        {
            Console.WriteLine($"Cylinder: {name} | Volume: {Volume():F2}");
        }
    }

    class Polygon : Rectangle
    {
        protected int n;

        public Polygon(string name, double width, double height, int n) : base(name, width, height)
        {
            this.n = n;
        }

        public double Volume()
        {
            return base.Area() * n;
        }

        public override void PrintInfo()
        {
            Console.WriteLine($"Polygon: {name} | Volume: {Volume():F2}");
        }
    }

    // ========================
    // ส่วนที่ 2: Stack & List
    // ========================

    class MyStack
    {
        protected List<object> data;

        public MyStack()
        {
            data = new List<object>();
        }

        public void Push(object obj)
        {
            data.Add(obj);
        }

        public object Pop()
        {
            if (!Empty())
            {
                object item = data[data.Count - 1];
                data.RemoveAt(data.Count - 1);
                return item;
            }
            return null;
        }

        public object Peek()
        {
            if (!Empty())
            {
                return data[data.Count - 1];
            }
            return null;
        }

        public int Size()
        {
            return data.Count;
        }

        public bool Empty()
        {
            return data.Count == 0;
        }
    }

    class MyList : MyStack
    {
        public void Insert(int index, object obj)
        {
            if (index >= 0 && index <= Size())
            {
                data.Insert(index, obj);
            }
        }

        public void InsertFront(object obj)
        {
            Insert(0, obj);
        }

        public void InsertBack(object obj)
        {
            Push(obj);
        }

        public object Remove(int index)
        {
            if (index >= 0 && index < Size())
            {
                object item = data[index];
                data.RemoveAt(index);
                return item;
            }
            return null;
        }

        public object RemoveBack()
        {
            return Pop();
        }
    }
}