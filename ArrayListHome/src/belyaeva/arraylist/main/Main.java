package belyaeva.arraylist.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> getFileStrings(String filePath) {
        try (Scanner scanner = new Scanner(new FileInputStream(filePath))) {
            ArrayList<String> fileStrings = new ArrayList<>();

            while (scanner.hasNextLine()) {
                fileStrings.add(scanner.nextLine());
            }

            return fileStrings;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

        return null;
    }

    private static void removeEvenNumbers(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);

                i--;
            }
        }
    }

    private static ArrayList<Integer> removeRepeatedNumbers(ArrayList<Integer> numbers) {
        ArrayList<Integer> notRepeatedNumbers = new ArrayList<>();

        for (Integer number : numbers) {
            if (!notRepeatedNumbers.contains(number)) {
                notRepeatedNumbers.add(number);
            }
        }

        return notRepeatedNumbers;
    }

    public static void main(String[] args) {
        String filePath = "InputStrings.txt";
        System.out.println(getFileStrings(filePath));

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(6, 4, 7, 0, 9, 5, 2, 3));

        removeEvenNumbers(numbers);
        System.out.println(numbers);

        ArrayList<Integer> repeatedNumbers = new ArrayList<>(Arrays.asList(2, 5, 4, 2, 9, 5, 2, 7));

        System.out.println(removeRepeatedNumbers(repeatedNumbers));
    }
}
