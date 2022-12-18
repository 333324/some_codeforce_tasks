//https://codeforces.com/contest/1771/problem/A
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hassamArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int t = Integer.parseInt(reader.readLine());

        for (int qq = 0; qq < t; qq++) {
            int n = Integer.parseInt(reader.readLine());

            int[] arr = readArr(reader, n);

            int min = Integer.MAX_VALUE, minAmount = 0;
            int max = 0, maxAmount = 0;

            for (int i = 0; i < n; i++) {
                if (arr[i] < min){
                    min = arr[i];
                    minAmount = 1;
                } else if (min == arr[i])
                    minAmount++;

                if (arr[i] > max){
                    max = arr[i];
                    maxAmount = 1;
                } else if (arr[i] == max)
                    maxAmount++;
            }

            long ans = 0;

            if (max != min)
                ans = ((long) maxAmount * (long) minAmount * 2L);
            else {
                for (int i = 1; i < maxAmount; i++)
                    ans += i;
                ans *= 2;
            }

            os.write(String.valueOf(ans).getBytes());
            os.write("\n".getBytes());

        }
        os.flush();
    }

    private static int[] readArr(BufferedReader reader, int length) throws IOException {
        String[] ans = reader.readLine().split("\\s");
        int[] ints = new int[length];
        for (int i = 0; i < length; i++)
            ints[i] = Integer.parseInt(ans[i]);

        return ints;
    }
}
