import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
Ежегодный турнир «Веселый коровяк» — по метанию коровьих лепешек на дальность — прошел 8–9 июля в селе 
Крылово Осинского района Пермского края. Участники соревнований кидают «снаряд» — спрессованный навоз, 
выбирая его из заранее заготовленной кучи. Желающих поупражняться в силе броска традиционно очень много — 
как мужчин, так и женщин. Каждую лепешку, которую метнули участники «Веселого коровяка», внимательно 
осматривали женщины в костюмах коров и тщательно замеряли расстояние.
Соревнования по метанию коровьих лепешек проводятся в Пермском крае с 2009 года.
К сожалению, после чемпионата потерялись записи с фамилиями участников, остались только записи о 
длине броска в том порядке, в котором их совершали участники.
Трактиорист Василий помнит три факта:
1) Число метров, на которое он метнул лепешку, оканчивалось на 5
2) Один из победителей чемпионата метал лепешку до Василия
3) Участник, метавший лепешку сразу после Василия, метнул ее на меньшее количество метров
Будем считать, что участник соревнования занял k-е место, если ровно (k − 1) участников чемпионата метнули 
лепешку строго дальше, чем он.
Какое максимально высокое место мог занять Василий?

Формат ввода
Первая строка входного файла содержит целое число n — количество участников чемпионата по метанию лепешек (3 ≤ n ≤ 10**5).
Вторая строка входного файла содержит n положительных целых чисел, каждое из которых не превышает 1000, — дальность 
броска участников чемпионата, приведенные в том порядке, в котором происходило метание.

Формат вывода
Выведите самое высокое место, которое мог занять тракторист Василий. Если не существует ни одного 
участника чемпионата, который удовлетворяет, описанным выше условиям, выведите число 0.
*/


public class Tournament {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        int length = Integer.parseInt(str);
        str = br.readLine();
        String[] arr = str.split(" ");
        int[] newArr = new int[length];
        for (int i = 0; i < length; i++) {
            newArr[i] = Integer.parseInt(arr[i]);
        }
        int maxElem = newArr[0];
        int idxOfMaxElem = 0;
        int element;
        for (int i = 1; i < newArr.length; i++) {
            element = newArr[i];
            if (element > maxElem) {
                maxElem = element;
                idxOfMaxElem = i;
            }
        }

        int a = -1;
        for (int i = idxOfMaxElem+1; i < length-1; i++) {
            if (newArr[i] % 10 == 5) {
                if (newArr[i+1] < newArr[i]) {
                    if (newArr[i] > a) {
                        a = newArr[i];
                    }
                }
            }
        }
        Integer result = 0;
        if (a != -1) {
            for (int i = 0; i < length; i++) {
                if (newArr[i] > a)
                    result++;
            }
            result++;
        }
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }
}
