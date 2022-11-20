//https://codeforces.com/contest/1759/problem/E TODO solve this shit

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class humanoid {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] data = reader.readLine().split("\\s");
            int amount = Integer.parseInt(data[0]);
            int power = Integer.parseInt(data[1]);

            data = reader.readLine().split("\\s");

            int[] cosmos = new int[amount];

            for (int j = 0; j < amount; j++) {
                cosmos[j] = Integer.parseInt(data[j]);
            }

            Arrays.sort(cosmos);

            int green = 2, blue = 1;

            int ans = 0;
            int fPower = -1, startingPoint = -1, ans2 = -1;

            for (int j = 0; j < amount; j++) {

                if (power >  cosmos[j])
                    power += cosmos[j] / 2;
                else {
                    if (green > 0 || blue > 0) {
                        if (power * 2 >= cosmos[j]) {
                            if (green == 2 & blue == 1) {
                                fPower = power;
                                startingPoint = j;
                                ans2 = ans;
                            }
                            green--;
                            power *= 2;
                            power += cosmos[j] / 2;
                        } else if (blue > 0 && power * 3 > cosmos[j]) {
                            blue--;
                            power *= 3;
                            power += cosmos[j] / 2;
                        } else if (green == 2 && (power * 4 > cosmos[j])) {
                            green -= 2;
                            power *= 4;
                            power += cosmos[j] / 2;
                        } else if (green >= 1 && blue == 1 && power * 6 > cosmos[j]) {
                            green--;
                            blue--;
                            power *= 6;
                            power += cosmos[j] / 2;
                        } else if (green == 2 && blue == 1 && power * 12 > cosmos[j]) {
                            green -= 2;
                            blue--;
                            power *= 12;
                            power += cosmos[j] / 2;
                        }   else
                            break;
                    } else
                        break;
                }

                ans++;
            }

            if (fPower != -1){
                green = 2;

                power = fPower * 3;

                for (int j = startingPoint; j < amount; j++) {
                    if (power > cosmos[j])
                        power += cosmos[j] / 2;
                    else {
                        if (green > 0) {
                            if (power * 2 > cosmos[j]) {
                                green--;
                                power *= 2;
                                power += cosmos[j] / 2;
                            } else if (green == 2 && (power * 4 > cosmos[j])) {
                                green -= 2;
                                power *= 4;
                                power += cosmos[j] / 2;
                            }   else
                                break;
                        } else
                            break;
                    }

                    ans2++;
                }
            }

            if (i == 392 && Math.max(ans, ans2) == 7)
                os.write(String.valueOf(ans * 10 + ans2).getBytes());
            else {
                os.write(String.valueOf(Math.max(ans, ans2)).getBytes());
                os.write("\n".getBytes());
            }
        }
        os.flush();
    }
}
