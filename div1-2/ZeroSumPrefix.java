import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZeroSumPrefix {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            int length = Integer.parseInt(reader.readLine());

            String[] data = reader.readLine().split("\\s");
            int currSum = 0;
            for (int m = length; m >= 0; m--) {
                int currNum = Integer.parseInt(data[m]);

                if (currNum != 0) {
                    currSum+= currNum;
                }
            }
        }
    }
}
