import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/*
В школе решили на один прямоугольный стол поставить два прямоугольных ноутбука. Ноутбуки нужно
поставить так, чтобы их стороны были параллельны сторонам стола. Определите, какие размеры должен иметь
стол, чтобы оба ноутбука на него поместились, и площадь стола была минимальна.

Формат ввода
Вводится четыре натуральных числа, первые два задают размеры одного ноутбука, а следующие два — размеры
второго. Числа не превышают 1000.

Формат вывода
Выведите два числа — размеры стола. Если возможно несколько ответов, выведите любой из них (но только один).
 */


public class Laptops {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        String[] arr = str.split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        int c = Integer.parseInt(arr[2]);
        int d = Integer.parseInt(arr[3]);

        Integer result1, result2;

        int square1 = (Math.max(a, c)) * (b + d);
        int square2 = (Math.max(a, d)) * (b + c);
        int square3 = (Math.max(b, d)) * (a + c);
        int square4 = (Math.max(b, c)) * (a + d);

        result1 = Math.max(a, c);
        result2 = (b + d);

        int minSquare = square1;
        if (square2 < minSquare) {
            minSquare = square2;
            result1 = Math.max(a, d);
            result2 = (b + c);
        }
        if (square3 < minSquare) {
            minSquare = square3;
            result1 = Math.max(b, d);
            result2 = (a + c);
        }
        if (square4 < minSquare) {
            result1 = Math.max(b, c);
            result2 = (a + d);
        }


        writer.write(result1 + " ");
        writer.write(result2.toString());
        writer.flush();
        writer.close();
    }




}