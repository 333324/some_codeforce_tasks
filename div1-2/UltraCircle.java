//https://codeforces.com/contest/1766/problem/A
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UltraCircle {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int t = Integer.parseInt(reader.readLine());

        for (int qq = 0; qq < t; qq++) {
            int n = Integer.parseInt(reader.readLine());

            int log = (int) Math.log10(n);

            int ans = log * 9 + (int) (n / Math.pow(10, log));

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
