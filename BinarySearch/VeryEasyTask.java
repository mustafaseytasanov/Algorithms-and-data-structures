import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/*
Сегодня утром жюри решило добавить в вариант олимпиады еще одну, Очень Легкую Задачу. 
Ответственный секретарь Оргкомитета напечатал ее условие в одном экземпляре, и теперь ему 
нужно до начала олимпиады успеть сделать еще N копий. В его распоряжении имеются два 
ксерокса, один из которых копирует лист за х секунд, а другой – за y. (Разрешается 
использовать как один ксерокс, так и оба одновременно. Можно копировать не только с оригинала, 
но и с копии.) Помогите ему выяснить, какое минимальное время для этого потребуется.

Формат ввода
На вход программы поступают три натуральных числа N, x и y, разделенные пробелом (1 ≤ N ≤ 2 × 10**8, 
1 ≤ x, y ≤ 10).

Формат вывода
Выведите одно число – минимальное время в секундах, необходимое для получения N копий.
*/

public class VeryEasyTask {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        String[] arr = str.split(" ");
        int n = Integer.parseInt(arr[0]);
        int x = Integer.parseInt(arr[1]);
        int y = Integer.parseInt(arr[2]);

        long out = Math.min(x, y);
        n -= 1;

        int multiplication = x * y;

        out += (n / (x + y)) * multiplication;
        n -= (n / (x + y)) * (x + y);

        int l = 0, r = multiplication, m;

        while (l < r) {
            m = (l + r) / 2;
            if ((m/x + m/y) >= n)
                r = m;
            else
                l = m + 1;
        }

        out += l;
        System.out.println(out);



        writer.flush();
        writer.close();
    }
}
