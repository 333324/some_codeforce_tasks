//https://codeforces.com/contest/1764/problem/A

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class colorDoremi {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            int b = Integer.parseInt(reader.readLine());

            int[] colors = readArr(reader, b);

            os.write("1 ".getBytes());
            os.write(String.valueOf(b).getBytes());
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
