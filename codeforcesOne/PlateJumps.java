import java.io.*;
import java.util.*;

public class PlateJumps {
    private static int getInt(char letter){
        return letter - 'a' + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++){
            String lol = reader.readLine();

            int len = lol.length() - 1;
            char startIndex = lol.charAt(0);
            char endIndex = lol.charAt(len);
            char minIndex = (char) Math.min(startIndex, endIndex);
            char maxIndex = (char) Math.max(startIndex, endIndex);
            int cost = maxIndex - minIndex;
            int amount = 2;

            List<Integer>[] ans = new ArrayList[maxIndex + 1];

            for (int j = 1; j < len; j++){
                char x = lol.charAt(j);
                if (x >= minIndex && x <= maxIndex){
                    if (ans[lol.charAt(j)] == null){
                        ans[lol.charAt(j)] = new ArrayList<>();
                    }
                    ans[lol.charAt(j)].add(j + 1);
                    amount++;
                }
            }

            os.write((cost + " " + amount + "\n").getBytes());
            os.write("1 ".getBytes());

            if (startIndex < endIndex)
                for (int j = startIndex; j <= endIndex; j++){
                    if (ans[j] != null)
                        for (int k = 0; k < ans[j].size(); k++)
                            os.write((ans[j].get(k) + " ").getBytes());

                }
            else
                for (int j = startIndex; j >= endIndex; j--){
                    if (ans[j] != null)
                        for (int k = 0; k < ans[j].size(); k++)
                            os.write((ans[j].get(k) + " ").getBytes());

                }
            os.write(((len + 1) + " ").getBytes());
            os.write("\n".getBytes());
            }

        os.flush();
    }
}
