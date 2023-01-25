import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
Даны два списка чисел, которые могут содержать до 10000 чисел каждый. Выведите все числа, которые 
входят как в первый, так и во второй список в порядке возрастания. Примечание. И даже эту задачу на 
Питоне можно решить в одну строчку.

Формат ввода
Вводятся два списка целых чисел. Все числа каждого списка находятся на отдельной строке.

Формат вывода
Выведите ответ на задачу.
*/

public class IntersectionOfSets {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        String[] arr = str.split(" ");
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < arr.length; i++)
            set1.add(Integer.parseInt(arr[i]));
        str = br.readLine();
        arr = str.split(" ");
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < arr.length; i++)
            set2.add(Integer.parseInt(arr[i]));

        set1.retainAll(set2);
        int[] array = new int[set1.size()];
        int idx = 0;
        for (int elem: set1) {
            array[idx] = elem;
            idx++;
        }
        Arrays.sort(array);
        for (Integer elem: array) {
            writer.write(elem + " ");
        }


        writer.flush();
        writer.close();
    }
}
