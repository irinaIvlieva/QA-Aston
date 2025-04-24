package Lesson_11_1;

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Мухтар");
        Cat cat1 = new Cat("Сима");
        Cat cat2 = new Cat("Чипс");
        Cat cat3 = new Cat("Прохор");

        dog1.run(150);
        dog1.run(600);
        dog1.swim(5);
        dog1.swim(15);

        cat1.run(100);
        cat1.run(250);
        cat1.swim(10);

        Bowl bowl = new Bowl(30);
        Cat[] cats = {cat1, cat2, cat3};

        for (Cat cat : cats) {
            cat.eat(bowl, 15);
        }

        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сыт: " + !cat.isHungry());
        }

        bowl.addFood(30);
        cat2.eat(bowl, 15);
        System.out.println(cat2.getName() + " сыт: " + !cat2.isHungry());

        // Выводим статистику
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Собак: " + Dog.getDogCount());
        System.out.println("Котов: " + Cat.getCatCount());
    }
}