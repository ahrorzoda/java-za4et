import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*Дань файл целых чисел, содержащий четное количество элементов. Удалить из данного файла первую половину элементов */
public class RemoveFirstHalf {
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

            // Удаление первой половины элементов
            removeFirstHalf(numbers);

            // Запись в файл
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            for (Integer number : numbers) {
                writer.write(number + " ");
            }
            writer.close();

            System.out.println("Удаление первой половины элементов выполнено успешно.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void removeFirstHalf(List<Integer> numbers) {
        int originalSize = numbers.size();
        int newSize = originalSize / 2;

        if (originalSize > 0) {
            // Удаляем первую половину элементов
            numbers.subList(0, newSize).clear();
        }
    }
}
