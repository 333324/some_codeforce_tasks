//https://codeforces.com/contest/1771/problem/B
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class hassamFriends {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int t = Integer.parseInt(reader.readLine());

        for (int qq = 0; qq < t; qq++) {
            int[] data = readArr(reader, 2);
            int n = data[0];
            int m = data[1];

            List<Integer>[] noFriends = new ArrayList[n + 1];

            int[] lastNotFriend = new int[n + 1];
    //        int[] firstNotFriend = new int[n + 1];

            for (int i = 0; i < m; i++) {
                int[] hater = readArr(reader, 2);

                int a = Math.min(hater[1], hater[0]);
                int b = Math.max(hater[1], hater[0]);

                lastNotFriend[b] = Math.max(lastNotFriend[b], a);
    //            firstNotFriend[b] = Math.min(firstNotFriend[b], a);

                if (noFriends[a] == null)
                    noFriends[a] = new ArrayList<>();
                noFriends[a].add(b);
                if (noFriends[b] == null)
                    noFriends[b] = new ArrayList<>();
                noFriends[b].add(a);
            }

            long ans = 1;
            long streak = 1;
            int start = 1;

            for (int i = 1; i < n; i++) {

                if (lastNotFriend[i + 1] < start)
                    streak++;
                else {
                    start = lastNotFriend[i + 1] + 1;
                    streak = i + 2 - start;
                }
                ans+= streak;
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
