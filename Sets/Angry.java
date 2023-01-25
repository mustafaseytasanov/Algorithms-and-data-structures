import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
Вы никогда не задумывались, почему в Angry Birds у птиц нет крыльев? Тем же вопросом задались разработчики новой игры. 
В их версии смысл игры прямо противоположен Angry Birds: зеленая свинка стреляет по злым птицам из лазерного ружья 
(завязка явно не хуже исходной игры).
Птицы в игре представляются точками на плоскости. Выстрел сбивает только ближайшую птицу находящуюся на линии огня. 
При этом сбитая птица падая сбивает всех птиц, находящихся ровно под ней. Две птицы не могут находиться в одной точке. 
По заданному расположению птиц необходимо определить, какое минимальное количество выстрелов необходимо, чтобы 
все птицы были сбиты.

Формат ввода
Первая строка входного файла содержит единственное целое число N (1 ≤ N ≤ 1000) — количество птиц.
Следующие N строк содержат по два натуральных числа каждая xi, yi — координаты i-ой птицы (0 < x, y ≤ 10**9). 
Свинка находится в точке с координатами (0, 0).

Формат вывода
Единственная строка выходного файла должна содержать одно целое число — минимальное количество выстрелов, необходимое 
для того, чтобы сбить всех птиц.
*/

public class Angry {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        int amount = Integer.parseInt(str);
        Set<Integer> set = new HashSet<>();
        String[] arr;
        int x;
        while (amount != 0) {

            str = br.readLine();
            arr = str.split(" ");
            x = Integer.parseInt(arr[0]);
            set.add(x);
            amount--;
        }

        Integer result = set.size();
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }
}
