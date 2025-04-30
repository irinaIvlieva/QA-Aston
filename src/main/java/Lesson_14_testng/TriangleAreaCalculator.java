package Lesson_14_testng;

public class TriangleAreaCalculator {
    public double calculateArea(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Base and height must be positive");
        }
        return (base * height) / 2;
    }
}