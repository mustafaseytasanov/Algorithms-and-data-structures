import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
Реализуйте двоичный поиск в массиве

Формат ввода
В первой строке входных данных содержатся натуральные числа N и K (0<N,K<=100 000). 
Во второй строке задаются N элементов первого массива, а в третьей строке – K элементов второго массива. 
Элементы обоих массивов - целые числа, каждое из которых по модулю не превосходит 10**9

Формат вывода
Требуется для каждого из K чисел вывести в отдельную строку "YES", если это число встречается 
в первом массиве, и "NO" в противном случае.
*/

public class BinarySearch {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");
        
        String str = br.readLine();
        String[] arr = str.split(" ");
        int N = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);

        str = br.readLine();
        arr = str.split(" ");
        int[] firstArray = new int[N];
        for (int i = 0; i < arr.length; i++)
            firstArray[i] = Integer.parseInt(arr[i]);

        str = br.readLine();
        arr = str.split(" ");
        int[] secondArray = new int[K];
        for (int i = 0; i < arr.length; i++)
            secondArray[i] = Integer.parseInt(arr[i]);

        // Implementation
        int l, r, m = 0;
        for (int element: secondArray) {

            l = 0;
            r = N - 1;

            if ((firstArray[0] > element) || (firstArray[N-1] < element)) {
                writer.write("NO\n");
            } else {
                while (l < r) {
                    m = (l + r) / 2;
                    if (element <= firstArray[m]) {
                        r = m;
                    } else {
                        l = m + 1;
                    }
                }
                if (element == firstArray[l])
                    writer.write("YES\n");
                else
                    writer.write("NO\n");
            }
        }


        writer.flush();
        writer.close();
    }
}
