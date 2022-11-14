import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class isBST {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int n = Integer.parseInt(reader.readLine());

        long[] weight = new long[n + 1];
        int[][] kids = new int[n + 1][2];

        for (int i = 1; i <= n; i++){
            String[] str = reader.readLine().split("\\s");

            weight[i] = Integer.parseInt(str[0]);
            kids[i][0] = Integer.parseInt(str[1]);
            kids[i][1] = Integer.parseInt(str[2]);
        }

        int starting = Integer.parseInt(reader.readLine());

        String ans = (searchMistakes(weight, kids, starting) ? "YES" : "NO");

        System.out.println(ans);
    }

    private static boolean searchMistakes(long[] weight, int[][] kids, int index) {
        if (kids[index][0] == -1 && kids[index][1] == -1)
            return true;

        boolean one = true, two = true;

        if (kids[index][0] != -1) {
            if (weight[index] < weight[kids[index][0]])
                return false;
            one = searchMistakes(weight, kids, kids[index][0]);
        }

        if (kids[index][1] != -1) {
            if (weight[index] > weight[kids[index][1]])
                return false;
            two = searchMistakes(weight, kids, kids[index][1]);
        }

        return (one && two);
    }
}
