//https://codeforces.com/contest/1759/problem/A

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class yeapyeap {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String m = reader.readLine();

            boolean ans = true;

            char lastLetter = m.charAt(0);

            if (lastLetter != 'Y' && lastLetter != 'e' && lastLetter != 's'){
                ans = false;
            } else
            for (int j = 1; j < m.length(); j++) {
                char letter = m.charAt(j);
                if (letter == 'Y') {
                    if (lastLetter != 's') {
                        ans = false;
                        break;
                    }
                } else if (letter == 's') {
                    if (lastLetter != 'e') {
                        ans = false;
                        break;
                    }
                } else if (letter == 'e') {
                    if (lastLetter != 'Y') {
                        ans = false;
                        break;
                    }
                } else {
                    ans = false;
                    break;
                }

                lastLetter = letter;
            }

            os.write((ans ? "YES\n" : "NO\n").getBytes());
        }
        os.flush();
    }
}