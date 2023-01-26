import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
Городская площадь имеет размер n× m и покрыта квадратной плиткой размером 1× 1. При плановой 
замене плитки выяснилось, что новой плитки недостаточно для покрытия всей площади, поэтому 
было решено покрыть плиткой только дорожку по краю площади, а в центре площади разбить 
прямоугольную клумбу (см. рисунок к примеру). При этом дорожка должна иметь одинаковую ширину 
по всем сторонам площади. Определите максимальную ширину дорожки, которую можно выложить из 
имеющихся плиток.

Формат ввода
Первая и вторая строки входных данных содержат по одному числу n и m (3≤ n ≤ 2× 10**9, 
3≤ m ≤ 2× 10**9) — размеры площади.
Третья строка содержит количество имеющихся плиток t, 1≤ t< nm.
Обратите внимание, что значение t может быть больше, чем возможное значение 32-битной 
целочисленной переменной, поэтому необходимо использовать 64-битные числа (тип int64 
в языке Pascal, тип long long в C и C++, тип long в Java и C#).

Формат вывода
Программа должна вывести единственное число — максимальную ширину дорожки, 
которую можно выложить из имеющихся плиток.
*/

public class Area {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        long n = Long.parseLong(str);
        str = br.readLine();
        long m = Long.parseLong(str);
        str = br.readLine();
        long t = Long.parseLong(str);


        long l = 0;
        long r = (Math.min(n, m) - 1) / 2;
        long middle, covering;


        while (l < r) {

            middle = (l + r + 1) / 2;
            covering = m * middle * 2 + (n - 2*middle) * 2 * middle;
            if (covering > t) {
                r = middle - 1;
            } else {
                l = middle;
            }
        }

        writer.write(l + "");


        writer.flush();
        writer.close();
    }
}

