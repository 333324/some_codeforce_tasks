//just a sipmle nums

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class eratosphen {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int n = Integer.parseInt(reader.readLine());

        boolean[] resheto = createEratosphen(n);

        for (int i = 1; i <= n; i++) {
            if (resheto[i])
                System.out.print(i + " ");
        }
    }

    public static boolean[] createEratosphen(int number) {
        boolean[] resheto = new boolean[number + 1];
        Arrays.fill(resheto, true);

        int minuend = 2;


        resheto[0] = false;
        resheto[1] = false;

        while (true) {
            if (minuend * 2 > number)
                return resheto;

            for (int i = 2 * minuend; i <= number; i += minuend)
                resheto[i] = false;

            for (int i = minuend + 1; i <= number; i++){
                if (resheto[i]) {
                    minuend = i;
                    break;
                }

                if (i == number){
                    return resheto;
                }
            }
        }
    }

    public static List<Integer> getList(boolean[] arr) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++)
            if (arr[i])
                result.add(i);

        return result;
    }
}
