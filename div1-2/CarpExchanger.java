//https://codeforces.com/contest/1765/problem/E
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CarpExchanger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int t = Integer.parseInt(reader.readLine());

        for (int qq = 0; qq < t; qq++) {
            String[] data = reader.readLine().split("\\s");

            int n = Integer.parseInt(data[0]);
            int a = Integer.parseInt(data[1]);
            int b = Integer.parseInt(data[2]);

            if (a > b)
                os.write("1".getBytes());
            else
                os.write(String.valueOf((int) Math.ceil(n / (float) a)).getBytes());
            os.write("\n".getBytes());
        }
        os.flush();
    }
}
