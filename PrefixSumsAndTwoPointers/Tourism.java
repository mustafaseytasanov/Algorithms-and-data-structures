import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

/*
Александр недавно увлекся горным туризмом. Ему уже надоело покорять отдельные горные пики, и 
он собирается покорить самую настоящую горную цепь!
Напомним, что Александр живет в плоском мире. Горная цепь состоит из отрезков, соединяющих точки 
на плоскости, каждая из которых находится строго правее предыдущей (x-координата следующей точки 
больше, чем у предыдущей). Трассой на горной цепи называется её часть между двумя фиксированными концами отрезков.
Участок, на котором при движении по трассе координата y (высота) всегда возрастает, называется подъемом, 
величиной подъема называется разность высот между начальной и конечной точками участка.
Туристическая компания предлагает на выбор несколько трасс на одной горной цепи. Александр 
из-за финансовых трудностей может выбрать для поездки только одну из этих трасс. Вы решили 
помочь ему с выбором. Александру важно для каждой трассы определить суммарную высоту подъемов 
на ней. Обратите внимание, что трасса может идти как слева-направо, так и справа-налево.

Формат ввода
В первой строке входного файла содержится единственное число N — количество точек ломаной, 
задающей горную цепь (1 ≤ N ≤ 30 000). Далее в N строках содержатся описания точек, каждое 
из которых состоит из двух целых чисел, xi и yi (1 ≤ xi, yi ≤ 30 000).
В следующей строке находится число M — количество трасс (1 ≤ M ≤ 30 000).
Далее в M строках содержатся описания трасс. Каждое описание представляет собой 
два целых числа, si и fi, они обозначают номера вершин начала и конца трассы, 
соответственно (1 ≤ si ≤ N, 1 ≤ fi ≤ N). Начало и конец трассы могут совпадать.
Гарантируется, что во входном файле задана именно горная цепь.

Формат вывода
Для каждой трассы выведите одно число — суммарную высоту подъемов на данной трассе.
*/

public class Tourism {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");


        String str = br.readLine();
        int n = Integer.parseInt(str);

        int[] heightsUp = new int[n-1];
        int[] heightsDown = new int[n-1];
        int index = 1;
        int y, oldY;
        String[] arr;
        str = br.readLine();
        arr = str.split(" ");
        oldY = Integer.parseInt(arr[1]);

        while (index != n) {

            str = br.readLine();
            arr = str.split(" ");
            y = Integer.parseInt(arr[1]);

            if (y > oldY)
                heightsUp[index-1] = y - oldY;
            else
                heightsDown[index-1] = oldY - y;

            oldY = y;
            index++;
        }

        long[] prefixSum1 = new long[n];
        long[] prefixSum2 = new long[n];

        prefixSum1[0] = 0;
        prefixSum2[0] = 0;

        for (int i = 0; i < n-1; i++) {
            prefixSum1[i+1] = prefixSum1[i] + heightsUp[i];
            prefixSum2[i+1] = prefixSum2[i] + heightsDown[i];
        }

        str = br.readLine();
        int m = Integer.parseInt(str);

        int s, f;
        while (m != 0) {

            str = br.readLine();
            arr = str.split(" ");
            s = Integer.parseInt(arr[0]);
            f = Integer.parseInt(arr[1]);

            if (s < f) {
                System.out.println(prefixSum1[f-1] - prefixSum1[s-1]);
            } else {
                System.out.println(prefixSum2[s-1] - prefixSum2[f-1]);
            }

            m--;
        }

    }
}
