import java.io.*;
import java.util.Scanner;
/*Заменить в нем все элементы на их квадраты*/
public class SquareNumbers {
    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";
        try {
            // Чтение из файла
            Scanner scanner = new Scanner(new File(inputFilePath));
            StringBuilder content = new StringBuilder();
            while (scanner.hasNext()) {
                if (scanner.hasNextDouble()) {
                    double number = scanner.nextDouble();
                    // Замена числа на его квадрат
                    content.append(Math.pow(number, 2)).append(" ");
                } else {
                    // Если следующий токен не является вещественным числом, добавляем его в результат
                    content.append(scanner.next()).append(" ");
                }
            }
            scanner.close();
            // Запись в файл
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            writer.write(content.toString());
            writer.close();
            System.out.println("Замена на квадраты выполнена успешно.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
