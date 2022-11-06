//https://codeforces.com/contest/1747/problem/A

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class groups {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++){
            int m = Integer.parseInt(reader.readLine());

            String[] str = reader.readLine().split("\\s");

            long negSum = 0;

            long posSum = 0;

            for (int j = 0; j < m; j++){
                int num = Integer.parseInt(str[j]);

                if (num > 0)
                    posSum+= num;
                else
                    negSum+= num * (-1);

            }

            os.write((Math.abs(posSum - negSum) + "\n").getBytes());
        }
        os.flush();
    }
}
