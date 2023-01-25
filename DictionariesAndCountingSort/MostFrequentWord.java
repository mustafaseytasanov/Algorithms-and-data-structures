import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
Дан текст. Выведите слово, которое в этом тексте встречается чаще всего. Если таких слов несколько, 
выведите то, которое меньше в лексикографическом порядке.

Формат ввода
Вводится текст.

Формат вывода
Выведите ответ на задачу.
*/

public class MostFrequentWord {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String[] arr;
        String str = br.readLine();
        Map<String, Integer> map = new HashMap<>();
        Integer val, maxValue = 0;
        while (str != null) {

            arr = str.split(" ");
            for (int i=0; i<arr.length; i++) {

                if (arr[i] != "") {
                    val = map.get(arr[i]);
                    if (val == null) {
                        val = 1;
                    } else {
                        val++;
                    }
                    map.put(arr[i], val);
                    maxValue = Math.max(maxValue, val);
                }
            }

            str = br.readLine();
        }

        Set<String> keySet = map.keySet();
        List<String> list = new ArrayList<>();
        for (String key: keySet) {
            val = map.get(key);
            if (Objects.equals(val, maxValue)) {
                list.add(key);
            }
        }

        Collections.sort(list);
        if (list.size() > 0)
            writer.write(list.get(0));
        else
            writer.write("");

        writer.flush();
        writer.close();

    }
}

