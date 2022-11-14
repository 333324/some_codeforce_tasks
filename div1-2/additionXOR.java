//https://codeforces.com/contest/1750/problem/C
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class additionXOR {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            int length = Integer.parseInt(reader.readLine());

            String a = reader.readLine();
            String b = reader.readLine();

            boolean shouldBeSame = a.charAt(0) == b.charAt(0);
            boolean possible = true;

            for (int j = 1; j < length; j++) {
                if (shouldBeSame == (a.charAt(j) != b.charAt(j))){
                    os.write("NO\n".getBytes());
                    possible = false;
                    break;
                }
            }

            StringBuilder ans = new StringBuilder();
            int moves = 0;

            if (possible) {
                os.write("YES\n".getBytes());

                for (int k = 0; k < length; k++) {
                    if (a.charAt(k) == '1') {
                        moves++;
                        ans.append(k + 1).append(" ").append(k + 1).append("\n");
                    }
                }

                if ((moves + (shouldBeSame ? 1 : 0)) % 2 == 0) {
                    moves += 3;
                    ans.append(1).append(" ").append(length).append("\n");
                    ans.append(1).append(" ").append(1).append("\n");
                    ans.append(2).append(" ").append(length).append("\n");
                }

                os.write((moves + "\n").getBytes());
                os.write(ans.toString().getBytes());
            }
        }
        os.flush();
    }
}