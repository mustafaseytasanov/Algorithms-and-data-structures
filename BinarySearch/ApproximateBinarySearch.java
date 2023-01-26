import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
Для каждого из чисел второй последовательности найдите ближайшее к нему в первой.

Формат ввода
В первой строке входных данных содержатся числа N и K (0 < N, K < 100 001). Во второй строке задаются N чисел 
первого массива, отсортированного по неубыванию, а в третьей строке – K чисел второго массива. 
Каждое число в обоих массивах по модулю не превосходит 2*10**9.

Формат вывода
Для каждого из K чисел выведите в отдельную строку число из первого массива, наиболее близкое к данному. 
Если таких несколько, выведите меньшее из них.
*/

public class ApproximateBinarySearch {

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

            while (l < r) {
                m = (l + r + 1) / 2;
                if (element < firstArray[m]) {
                    r = m - 1;
                } else {
                    l = m;
                }
            }

            if (l+1 <= N-1) {
                if ((firstArray[l+1] - element) < (element - firstArray[l])) {
                    writer.write(firstArray[l+1] + "\n");
                } else {
                    writer.write(firstArray[l] + "\n");
                }
            } else {
                writer.write(firstArray[l] + "\n");
            }
        }


        writer.flush();
        writer.close();
    }
}
