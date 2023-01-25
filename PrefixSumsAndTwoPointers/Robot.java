import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/*
Студенты одного из вузов спроектировали робота для частичной автоматизации процесса 
сборки авиационного двигателя.
В процессе сборки двигателя могут встречаться операции 26 типов, которые обозначаются 
строчными буквами латинского алфавита. Процесс сборки состоит из N операций.
Предполагается использовать робота один раз для выполнения части подряд идущих операций 
из процесса сборки.
Память робота состоит из K ячеек, каждая из которых содержит одну операцию. Операции выполняются 
последовательно, начиная с первой, в том порядке, в котором они расположены в памяти. Выполнив 
последнюю из них, робот продолжает работу с первой. Робота можно остановить после любой операции. 
Использование робота экономически целесообразно, если он выполнит хотя бы K + 1 операцию.
Требуется написать программу, которая по заданному процессу сборки определит количество 
экономически целесообразных способов использования робота.

Формат ввода
В первой строке входного файла записано число K > 0 — количество операций, которые можно 
записать в память робота.
Вторая строка состоит из N > K строчных латинских букв, обозначающих операции — процесс 
сборки двигателя. Операции одного и того же типа обозначаются одной и той же буквой. N ≤ 200000

Формат вывода
Выходной файл должен содержать единственное целое число — количество экономически целесообразных 
способов использования робота.
*/

public class Robot {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        int k = Integer.parseInt(str);
        String operations = br.readLine();

        int count = 0;
        long sum = 0;
        for (int i = 0; i < operations.length() - k; i++) {

            if (operations.charAt(i) == operations.charAt(i+k)) {
                count++;
                sum += count;
            } else {
                count = 0;
            }
        }

        System.out.println(sum);

    }
}
