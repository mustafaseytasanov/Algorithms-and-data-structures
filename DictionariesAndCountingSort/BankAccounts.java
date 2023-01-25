import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
Некоторый банк хочет внедрить систему управления счетами клиентов, поддерживающую следующие операции:
Пополнение счета клиента. Снятие денег со счета. Запрос остатка средств на счете. Перевод денег между 
счетами клиентов. Начисление процентов всем клиентам.
Вам необходимо реализовать такую систему. Клиенты банка идентифицируются именами (уникальная строка, 
не содержащая пробелов). Первоначально у банка нет ни одного клиента. Как только для клиента проводится операция 
пололнения, снятия или перевода денег, ему заводится счет с нулевым балансом. Все дальнейшие операции проводятся 
только с этим счетом. 
Сумма на счету может быть как положительной, так и отрицательной, при этом всегда является целым числом.

Формат ввода
Входной файл содержит последовательность операций. Возможны следующие операции: DEPOSIT name sum - зачислить сумму sum 
на счет клиента name. Если у клиента нет счета, то счет создается. WITHDRAW name sum - снять сумму sum со счета клиента name. 
Если у клиента нет счета, то счет создается. BALANCE name - узнать остаток средств на счету
клиента name. TRANSFER name1 name2 sum - перевести сумму sum со счета клиента name1 на счет клиента name2. Если у какого-либо 
клиента нет счета, то ему создается счет. INCOME p - начислить всем клиентам, у которых открыты счета, p% от суммы счета. 
Проценты начисляются только клиентам с положительным остатком на счету, если у клиента остаток отрицательный, то его счет не меняется. 
После начисления процентов сумма на счету остается целой, 
то есть начисляется только целое число денежных единиц. Дробная часть начисленных процентов отбрасывается.

Формат вывода
Для каждого запроса BALANCE программа должна вывести остаток на счету данного клиента. Если же у клиента 
с запрашиваемым именем не открыт счет в банке, выведите ERROR.
*/

public class BankAccounts {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        Map<String, Long> map = new HashMap<>();
        String[] arr;
        String str = br.readLine();
        Long val, val2;
        while (str != null) {

            arr = str.split(" ");

            switch (arr[0]) {

                case "DEPOSIT":
                    val = map.get(arr[1]);
                    if (val == null) {
                        map.put(arr[1], Long.parseLong(arr[2]));
                    } else {
                        map.put(arr[1], val + Long.parseLong(arr[2]));
                    }
                    break;
                case "WITHDRAW":
                    val = map.get(arr[1]);
                    if (val == null) {
                        map.put(arr[1], (-1) * Long.parseLong(arr[2]));
                    } else {
                        map.put(arr[1], val - Long.parseLong(arr[2]));
                    }
                    break;
                case "BALANCE":
                    if (map.get(arr[1]) != null)
                        writer.write(map.get(arr[1]) + "\n");
                    else
                        writer.write("ERROR\n");
                    break;
                case "TRANSFER":
                    val = map.get(arr[1]);
                    val2 = map.get(arr[2]);
                    if (val == null) {
                        map.put(arr[1], (-1) * Long.parseLong(arr[3]));
                    } else {
                        map.put(arr[1], val - Long.parseLong(arr[3]));
                    }
                    if (val2 == null) {
                        map.put(arr[2], Long.parseLong(arr[3]));
                    } else {
                        map.put(arr[2], val2 + Long.parseLong(arr[3]));
                    }
                    break;
                default: // INCOME
                    Object[] keySet = map.keySet().toArray();
                    for (Object element: keySet) {
                        if (map.get(element.toString()) > 0) {
                            map.put((String) element,
                                    (map.get(element.toString()) * (Long.parseLong(arr[1]) + 100)) / 100);
                        }
                    }
                    break;
            }

            str = br.readLine();
        }


        writer.flush();
        writer.close();
    }
}
