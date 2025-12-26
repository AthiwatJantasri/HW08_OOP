import math

# ==========================================
# 1. Class Shape
# ==========================================
class Shape:
    # 1.1 Constructor
    def __init__(self, name):
        self._name = name  # protected attribute

    # 1.1 Getter / Setter
    def get_name(self):
        return self._name 

    def set_name(self, name):
        self._name = name

    # 1.2 Override Method (Base)
    def area(self):
        return 0.0

    def printinfo(self):
        # 1.3 แสดงผล (ใช้ getter หรือ attribute โดยตรงก็ได้ แต่ในคลาสลูกใช้ getter จะสุภาพกว่า)
        print(f"Shape: {self._name} | Area: {self.area():.2f}")


# ==========================================
# 2. Class Circle (Inherits Shape)
# ==========================================
class Circle(Shape):
    def __init__(self, name, radius):
        super().__init__(name)
        self._radius = radius

    # 1.1 Getter / Setter
    def get_radius(self):
        return self._radius

    def set_radius(self, radius):
        self._radius = radius

    # 1.2 Override Method & 1.3 Calculate Area
    def area(self):
        return math.pi * (self._radius ** 2)


# ==========================================
# 3. Class Rectangle (Inherits Shape)
# ==========================================
class Rectangle(Shape):
    def __init__(self, name, width, height):
        super().__init__(name)
        self._width = width
        self._height = height

    # 1.1 Getter / Setter
    def get_width(self):
        return self._width
    
    def set_width(self, width):
        self._width = width

    def get_height(self):
        return self._height

    def set_height(self, height):
        self._height = height

    # 1.2 Override Method & 1.3 Calculate Area
    def area(self):
        return self._width * self._height


# ==========================================
# 4. Class Cylinder (Inherits Circle)
# ==========================================
class Cylinder(Circle):
    def __init__(self, name, radius, length):
        super().__init__(name, radius)
        self._length = length

    # 1.1 Getter / Setter
    def get_length(self):
        return self._length

    def set_length(self, length):
        self._length = length

    # 1.3 Calculate Volume (ใช้ Area ของพ่อ * ความยาว)
    def volume(self):
        return self.area() * self._length

    # 1.2 Override Method
    def printinfo(self):
        # แก้ไขจุดที่ผิด: เรียก self.volume() ไม่ใช่ self._volume()
        print(f"Cylinder: {self._name} | Volume: {self.volume():.2f}")


# ==========================================
# 5. Class Polygon (Inherits Rectangle)
# ==========================================
class Polygon(Rectangle):
    def __init__(self, name, width, height, n):
        super().__init__(name, width, height)
        self._n = n # n ในที่นี้อาจหมายถึงความลึก หรือจำนวนชั้น เพื่อหาปริมาตร

    # 1.1 Getter / Setter
    def get_n(self):
        return self._n

    def set_n(self, n):
        self._n = n

    # 1.3 Calculate Volume (Area ฐาน * n)
    def volume(self):
        return self.area() * self._n

    # 1.2 Override Method
    def printinfo(self):
        print(f"Polygon: {self._name} | Volume: {self.volume():.2f}")


# ==========================================
# Main Execution
# ==========================================
if __name__ == "__main__":
    print("=== Testing ===")
    
    c = Circle("MyCircle", 5.0)
    c.printinfo() # เรียกใช้ printinfo ของ Shape (เพราะ Circle ไม่ได้ override)

    r = Rectangle("MyRect", 4.0, 5.0)
    r.printinfo() # เรียกใช้ printinfo ของ Shape

    cyl = Cylinder("MyCylinder", 5.0, 10.0)
    cyl.printinfo() # เรียกใช้ printinfo ของ Cylinder (ที่ override มาแสดง Volume)

    poly = Polygon("MyPoly", 4.0, 5.0, 3)
    poly.printinfo() # เรียกใช้ printinfo ของ Polygon
