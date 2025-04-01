public class Lesson_6 {

    public static void main(String[] args) {
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung s25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 15 Pro Max", "10.09.2023", "Apple Inc.", "USA", 5399, true);
        productsArray[2] = new Product("Dyson", "22.01.2024", "Dyson", "Great Britain", 51999, false);
        productsArray[3] = new Product("Bosch", "05.10.2023", "Bosch", "Poland", 29999, false);
        productsArray[4] = new Product("Huawei", "15.05.2023", "Huawei", "China", 10999, true);

        for (Product product : productsArray) {
            product.printInfo();
        }
    }
}
