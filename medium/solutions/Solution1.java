import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution1 {

    public static void addOrderedStringWithBinarySearh(String[] orderedArray, String value){
        int index = Arrays.binarySearch(orderedArray, 0, items, value);
        if (index < 0) {
            // this is a new value to insert (not a duplicate).
            index = - index - 1;
        }
        System.arraycopy(orderedArray, index, orderedArray, index+1, items - index);
        orderedArray[index] = value;
        items++;
    }

    public static int binarySearch(String[] arr, String x) {
        int l = 0, r = arr.length - 1;
        int m = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            int res = x.compareTo(arr[m]);
            // Check if x is present at mid
            if (res == 0)
                return m;
            // If x greater, ignore left half
            if (res > 0)
                l = m + 1;
                // If x is smaller, ignore right half
            else
                r = m - 1;
        }
        return m;
    }



    public static String ADD_CONTACT = "add";
    public static ArrayList<Integer> resp = new ArrayList<>();
    public static int items = 0;


    public static int[] contacts(String[][] queries) {
        String[] orderedArray = new String[queries.length];
        Arrays.fill(orderedArray, "|");
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i][0];
            String value = queries[i][1];

            if (ADD_CONTACT.equals(query)) {
                addOrderedStringWithBinarySearh(orderedArray, value);
            } else {
                int index = binarySearch(orderedArray, value);
                if(index==items){
                    resp.add(0);
                }
                else{
                    int val = -1;
                    if(!orderedArray[index].startsWith(value)){
                        index++;
                    }

                    char lastChar =value.charAt(value.length()-1);
                    lastChar+=1;
                    String lastValue = value.substring(0,value.length()-1)
                            +String.valueOf(lastChar);
                    int indexF = binarySearch(orderedArray,lastValue);

                    if(index>indexF){val=0;}
                    else if(index!=indexF && indexF==items && orderedArray[indexF-1].startsWith(value)){
                        val = indexF-index;
                    }
                    else if(orderedArray[indexF].startsWith(value)){
                        indexF++;
                        val = indexF-index;
                    }
                    else{
                        val = indexF-index;
                    }
                    resp.add(val);
                }
            }
        }
        return resp.stream().mapToInt(Integer::intValue).toArray();
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = contacts(queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
