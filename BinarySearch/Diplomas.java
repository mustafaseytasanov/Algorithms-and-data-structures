import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
Когда Петя учился в школе, он часто участвовал в олимпиадах по информатике, математике и физике. 
Так как он был достаточно способным мальчиком и усердно учился, то на многих из этих олимпиад он 
получал дипломы. К окончанию школы у него накопилось n дипломов, причём, как оказалось, все они 
имели одинаковые размеры: w — в ширину и h — в высоту. Сейчас Петя учится в одном из лучших 
российских университетов и живёт в общежитии со своими одногруппниками. Он решил украсить свою 
комнату, повесив на одну из стен свои дипломы за школьные олимпиады. Так как к бетонной стене 
прикрепить дипломы достаточно трудно, то он решил купить специальную доску из пробкового дерева, 
чтобы прикрепить её к стене, а к ней — дипломы. Для того чтобы эта конструкция выглядела более 
красиво, Петя хочет, чтобы доска была квадратной и занимала как можно меньше места на стене. 
Каждый диплом должен быть размещён строго в прямоугольнике размером w на h. Дипломы запрещается 
поворачивать на 90 градусов. Прямоугольники, соответствующие различным дипломам, не должны иметь 
общих внутренних точек. Требуется написать программу, которая вычислит минимальный размер стороны 
доски, которая потребуется Пете для размещения всех своих дипломов.

Формат ввода
Входной файл содержит три целых числа: w, h, n (1 ≤ w, h, n ≤ 10**9).

Формат вывода
В выходной файл необходимо вывести ответ на поставленную задачу.
*/

public class Diplomas {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        String[] arr = str.split(" ");
        long w = Integer.parseInt(arr[0]);
        long h = Integer.parseInt(arr[1]);
        long n = Integer.parseInt(arr[2]);

        double floatN = Math.sqrt(n);
        long a = (long) Math.ceil(floatN);

        long value1 = a * w;
        long value2 = a * h;

        long maxValue = Math.max(value1, value2);
        long minValue = Math.min(value1, value2);

        long l = 0,
                r = maxValue - minValue,
                m;


        while (l < r) {

            m = (l + r) / 2;
            if (n <= ((minValue + m)/w) * ((minValue + m)/h))
                r = m;
            else
                l = m + 1;
        }
        writer.write(((minValue + l)) + "");

        writer.flush();
        writer.close();
    }
}




