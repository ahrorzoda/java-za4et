package d9;

/*Дан символный файл, содержащий  по крайне мере один символ пробела. Удалить все его элементы, расположение после последнего символа пробела, включая и этот пробел  пример*/

import java.io.*;

public class RemoveSpaces {
    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        try {
            // Чтение из файла
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            reader.close();

            // Удаление пробелов после последнего символа пробела
            String result = removeSpacesAfterLastSpace(content.toString());

            // Запись в файл
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            writer.write(result);
            writer.close();

            System.out.println("Пробелы удалены успешно.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String removeSpacesAfterLastSpace(String input) {
        int lastSpaceIndex = input.lastIndexOf(' ');

        if (lastSpaceIndex != -1) {
            return input.substring(0, lastSpaceIndex);
        } else {
            // Если символ пробела не найден, возвращаем оригинальную строку
            return input;
        }
    }
}
