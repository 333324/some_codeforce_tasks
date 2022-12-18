//https://codeforces.com/contest/1766/problem/C
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WallPainting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int t = Integer.parseInt(reader.readLine());

        for (int qq = 0; qq < t; qq++) {
            int n = Integer.parseInt(reader.readLine());

            char[][] wall = new char[2][n];

            wall[0] = reader.readLine().toCharArray();
            wall[1] = reader.readLine().toCharArray();

            int s = 0, e = n - 1;

            while (wall[0][s] == 'W' && wall[1][s] == 'W')
                s++;

            while (wall[0][e] == 'W' && wall[1][e] == 'W')
                e--;

            int exitLevel = 0;
            boolean ans = true;

            for (int i = s; i <= e; i++) {
                if (i == s || exitLevel == 3) {
                    if (wall[0][i] == 'B' && wall[1][i] == 'B'){
                        exitLevel = 3;
                    } else {
                        if (wall[0][i] == 'B')
                            exitLevel = 1;
                        else
                            exitLevel = 2;
                    }
                } else if (wall[exitLevel - 1][i] == 'B'){
                    if (wall[exitLevel % 2][i] == 'B')
                        exitLevel = 3 - exitLevel;
                } else {
                    ans = false;
                    break;
                }

            }


            os.write((ans ? "YES\n" : "NO\n").getBytes());
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
