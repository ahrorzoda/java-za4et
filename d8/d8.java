package d8;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*Дань файл вещественных чисел. Найти общее количество его локальных экстремумов, то есть локальных минимумов и локальных максимумов */
public class d8 {
    public static void main(String[] args)  {
      String inputFile = "input.txt";
     String outputFile = "output.txt";
      try {
          Scanner scanner = new Scanner(new File(inputFile));
          List<Double> numbers = new ArrayList<>();
          int i = 1;
          int count = 0;
          BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
          while (scanner.hasNext()) {
              if (scanner.hasNextDouble()) {
                  numbers.add(scanner.nextDouble());
              } else {
                  scanner.next();
              }
          }

          for(Double number: numbers) {
              while (i != numbers.size()-1) {
                  if (isLocalExtremum(numbers.get(i-1), numbers.get(i), numbers.get(i+1))) {
                      count++;
                  } else {
                      System.out.println("else");
                  }
                  i++;
              }

          }
         System.out.println(count);
          writer.close();
          scanner.close();

      }  catch (IOException e) {
          throw new RuntimeException(e);
      }
    }

    private static boolean isLocalExtremum(double prev, double current, double next) {
        return (prev > current && current < next) || (prev < current && current > next);
    }

}