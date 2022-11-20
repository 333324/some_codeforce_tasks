//https://codeforces.com/contest/1759/problem/C

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class thermostat {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] data = reader.readLine().split("\\s");
            int l = Integer.parseInt(data[0]);
            int r = Integer.parseInt(data[1]);
            int x = Integer.parseInt(data[2]);

            data = reader.readLine().split("\\s");
            int curr = Integer.parseInt(data[0]);
            int target = Integer.parseInt(data[1]);

            int ans = 0;

            if (curr == target)
                ans = 0;
            else if ((x > (curr - l) && x > (r - curr)) || (x > (target - l) && x > (r - target)))
                ans = -1;
            else if (x <= Math.abs(curr - target))
                ans = 1;
            else if ((x <= (curr - l) && x <= (target - l)) || (x <= (r - target) && x <= (r - curr)))
                ans = 2;
            else
                ans = 3;

/*            if (ans == 3 && (curr == l || curr == r || target == l || target == r))
                ans--;*/

            os.write(String.valueOf(ans).getBytes());
            os.write("\n".getBytes());
        }
        os.flush();
    }
}