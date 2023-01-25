import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
В новой программе OpenCalculator появилась новая возможность – можно настроить, 
какие кнопки отображаются, а какие – нет. Если кнопка не отображается на экране, то ввести соответствующую цифру с 
клавиатуры или копированием из другой программы нельзя. Петя настроил калькулятор так, что он отображает только кнопки с цифрами x, y, z. 
Напишите программу, определяющую, сможет ли Петя ввести число N, а если нет, то какое минимальное количество кнопок надо 
дополнительно отобразить на экране для его ввода.

Формат ввода
Сначала вводятся три различных числа из диапазона от 0 до 9: x, y и z (числа разделяются пробелами). Далее вводится целое 
неотрицательное число N, которое Петя хочет ввести в калькулятор. Число N не превышает 10000.

Формат вывода
Выведите, какое минимальное количество кнопок должно быть добавлено для того, чтобы можно было ввести число N (если число может 
быть введено с помощью уже имеющихся кнопок, выведите 0)
*/


public class OpenCalculator {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        String[] arr = str.split(" ");
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++)
            set.add(Integer.parseInt(arr[i]));
        str = br.readLine();
        int element;
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            element = Integer.parseInt(String.valueOf(str.charAt(i)));
            set2.add(element);
        }
        set2.removeAll(set);
        Integer size = set2.size();
        writer.write(size.toString());
        writer.flush();
        writer.close();
    }
}
