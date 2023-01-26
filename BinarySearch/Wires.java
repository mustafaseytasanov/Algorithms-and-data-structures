import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
Дано N отрезков провода длиной L1, L2, ..., LN сантиметров. Требуется с помощью разрезания получить 
из них K равных отрезков как можно большей длины, выражающейся целым числом сантиметров. Если нельзя 
получить K отрезков длиной даже 1 см, вывести 0.

Формат ввода
В первой строке находятся числа N и К. В следующих N строках - L1, L2, ..., LN, по одному числу в строке.
Ограничения: 1 ≤ N, K ≤ 10 000, 100 ≤ Li ≤ 10 000 000, все числа целые.

Формат вывода
Вывести одно число - полученную длину отрезков.
*/


public class Wires {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        String[] arr = str.split(" ");
        Long N = Long.parseLong(arr[0]);
        Long K = Long.parseLong(arr[1]);

        int i = 0;
        long[] numbersArray = new long[Math.toIntExact(N)];
        long sum = 0;
        while (i < N) {
            str = br.readLine();
            numbersArray[i] = Long.parseLong(str);
            sum += numbersArray[i];
            i++;
        }

        long l = 0;
        long r = sum / K;
        long m;
        long expectK;

        while (l < r) {

            m = (l + r + 1) / 2;
            expectK = 0;
            for (int j = 0; j < numbersArray.length; j++) {
                expectK += numbersArray[j] / m;
            }

            if (expectK < K) {
                r = m - 1;
            } else {
                l = m;
            }
        }

        writer.write(l + "");


        writer.flush();
        writer.close();
    }
}

