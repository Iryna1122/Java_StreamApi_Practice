import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the random numbers list: ");
        int size = scanner.nextInt();

        List<Integer>numbers = generateRandomDigit(size);

        System.out.println("Generated numbers: " + numbers);

        System.out.println("Even numbers count: " + countEven(numbers));
        System.out.println("Odd numbers count: " + countOdd(numbers));
        System.out.println("Zero numbers count: " + countZero(numbers));


        System.out.print("Enter a number to count occurrences: ");
        int userNumber = scanner.nextInt();
        long userNumberCount = countOccurrences(numbers, userNumber);
        System.out.println(userNumber + " occurrences count: " + userNumberCount);

    }


    private static List<Integer> generateRandomDigit(int size)
    {
        Random random = new Random();

        return random.ints(size, -100, 101)
                .boxed()
                .collect(Collectors.toList());

    }

    private static long countEven(List<Integer> numbers)
    {

        return numbers.stream().filter(n-> n %2 ==0).count();
    }

    private static long countOdd(List<Integer> numbers)
    {
        return numbers.stream()
                .filter(n->n!=0).count();
    }

    private static long countZero(List<Integer>numbers)
    {
        return numbers.stream()
                .filter(n->n==0).count();
    }

    private static long countOccurrences(List<Integer> numbers, int target)
    {
        return numbers.stream()
                .filter(n->n==target).count();
    }

}