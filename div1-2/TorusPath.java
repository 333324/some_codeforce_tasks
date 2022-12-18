//https://codeforces.com/contest/1765/problem/K
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TorusPath {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int n = Integer.parseInt(reader.readLine());

        long summary = 0;

        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = readArr(reader, n);
            for (int j = 0; j < n; j++)
                summary+= grid[i][j];
        }

        int minlol = Math.min(grid[n - 1][0], grid[0][n - 1]);

        for (int i = 1; i < n - 1; i++) {
            minlol = Math.min(minlol, grid[n - i - 1][i]);
        }

        os.write(String.valueOf(summary - minlol).getBytes());

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
