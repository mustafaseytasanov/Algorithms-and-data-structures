import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
Дано N упорядоченных по неубыванию последовательностей целых чисел (т.е. каждый следующий элемент 
больше либо равен предыдущему), в каждой из последовательностей ровно L элементов. Для каждых двух
последовательностей выполняют следующую операцию: объединяют их элементы (в объединенной 
последовательности каждое число будет идти столько раз, сколько раз оно встречалось суммарно в 
объединяемых последовательностях), упорядочивают их по неубыванию и смотрят, какой элемент в этой 
последовательности из 2L элементов окажется на месте номер L (этот элемент называют левой медианой).
Напишите программу, которая для каждой пары последовательностей выведет левую медиану их объединения.

Формат ввода
Сначала вводятся числа N и L (2 ≤ N ≤ 100, 1 ≤ L ≤ 300). В следующих N строках задаются 
последовательности. Каждая последовательность состоит из L чисел, по модулю не превышающих 30000.

Формат вывода
В первой строке выведите медиану объединения 1-й и 2-й последовательностей, во второй 
строке — объединения 1-й и 3-й, и так далее, в (N‑1)-ой строке — объединения 1-й и N-ой 
последовательностей, далее медиану объединения 2-й и 3-й, 2-й и 4-й, и т.д. до 2-й и N-ой,
затем 3-й и 4-й и так далее. В последней строке должна быть выведена медиана объединения
(N–1)-й и N-ой последовательностей.
*/

public class Median {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        String[] arr = str.split(" ");
        int N = Integer.parseInt(arr[0]);
        int L = Integer.parseInt(arr[1]);

        int[][] numbersArray = new int[N][L];

        for (int i = 0; i < numbersArray.length; i++) {

            str = br.readLine();
            arr = str.split(" ");
            for (int j = 0; j < numbersArray[i].length; j++) {
                numbersArray[i][j] = Integer.parseInt(arr[j]);
            }
        }

        int[] array1, array2;
        int p1, p2, result;
        for (int i = 0; i < numbersArray.length - 1; i++) {
            array1 = numbersArray[i];
            for (int j = i+1; j < numbersArray.length; j++) {
                array2 = numbersArray[j];
                p1 = 0;
                p2 = 0;
                result = 0;
                while (p1 + p2 < L) {

                    if (array1[p1] < array2[p2]) {
                        result = array1[p1];
                        p1++;
                    } else {
                        result = array2[p2];
                        p2++;
                    }
                }

                writer.write(result + "\n");

            }
        }


        writer.flush();
        writer.close();
    }
}

