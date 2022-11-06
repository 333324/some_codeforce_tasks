//https://codeforces.com/contest/1740/problem/B

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class factorize {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);


        int n = Integer.parseInt(reader.readLine());

        List<Integer> simpleNums = getList(createEratosphen(100_000));

        for (int i = 0; i < n; i++){
            int number = Integer.parseInt(reader.readLine());

            for (Integer addition : simpleNums){
                if (!isSipmle(number + addition)){
                    os.write((addition + "\n").getBytes());
                    break;
                }
            }
        }
        os.flush();
    }

    public static boolean isSipmle(long a){
        for(long i = 2; i <= Math.sqrt(a); i++)
        if (a % i == 0)
            return false;
        return true;
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