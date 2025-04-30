package Lesson_13_1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        students.add(new Student("Мария", "Группа 1", 1,
                Map.of("Математика", 4, "Физика", 4, "Теория упругости", 3)));
        students.add(new Student("Юрий", "Группа 2", 1,
                Map.of("Математика", 3, "Физика", 2, "Теория упругости", 2)));
        students.add(new Student("Антон", "Группа 1", 2,
                Map.of("Математика", 5, "Физика", 5, "Теория упругости", 4)));
        students.add(new Student("Анатолий", "Группа 3", 3,
                Map.of("Литература", 4, "Философия", 5, "История", 3)));

        StudentManager manager = new StudentManager(students);

        System.out.println(" Все студенты");
        students.forEach(System.out::println);

        manager.promoteStudents();
        manager.removeUnderperformingStudents();

        System.out.println("\n Оставшиеся студенты");
        students.forEach(System.out::println);

        manager.printStudents(4);
    }
}

