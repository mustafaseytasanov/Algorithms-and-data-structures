import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
Дан список, заполненный произвольными целыми числами. Найдите в этом списке два числа, 
произведение которых максимально. Выведите эти числа в порядке неубывания.
Список содержит не менее двух элементов. Числа подобраны так, что ответ однозначен.
Решение должно иметь сложность O(n), где n - размер списка.
*/

public class TwoNumbers {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        String[] arr = str.split(" ");
        List<Long> arrayList = new ArrayList<>();
        List<Long> arrayList2 = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arrayList.add(Long.parseLong(arr[i]));
            arrayList2.add(Long.parseLong(arr[i]));
        }
        // 1
        Long max1 = arrayList.get(0);
        int idx = 0;
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i) > max1) {
                max1 = arrayList.get(i);
                idx = i;
            }
        }
        arrayList.remove(idx);
        Long max2 = arrayList.get(0);
        idx = 0;
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i) > max2) {
                max2 = arrayList.get(i);
                idx = i;
            }
        }
        arrayList.remove(idx);

        // 2
        Long min1 = arrayList2.get(0);
        idx = 0;
        for (int i = 1; i < arrayList2.size(); i++) {
            if (arrayList2.get(i) < min1) {
                min1 = arrayList2.get(i);
                idx = i;
            }
        }
        arrayList2.remove(idx);
        Long min2 = arrayList2.get(0);
        idx = 0;
        for (int i = 1; i < arrayList2.size(); i++) {
            if (arrayList2.get(i) < min2) {
                min2 = arrayList2.get(i);
                idx = i;
            }
        }
        arrayList2.remove(idx);

        if (max1 * max2 >= min1 * min2) {
            writer.write(max2 + " ");
            writer.write(max1.toString());
        } else {
            writer.write(min1 + " ");
            writer.write(min2.toString());
        }

        writer.flush();
        writer.close();
    }
}
