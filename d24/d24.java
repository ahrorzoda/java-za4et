/*Дань файл целых чисел. Продублировать в нем все элементы с нечетными номерами*/
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DuplicateOddIndices {
    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        try {
            // Чтение из файла
            Scanner scanner = new Scanner(new File(inputFilePath));
            List<Integer> numbers = new ArrayList<>();

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    numbers.add(scanner.nextInt());
                } else {
                    // Если следующий токен не является целым числом, пропускаем его
                    scanner.next();
                }
            }

            scanner.close();

            // Дублирование элементов с нечетными номерами
            duplicateOddIndices(numbers);

            // Запись в файл
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            for (Integer number : numbers) {
                writer.write(number + " ");
            }
            writer.close();

            System.out.println("Дублирование выполнено успешно.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void duplicateOddIndices(List<Integer> numbers) {
        int size = numbers.size();
        for (int i = size - 1; i >= 0; i--) {
            if (i % 2 == 1) {
                // Если индекс четный, дублируем элемент
                numbers.add(i + 1, numbers.get(i));
            }
        }
    }
}
