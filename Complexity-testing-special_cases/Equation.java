import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/*
Решите в целых числах уравнение:
(ax+b)**(1/2) = c,
a, b, c – данные целые числа: найдите все решения или сообщите, что решений в целых числах нет.

Формат ввода
Вводятся три числа a, b и c по одному в строке.

Формат вывода
Программа должна вывести все решения уравнения в порядке возрастания, либо NO SOLUTION
(заглавными буквами), если решений нет. Если решений бесконечно много, вывести MANY SOLUTIONS.
 */



public class Equation {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        int a = Integer.parseInt(str);
        str = br.readLine();
        int b = Integer.parseInt(str);
        str = br.readLine();
        int c = Integer.parseInt(str);

        Integer result;
        if (c < 0)
            writer.write("NO SOLUTION");
        else if (a == 0) {
            if (b == c*c)
                writer.write("MANY SOLUTIONS");
            else
                writer.write("NO SOLUTION");
        } else {
            if ((c*c - b) % a != 0)
                writer.write("NO SOLUTION");
            else {
                result = (c * c - b) / a;
                writer.write(result.toString());
            }
        }

        writer.flush();
        writer.close();
    }
}
