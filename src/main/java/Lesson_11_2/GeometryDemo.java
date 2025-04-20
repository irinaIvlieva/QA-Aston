package Lesson_11_2;

public class GeometryDemo {
    public static void main(String[] args) {
        GeometricShape[] shapes = {
                new Circle(5, "Красный", "Черный"),
                new Rectangle(4, 6, "Синий", "Белый"),
                new Triangle(3, 4, 5, "Зеленый", "Желтый")
        };

        for (GeometricShape shape : shapes) {
            shape.printInfo();
        }
    }
}
