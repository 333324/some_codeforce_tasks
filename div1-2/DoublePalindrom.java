//https://codeforces.com/contest/1758/problem/A
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DoublePalindrom {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String str = reader.readLine();

            os.write(str.getBytes());

            for (int j = str.length() - 1; j >= 0; j--) {
                os.write(String.valueOf(str.charAt(j)).getBytes());
            }
            os.write("\n".getBytes());
        }
        os.flush();
    }
}
