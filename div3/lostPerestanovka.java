//https://codeforces.com/contest/1759/problem/B

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lostPerestanovka {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] data = reader.readLine().split("\\s");
            int amount = Integer.parseInt(data[0]);
            int missing = Integer.parseInt(data[1]);

            int max = 0;

            String[] arr = reader.readLine().split("\\s");

            boolean[] weHaveThem = new boolean[1000];

            for (int j = 0; j < amount; j++) {
                max = Math.max(max, Integer.parseInt(arr[j]));
                weHaveThem[Integer.parseInt(arr[j])] = true;
            }

            int counter = 1;

            while (missing > 0) {
                if (!weHaveThem[counter])
                    missing-= counter;
                weHaveThem[counter] = true;
                counter++;
            }

            if (missing == 0 && isPerestanoska(weHaveThem, max))
                os.write("YES\n".getBytes());
            else
                os.write("NO\n".getBytes());
        }
        os.flush();
        }

        private static boolean isPerestanoska(boolean[] arr, int length) {
            for (int i = 1; i <= length; i++)
                if (!arr[i]) return false;
            return true;
        }
}
