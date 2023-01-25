import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
В этой задаче Вам требуется найти максимальную по длине подстроку данной строки, такую 
что каждый символ встречается в ней не более k раз.

Формат ввода
В первой строке даны два целых числа n и k (1 ≤ n ≤ 100000, 1 ≤ k ≤ n ) , где n – количество 
символов в строке. Во второй строке n символов – данная строка, состоящая только из строчных латинских букв.

Формат вывода
В выходной файл выведите два числа – длину искомой подстроки и номер её первого символа. 
Если решений несколько, выведите любое.
*/

public class Substring {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");


        String str = br.readLine();
        String[] arr = str.split(" ");

        int length = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);

        str = br.readLine();

        Map<Character, Integer> map = new HashMap<>();

        int maxValue = 1;
        int pointer1 = 1, pointer2 = 0;
        map.put(str.charAt(0), 1);
        char ch;

        Integer result1 = 0, result2 = 0;

        while (pointer1 < length) {

            ch = str.charAt(pointer1);

            if (map.get(ch) == null) {
                map.put(ch, 1);
            } else {

                if (map.get(ch) < k)
                    map.put(ch, map.get(ch) + 1);
                else {

                    map.put(ch, map.get(ch) + 1);

                    if (pointer1 - pointer2 > result1) {
                        result1 = pointer1 - pointer2;
                        result2 = pointer2 + 1;
                    }

                    while (true) {

                        map.put(str.charAt(pointer2), map.get(str.charAt(pointer2)) - 1);
                        pointer2++;
                        if (str.charAt(pointer2 - 1) == ch) {
                            break;
                        }


                    }

                }

            }


            pointer1++;
        }

        if (pointer1 - pointer2 > result1) {
            result1 = pointer1 - pointer2;
            result2 = pointer2 + 1;
        }

        writer.write(result1 + " " + result2);

        writer.flush();
        writer.close();
    }
}
