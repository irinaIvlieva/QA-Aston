package Lesson_13_1;

import java.util.Set;

public class StudentManager {

    public static void removeUnderperformingStudents(Set<Student> students) {
        System.out.println("\n Отчисление студентов со средним баллом < 3");
        students.removeIf(student -> {
            if (student.getAverageGrade() < 3) {
                System.out.println(student.getName() + " отчислен (средний балл: " +
                        String.format("%.2f", student.getAverageGrade()) + ")");
                return true;
            }
            return false;
        });
    }

    public static void promoteStudents(Set<Student> students) {
        System.out.println("\n Перевод студентов на следующий курс");
        for (Student student : students) {
            student.promoteToNextCourse();
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        System.out.println("\n Студенты " + course + " курса");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName() + " (группа: " + student.getGroup() +
                        ", средний балл: " + String.format("%.2f", student.getAverageGrade()) + ")");
            }
        }
    }
}
