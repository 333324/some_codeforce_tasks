//https://codeforces.com/contest/1748/problem/B

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StringsVariety {
    private static class subString {
        public int startIndex;
        public int endIndex;

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }

            if (obj.getClass() != this.getClass()) {
                return false;
            }

            final subString other = (subString) obj;

            return (this.endIndex == other.endIndex && this.startIndex == other.startIndex);
        }

        subString(int x, int y){
            this.startIndex = x;
            this.endIndex = y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            int length = Integer.parseInt(reader.readLine());
            String lol = reader.readLine();

            os.write((countOptions(lol, length) + "\n").getBytes());
        }
        os.flush();
    }

    private static int countOptions(String realStr, int length) {
        int ans = length;

        List<subString> variety = new ArrayList<>();

        for (int i = 0; i  < length; i++) {
            variety.add(new subString(i, i));
        }

        for (int i = 1; i < length; i++) {
            int added = 0;
            List<subString> newVariety = new ArrayList<>();
                for (subString curr : variety) {
                    if (curr.startIndex > 0) {
                        if (isVary(realStr.substring(curr.startIndex - 1, curr.endIndex + 1)))
                            if (!newVariety.contains(new subString(curr.startIndex - 1, curr.endIndex))) {
                                newVariety.add(new subString(curr.startIndex - 1, curr.endIndex));
                                added++;
                            }
                    }
                    if (curr.endIndex < length - 1) {
                        if (isVary(realStr.substring(curr.startIndex, curr.endIndex + 2)))
                            if (!newVariety.contains(new subString(curr.startIndex, curr.endIndex  +1))) {
                                newVariety.add(new subString(curr.startIndex, curr.endIndex + 1));
                                added++;
                            }
                    }
                }

            variety = newVariety;
            if (added == 0)
                break;
            ans+= added;
        }
        return ans;
    }

    private static boolean isVary(String str) {
        int[] numsAmount = new int[10];
        for (int i = 0; i < str.length(); i++){
            numsAmount[str.charAt(i) - '0']++;
        }

        int variety = 0;
        for (int i = 0; i < 10; i++) {
            if (numsAmount[i] > 0)
                variety++;
        }

        for (int i = 0; i < 10; i++) {
            if (numsAmount[i] > variety)
                return false;
        }
        return true;
    }
}