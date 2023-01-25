import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/*
Имеется N кг металлического сплава. Из него изготавливают заготовки массой K кг каждая.
После этого из каждой заготовки вытачиваются детали массой M кг каждая (из каждой заготовки вытачивают
максимально возможное количество деталей). Если от заготовок после этого что-то остается, то этот
материал возвращают к началу производственного цикла и сплавляют с тем, что осталось при изготовлении
заготовок. Если того сплава, который получился, достаточно для изготовления хотя бы одной заготовки,
то из него снова изготавливают заготовки, из них – детали и т.д. Напишите программу, которая вычислит,
какое количество деталей может быть получено по этой технологии из имеющихся исходно N кг сплава.

Формат ввода
Вводятся N, K, M. Все числа натуральные и не превосходят 200.

Формат вывода
Выведите одно число — количество деталей, которое может получиться по такой технологии.
 */

public class Details {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        String[] arr = str.split(" ");
        int N = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);
        int M = Integer.parseInt(arr[2]);

        int blanks;
        int remainder;
        Integer details = 0;

        while (true) {
            if (N < K)
                break;
            if (K < M)
                break;
            blanks = N / K;
            N -= (blanks * K);
            details += (blanks * (K / M));
            N += (blanks * (K % M));
        }

        writer.write(details.toString());
        writer.flush();
        writer.close();
    }
}