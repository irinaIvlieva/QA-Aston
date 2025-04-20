package Lesson_11_1;

class Bowl {
    private int foodAmount;

    public Bowl(int initialAmount) {
        this.foodAmount = initialAmount;
    }

    public boolean decreaseFood(int amount) {
        if (amount <= foodAmount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }

    public void addFood(int amount) {
        foodAmount += amount;
        System.out.println("В миску добавлено " + amount + " еды. Теперь в миске " + foodAmount + " еды.");
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}