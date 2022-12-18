//https://codeforces.com/contest/1766/problem/B
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NotepadTyping {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int t = Integer.parseInt(reader.readLine());

        for (int qq = 0; qq < t; qq++) {
            int n = Integer.parseInt(reader.readLine());

            String str = reader.readLine();

            short[] container = new short[3000];

            boolean ans = false;

            int lastid = 0;

            for (int i = 0; i < n - 1; i++) {
                int id = (str.charAt(i) - 'a') * 100 + str.charAt(i + 1) - 'a';

                if ((container[id] > 0 && lastid != id) || (container[id] > 1)){
                    ans = true;
                    break;
                } else {
                    container[id]++;
                    lastid = id;
                }
            }

            os.write((ans ? "YES\n" : "NO\n").getBytes());
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
