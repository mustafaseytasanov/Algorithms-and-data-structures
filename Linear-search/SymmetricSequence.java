import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
Последовательность чисел назовем симметричной, если она одинаково читается как слева направо, 
так и справа налево. Например, следующие последовательности являются симметричными:
1 2 3 4 5 4 3 2 1
1 2 1 2 2 1 2 1
Вашей программе будет дана последовательность чисел. Требуется определить, какое минимальное количество и 
каких чисел надо приписать в конец этой последовательности, чтобы она стала симметричной.

Формат ввода
Сначала вводится число N — количество элементов исходной последовательности (1 ≤ N ≤ 100). Далее идут N чисел — 
элементы этой последовательности, натуральные числа от 1 до 9.

Формат вывода
Выведите сначала число M — минимальное количество элементов, которое надо дописать к последовательности, а потом 
M чисел (каждое — от 1 до 9) — числа, которые надо дописать к последовательности.
*/

public class SymmetricSequence {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        int N = Integer.parseInt(str);
        str = br.readLine();
        String[] arr = str.split(" ");
        int[] sequence = new int[N];
        for (int i = 0; i < arr.length; i++) {
            sequence[i] = Integer.parseInt(arr[i]);
        }


        boolean isRightSequence = true;

        int[] inBackOrder = new int[N];
        for (int i = 0; i < N; i++) {
            inBackOrder[i] = sequence[N-1-i];
        }

        if (Arrays.equals(sequence, inBackOrder)) {
            System.out.println(0);
        } else {
            function(sequence, N);
        }


        writer.flush();
        writer.close();
    }

    public static void function(int[] sequence, int N) {

        for (int i = 1; i < N; i++) {
            int[] array1 = new int[N-i];
            int[] array2 = new int[N-i];
            for (int j = 0; j < N-i; j++) {
                array1[j] = sequence[i+j];
                array2[j] = sequence[N-1-j];
            }

            if (Arrays.equals(array1, array2)) {
                System.out.println(i);
                int result = i;
                for (int j = result - 1; j >= 0; j--) {
                    System.out.print(sequence[j] + " ");
                }
                break;
            }
        }
    }






}
