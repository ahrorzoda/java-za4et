import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*Уменьшить его размер до 50 элементов, удалив из файла необходимое количество конечных элементов.*/
public class ReduceFileSize {
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

            // Уменьшение размера файла до 50 элементов
            reduceFileSize(numbers, targetSize);

            // Запись в файл
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            for (Integer number : numbers) {
                writer.write(number + " ");
            }
            writer.close();

            System.out.println("Уменьшение размера файла выполнено успешно.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void reduceFileSize(List<Integer> numbers, int targetSize) {
        int currentSize = numbers.size();
        if (currentSize > targetSize) {
            // Если текущий размер больше целевого, удаляем лишние элементы
            numbers.subList(targetSize, currentSize).clear();
        }
    }
}
