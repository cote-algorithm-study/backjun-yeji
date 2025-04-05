import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        StringBuilder builder = new StringBuilder();
        builder.append(br.readLine());
        int mismatchCount = 0;

        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);

            int isExist = builder.indexOf(String.valueOf(c));
            if (isExist == -1) {
                mismatchCount++;
            } else {
                builder.delete(isExist, isExist + 1);
            }
        }

        mismatchCount += (builder.length());
        System.out.println(mismatchCount);
    }

}