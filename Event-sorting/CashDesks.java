import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
На одном из московских вокзалов билеты продают N касс. Каждая касса работает без перерыва 
определенный промежуток времени по фиксированному расписанию (одному и тому же каждый день). 
Требуется определить, на протяжении какого времени в течение суток работают все кассы
одновременно.

Формат ввода
Сначала вводится одно целое число N (0 < N ≤ 1000).
В каждой из следующих N строк через пробел расположены 4 целых числа, первые два из 
которых обозначают время открытия кассы в часах и минутах (часы — целое число от 0 до 23, 
минуты — целое число от 0 до 59), оставшиеся два — время закрытия в том же формате. 
Числа разделены пробелами.
Время открытия означает, что в соответствующую ему минуту касса уже работает, 
а время закрытия — что в соответствующую минуту касса уже не работает. Например, 
касса, открытая с 10 ч. 30 мин. до 18 ч. 30 мин., ежесуточно работает 480 минут.
Если время открытия совпадает с временем закрытия, то касса работает круглосуточно. 
Если первое время больше второго, то касса начинает работу до полуночи, а 
заканчивает — на следующий день.

Формат вывода
Требуется вывести одно число — суммарное время за сутки (в минутах), на протяжении 
которого работают все N касс.
*/

public class CashDesks {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));

        String str = br.readLine();
        int n = Integer.parseInt(str);
        int index = 0;
        String[] arr;
        Map<Integer, Integer> map = new HashMap<>();
        int h1, m1, h2, m2;
        int time1, time2;
        Integer key;
        while (index < n) {

            str = br.readLine();
            arr = str.split(" ");
            h1 = Integer.parseInt(arr[0]);
            m1 = Integer.parseInt(arr[1]);
            h2 = Integer.parseInt(arr[2]);
            m2 = Integer.parseInt(arr[3]);

            time1 = h1 * 60 + m1;
            time2 = h2 * 60 + m2;

            if (time1 < time2) {
                key = map.get(time1);
                if (key == null)
                    key = 0;
                map.put(time1, key+1);
                key = map.get(time2);
                if (key == null)
                    key = 0;
                map.put(time2, key-1);
            } else if (time1 == time2) {
                key = map.get(0);
                if (key == null)
                    key = 0;
                map.put(0, key+1);
                key = map.get(1440);
                if (key == null)
                    key = 0;
                map.put(1440, key-1);
            } else {
                key = map.get(time1);
                if (key == null)
                    key = 0;
                map.put(time1, key+1);
                key = map.get(1440);
                if (key == null)
                    key = 0;
                map.put(1440, key-1);
                key = map.get(0);
                if (key == null)
                    key = 0;
                map.put(0, key+1);
                key = map.get(time2);
                if (key == null)
                    key = 0;
                map.put(time2, key-1);
            }


            index++;
        }

        int[][] visits = new int[map.size()][2];
        Set<Integer> set = map.keySet();

        int idx = 0;
        for (int element: set) {
            visits[idx][0] = element;
            visits[idx][1] = map.get(element);
            idx++;
        }
        Arrays.sort(visits, Comparator.comparingInt(ar -> ar[0]));

        int count = 0;
        int[][] visits2 = new int[visits.length][2];
        for (int i = 0; i < visits.length; i++) {
            count += visits[i][1];
            visits2[i][0] = visits[i][0];
            visits2[i][1] = count;
        }

        index = 0;
        int result = 0;
        int saveTime = 0;
        boolean flag = false;
        while (index < visits2.length) {

            if (flag == false) {
                if (visits2[index][1] == n) {
                    saveTime = visits2[index][0];
                    flag = true;
                }
            } else {
                result += visits2[index][0] - saveTime;
                flag = false;
            }

            index++;
        }

        System.out.println(result);

    }
}
