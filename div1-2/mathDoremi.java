//https://codeforces.com/contest/1764/problem/B

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class mathDoremi {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            int b = Integer.parseInt(reader.readLine());

            int[] s = readArr(reader, b);

            Arrays.sort(s);

            int min = s[0];
            int preMin = s[1];

            for (int j = b - 1; j >= 0; j--) {
                if (s[j] % min != 0) {
                    min = s[j] % min;
                    j = b;
                }
            }

            os.write(String.valueOf(s[b - 1] / min).getBytes());
            os.write("\n".getBytes());
        }
        os.flush();
    }

    private static int[] readArr(BufferedReader reader, int length) throws IOException {
        String[] ans = reader.readLine().split("\\s");
        int[] ints = new int[length];
        for (int i = 0; i < length; i++)
            ints[i] = Integer.parseInt(ans[i]);

        return ints;
    }
}
