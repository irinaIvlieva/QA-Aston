package Lesson_11_2;

interface GeometricShape {
    String getFillColor();
    String getBorderColor();
    double calculatePerimeter();
    double calculateArea();

    default void printInfo() {
        System.out.println("Периметр: " + calculatePerimeter() + ", Площадь: " + calculateArea() + ", Цвет фона: " + getFillColor() + ", Цвет границ: " + getBorderColor());
    }
}
