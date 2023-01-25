import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/*
Даны три натуральных числа. Возможно ли построить треугольник с такими сторонами. Если это
возможно, выведите строку YES, иначе выведите строку NO.
Треугольник — это три точки, не лежащие на одной прямой.

Формат ввода
Вводятся три натуральных числа.

Формат вывода
Выведите ответ на задачу.
 */


public class Triangle {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");
        String str = br.readLine();
        int dot1 = Integer.parseInt(str);
        str = br.readLine();
        int dot2 = Integer.parseInt(str);
        str = br.readLine();
        int dot3 = Integer.parseInt(str);

        String result = function(dot1, dot2, dot3);
        writer.write(result);
        writer.flush();
        writer.close();
    }

    public static String function(int dot1, int dot2, int dot3) {

        if (dot1 + dot2 > dot3) {
            if (dot1 + dot3 > dot2) {
                if (dot2 + dot3 > dot1)
                    return "YES";
            }
        }
        return "NO";

    }
}
