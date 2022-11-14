//https://codeforces.com/gym/104052/problem/B need to speed up

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SchoolFruits {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] data = reader.readLine().split("\\s");

            int[] fruits = new int[4];

            fruits[0] = Integer.parseInt(data[0]);
            fruits[1] = Integer.parseInt(data[1]);
            fruits[2] = Integer.parseInt(data[2]);
            fruits[3] = Integer.parseInt(data[3]);

            int ans = 0;

            int[] baseFruits = new int[4];
            System.arraycopy(fruits, 0, baseFruits, 0, 4);

            for (int a = 0; a <= min(fruits[0] / 2, fruits[1], fruits[2], Integer.MAX_VALUE); a++) {

                if (a > 0)
                    lunch1(baseFruits);

                int[] baseBaseFruits = new int[4];
                System.arraycopy(baseFruits, 0, baseBaseFruits, 0, 4);

                for (int b = 0; b <= Math.min(baseFruits[2] / 2, baseFruits[0] / 2); b++) {

                    if (b > 0)
                        lunch2(baseBaseFruits);

                    for (int c = 0; c <= min(baseBaseFruits[0], baseBaseFruits[1], baseBaseFruits[2] / 2, baseBaseFruits[3]); c++) {
                        if (isGood(a, b, c, fruits))
                            ans = Math.max(a + b + c, ans);
                    }
                }
            }

            os.write((ans + "\n").getBytes());
        }
        os.flush();
    }

    private static boolean isGood(int a, int b, int c, int[] fruits) {
        return (a * 2 + b * 2 + c <= fruits[0])
                && (a + c <= fruits[1])
                && (a + b * 2 + c * 2 <= fruits[2])
                && (c <= fruits[3]);
    }

    private static int min(int apricot, int banana, int apple, int pear){
        if (apricot <= banana && apricot <= apple && apricot <= pear)
            return apricot;
        if (banana <= apricot && banana <= apple && banana <= pear)
            return banana;
        if (apple <= banana && apple <= apricot && apricot <= pear)
            return apple;

        return pear;
    }

    private static void lunch1(int[] fruits){
        fruits[0]-= 2;
        fruits[1]--;
        fruits[2]--;
    }
    private static void lunch2(int[] fruits){
        fruits[0]-= 2;
        fruits[2]-= 2;
    }
    private static void lunch3(int[] fruits){
        fruits[0]--;
        fruits[1]--;
        fruits[2]-= 2;
        fruits[3]--;
    }
}



