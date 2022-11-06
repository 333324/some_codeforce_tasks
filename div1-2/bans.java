//https://codeforces.com/contest/1747/problem/B

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bans {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(reader.readLine());

            int k = 0;

            os.write(((m + 1) / 2 + "\n").getBytes());

            while (k != m){
                if (k == m - 1){
                    os.write((k * 3 / 2 + 1 + " " + (k * 3 / 2 + 3)).getBytes());
                    k+= 1;
                } else {
                    os.write((1 + k * 3 / 2 + " " + (m - k / 2) * 3).getBytes());
                    k+= 2;
                }
                os.write("\n".getBytes());
            }
        }
        os.flush();
    }
}