import java.io.*;
import java.util.Scanner;
/*Заменить в нем каждое положтельное число на три нуля. */
public class ReplacePositiveNumbers {
    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";
        try {
            Scanner scanner = new Scanner(new File(inputFilePath));
            StringBuilder content = new StringBuilder();
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int number = scanner.nextInt();
                    if (number > 0) {
                        content.append("000 ");
                    } else {
                        content.append(number).append(" ");
                    }
                } else {
                    // Если следующий токен не является целым числом, добавляем его в результат
                    content.append(scanner.next()).append(" ");
                }
            }
            scanner.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            writer.write(content.toString());
            writer.close();

            System.out.println("Замена выполнена успешно.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
