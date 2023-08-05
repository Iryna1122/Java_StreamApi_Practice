import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task2 {

    public static void main(String[] args) {
//        Для набору назв міст(міста можуть повторюватися) потрібно:
// Показати всі міста
// Показати всі міста довжиною більше шести символів
// Порахувати скільки разів зустрічається місто, назву якого ввів користувач
// Порахувати всі міста, на вказану букву


        System.out.print("Enter the number of cities: ");

        Scanner scanner = new Scanner(System.in);

        int numCities = scanner.nextInt();
        scanner.nextLine();

        List<String> cities = new ArrayList<>();

        for(int i = 0; i<numCities; i++)
        {
            System.out.print("Enter city name: ");
            String name = scanner.nextLine();

            cities.add(name);

        }

        System.out.println("All cities: " + cities);

        List<String>citiesWithLengthGreaterThanSix = cities.stream()
                .filter(c->c.length()>6)
                .collect(Collectors.toList());

        System.out.println("Cities with length greater than six: " + citiesWithLengthGreaterThanSix);

        System.out.println();

        System.out.print("Enter city for search: ");
        String cityName =  scanner.nextLine();

       long countCityOccurrencess = countCityOccurrences(cities,cityName);

        System.out.println("Count cities CityOccurrences with " + cityName +":  "+ countCityOccurrencess );

        System.out.print("Enter letter: ");
        String letter = scanner.nextLine();

        long countCityWithLetterr = countCityWithLetter(cities,letter);
        System.out.println("Cities starting with letter " + letter + ": " + countCityWithLetterr);

    }

    private static long countCityOccurrences(List<String> cities, String targetCity) {

        return cities.stream().filter(c->c.equals(targetCity)).count();

    }

    private static long countCityWithLetter(List<String>cities, String letter)
    {
        return cities.stream()
                .filter(c->c.startsWith(letter)).count();
    }

}
