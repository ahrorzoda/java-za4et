import java.io.*;
import java.util.Scanner;
/*Удалить из него все отрицательные числа */
public class RemoveNegativeNumbers {
    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        try {
            // Чтение из файла
            Scanner scanner = new Scanner(new File(inputFilePath));
            StringBuilder content = new StringBuilder();

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int number = scanner.nextInt();
                    if (number >= 0) {
                        // Добавление неотрицательного числа в результат
                        content.append(number).append(" ");
                    }
                    // Если число отрицательное, пропускаем его
                } else {
                    // Если следующий токен не является целым числом, добавляем его в результат
                    content.append(scanner.next()).append(" ");
                }
            }

            scanner.close();

            // Запись в файл
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            writer.write(content.toString());
            writer.close();

            System.out.println("Отрицательные числа удалены успешно.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
