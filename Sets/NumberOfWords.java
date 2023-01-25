import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
Во входном файле (вы можете читать данные из sys.stdin, подключив библиотеку sys) записан текст. Словом 
считается последовательность непробельных символов идущих подряд, слова разделены одним или большим числом пробелов или 
символами конца строки. Определите, сколько различных слов содержится в этом тексте.

Формат ввода
Вводится текст.

Формат вывода
Выведите ответ на задачу.
*/

public class NumberOfWords {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        String[] arr;
        Set<String> set1 = new HashSet<>();
        while (str != null) {
            arr = str.split(" ");
            for (int i=0; i<arr.length; i++) {
                if (arr[i] != "")
                    set1.add(arr[i]);
            }
            str = br.readLine();
        }

        set1.remove("");
        Integer size = set1.size();
        writer.write(size.toString());
        writer.flush();
        writer.close();
    }
}
