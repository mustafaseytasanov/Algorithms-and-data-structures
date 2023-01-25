import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
Вам дан словарь, состоящий из пар слов. Каждое слово является синонимом к парному ему слову. Все слова в словаре 
различны. Для одного данного слова определите его синоним.

Формат ввода
Программа получает на вход количество пар синонимов N. Далее следует N строк, каждая строка содержит ровно 
два слова-синонима. После этого следует одно слово.

Формат вывода
Программа должна вывести синоним к данному слову. 
*/

public class SynonymDictionary {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        int amount = Integer.parseInt(str);
        String[] arr;
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        while (amount != 0) {
            str = br.readLine();
            arr = str.split(" ");
            map1.put(arr[0], arr[1]);
            map2.put(arr[1], arr[0]);
            amount--;
        }

        String keyString = br.readLine();
        String res = map1.get(keyString);
        if (res != null) {
            writer.write(res);
        } else {
            res = map2.get(keyString);
            writer.write(res);
        }

        writer.flush();
        writer.close();
    }
}
