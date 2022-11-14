//https://codeforces.com/contest/1750/problem/A
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cosPerestanovka {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++){
            String m = reader.readLine();

            String[] lol = reader.readLine().split("\\s");

            if (lol[0].equals("1"))
                os.write("YES\n".getBytes());
            else
                os.write("NO\n".getBytes());
        }
        os.flush();
    }
}
