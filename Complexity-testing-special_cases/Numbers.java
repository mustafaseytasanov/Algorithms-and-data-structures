import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/*
Телефонные номера в адресной книге мобильного телефона имеют один из следующих
форматов: +7<код><номер>, 8<код><номер>, <номер>, где <номер> — это семь цифр, а <код> — это три цифры
или три цифры в круглых скобках. Если код не указан, то считается, что он равен 495. Кроме того,
в записи телефонного номера может стоять знак “-” между любыми двумя цифрами (см. пример).
На данный момент в адресной книге телефона Васи записано всего три телефонных номера, и он хочет
записать туда еще один. Но он не может понять, не записан ли уже такой номер в телефонной книге.
Помогите ему! Два телефонных номера совпадают, если у них равны коды и равны номера.
Например, +7(916)0123456 и 89160123456 — это один и тот же номер.

Формат ввода
В первой строке входных данных записан номер телефона, который Вася хочет добавить в адресную книгу
своего телефона. В следующих трех строках записаны три номера телефонов, которые уже находятся
в адресной книге телефона Васи. Гарантируется, что каждая из записей соответствует одному из трех
приведенных в условии форматов.

Формат вывода
Для каждого телефонного номера в адресной книге выведите YES (заглавными буквами), если он совпадает
с тем телефонным номером, который Вася хочет добавить в адресную книгу или NO (заглавными буквами)
в противном случае.
 */



public class Numbers {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");
        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();
        String str4 = br.readLine();

        boolean[] result = function(str1, str2, str3, str4);
        for (int i = 0; i < result.length; i++) {
            if (result[i] == true)
                writer.write("YES" + '\n');
            else
                writer.write("NO" + '\n');
        }

        writer.flush();
        writer.close();
    }

    public static boolean[] function(String str1, String str2, String str3,
                                     String str4) {

        String newStr1 = deleteRedundantSymbols(str1);
        String newStr2 = deleteRedundantSymbols(str2);
        String newStr3 = deleteRedundantSymbols(str3);
        String newStr4 = deleteRedundantSymbols(str4);

        boolean[] arr = new boolean[3];
        arr[0] = newStr1.equals(newStr2);
        arr[1] = newStr1.equals(newStr3);
        arr[2] = newStr1.equals(newStr4);

        return arr;

    }

    public static String deleteRedundantSymbols(String str) {
        StringBuilder sb = new StringBuilder();
        char sym;
        for (int i = 0; i < str.length(); i++) {
            sym = str.charAt(i);
            if ((sym != '-') && (sym != '(') && (sym != ')'))
                sb.append(sym);
        }
        return convertToStandard(sb.toString());
    }

    public static String convertToStandard(String str) {

        StringBuilder sb = new StringBuilder();
        if (str.length() == 7) {
            sb.append("8495");
            sb.append(str);
            return sb.toString();
        } else if (str.length() == 12) {
            if ((str.charAt(0) == '+') && (str.charAt(1) == '7')) {
                sb.append("8");
                sb.append(str, 2, 12);
                return sb.toString();
            }
        }
        return str;
    }

}

