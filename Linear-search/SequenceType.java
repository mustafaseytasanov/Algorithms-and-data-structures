import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
По последовательности чисел во входных данных определите ее вид:

CONSTANT – последовательность состоит из одинаковых значений
ASCENDING – последовательность является строго возрастающей
WEAKLY ASCENDING – последовательность является нестрого возрастающей
DESCENDING – последовательность является строго убывающей
WEAKLY DESCENDING – последовательность является нестрого убывающей
RANDOM – последовательность не принадлежит ни к одному из вышеупомянутых типов

Формат ввода
По одному на строке поступают числа последовательности ai, |ai| ≤ 10**9.
Признаком окончания последовательности является число -2× 10**9. Оно в последовательность не входит.

Формат вывода
В единственной строке выведите тип последовательности.
*/

public class SequenceType {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str;
        int seqEnd = -2_000_000_000;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (true) {
            str = br.readLine();
            int num = Integer.parseInt(str);
            if (num == seqEnd)
                break;
            arrayList.add(num);
        }




        if ((str = isConstant(arrayList)) != null) {
            writer.write(str);
        } else if ((str = isAscending(arrayList)) != null) {
            writer.write(str);
        } else if ((str = isWeaklyAscending(arrayList)) != null) {
            writer.write(str);
        } else if ((str = isDescending(arrayList)) != null) {
            writer.write(str);
        } else if ((str = isWeaklyDescending(arrayList)) != null) {
            writer.write(str);
        } else {
            writer.write("RANDOM");
        }

        writer.flush();
        writer.close();
    }


    public static String isWeaklyDescending(ArrayList<Integer> arrayList) {
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i) > arrayList.get(i-1))
                return null;
        }
        return "WEAKLY DESCENDING";
    }

    public static String isDescending(ArrayList<Integer> arrayList) {
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i) >= arrayList.get(i-1))
                return null;
        }
        return "DESCENDING";
    }


    public static String isWeaklyAscending(ArrayList<Integer> arrayList) {
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i) < arrayList.get(i-1))
                return null;
        }
        return "WEAKLY ASCENDING";
    }


    public static String isAscending(ArrayList<Integer> arrayList) {
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i) <= arrayList.get(i-1))
                return null;
        }
        return "ASCENDING";
    }

    public static String isConstant(ArrayList<Integer> arrayList) {

        for (int i = 1; i < arrayList.size(); i++) {
            if (!Objects.equals(arrayList.get(i), arrayList.get(i - 1)))
                return null;
        }
        return "CONSTANT";
    }

}

