/***************************************************************************************
 *                                                                                     *
 *                                 привет)                                             *
 *                          я пидорас                                                  *
 *                               код писал пидорас                                     *
 *                        ебите меня в жопу                                            *
 *                                                                                     *
 **************************************************************************************/

//https://codeforces.com/contest/1764/problem/C

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class cityDoremi {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());

            int[] heights = readArr(reader, n);

            Arrays.sort(heights);

            long ans;

            int aa = n % 2 == 1 ? 1 : 0;
            int mid = n / 2, left = mid - 1, right = mid + aa;
            int target = heights[mid];

            while (left >= 0 && right <= n) {
                if (heights[left] != target)
                    break;
                if (heights[right] != target)
                    break;
                left--;
                right++;
            }


            ans = left == -1 ? n / 2 : (long) (right) * (left + 1);



            os.write(String.valueOf(ans).getBytes());
            nl(os);
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

    private static void nl(BufferedOutputStream os) throws IOException {
        os.write("\n".getBytes());
    }

    private static void space(BufferedOutputStream os) throws IOException {
        os.write(" ".getBytes());
    }
}
