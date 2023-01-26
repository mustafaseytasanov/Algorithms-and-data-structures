import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.*;

/*
Экзамен по берляндскому языку проходит в узкой и длинной аудитории. На экзамен пришло 
N студентов. Все они посажены в ряд. Таким образом, позиция каждого человека задается 
координатой на оси Ox (эта ось ведет вдоль длинной аудитории). Два человека могут 
разговаривать, если расстояние между ними меньше или равно D. Какое наименьшее 
количество типов билетов должен подготовить преподаватель, чтобы никакие два 
студента с одинаковыми билетами не могли разговаривать? Выведите способ раздачи 
преподавателем билетов.

Формат ввода
В первой строке входного файла содержится два целых числа N, D (1 ≤ N ≤ 10000; 0 ≤ D ≤ 10**6). 
Вторая строка содержит последовательность различных целых чисел X1, X2, ..., XN, где 
Xi (0 ≤ Xi ≤ 10**6) обозначает координату вдоль оси Ox i-го студента

Формат вывода
В первую строчку выходного файла выведите количество вариантов, а во вторую, 
разделяя пробелами, номера вариантов студентов в том порядке, в каком они перечислены во входном файле.
*/

public class Students {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));

        String str = br.readLine();
        String[] arr = str.split(" ");
        int n = Integer.parseInt(arr[0]);
        int d = Integer.parseInt(arr[1]);

        str = br.readLine();
        arr = str.split(" ");
        int[] positions = new int[n];
        int[] positions2 = new int[n];
        for (int i = 0; i < n; i++) {
            positions[i] = Integer.parseInt(arr[i]);
            positions2[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(positions);


        Map<Integer, Integer>  map = new HashMap<>();
        int[][] positionsWithOptions = new int[n][2];
        for (int i = 0; i < positions.length; i++) {
            positionsWithOptions[i][0] = positions[i];
        }
        positionsWithOptions[0][1] = 1;
        map.put(positionsWithOptions[0][0], 1);

        int maxOption = 1;
        int pointer = 0;
        for (int i = 1; i < positions.length; i++) {

            if (positionsWithOptions[i][0] - positionsWithOptions[pointer][0] <= d) {
                maxOption++;
                positionsWithOptions[i][1] = maxOption;
                map.put(positionsWithOptions[i][0], maxOption);
            } else {
                positionsWithOptions[i][1] = positionsWithOptions[pointer][1];
                map.put(positionsWithOptions[i][0], positionsWithOptions[pointer][1]);
                pointer++;
            }
        }

        System.out.println(maxOption);
        for (int i = 0; i < positions2.length; i++) {
            System.out.print(map.get(positions2[i]) + " ");
        }

    }

}
