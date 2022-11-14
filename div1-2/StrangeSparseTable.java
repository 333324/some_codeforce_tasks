import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StrangeSparseTable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        String[] data = reader.readLine().split("\\s");
        String[] firstQ = reader.readLine().split("\\s");

        int firstNum = Integer.parseInt(data[2]);
        int qAmount = Integer.parseInt(data[1]);
        int length = Integer.parseInt(data[0]);
        int left = Integer.parseInt(firstQ[0]);
        int right = Integer.parseInt(firstQ[1]);

        int[][] sparseTable = new int[log2nlz(length) + 1][length + 1];
        int ans = 0;

        sparseTable[0][0] = firstNum;

        for (int i = 1; i < length; i++) {
            sparseTable[0][i] = (23 * sparseTable[0][i - 1] + 21563) % 16714589;
        }

        buildSparseTable(sparseTable, length);

        for (int i = 0; i < qAmount; i++) {

            ans = getMin(left, right, sparseTable);

            if (i == qAmount - 1)
                os.write((left + " " + right + " " + ans + "\n").getBytes());

            left = ((17 * left + 751 + ans + 2 * (i + 1)) % length) + 1;
            right = ((13 * right + 593 + ans + 5 * (i + 1)) % length) + 1;
        }

        os.flush();
    }

    private static int getMin(int left, int right, int[][] table) {
        left--;
        right--;
        int realLog = log2nlz(Math.abs(right - left));
        int log = log2nlz(Math.abs(right - left) - 1);
        return Math.min(table[realLog][Math.min(left, right)],
                table[realLog][Math.max(left, right) - (1 << log)]);
    }

    private static void buildSparseTable(int[][] table, int length) {
        int log = log2nlz(length) + 1;

        for (int l = 1; l < log; l++)
            for (int i = 0; i < length - (1 << l) + 1; i++)
                table[l][i] = Math.min(table[l - 1][i], table[l - 1][i + ((1 << (l - 1)))]);
    }

    private static int log2nlz(int num) {
        if (num <= 0)
            return 0;
        return 31 - Integer.numberOfLeadingZeros(num);
    }
}