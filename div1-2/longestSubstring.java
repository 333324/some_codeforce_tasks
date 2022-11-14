//https://codeforces.com/contest/1750/problem/B

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class longestSubstring {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            int length = Integer.parseInt(reader.readLine());

            String lol = reader.readLine();

            int zerosRow = 0, zeros = 0, one = 0, oneRow = 0;
            int maxRow = 0;

            for (int j = 0; j < length; j++){
                if (lol.charAt(j) == '1') {
                    oneRow++;
                    maxRow = Math.max(maxRow, Math.max(zerosRow, oneRow));
                    zerosRow = 0;
                    one++;
                } else {
                    zerosRow++;
                    maxRow = Math.max(maxRow, Math.max(zerosRow, oneRow));
                    oneRow = 0;
                    zeros++;
                }
            }

            long a = (long) maxRow * maxRow;
            long b = (long) zeros * one;

            os.write(((long)  Math.max(a, b) + "\n").getBytes());
        }
        os.flush();
    }
}
