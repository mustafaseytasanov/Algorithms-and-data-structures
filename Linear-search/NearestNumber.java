import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/*
Напишите программу, которая находит в массиве элемент, самый близкий по величине к  данному числу.

Формат ввода
В первой строке задается одно натуральное число N, не превосходящее 1000 – размер массива. 
Во второй строке содержатся N чисел – элементы массива (целые числа, не превосходящие по модулю 1000). В третьей строке 
вводится одно целое число x, не превосходящее по модулю 1000.

Формат вывода
Вывести значение элемента массива, ближайшее к x. Если таких чисел несколько, выведите любое из них.
*/

public class NearestNumber {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        int length = Integer.parseInt(str);
        str = br.readLine();
        String[] arr = str.split(" ");
        int[] newArr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = Integer.parseInt(arr[i]);
        }
        str = br.readLine();
        int x = Integer.parseInt(str);
        Integer answer = newArr[0];
        int diff = Math.abs(answer - x);

        for (int i = 1; i < length; i++) {
            int abs = Math.abs(newArr[i] - x);
            if (abs < diff) {
                answer = newArr[i];
                diff = abs;
            }
        }
        
        writer.write(answer.toString());
        writer.flush();
        writer.close();
    }

}

