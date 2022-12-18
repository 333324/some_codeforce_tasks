//https://codeforces.com/contest/1765/problem/M
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumLCM {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int t = Integer.parseInt(reader.readLine());

        for (int qq = 0; qq < t; qq++) {
            int n = Integer.parseInt(reader.readLine());

            if (n < 4){
                os.write(String.valueOf(1).getBytes());
                os.write(" ".getBytes());
                os.write(String.valueOf(n - 1).getBytes());
                os.write("\n".getBytes());
            } else
                for (int i = 2; i < Math.sqrt(n) + 1; i++) {
                    if (n % i == 0){
                        os.write(String.valueOf(n / i).getBytes());
                        os.write(" ".getBytes());
                        os.write(String.valueOf(n - n / i).getBytes());
                        os.write("\n".getBytes());
                        break;
                    }

                    if (i == (int) Math.sqrt(n)){
                        os.write(String.valueOf(1).getBytes());
                        os.write(" ".getBytes());
                        os.write(String.valueOf(n - 1).getBytes());
                        os.write("\n".getBytes());
                    }
                }
            }
        os.flush();
    }
}
