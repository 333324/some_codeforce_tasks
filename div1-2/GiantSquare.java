//https://codeforces.com/contest/1748/problem/A

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GiantSquare {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int qAmount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < qAmount; i++) {
            int ans = (Integer.parseInt(reader.readLine()) + 1) / 2;
            os.write((ans + "\n").getBytes());
        }

        os.flush();
    }
}
