import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TV {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<myTV> TVs = Arrays.asList(
            new myTV("TV1", 2019, 15000,42, "Samsung"),
            new myTV("TV2", 2020, 16000,32, "Philips"),
            new myTV("TV3", 2021, 17000,42, "HP"),
            new myTV("TV4", 2022, 18000,32, "Samsung"),
            new myTV("TV5", 2023, 19000,42, "Samsung")

        );

        System.out.println("All TVS: ");

        TVs.forEach(System.out::println);System.out.println();

        System.out.println("Показати всі телевізори з вказаною діагоналлю");

        System.out.print("Enter diagonal");
        int diagonal = scanner.nextInt();

        TVs.stream().filter(c->c.Diagonal==diagonal).forEach(System.out::println);System.out.println();

        System.out.println("Показати всі телевізори вказаного виробника");

        System.out.print("Enter manufacture: ");
        String manuf = scanner.nextLine();
        TVs.stream().filter(t->t.Manufacture.equals(manuf)).forEach(System.out::println);System.out.println();



        System.out.println("Показати всі телевізори поточного року");

        int currentYear = LocalDate.now().getYear();

        TVs.stream().filter(t->t.Year==currentYear).forEach(System.out::println);System.out.println();

        System.out.println("Показати всі телевізори дорожчі вказаної ціни");

        System.out.println("Enter price: ");
        int price = scanner.nextInt();

        TVs.stream().filter(t->t.Price>price).forEach(System.out::println);System.out.println();

        System.out.println("Показати всі телевізори відсортовані по ціні зростання");

       TVs.stream().sorted(Comparator.comparingDouble(myTV::getPrice)).forEach(System.out::println);

        System.out.println("Показати всі телевізори відсортовані по ціні спадання");

        TVs.stream().sorted(Comparator.comparingDouble(myTV::getPrice).reversed()).forEach(System.out::println);
        System.out.println("Показати всі телевізори відсортовані по діагоналі по зростанню ");

        TVs.stream().sorted(Comparator.comparingDouble(myTV::getDiagonal)).forEach(System.out::println);
        System.out.println("Показати всі телевізори відсортовані по діагоналі по спаданню ");
        TVs.stream().sorted(Comparator.comparingDouble(myTV::getDiagonal).reversed()).forEach(System.out::println);

    }
    public static class myTV
    {
        private String Name;
        private int Year;
        private int Price;
        private int Diagonal;
        private String Manufacture;

        public myTV(String name, int year, int price, int diagonal, String manufacture)
        {
            this.Name = name;
            this.Year = year;
            this.Price = price;
            this.Diagonal = diagonal;
            this.Manufacture = manufacture;
        }

        @Override
        public String toString() {
            return "myTV{" +
                    "Name='" + Name + '\'' +
                    ", Year=" + Year +
                    ", Price=" + Price +
                    ", Diagonal=" + Diagonal +
                    ", Manufacture='" + Manufacture + '\'' +
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

        public int getDiagonal() {
            return Diagonal;
        }

        public String getManufacture() {
            return Manufacture;
        }
    }
}
