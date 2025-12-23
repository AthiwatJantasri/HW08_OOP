import math

# ========================
# ส่วนที่ 1: Shape Hierarchy
# ========================

class Shape:
    def __init__(self, name):
        self._name = name # protected convention uses _

    def area(self):
        return 0.0

    def printinfo(self):
        print(f"Shape: {self._name} | Area: {self.area():.2f}")

class Circle(Shape):
    def __init__(self, name, radius):
        super().__init__(name)
        self._radius = radius

    def area(self):
        return math.pi * (self._radius ** 2)

class Rectangle(Shape):
    def __init__(self, name, width, height):
        super().__init__(name)
        self._width = width
        self._height = height

    def area(self):
        return self._width * self._height

class Cylinder(Circle):
    def __init__(self, name, radius, length):
        super().__init__(name, radius)
        self._length = length

    def volume(self):
        return super().area() * self._length

    def printinfo(self):
        print(f"Cylinder: {self._name} | Volume: {self.volume():.2f}")

class Polygon(Rectangle):
    def __init__(self, name, width, height, n):
        super().__init__(name, width, height)
        self._n = n

    def volume(self):
        return super().area() * self._n

    def printinfo(self):
        print(f"Polygon: {self._name} | Volume: {self.volume():.2f}")

# ========================
# ส่วนที่ 2: Stack & List
# ========================

class MyStack:
    def __init__(self):
        self.data = []

    def push(self, obj):
        self.data.append(obj)

    def pop(self):
        if not self.empty():
            return self.data.pop()
        return None

    def peek(self):
        if not self.empty():
            return self.data[-1]
        return None

    def size(self):
        return len(self.data)

    def empty(self):
        return len(self.data) == 0

class MyList(MyStack):
    def insert(self, index, obj):
        if 0 <= index <= self.size():
            self.data.insert(index, obj)

    def insert_front(self, obj):
        self.insert(0, obj)

    def insert_back(self, obj):
        self.push(obj)

    def remove(self, index):
        if 0 <= index < self.size():
            return self.data.pop(index)
        return None

    def remove_back(self):
        return self.pop()

# ========================
# Main Execution
# ========================
if __name__ == "__main__":
    print("=== 1. Testing Shapes ===")
    
    c = Circle("MyCircle", 5.0)
    c.printinfo()

    r = Rectangle("MyRect", 4.0, 5.0)
    r.printinfo()

    cyl = Cylinder("MyCylinder", 5.0, 10.0)
    cyl.printinfo()

    poly = Polygon("MyPoly", 4.0, 5.0, 3)
    poly.printinfo()

    print("\n=== 2. Testing Stack & List ===")
    
    my_list = MyList()
    my_list.insert_back("Jack")
    my_list.insert_back("John")
    my_list.insert(2, "Joe")
    my_list.insert_back("Jane")
    my_list.push("Jim")

    print(f"Size: {my_list.size()}")
    print(f"Peek (Top): {my_list.peek()}")

    print(f"Pop: {my_list.pop()}")
    print(f"Peek after pop: {my_list.peek()}")