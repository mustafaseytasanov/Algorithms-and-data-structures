import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Организаторы детского праздника планируют надуть для него M воздушных шариков. 
С этой целью они пригласили N добровольных помощников, i-й среди которых надувает шарик 
за Ti минут, однако каждый раз после надувания Zi шариков устает и отдыхает Yi минут. 
Теперь организаторы праздника хотят узнать, через какое время будут надуты все шарики 
при наиболее оптимальной работе помощников, и сколько шариков надует каждый из них. 
(Если помощник надул шарик, и должен отдохнуть, но больше шариков ему надувать не придется, 
то считается, что он закончил работу сразу после окончания надувания последнего шарика, 
а не после отдыха).

Формат ввода
В первой строке входных данных задаются числа M и N (0 ≤ M ≤ 15000, 1 ≤ N ≤ 1000). 
Следующие N строк содержат по три целых числа - Ti, Zi и Yi соответственно (1 ≤ Ti, 
Yi ≤ 100, 1 ≤ Zi ≤ 1000).

Формат вывода
Выведите в первой строке число T - время, за которое будут надуты все шарики. 
Во второй строке выведите N чисел - количество шариков, надутых каждым из 
приглашенных помощников. Разделяйте числа пробелами. Если распределений шариков 
несколько, выведите любое из них.
*/


public class Holiday {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));

        String str = br.readLine();
        String[] arr = str.split(" ");
        int m = Integer.parseInt(arr[0]);
        int n = Integer.parseInt(arr[1]);

        int top = 200 * m;
        top = (int) Math.ceil(top / n);
        int i = 0;
        int number, count;
        List<Integer> list = new ArrayList<>();
        while (i < n) {
            str = br.readLine();
            arr = str.split(" ");
            int t = Integer.parseInt(arr[0]);
            int z = Integer.parseInt(arr[1]);
            int y = Integer.parseInt(arr[2]);
            number = 0;
            while (number <= top) {
                count = z;
                while (count != 0) {
                    number += t;
                    list.add(number);
                    list.add(i);
                    count--;
                }
                number += y;
            }
            i++;
        }

        int[][] balls = new int[list.size()/2][2];
        for (int j = 0; j < balls.length; j++) {
            balls[j][0] = list.get(j*2);
            balls[j][1] = list.get(j*2+1);
        }

        Arrays.sort(balls, Comparator.comparingInt(ar -> ar[0]));

        int time = 0;
        int remainder = m;
        int[] result = new int[n];
        int idx = 0;
        while (remainder != 0) {
            result[balls[idx][1]] += 1;
            time = balls[idx][0];
            idx++;
            remainder--;
        }
        System.out.println(time);
        for (int elem: result) {
            System.out.print(elem + " ");
        }

    }
}
