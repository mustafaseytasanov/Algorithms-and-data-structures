import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
Вася очень любит везде искать своё счастливое число K. 
Каждый день он ходит в школу по улице, вдоль которой припарковано  N машин. Он заинтересовался 
вопросом, сколько существует наборов машин, стоящих подряд на местах с L до R, что 
сумма их номеров равна K. Помогите Васе узнать ответ на его вопрос.
Например, если число N=5, K=17, а номера машин равны 17, 7, 10, 7, 10, то существует 
4 набора машин:
17 (L=1,R=1),
7, 10 (L=2,R=3),
10, 7 (L=3,R=4),
7, 10 (L=4,R=5)

Формат ввода
В первой строке входных данных задаются числа N и K (1≤N≤100000, 1≤K≤10**9).
Во второй строке содержится N чисел, задающих номера машин. Номера машин могут принимать значения от 
1 до 999 включительно.

Формат вывода
Необходимо вывести одно число — количество наборов.
*/

public class SumOfNumbers {

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
        int[] newArr = new int[N];
        for (int i=0; i < arr.length; i++) {
            newArr[i] = Integer.parseInt(arr[i]);
        }
        int sum = 0;
        Integer result = 0;

        int pointer2 = 0;
        int pointer1 = 0;
        while (pointer2 < N) {

            if (newArr[pointer2] > K) {
                pointer2++;
                pointer1 = pointer2;
                sum = 0;
            } else if (newArr[pointer2] == K) {
                result++;
                pointer2++;
                pointer1 = pointer2;
                sum = 0;
            } else {
                sum += newArr[pointer2];
                if (sum < K) {
                    pointer2++;
                } else if (sum == K) {
                    result++;
                    pointer2++;
                    sum -= newArr[pointer1];
                    pointer1++;
                } else {
                    while (true) {
                        sum -= newArr[pointer1];
                        pointer1++;
                        if (sum == K) {
                            result++;
                            pointer2++;
                            sum -= newArr[pointer1];
                            pointer1++;
                            break;
                        } else if (sum < K) {
                            pointer2++;
                            break;
                        }
                    }

                }
            }


        }

        writer.write(result.toString());


        writer.flush();
        writer.close();
    }
}
