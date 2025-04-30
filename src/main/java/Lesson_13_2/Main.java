package Lesson_13_2;

public class Main {
    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();

        phoneDirectory.add("Козлов", "89000000000");
        phoneDirectory.add("Ефремов", "88005553535");
        phoneDirectory.add("Авдеев", "89651234567");
        phoneDirectory.add("Ефремов", "89996510000");

        System.out.println("Телефоны Козлова: " + phoneDirectory.get("Козлов"));
        System.out.println("Телефоны Евремова: " + phoneDirectory.get("Ефремов"));
        System.out.println("Телефоны Авдеева: " + phoneDirectory.get("Авдеев"));
    }
}