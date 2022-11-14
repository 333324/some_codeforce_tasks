//TODO ну доделай крч https://codeforces.com/contest/1750/problem/D
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class arrayOfGCD {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int amount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < amount; i++) {
            String[] data = reader.readLine().split("\\s");

            int n = Integer.parseInt(data[0]);
            int m = Integer.parseInt(data[1]);

            String[] numArray = reader.readLine().split("\\s");

            long ans = 1;

            int lastNum = Integer.parseInt(numArray[0]);
            int currNum;

            for (int j = 1; j < n; j++) {
                currNum = Integer.parseInt(numArray[j]);
                if (lastNum % currNum != 0){
                    ans = 0;
                    break;
                }

                ans = (ans * (variantsWithExceptions(currNum, m, lastNum) % 998244353)) % 998244353;

                lastNum = currNum;
            }
            os.write((ans + "\n").getBytes());
        }
        os.flush();
    }
    private static long variantsWithExceptions(int diviser, int limit, int exception) {
        if (exception == diviser)
            return 1;

        return limit / diviser - limit / exception;
    }

    private static long gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}
