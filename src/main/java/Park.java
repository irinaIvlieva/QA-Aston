public class Park {
    private String parkName;
    private Attraction[] attractions;

    public Park(String name, int attractionCount) {
        this.parkName = name;
        this.attractions = new Attraction[attractionCount];
    }

    public class Attraction {
        private String name;
        private String workingHours;
        private double price;

        public Attraction(String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void printInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + price + " руб.");
        }
    }

    public void addAttraction(int index, String name, String workingHours, double price) {
        if (index >= 0 && index < attractions.length) {
            attractions[index] = new Attraction(name, workingHours, price);
        }
    }

    public void printParkInfo() {
        System.out.println("Парк " + parkName);
        System.out.println();
        for (Attraction attraction : attractions) {
            if (attraction != null) {
                attraction.printInfo();
                System.out.println("---------------");
            }
        }
    }

    public static void main(String[] args) {
        Park disneyland = new Park("Дружбы", 3);

        disneyland.addAttraction(0, "Колесо обозрения", "8:00-00:00", 800);
        disneyland.addAttraction(1, "Американские горки", "10:00-21:00", 1250);
        disneyland.addAttraction(2, "Ракета", "11:00-20:00", 900);

        disneyland.printParkInfo();
    }

}
