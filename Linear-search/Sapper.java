import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.Arrays;

/*
Вам необходимо построить поле для игры "Сапер" по его конфигурации – размерам и координатам расставленных на нем мин.
Вкратце напомним правила построения поля для игры "Сапер":
Поле состоит из клеток с минами и пустых клеток
Клетки с миной обозначаются символом *
Пустые клетки содержат число ki,j, 0≤ ki, j ≤ 8 – количество мин на соседних клетках. Соседними клетками являются 
восемь клеток, имеющих смежный угол или сторону.

Формат ввода
В первой строке содержатся три числа: N, 1 ≤ N ≤ 100 - количество строк на поле, M, 1 ≤ M ≤ 100 - количество столбцов 
на поле, K, 0 ≤ K ≤ N ⋅ M - количество мин на поле.
В следующих K строках содержатся по два числа с координатами мин: p, 1 ≤ p ≤ N - номер строки 
мины, q, 1 ≤ 1 ≤ M - номер столбца мины.

Формат вывода
Выведите построенное поле, разделяя строки поля переводом строки, а столбцы - пробелом.
*/

public class Sapper {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        String[] arr = str.split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);
        int K = Integer.parseInt(arr[2]);

        String[][] array = new String[N][M];
        int p, q;
        while (K != 0) {

            str = br.readLine();
            arr = str.split(" ");
            p = Integer.parseInt(arr[0]);
            q = Integer.parseInt(arr[1]);
            array[p-1][q-1] = "*";

            K--;
        }

        String cell;
        Integer result;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                cell = array[i][j];
                result = 0;
                if (cell != "*") {
                    if (i >= 1) {
                        if (j >= 1) {
                            if (array[i - 1][j - 1] == "*")
                                result++;
                        }
                        if (array[i - 1][j] == "*")
                            result++;
                        if (j < array[i].length - 1) {
                            if (array[i - 1][j + 1] == "*")
                                result++;
                        }
                    }
                    if (j >= 1) {
                        if (array[i][j - 1] == "*")
                            result++;
                    }
                    if (j < array[i].length - 1) {
                        if (array[i][j + 1] == "*")
                            result++;
                    }
                    if (i < array.length - 1) {
                        if (j >= 1) {
                            if (array[i + 1][j - 1] == "*")
                                result++;
                        }
                        if (array[i + 1][j] == "*")
                            result++;
                        if (j < array[i].length - 1) {
                            if (array[i + 1][j + 1] == "*")
                                result++;
                        }
                    }
                    array[i][j] = result.toString();
                }
            }
        }
        
        for (String[] element: array) {
            for (String cell2: element) {
                writer.write(cell2 + " ");
            }
            writer.write('\n');
        }

        writer.flush();
        writer.close();

    }
}
