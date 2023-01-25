import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
Во входном файле (вы можете читать данные из файла input.txt) записан текст. Словом считается 
последовательность непробельных символов идущих подряд, слова разделены одним или большим числом пробелов или 
символами конца строки. Для каждого слова из этого текста подсчитайте, сколько раз оно встречалось в этом тексте ранее.

Формат ввода
Вводится текст.

Формат вывода
Выведите ответ на задачу.
*/

public class WordOccurrenceNumber {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String[] arr;
        String str = br.readLine();
        Map<String, Integer> map = new HashMap<>();
        Integer val;
        while (str != null) {

            if (str.equals(""))
                break;
            arr = str.split(" ");
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != "") {
                    val = map.get(arr[i]);
                    if (val == null) {
                        writer.write(0 + " ");
                        map.put(arr[i], 1);
                    } else {
                        writer.write(val + " ");
                        map.put(arr[i], val+1);
                    }
                }
            }
            str = br.readLine();
        }

        writer.flush();
        writer.close();
    }
}
