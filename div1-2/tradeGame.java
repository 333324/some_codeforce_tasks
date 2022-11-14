import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class tradeGame {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(reader.readLine());

            String[] str = reader.readLine().split("\\s");

            if (Objects.equals(str[0], "2")){
                os.write("Alice\n".getBytes());
            } else if (Objects.equals(str[0], "1")){
                os.write("Bob\n".getBytes());
            } else {
                long sum = 0;
                for (int j = 0; j < m; j++) {
                    sum += Integer.parseInt(str[j]);
                }

                sum = sum - m * 2L;

                String ans = ((sum % 2) == 1 ? "Alice\n" : "Bob\n");
                os.write(ans.getBytes());
            }
        }
        os.flush();
    }
}