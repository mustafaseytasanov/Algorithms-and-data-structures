import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
Для строительства двумерной пирамиды используются прямоугольные блоки, каждый из которых 
характеризуется шириной и высотой.
Можно поставить один блок на другой, только если ширина верхнего блока строго меньше ширины нижнего (блоки нельзя поворачивать). 
Самым нижним в пирамиде может быть блок любой ширины.
По заданному набору блоков определите, пирамиду какой наибольшей высоты можно построить из них.

Формат ввода
В первой строке входных данных задается число N — количество блоков (1≤N≤100000).
В следующих N строках задаются пары натуральных чисел  wi и hi (1≤wi,hi≤10**9) — ширина и высота блока соответственно.

Формат вывода
Выведите одно целое число — максимальную высоту пирамиды.
*/

public class Pyramid {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        int amount = Integer.parseInt(str);
        Map<Long, Long> map = new HashMap<>();
        String[] arr;
        Long key, val, val2;

        while (amount != 0) {

            str = br.readLine();
            arr = str.split(" ");
            key = Long.parseLong(arr[0]);
            val = Long.parseLong(arr[1]);

            val2 = map.get(key);
            if (val2 == null) {
                map.put(key, val);
            } else {
                map.put(key, Math.max(val, val2));
            }

            amount--;
        }

        Long result = Long.valueOf(0);
        Set<Long> set = map.keySet();
        for (Long element: set) {
            result += map.get(element);
        }

        writer.write(result.toString());
        writer.flush();
        writer.close();

    }
}
