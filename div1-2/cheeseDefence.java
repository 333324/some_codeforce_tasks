//https://codeforces.com/contest/1740/problem/B

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cheeseDefence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int n = Integer.parseInt(reader.readLine());

        for (int j = 0; j < n; j++) {
            long max = 0;

            long ans = 0;

            int m = Integer.parseInt(reader.readLine());

            for (int i = 0; i < m; i++) {
                String[] str = reader.readLine().split("\\s");

                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);

                ans += 2 * Math.min(a, b);

                max = Math.max(Math.max(a, b), max);
            }

            os.write(((ans + max * 2) + "\n").getBytes());
        }
        os.flush();
    }
}
