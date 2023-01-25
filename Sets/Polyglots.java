import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
Каждый из N школьников некоторой школы знает Mi языков. Определите, какие языки знают все школьники и языки, 
которые знает хотя бы один из школьников.

Формат ввода
Первая строка входных данных содержит количество школьников N. Далее идет N чисел Mi, после каждого из чисел идет Mi строк, 
содержащих названия языков, которые знает i-й школьник. Длина названий языков не превышает 1000 символов, количество различных 
языков не более 1000. 1 ≤ N ≤ 1000, 1 ≤ Mi ≤ 500.

Формат вывода
В первой строке выведите количество языков, которые знают все школьники. Начиная со второй строки - список таких языков. 
Затем - количество языков, которые знает хотя бы один школьник, на следующих строках - список таких языков.
*/


public class Polyglots {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        int amount = Integer.parseInt(str);
        int amount2;

        Set<String> allLanguages = new HashSet<>();
        Set<String> mainLanguages = new HashSet<>();
        Set<String> languages;
        int iteration = 0;
        while (amount != 0) {
            languages = new HashSet<>();
            str = br.readLine();
            amount2 = Integer.parseInt(str);
            while (amount2 != 0) {
                str = br.readLine();
                allLanguages.add(str);
                languages.add(str);
                amount2--;
            }
            if (iteration == 0) {
                mainLanguages.addAll(languages);
            } else {
                mainLanguages.retainAll(languages);
            }

            iteration++;
            amount--;
        }

        Integer result = mainLanguages.size();
        writer.write(result + "\n");
        for (String element: mainLanguages) {
            writer.write(element + "\n");
        }
        result = allLanguages.size();
        writer.write(result + "\n");
        for (String element: allLanguages) {
            writer.write(element + "\n");
        }

        writer.flush();
        writer.close();
    }
}
