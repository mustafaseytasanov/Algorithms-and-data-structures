import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
Геном жителей системы Тау Кита содержит 26 видов оснований, для обозначения которых будем использовать
буквы латинского алфавита от A до Z, а сам геном записывается строкой из латинских букв. Важную роль в геноме играют пары 
соседних оснований, например, в геноме «ABBACAB» можно выделить следующие пары оснований: AB, BB, BA, AC, CA, AB.
Степенью близости одного генома другому геному называется количество пар соседних оснований первого генома, которые 
встречаются во втором геноме.
Вам даны два генома, определите степень близости первого генома второму геному. Программа получает на вход 
две строки, состоящие из заглавных латинских букв. Каждая строка непустая, и её длина не превосходит 105.
Программа должна вывести одно целое число – степень близости генома, записанного в первой строке, 
геному, записанному во второй строке.
*/

public class Genome {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        // str1
        String str = br.readLine();
        String[] arr = new String[str.length()-1];
        for (int i = 0; i < str.length()-1; i++) {
            arr[i] = str.substring(i, i+2);
        }
        // str2
        str = br.readLine();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < str.length()-1; i++) {
            set.add(str.substring(i, i+2));
        }

        // Solution
        Integer result = 0;
        for (String element: arr) {
            if (set.contains(element))
                result++;
        }

        writer.write(result.toString());
        writer.flush();
        writer.close();
    }
}
