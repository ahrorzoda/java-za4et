import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*Дань файл целых чисел, содержащий менее 50 элементов. Увеличить его размер до 50 элементов, записав в начало файла необходимое количество нулей.*/
public class IncreaseFileSize {
    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";
        int targetSize = 50;

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

            // Увеличение размера файла до 50 элементов
            increaseFileSize(numbers, targetSize);

            // Запись в файл
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            for (Integer number : numbers) {
                writer.write(number + " ");
            }
            writer.close();

            System.out.println("Увеличение размера файла выполнено успешно.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void increaseFileSize(List<Integer> numbers, int targetSize) {
        int currentSize = numbers.size();
        if (currentSize < targetSize) {
            // Если текущий размер меньше целевого, добавляем необходимое количество нулей в начало
            for (int i = 0; i < targetSize - currentSize; i++) {
                numbers.add(0, 0);
            }
        }
    }
}
