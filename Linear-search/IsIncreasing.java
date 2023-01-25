import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/*
Дан список. Определите, является ли он монотонно возрастающим(то есть верно ли, 
что каждый элемент этого списка больше предыдущего).
Выведите YES, если массив монотонно возрастает и NO в противном случае.
*/


public class IsIncreasing {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        String str = br.readLine();
        String[] arr = str.split(" ");

        writer.write(function(arr));


        writer.flush();
        writer.close();
    }

    public static String function(String[] arr) {

        for (int i = 1; i < arr.length; i++) {

            if ((Integer.parseInt(arr[i])) <= (Integer.parseInt(arr[i-1])))
                return "NO";
        }
        return "YES";
    }

}
