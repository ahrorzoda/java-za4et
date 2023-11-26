import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/* Заменить в нем все локальные максимумы на среднее значение первого и последнего локальных минимумов*/
public class ReplaceLocalMaxima {
    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        try {
            // Чтение из файла
            Scanner scanner = new Scanner(new File(inputFilePath));
            List<Double> numbers = new ArrayList<>();

            while (scanner.hasNext()) {
                if (scanner.hasNextDouble()) {
                    numbers.add(scanner.nextDouble());
                } else {
                    // Если следующий токен не является вещественным числом, пропускаем его
                    scanner.next();
                }
            }

            scanner.close();

            // Замена локальных максимумов
            replaceLocalMaxima(numbers);

            // Запись в файл
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            for (Double number : numbers) {
                writer.write(number + " ");
            }
            writer.close();

            System.out.println("Замена локальных максимумов выполнена успешно.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void replaceLocalMaxima(List<Double> numbers) {
        int size = numbers.size();

        for (int i = 1; i < size - 1; i++) {
            if (numbers.get(i) > numbers.get(i - 1) && numbers.get(i) > numbers.get(i + 1)) {
                // Текущий элемент - локальный максимум
                double avg = calculateAverageOfLocalMinima(numbers, i);
                numbers.set(i, avg);
            }
        }
    }

    private static double calculateAverageOfLocalMinima(List<Double> numbers, int currentIndex) {
        int size = numbers.size();

        for (int i = currentIndex - 1; i >= 0; i--) {
            if (i == 0 || numbers.get(i) < numbers.get(i - 1)) {
                // numbers.get(i) - первый локальный минимум
                break;
            }
        }

        for (int i = currentIndex + 1; i < size; i++) {
            if (i == size - 1 || numbers.get(i) < numbers.get(i + 1)) {
                // numbers.get(i) - последний локальный минимум
                return (numbers.get(currentIndex) + numbers.get(i)) / 2.0;
            }
        }

        // Если не найдены локальные минимумы, возвращаем текущее значение
        return numbers.get(currentIndex);
    }
}
