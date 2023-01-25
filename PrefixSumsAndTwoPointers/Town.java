import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
В центре города Че есть пешеходная улица - одно из самых популярных мест для прогулок жителей города. 
По этой улице очень приятно гулять, ведь вдоль улицы расположено n забавных памятников.
Девочке Маше из города Че нравятся два мальчика из ее школы, и она никак не может сделать выбор 
между ними. Чтобы принять окончательное решение, она решила назначить обоим мальчикам свидание в одно 
и то же время. Маша хочет выбрать два памятника на пешеходной улице, около которых мальчики будут ее ждать. 
При этом она хочет выбрать такие памятники, чтобы мальчики не увидели друг друга. Маша знает, что из-за 
тумана мальчики увидят друг друга только в том случае, если они будут на расстоянии не более r метров.
Маше заинтересовалась, а сколько способов есть выбрать два различных памятника для организации свиданий.

Формат ввода
В первой строке входного файла находятся два целых числа n и r (2 ≤ n ≤ 300000, 1 ≤ r ≤ 10**9) - количество 
памятников и максимальное расстояние, на котором мальчики могут увидеть друг друга.
Во второй строке задано n положительных чисел d1, …, dn, где di - расстояние от i-го памятника 
до начала улицы. Все памятники находятся на разном расстоянии от начала улицы. Памятники приведены 
в порядке возрастания расстояния от начала улицы (1 ≤ d1, d2, …, dn ≤ 10**9).

Формат вывода
Выведите одно число - число способов выбрать два памятника для организации свиданий.
*/

public class Town {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");


        String str = br.readLine();
        String[] arr = str.split(" ");
        int n = Integer.parseInt(arr[0]);
        long r = Long.parseLong(arr[1]);
        str = br.readLine();
        arr = str.split(" ");
        long[] monuments = new long[n];
        for (int i=0; i<arr.length; i++)
            monuments[i] = Long.parseLong(arr[i]);

        // Impl
        int pointer1 = 0, pointer2 = 1;
        long diff;
        Long result = Long.valueOf(0);
        while (true) {

            diff = monuments[pointer2] - monuments[pointer1];
            if (diff > r) {
                result += monuments.length - pointer2;
                pointer1++;
            } else {
                if (pointer2 < monuments.length-1)
                    pointer2++;
                else
                    break;
            }
        }

        writer.write(result.toString());
        writer.flush();
        writer.close();
    }
}

