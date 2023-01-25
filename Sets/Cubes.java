import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
Аня и Боря любят играть в разноцветные кубики, причем у каждого из них свой набор и в каждом наборе все кубики различны по цвету. 
Однажды дети заинтересовались, сколько существуют цветов таких, что кубики каждого цвета присутствуют в 
обоих наборах. Для этого они занумеровали все цвета 
случайными числами. На этом их энтузиазм иссяк, поэтому вам предлагается помочь им в оставшейся части. 
Номер любого цвета — это целое число в пределах от 0 до 10**9.

Формат ввода
В первой строке входного файла записаны числа N и M — количество кубиков у Ани и Бори соответственно. В следующих N строках 
заданы номера цветов кубиков Ани. В последних M строках номера цветов кубиков Бори.

Формат вывода
Выведите сначала количество, а затем отсортированные по возрастанию номера цветов таких, что кубики каждого цвета 
есть в обоих наборах, затем количество и отсортированные по возрастанию номера остальных цветов у Ани, потом количество и 
отсортированные по возрастанию номера остальных цветов у Бори.
*/

public class Cubes {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        String[] arr = str.split(" ");
        int anya = Integer.parseInt(arr[0]);
        int borya = Integer.parseInt(arr[1]);
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < anya; i++) {
            str = br.readLine();
            set1.add(Integer.parseInt(str));
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < borya; i++) {
            str = br.readLine();
            set2.add(Integer.parseInt(str));
        }
        // 1
        Set<Integer> set3 = new HashSet<>(set1);
        set3.retainAll(set2);
        int[] array = new int[set3.size()];
        int idx = 0;
        for (int elem: set3) {
            array[idx] = elem;
            idx++;
        }
        Arrays.sort(array);
        Integer size = set3.size();
        writer.write(size + "\n");
        for (Integer elem: array) {
            writer.write(elem + " ");
        }
        writer.write("\n");
        // 2
        Set<Integer> set4 = new HashSet<>(set1);
        set4.removeAll(set2);
        int[] array2 = new int[set4.size()];
        idx = 0;
        for (int elem: set4) {
            array2[idx] = elem;
            idx++;
        }
        Arrays.sort(array2);
        size = set4.size();
        writer.write(size + "\n");
        for (Integer elem: array2) {
            writer.write(elem + " ");
        }
        writer.write("\n");

        // 3
        Set<Integer> set5 = new HashSet<>(set2);
        set5.removeAll(set1);
        int[] array3 = new int[set5.size()];
        idx = 0;
        for (int elem: set5) {
            array3[idx] = elem;
            idx++;
        }
        Arrays.sort(array3);
        size = set5.size();
        writer.write(size + "\n");
        for (Integer elem: array3) {
            writer.write(elem + " ");
        }


        writer.flush();
        writer.close();
    }
}
