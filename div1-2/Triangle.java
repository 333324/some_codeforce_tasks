//https://codeforces.com/contest/1767/problem/A
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Triangle {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int t = Integer.parseInt(reader.readLine());

        for (int qq = 0; qq < t; qq++) {
            String lol = reader.readLine();

            int[] arr = readArr(reader, 2);

            int x1 = arr[0] , y1 = arr[1];
            arr = readArr(reader, 2);

            int x2 = arr[0] , y2 = arr[1];
            arr = readArr(reader, 2);

            int x3 = arr[0] , y3 = arr[1];

            if ((Math.min(x1, x3) < x2 && x2 < Math.max(x1, x3)) || (Math.min(y1, y3) < y2 && y2 < Math.max(y1, y3)))
                os.write("YES\n".getBytes());
            else if ((Math.min(x2, x3) < x1 && x1 < Math.max(x2, x3)) || (Math.min(y2, y3) < y1 && y1 < Math.max(y2, y3)))
                os.write("YES\n".getBytes());
            else if ((Math.min(x1, x2) < x3 && x3 < Math.max(x1, x2)) || (Math.min(y1, y2) < y3 && y3 < Math.max(y1, y2)))
                os.write("YES\n".getBytes());
            else
                os.write("NO\n".getBytes());
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
