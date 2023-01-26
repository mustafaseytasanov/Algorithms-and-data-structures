import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
На первом курсе одной Школы, учится 1 ≤ N ≤ 10**9 студентов. При проведении экзаменов
студентов рассаживают в ряд, каждого за своей партой. Парты пронумерованы числами от 0 до N - 1.
Известно, что студент, оставшись без наблюдения, открывает телефон и начинает искать
ответы на экзамен в поисковике Яндекса.
Поэтому было решено позвать M преподавателей наблюдать за студентами. Когда за студентом
наблюдает хотя бы один преподаватель, он стесняется и не идет искать ответы к экзамену. 
Преподаватель с номером i видит студентов сидящих за партами от bi до ei включительно.
Необходимо посчитать количество студентов, которые все таки будут искать ответы к экзамену 
в Яндексе

Формат ввода
В первой строке находятся два целых числа 1 ≤ N ≤ 10**9, 1 ≤ M ≤ 10**4 — число студентов и 
число преподавателей соответственно. В следующих M строках содержится по два целых числа 
0 ≤ bi ≤ ei ≤ N - 1 — парты, за которыми наблюдает i-й преподаватель.

Формат вывода
Выведите одно число — количество студентов оставшихся без наблюдения.
*/

public class Observation {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        String[] arr = str.split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);

        int[][] array = new int[2*M][2];
        int idx = 0;
        while (idx != M) {

            str = br.readLine();
            arr = str.split(" ");

            array[2*idx][0] = Integer.parseInt(arr[0]);
            array[2*idx][1] = -1;
            array[2*idx+1][0] = Integer.parseInt(arr[1]) + 1;
            array[2*idx+1][1] = 1;

            idx++;
        }
        Arrays.sort(array, Comparator.comparingInt(ar -> ar[0]));
        
        int counter = 0;
        int lastCounter = 0;
        int element;
        int result = 0;
        int lastZeroIndex = 0;

        idx = 0;
        while (idx < 2*M) {

            while (true) {

                element = array[idx][0];
                counter += array[idx][1];

                if (idx < 2*M - 1) {
                    if (element == array[idx + 1][0])
                        idx++;
                    else
                        break;
                } else
                    break;

            }

            if (counter != 0) {
                if (lastCounter == 0) {
                    result += array[idx][0] - lastZeroIndex;
                }
            } else {
                lastZeroIndex = array[idx][0];
            }

            lastCounter = counter;
            idx++;
        }
        result += N - array[2*M-1][0];

        System.out.println(result);

        writer.flush();
        writer.close();
    }
}

