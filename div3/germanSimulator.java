//https://codeforces.com/contest/1759/problem/D

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class germanSimulator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] data = reader.readLine().split("\\s");
            long curr = Integer.parseInt(data[0]);
            int maxMulti = Integer.parseInt(data[1]);

            long realCurr = curr;

            long lastAns = 1;
            long ans = 1;

            while (ans <= maxMulti) {
                int preZero = getNumBeforeZero(curr);

                lastAns = ans;

                if (preZero % 2 == 0) {
                    ans*= 5;
                    curr*= 5;
                } else if (preZero == 5) {
                    ans*= 2;
                    curr*= 2;
                } else {
                    ans*= 10;
                    curr*= 10;
                }
            }

            long maxCurr = realCurr * lastAns;

            for (int j = 2; j < 10; j++)
                if ((long) lastAns * (long) j <= maxMulti)
                    maxCurr += realCurr * lastAns;
                else
                    break;


            os.write(String.valueOf(maxCurr).getBytes());
            os.write("\n".getBytes());
        }
        os.flush();
    }

    private static int zerosAhead(long a) {
        int ans = 0;
        int num = 1;
        while (a % num == 0) {
            ans++;
            num*= 10;
        }
        return ans;
    }

    private static int getNumBeforeZero(long a) {
        while (a % 10 == 0) {
            a/= 10;
        }
        return (int) a % 10;
    }
}
