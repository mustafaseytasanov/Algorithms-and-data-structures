import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/*
Дано n отрезков на числовой прямой и m точек на этой же прямой. Для каждой из данных
точек определите, скольким отрезкам они принадлежат. Точка x считается принадлежащей 
отрезку с концами a и b, если выполняется двойное неравенство min(a, b) ≤ x ≤ max(a, b).

Формат ввода
Первая строка содержит два целых числа n (1 ≤ n ≤ 10**5) – число отрезков и m (1 ≤ m ≤ 10**5) – 
число точек. В следующих n строках по два целых числи ai и bi – координаты концов соответствующего
отрезка. В последней строке m целых чисел – координаты точек. Все числа по модулю не превосходят 10**9

Формат вывода
В выходной файл выведите m чисел – для каждой точки количество отрезков, в которых она содержится.
*/

public class DotsAndSegments {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        String[] arr = str.split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);

        int[][] endOfSegment = new int[n*2][2];
        int index = 0;
        int minELem, maxElem;
        while (index < n) {

            str = br.readLine();
            arr = str.split(" ");

            minELem = Math.min(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
            maxElem = Math.max(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));

            endOfSegment[2*index][0] = minELem;
            endOfSegment[2*index][1] = 1;
            endOfSegment[2*index+1][0] = maxElem + 1;
            endOfSegment[2*index+1][1] = -1;

            index++;
        }
        Arrays.sort(endOfSegment, Comparator.comparingInt(ar -> ar[0]));

        str = br.readLine();
        arr = str.split(" ");
        int[] dots = new int[m];
        int[] dots2 = new int[m];

        for (int i = 0; i < m; i++) {
            dots[i] = Integer.parseInt(arr[i]);
            dots2[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(dots);

        int count = 0;
        int pointer1 = 0, pointer2 = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while ((pointer1 < m) && (pointer2 < 2*n)) {

            if (dots[pointer1] < endOfSegment[pointer2][0]) {
                map.put(dots[pointer1], count);
                pointer1++;
            } else {
                count += endOfSegment[pointer2][1];
                pointer2++;
            }
        }
/*
        for (int i = pointer1; i < m; i++) {
            map.put(dots[pointer1], 0);
        }*/

        for (int i = 0; i < dots2.length; i++) {

            if (map.get(dots2[i]) != null)
                System.out.print(map.get(dots2[i]) + " ");
            else
                System.out.print(0 + " ");

        }
        writer.flush();
        writer.close();

    }

}

