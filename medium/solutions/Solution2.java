import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution2 {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        if(s.length()%2==0){
            LinkedList<Character> queue = new LinkedList<>();
            for(int i = 0; i<s.length(); i++){
                if(s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='('){
                    queue.addFirst(s.charAt(i));
                }
                else{
                    if(queue.isEmpty())return "NO";
                    else{
                        if((int)s.charAt(i) - (int) queue.poll() > 3 ){
                            return "NO";
                        }
                    }
                }
            }
            if(queue.isEmpty()){
                return "YES";
            }
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
