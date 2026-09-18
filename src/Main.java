import java.util.Scanner;

interface Type {

    void setType(String type);

    String getType();
}

abstract class Shape implements Type {
    double area;
    double perimeter;
    String type;

    Shape() {
        area = 0;
        perimeter = 0;
    }

    Shape(double area, double perimeter) {
        this.area = area;
        this.perimeter = perimeter;
    }

    void setArea(double area) {
        this.area = area;
    }

    void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "\nArea of " + this.type + " is " + this.area + "\n" + (this.type == "Circle" ? "Circumstance" : "Perimeter") + " of" + this.type + " is " + this.perimeter;
    }
    @Override
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String getType() {
        return type;
    }

    double getPerimeter() {
        return perimeter;
    }

    abstract public void calcArea();

    abstract public void calcPerimeter();

    abstract public void displayArea();

    abstract public void displayPerimeter();

}

class Circle extends Shape {
    double radius;

    Circle() {
        this(0);
    }

    Circle(double radius) {
        this.radius = radius;
        setType("Circle");
    }

    void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void calcArea() {
        setArea(Math.PI * radius * radius);
    }

    @Override
    public void calcPerimeter() {
        setPerimeter(Math.PI * radius);
    }

    @Override
    public void displayArea() {
        System.out.println("Area of Circle given by: " + getArea());
    }

    @Override
    public void displayPerimeter() {
        System.out.println("Circumstance of Circle given by: " + getPerimeter());
    }

    public void acceptRecord() {
        System.out.println("Enter the radius of the circle");
        Scanner input = new Scanner(System.in);
        setRadius(input.nextDouble());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Shape)) return false;
        Circle other = (Circle) obj;
        return this.radius == other.radius;
    }

}

class Rectangle extends Shape {
    double length;
    double width;

    Rectangle() {
        this(0, 0);
    }

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
        setType("Rectangle");
    }

    @Override
    public void calcArea() {
        setArea(length * width);
    }

    @Override
    public void calcPerimeter() {
        setPerimeter((length + width) * 2);
    }

    public void acceptRecord() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Detail's for Rectangle.");
        System.out.print("Length of the Rectangle: ");
        length = sc.nextDouble();
        System.out.print("Width of the Rectangle: ");
        width = sc.nextDouble();
    }

    @Override
    public void displayArea() {
        System.out.println("Area of rectangle given by: " + getArea());
    }

    @Override
    public void displayPerimeter() {
        System.out.println("Perimeter of rectangle given by: " + getPerimeter());
    }
}

class Utility {

    static int menu() {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Rectangle.");
        System.out.println("2. Circle.");
        System.out.println("0. Exit.");
        return input.nextInt();
    }

    static void readAndCalculationObject(Shape obj) {
        if (obj instanceof Rectangle object) {
            object.acceptRecord();
        } else {
            Circle object = (Circle) obj;
            object.acceptRecord();
        }
        Scanner input = new Scanner(System.in);
        System.out.println("1. Calculate Area.");
        System.out.println("2. Calculate " + (obj.getType() == "Rectangle" ? "Perimeter" : "Circumstance") + ".");
        System.out.println("3. Both");
        switch (input.nextInt()){
            case 1:
            {
                obj.calcArea();
                obj.displayArea();
                break;
            }
            case 2:
            {
                obj.calcPerimeter();
                obj.displayPerimeter();
                break;
            }
            case 3:{
                obj.calcArea();
                obj.calcPerimeter();
                System.out.println(obj);
                break;
            }
        }
    }

    static void run() {
        int choice;
        while ((choice = menu()) != 0) {
            Shape shape = shapeFactory(choice);
            readAndCalculationObject(shape);
        }
    }

    static Shape shapeFactory(int choice) {
        Shape shape = null;
        switch (choice) {
            case 1: {
                shape = new Rectangle();
                break;
            }
            case 2: {
                shape = new Circle();
                break;
            }
        }
        return shape;
    }


}

public class Main {
    public static void main(String[] args) {
        Utility.run();
    }

}


