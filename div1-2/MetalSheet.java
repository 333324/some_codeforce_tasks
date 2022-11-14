//https://codeforces.com/gym/104052/problem/A

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class MetalSheet {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split("\\s");

        long metalSmall = Math.min(Long.parseLong(data[0]), Long.parseLong(data[1]));
        long metalBig = Math.max(Long.parseLong(data[0]), Long.parseLong(data[1]));
        long pressSmall = Math.min(Long.parseLong(data[2]), Long.parseLong(data[3]));
        long pressBig = Math.max(Long.parseLong(data[2]), Long.parseLong(data[3]));

        BigDecimal metalSmallB = new BigDecimal(Math.min(Long.parseLong(data[0]), Long.parseLong(data[1])));
        BigDecimal metalBigB = new BigDecimal(Math.max(Long.parseLong(data[0]), Long.parseLong(data[1])));
        BigDecimal pressSmallB = new BigDecimal(Math.min(Long.parseLong(data[2]), Long.parseLong(data[3])));
        BigDecimal pressBigB = new BigDecimal(Math.max(Long.parseLong(data[2]), Long.parseLong(data[3])));


        BigDecimal ans = new BigDecimal("0");

        if (pressBig < metalSmall) {
           // ans = metalBig * metalSmall - pressSmall * pressBig;
            ans = metalBigB.multiply(metalSmallB).subtract(pressSmallB.multiply(pressBigB));
        } else if (pressBig >= metalBig) {
          //  ans = metalBig * ((float) (metalSmall - pressSmall) / 2);
            ans = metalBigB.multiply(metalSmallB.subtract(pressSmallB)).divide(new BigDecimal(2));
        } else {
          //  ans = metalSmall * ((float) (metalBig - pressSmall) / 2);
            if (pressSmall > metalSmall)
                ans = metalSmallB.multiply(metalBigB.subtract(pressBigB)).divide(new BigDecimal(2));
            else
            ans = metalSmallB.multiply(metalBigB.subtract(pressSmallB)).divide(new BigDecimal(2));
        }

        if (ans.compareTo(new BigDecimal(0)) < 0)
            ans = new BigDecimal(0);
        System.out.println(ans);

        /*if (ans % 1 == 0 || ans < 0)
            System.out.println(ans < 0 ? 0 : (int) ans);
         else
            System.out.println(ans);*/
    }
}
