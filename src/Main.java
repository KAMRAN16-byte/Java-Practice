import java.util.Scanner;

abstract class Shape {
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

    void setType(String type) {
        this.type = type;
    }

    String getType() {
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
        System.out.println("Area of Circle given by: "  + getArea());
    }

    @Override
    public void displayPerimeter() {
        System.out.println("Circumstance of Circle given by: "  + getPerimeter());
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

    public void acceptRecord(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Detail's from Rectangle.");
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