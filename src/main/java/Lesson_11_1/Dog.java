package Lesson_11_1;

class Dog extends Animal {
    private static int dogCount = 0;
    private final int MAX_RUN_DISTANCE = 500;
    private final int MAX_SWIM_DISTANCE = 10;

    public Dog(String name) {
        super(name);
        dogCount++;
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
        if (distance <= MAX_SWIM_DISTANCE) {
            super.swim(distance);
        } else {
            System.out.println(getName() + " не может проплыть больше " + MAX_SWIM_DISTANCE + " м.");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}