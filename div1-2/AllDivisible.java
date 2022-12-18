//https://codeforces.com/contest/1758/problem/C
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllDivisible {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            String[] data = reader.readLine().split("\\s");
            int n = Integer.parseInt(data[0]);
            int x = Integer.parseInt(data[1]);

            int lol = x;
            if (n % x != 0) {
                os.write("-1\n".getBytes());
            } else {
                os.write(String.valueOf(x).getBytes());
                os.write(" ".getBytes());
                for (int j = 2; j < n; j++) {
                    if (j % lol != 0) {
                        os.write(String.valueOf(j).getBytes());
                        os.write(" ".getBytes());
                    } else if (lol <= n){
                        for (int k = 2; k <= n; k++)
                            if (n % (lol * k) == 0) {
                                lol *= k;
                                break;
                            }
                        os.write(String.valueOf(lol).getBytes());
                        os.write(" ".getBytes());
                    } else {
                        os.write(String.valueOf(n).getBytes());
                        os.write(" ".getBytes());
                    }
                }
                os.write("1\n".getBytes());
            }
        }
        os.flush();
    }

    private static int biggestPow(int num, int limit) {
        int ans = limit;

        while (ans % num == 0)
            ans/= num;

        return limit / ans;
    }
}
