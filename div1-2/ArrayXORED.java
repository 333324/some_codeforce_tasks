//https://codeforces.com/contest/1758/B
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayXORED {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            int b = Integer.parseInt(reader.readLine());

            if (b % 2 == 1) {
                for (int j = 0; j < b; j++)
                    os.write("244 ".getBytes());
                os.write("\n".getBytes());
            } else {
                for (int j = 0; j < (b - 2) / 2; j++) {
                    os.write("2 2 ".getBytes());
                }

                os.write("3 1\n".getBytes());
            }

        }
        os.flush();
    }
}
