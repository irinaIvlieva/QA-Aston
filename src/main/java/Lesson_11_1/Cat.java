package Lesson_11_1;

class Cat extends Animal {
    private static int catCount = 0;
    private final int MAX_RUN_DISTANCE = 200;
    private boolean isHungry = true;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            super.run(distance);
        } else {
            System.out.println(getName() + " не может пробежать больше " + MAX_RUN_DISTANCE + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(getName() + " не умеет плавать!");
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.decreaseFood(amount)) {
            isHungry = false;
            System.out.println(getName() + " поел и теперь сыт.");
        } else {
            System.out.println(getName() + " не смог поесть, в миске недостаточно еды.");
        }
    }

    public boolean isHungry() {
        return isHungry;
    }

    public static int getCatCount() {
        return catCount;
    }
}
