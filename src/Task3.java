import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

// Показати всі автомобілі
// Показати всі автомобілі вказаного кольору
// Показати всі автомобілі вказаного об’єму двигуна
// Показати всі автомобілі дорожчі вказаної ціни
// Показати всі автомобілі чий рік випуску знаходиться в вказаному діапазоні

        Scanner scanner = new Scanner(System.in);

        List<Car> cars = Arrays.asList(
                new Car("Tesla", 2020, 23000, "Red", 2000.0),
                new Car("Toyota", 2023, 18000, "Burgundi", 3.5),
                new Car("Nissan", 2019, 19000, "Black", 2.3),
                new Car("Mazda", 2021, 21000, "Yellow", 2.0)

        );

        System.out.println("All cars: ");
        cars.forEach(System.out::println);

        System.out.println("Показати всі автомобілі вказаного кольору: ");
        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        cars.stream()
                .filter(c->c.Color.equals(color)).forEach(System.out::println);

        System.out.println("Показати всі автомобілі вказаного об’єму двигуна: ");
        System.out.print("Enter volume of engine: ");
        double volume = scanner.nextDouble();

        cars.stream().filter(c->c.Volume==volume).forEach(System.out::println);

        System.out.println("Показати всі автомобілі дорожчі вказаної ціни: ");

        System.out.print("Enter price: ");
        int price = scanner.nextInt();

        cars.stream().filter(c->c.Price>price).forEach(System.out::println);

        System.out.println("Показати всі автомобілі чий рік випуску знаходиться в вказаному діапазоні\n: ");
        System.out.print("Enter min year: ");
        int minYear = scanner.nextInt();
        System.out.print("Enter max year: ");
        int maxYear = scanner.nextInt();

        cars.stream().filter(c->c.Year>=minYear && c.Year<=maxYear).forEach(System.out::println);

    }

    public static class Car
    {
        private String Name;
        private int Year;
        private int Price;
        private String Color;
        private double Volume;

        public Car(String name, int year, int price, String color, double volume)
        {
            this.Name = name;
            this.Year = year;
            this.Price = price;
            this.Color = color;
            this.Volume = volume;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "Name='" + Name + '\'' +
                    ", Year=" + Year +
                    ", Price=" + Price +
                    ", Color='" + Color + '\'' +
                    ", Volume=" + Volume +
                    '}';
        }

        public String getName() {
            return Name;
        }

        public int getYear() {
            return Year;
        }

        public int getPrice() {
            return Price;
        }

        public String getColor() {
            return Color;
        }

        public double getVolume() {
            return Volume;
        }

        public void setName(String name) {
            Name = name;
        }

        public void setYear(int year) {
            Year = year;
        }

        public void setPrice(int price) {
            Price = price;
        }

        public void setColor(String color) {
            Color = color;
        }

        public void setVolume(double volume) {
            Volume = volume;
        }
    }
}
