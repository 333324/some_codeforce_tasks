//https://codeforces.com/contest/1767/problem/B
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.util.Arrays;

public class BlockTowers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int t = Integer.parseInt(reader.readLine());

        for (int qq = 0; qq < t; qq++) {
            int n = Integer.parseInt(reader.readLine());

            int[] arr = readArr(reader, n);

            long ans = arr[0];

            arr[0] = 0;

            Arrays.sort(arr);

            for (int i = 0; i < n; i++) {
                if (arr[i] <= ans)
                    continue;

                ans = (long) Math.ceil((arr[i] + (double) ans) / 2);
            }

            os.write(String.valueOf(ans).getBytes());
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
