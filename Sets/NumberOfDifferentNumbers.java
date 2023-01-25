import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
Дан список чисел, который может содержать до 100000 чисел. Определите, сколько в нем 
встречается различных чисел.

Формат ввода
Вводится список целых чисел. Все числа списка находятся на одной строке.

Формат вывода
Выведите ответ на задачу.
*/


public class NumberOfDifferentNumbers {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        String[] arr = str.split(" ");
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++)
            set.add(Integer.parseInt(arr[i]));

        Integer result = set.size();
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }
}
