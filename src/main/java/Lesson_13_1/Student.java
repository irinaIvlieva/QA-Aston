package Lesson_13_1;

import java.util.Map;

public class Student {
    private String name;
    private String group;
    private int course;
    private Map<String, Integer> grades;

    public Student(String name, String group, int course, Map<String, Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) return 0;
        double sum = 0;
        for (int grade : grades.values()) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public void promoteToNextCourse() {
        if (getAverageGrade() >= 3) {
            course++;
            System.out.println(name + " переведён на " + course + " курс");
        } else {
            System.out.println(name + " не переведён (средний балл: " + getAverageGrade() + ")");
        }
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return name + " (группа: " + group + ", курс: " + course +
                ", средний балл: " + String.format("%.2f", getAverageGrade()) + ")";
    }
}