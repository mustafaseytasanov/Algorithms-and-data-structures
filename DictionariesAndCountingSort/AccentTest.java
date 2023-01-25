import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalTime;
import java.util.*;

/*
Учительница задала Пете домашнее задание — в заданном тексте расставить ударения в словах, после чего поручила 
Васе проверить это домашнее задание. Вася очень плохо знаком с данной темой, поэтому он нашел словарь, в котором 
указано, как ставятся ударения в словах. К сожалению, в этом словаре присутствуют не все слова. Вася решил, 
что в словах, которых нет в словаре, он будет считать, что Петя поставил ударения правильно, если в этом слове
Петей поставлено ровно одно ударение. Оказалось, что в некоторых словах ударение может быть поставлено больше, 
чем одним способом. Вася решил, что в этом случае если то, как Петя поставил ударение, соответствует одному из
приведенных в словаре вариантов, он будет засчитывать это как правильную расстановку ударения, а если 
не соответствует, то как ошибку. Вам дан словарь, которым пользовался Вася и домашнее задание, сданное Петей. 
Ваша задача — определить количество ошибок, которое в этом задании насчитает Вася.

Формат ввода
Вводится сначала число N — количество слов в словаре (0≤N≤20000). Далее идет N строк со словами из словаря. 
Каждое слово состоит не более чем из 30 символов. Все слова состоят из маленьких и заглавных латинских букв. 
В каждом слове заглавная ровно одна буква — та, на которую попадает ударение. Слова в словаре расположены в 
алфавитном порядке. Если есть несколько возможностей расстановки ударения в одном и том же слове, то эти 
варианты в словаре идут в произвольном порядке. Далее идет упражнение, выполненное Петей. Упражнение 
представляет собой строку текста, суммарным объемом не более 300000 символов. Строка состоит из слов, 
которые разделяются между собой ровно одним пробелом. Длина каждого слова не превышает 30 символов. 
Все слова состоят из маленьких и заглавных латинских букв (заглавными обозначены те буквы, над которыми Петя 
поставил ударение). Петя мог по ошибке в каком-то слове поставить более одного ударения или не поставить ударения вовсе.

Формат вывода
Выведите количество ошибок в Петином тексте, которые найдет Вася.
*/

public class AccentTest {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        Map<String, Set<Integer>> map = new HashMap<>();
        String str = br.readLine();
        int length = Integer.parseInt(str);
        Set<Integer> set;
        while (length != 0) {

            str = br.readLine();
            set = map.get(str.toLowerCase());
            if (set == null)
                set = new HashSet<>();

            for (int i = 0; i < str.length(); i++) {
                if (((int) str.charAt(i) >= (int) 'A') && ((int) str.charAt(i) <= (int) 'Z')) {
                    set.add(i);
                    map.put(str.toLowerCase(), set);
                }
            }
            length--;
        }
        
        Integer numberOfMistakes = 0;
        str = br.readLine();
        if (Objects.equals(str, "")) {
            writer.write(numberOfMistakes.toString());
            writer.flush();
            writer.close();
            return;
        }

        String[] arr = str.split(" ");
        int big, idx = 0;
        char ch;
        String str2;
        for (int i=0; i<arr.length; i++) {

            big = 0;
            for (int j = 0; j < arr[i].length(); j++) {
                ch = arr[i].charAt(j);
                if (((int) ch >= (int) 'A') && ((int) ch <= (int) 'Z')) {
                    big++;
                    idx = j;
                }
            }

            str2 = arr[i].toLowerCase();

            if (big != 1) {
                numberOfMistakes++;
            } else {
                if (map.containsKey(str2)) {
                    if (!(map.get(str2).contains(idx))) {
                        numberOfMistakes++;
                    }
                }
            }

        }


        writer.write(numberOfMistakes.toString());
        writer.flush();
        writer.close();

    }
}
