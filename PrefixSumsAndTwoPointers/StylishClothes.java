import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
Глеб обожает шоппинг. Как-то раз он загорелся идеей подобрать себе майку и штаны так, чтобы выглядеть в них 
максимально стильно. В понимании Глеба стильность одежды тем больше, чем меньше разница в цвете элементов его одежды.
В наличии имеется N (1 ≤ N ≤ 100 000) маек и M (1 ≤ M ≤ 100 000) штанов, про каждый элемент 
известен его цвет (целое число от 1 до 10 000 000). Помогите Глебу выбрать одну майку и одни штаны так, 
чтобы разница в их цвете была как можно меньше.

Формат ввода
Сначала вводится информация о майках: в первой строке целое число N (1 ≤ N ≤ 100 000) и во второй 
N целых чисел от 1 до 10 000 000 — цвета имеющихся в наличии маек. Гарантируется, что номера цветов идут 
в возрастающем порядке (в частности, цвета никаких двух маек не совпадают).
Далее в том же формате идёт описание штанов: их количество M (1 ≤ M ≤ 100 000) и в следующей строке 
M целых чисел от 1 до 10 000 000 в возрастающем порядке — цвета штанов.

Формат вывода
Выведите пару неотрицательных чисел — цвет майки и цвет штанов, которые следует выбрать Глебу. 
Если вариантов выбора несколько, выведите любой из них.
*/

public class StylishClothes {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");


        String str = br.readLine();
        int N = Integer.parseInt(str);
        str = br.readLine();
        String[] arr = str.split(" ");
        int[] tShirts = new int[N];
        for (int i=0; i<arr.length; i++)
            tShirts[i] = Integer.parseInt(arr[i]);
        str = br.readLine();
        int M = Integer.parseInt(str);
        str = br.readLine();
        arr = str.split(" ");
        int[] pants = new int[M];
        for (int i=0; i<arr.length; i++)
            pants[i] = Integer.parseInt(arr[i]);

        // Impl
        Integer result1 = tShirts[0],
                result2 = pants[0];
        int pointer1 = 0, pointer2 = 0;
        int diff = Math.abs(result1 - result2);
        int element1, element2;
        while (true) {

            element1 = tShirts[pointer1];
            element2 = pants[pointer2];

            if ((pointer1 < N-1) && (pointer2 < M-1)) {
                if (element1 > element2) {
                    pointer2++;
                } else {
                    pointer1++;
                }
            } else if ((pointer2 == M-1) && (pointer1 < N-1)) {
                pointer1++;
            } else if ((pointer1 == N-1) && (pointer2 < M-1)) {
                pointer2++;
            } else {
                break;
            }

            if (Math.abs(tShirts[pointer1] - pants[pointer2]) < diff) {
                result1 = tShirts[pointer1];
                result2 = pants[pointer2];
                diff = Math.abs(result1 - result2);
            }


        }

        writer.write(result1 + " " + result2);

        writer.flush();
        writer.close();
    }
}



