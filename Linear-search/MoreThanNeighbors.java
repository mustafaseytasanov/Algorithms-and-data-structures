import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/*
Дан список чисел. Определите, сколько в этом списке элементов, которые больше двух своих 
соседей и выведите количество таких элементов.

Формат ввода
Вводится список чисел. Все числа списка находятся на одной строке.

Формат вывода
Выведите ответ на задачу.
*/

public class MoreThanNeighbors {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        String[] arr = str.split(" ");
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = Integer.parseInt(arr[i]);
        }

        Integer answer = 0;
        for (int i = 1; i < (newArr.length-1); i++) {
            if ((newArr[i] > newArr[i-1]) && (newArr[i] > newArr[i+1]))
                answer++;
        }

        writer.write(answer.toString());
        writer.flush();
        writer.close();
    }

}

