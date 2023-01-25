import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/*
За многие годы заточения узник замка Иф проделал в стене прямоугольное отверстие размером D × E.
Замок Иф сложен из кирпичей, размером A × B × C. Определите, сможет ли узник выбрасывать кирпичи в море
через это отверстие, если стороны кирпича должны быть параллельны сторонам отверстия.

Формат ввода
Программа получает на вход числа A, B, C, D, E.

Формат вывода
Программа должна вывести слово YES или NO.
 */

public class Prisoner {

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
        str = br.readLine();
        int d = Integer.parseInt(str);
        str = br.readLine();
        int e = Integer.parseInt(str);

        String res = function(a, b, c, d, e);
        writer.write(res);
        writer.flush();
        writer.close();
    }

    public static String function(int a, int b, int c, int d, int e) {

        if ((a <= d) && (b <= e)) {
            return "YES";
        }
        if ((a <= e) && (b <= d)) {
            return "YES";
        }
        if ((a <= d) && (c <= e)) {
            return "YES";
        }
        if ((a <= e) && (c <= d)) {
            return "YES";
        }
        if ((b <= d) && (c <= e)) {
            return "YES";
        }
        if ((b <= e) && (c <= d)) {
            return "YES";
        }
        return "NO";
    }

}