import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;

/*
При реализации проекта «Умная школа» было решено в каждый учебный класс выбранной для этого школы 
установить по кондиционеру нового поколения для автоматического охлаждения и вентиляции воздуха. 
По проекту в каждом классе должен быть установлен только один кондиционер и мощность кондиционера 
должна быть достаточной для размеров класса. Чем больше класс, тем мощнее должен быть кондиционер.
Все классы школы пронумерованы последовательно от 1 до n. Известно, что для каждого класса 
с номером i, требуется ровно один кондиционер, мощность которого больше или равна ai ватт.
Администрации школы предоставили список из m различных моделей кондиционеров, которые можно закупить. 
Для каждой модели кондиционера известна его мощность и стоимость. Требуется написать программу, которая 
определит, за какую минимальную суммарную стоимость кондиционеров можно оснастить все классы школы.

Формат ввода
Первая строка входного файла содержит одно целое число n (1 ≤ n ≤ 50 000) количество классов в школе.
Вторая строка содержит n целых чисел ai (1 ≤ ai ≤ 1000) — минимальная мощность кондиционера в ваттах, 
который можно установить в классе с номером i.
Третья строка содержит одно целое число m (1 ≤ m ≤ 50 000) — количество предложенных моделей кондиционеров.
Далее, в каждой из m строк содержится пара целых чисел bj и cj (1 ≤ bj ≤ 1000, 1 ≤ cj ≤ 1000) мощность 
в ваттах j-й модели кондиционера и его цена в рублях соответственно.

Формат вывода
Выходной файл должен содержать одно число минимальную суммарную стоимость кондиционеров в рублях. 
Гарантируется, что хотя бы один корректный выбор кондиционеров существует, и во всех классах можно 
установить подходящий кондиционер.
*/

public class Conditioners {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        int n = Integer.parseInt(str);
        str = br.readLine();
        String[] arr = str.split(" ");
        int[] minPowers = new int[n];
        for (int i = 0; i < arr.length; i++) {
            minPowers[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(minPowers);
        str = br.readLine();
        int m = Integer.parseInt(str);
        int[][] valueAndPower = new int[m][2];
        for (int j = 0; j < m; j++) {
            str = br.readLine();
            arr = str.split(" ");
            valueAndPower[j][0] = Integer.parseInt(arr[0]);
            valueAndPower[j][1] = Integer.parseInt(arr[1]);
        }
        Arrays.sort(valueAndPower, Comparator.comparingInt(ar -> ar[1]));

        // Implementation
        int pointer1 = 0, pointer2 = 0;
        int result = 0;
        while (pointer1 != n) {

            if (minPowers[pointer1] <= valueAndPower[pointer2][0]) {
                result += valueAndPower[pointer2][1];
                pointer1++;
            } else {
                pointer2++;
            }
        }

        writer.write(result + "");


        writer.flush();
        writer.close();

    }
}
